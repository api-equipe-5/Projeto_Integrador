//Importação das bibliotecas a serem utilizadas
#include <Adafruit_Sensor.h>
#include <DHT.h>
#include <DHT_U.h>
#include <SoftwareSerial.h>

//int temporizadorDebug = 0;  // Váriavel para auxiliar no debug

// Váriaveis relacionadas ao funcionamento automático
int temporizadorHoras = 0;
int regarACada = 0;
boolean regando = false;
int const tempoDeRegaPadrao = 10;  //Divida o valor por 2 para saber o tempo em segundos que a rega ira durar
int tempoDeRega = tempoDeRegaPadrao;
boolean automatico = false;

// Pinagem do Bluetooth e váriaveis relacionadas
const int pinoRX = 2; //Preto liga no 3 do arduino
const int pinoTX = 3;  //Branco liga no 2 do arduino
const int vccBluetooth = 4;
int dadoBluetooth;

// Pinagem do LED de testes
const int led = 7;

// Pinagem do Sensor de Chuva
const int vccSensorChuva = 8;
const int pinoAnalogSensorChuva = A0;

// Pinagem do Sensor de Umidade do solo
const int vccSensorSolo = 9;
const int pinoAnalogSensorSolo = A1;

// Pinagem do DHT22, sensor de umidade do ar e temperatura do ar
const int dadosDHT = 5;
const int vccDHT = 6; 

// Pinagem da Bomba de àgua para irrigação
const int bombaDeAgua = 10;


// Inicializando os objetos Bluetooth e DHT
SoftwareSerial bluetooth(pinoRX, pinoTX);
DHT dht(dadosDHT, DHT22);

void setup() {
  // Iniciando conexões seriais
  Serial.begin(9600);
  bluetooth.begin(9600);
  dht.begin();

  // Configurando o funcionamento do pino do LED
  pinMode(led, OUTPUT);

  // Configurando o funcionamento dos pinos do sensor de chuva
  pinMode(vccSensorChuva, OUTPUT);
  pinMode(pinoAnalogSensorChuva, INPUT);
  digitalWrite(vccSensorChuva, HIGH);

  // Configurando o funcionamento dos pinos do sensor do solo
  pinMode(vccSensorSolo, OUTPUT);
  pinMode(pinoAnalogSensorSolo, INPUT);
  digitalWrite(vccSensorSolo, HIGH);

  // Configurando o funcionamento dos pinos do DHT22
  pinMode(vccDHT, OUTPUT);
  digitalWrite(vccDHT, HIGH);

  // Configurando o funcionamento dos pinos do Bluetooth (alimentação apenas)
  pinMode(vccBluetooth, OUTPUT);
  digitalWrite(vccBluetooth, HIGH);

  // Configurando o funcionamento do pino da bomba de água
  pinMode(bombaDeAgua, OUTPUT);
  digitalWrite(bombaDeAgua, LOW);
}

void loop() {
  atividadesBluetooth();  // Função principal de funcionamento, sempre verifica se existe algo sendo recebido pelo Bluetooth

  // Trecho responsável por fazer o temporizador para regar no período determinado de horas
  temporizadorHoras++;
  if((temporizadorHoras/2) == (regarACada)){
    if(automatico){
      regar();
    }
    temporizadorHoras == 0;
  }


  // Condicional que verifica se o usuário está pedindo para regar naquele exato momento, caso sim, faz a rega
  if(regando){
    tempoDeRega = tempoDeRega - 1;
    if(tempoDeRega == 0){
      regando = false;
      tempoDeRega = tempoDeRegaPadrao;
      digitalWrite(bombaDeAgua, LOW);
    }
  }

  // Trecho usado para debug durante o desenvolvimento
//  if(temporizadorDebug == 20){
//    debug();
//    temporizadorDebug = 0;
//  }else{
//    temporizadorDebug++;
//  }

  delay(500); // Pequeno delay para evitar que os dados do Bluetooth se sobrescrevam
  
}

// Função regar, responsável por abrir a bomba de água quando requisitado
void regar(){
  regando = true;
  digitalWrite(bombaDeAgua, HIGH);
}

// Função para ler os valores do DHT22, utilizada em atividadesBluetooth()
float atividadesDHT(int tipoDeLeitura){
  float umidade = dht.readHumidity();
  float temperatura = dht.readTemperature();

  //Devolve a leitura que foi pedida
  if(tipoDeLeitura == 0){
    return umidade;
  }else{
    if(tipoDeLeitura == 1){
      return temperatura;
      }
    }
  }

// Função para ler os valores do sensor de chuva, utilizada em atividadesBluetooth()
int atividadesSensorChuva(){
  int valorAnalogSensorChuva = analogRead(pinoAnalogSensorChuva);
  int porcentagem = map(valorAnalogSensorChuva, 0, 1023, 100, 0);

  return porcentagem;
}


// Função para ler os valores do sensor do solo, utilizada em atividadesBluetooth()
int atividadesSensorSolo(){
  int valorAnalogSensorSolo = analogRead(pinoAnalogSensorSolo);
  int porcentagem = map(valorAnalogSensorSolo, 0, 1023, 100, 0);

  return porcentagem;
}



// Função principal, responsável por verificar o que está sendo recebido pelo bluetooth e agir de acordo
void atividadesBluetooth(){
    // Verifica se a algo na porta serial do bluetooth para ser lido
    if(bluetooth.available()){
      dadoBluetooth = bluetooth.read();


    // O aplicativo envia números para o bluetooth do arduíno, cada sequência significa uma informação ou ação

    
    // De 1 à 24, período de rega automático escolhido manualmente pelo usuário
    if((dadoBluetooth >= 1) and (dadoBluetooth <= 24)){
      regarACada = dadoBluetooth;
      regarACada = (regarACada*60*60);     //Converte horas para segundos
    }


    // 25 e 26, aplicativo pedindo informções sobre o DHT
    if(dadoBluetooth == 25){       //Celular pedindo o valor da umidade
      float leitura = atividadesDHT(0);
      bluetooth.write(leitura);
    }
    if(dadoBluetooth == 26){       //Celular pedindo o valor da temperatura
      float leitura = atividadesDHT(1);
      bluetooth.write(leitura);
    }

    
    // 27, aplicativo pedindo informções sobre o sensor do solo
    if(dadoBluetooth == 27){        //Celular pedindo se está molhado ou não
      int leitura = atividadesSensorSolo();
      bluetooth.write(leitura);
    }

    // 28, aplicativo pedindo informções sobre o sensor de chuva
    if(dadoBluetooth == 28){        //Celular pedindo se está chovendo ou não
      int leitura = atividadesSensorChuva();
      bluetooth.write(leitura);
    }

    // 29, aplicativo acendendo/apagando o LED de teste
    if(dadoBluetooth == 29){   //Inverte o estado do led
      digitalWrite(led, !digitalRead(led));
    }


    // 30 e 31, usuário desativando/ativando a rega automática pelo aplicativo
    if(dadoBluetooth == 30){   //Desativando modo automatico no app
      automatico = false;
    }
    if(dadoBluetooth == 31){   //Ativando modo automatico no app
      automatico = true;
    }


    // 32, usuário pedindo para regar no exato instante
    if(dadoBluetooth == 32){
      regar();
    }


    // 51 à 75, usuário configurando uma plantação que não existe nas pré-configuradas do aplicativo
    if((dadoBluetooth >= 51) and (dadoBluetooth <= 75)){
      automatico = true;
      regarACada = dadoBluetooth - 50;
      regarACada = (regarACada*60*60);     //Converte horas para segundos
      }
  
    }
    
    dadoBluetooth = 0; // Reseta o dado recebido após usado, para não haver conflitos
}

/* Função de debugg
void debug(){
  float temperatura = dht.readTemperature();
  float umidade = dht.readHumidity();

  int valorAnalogSensorSolo = analogRead(pinoAnalogSensorSolo);
  int solo = map(valorAnalogSensorSolo, 0, 1023, 100, 0);

  int valorAnalogSensorChuva = analogRead(pinoAnalogSensorChuva);
  int chuva = map(valorAnalogSensorChuva, 0, 1023, 100, 0);

  Serial.print("Medições DHT -> ");
  Serial.print("Temperatura: ");
  Serial.print(temperatura);
  Serial.print(" | ");
  Serial.print("Umidade: ");
  Serial.println(umidade);

 Serial.print("Medição sensor de chuva -> ");
 Serial.print("Porcentagem da chuva: ");
 Serial.print(chuva);
 Serial.println(" %");

 Serial.print("Medição sensor de solo -> ");
 Serial.print("Umidade do solo: ");
 Serial.print(solo);
 Serial.println(" %");

}
*/
