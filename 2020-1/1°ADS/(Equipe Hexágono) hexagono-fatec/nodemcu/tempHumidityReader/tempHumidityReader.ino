#include <Wire.h>
#include <SSD1306Wire.h>
#include <DHT.h>
#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <ESP8266WebServer.h>
#include <ESP8266mDNS.h>
#include <FirebaseArduino.h>

//Dados da rede wifi
#define STASSID "" //coloque a ssid da sua net no lugar do SSID
#define STAPSK  "" //coloque a senha da sua net
const char* ssid = STASSID;
const char* password = STAPSK;
int testeposi= 1;
int testeneg= -1;

//Dados do firebase
#define FIREBASE_HOST "" //link do bd
#define FIREBASE_AUTH "" //chave secreta do bd
ESP8266WebServer server(80);

//Pino de ligacao do DHT11
#define DHTPIN 5

//Define o tipo de sensor DHT
#define DHTTYPE DHT11

// Inicializa o display Oled SDA 2, SCL 14
SSD1306Wire  display(0x3c, 2, 14);

int minima = 99;
int maxima = 0;
int temp; //temperatura
int hum; //humidade
 
DHT dht(DHTPIN, DHTTYPE);

//Intervalo de tempo entre leituras e tambem tempo de inicialização
const long intervalo = 10000;

//Armazena o valor (tempo) da ultima leitura
unsigned long previousMillis = 0;

void setup()
{
  Serial.begin(115200);

  //Inicializa o Wifi
  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);
  
  server.begin();
  Serial.println("HTTP server started");

  //Iniciar display Oled
  display.init();
  display.flipScreenVertically();

  //Iniciar sensor de temperatura
  dht.begin();

  //Iniciar Firebase
  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
}

 
void Atualiza_Temperatura_Display(int temperatura, int hum)
{
  //Apaga o display
  display.clear();

  //Desenha as molduras
  display.drawRect(0, 0, 128, 16);
  display.drawRect(0, 16, 63, 48);
  display.drawRect(64, 16, 128, 48);
  display.setFont(ArialMT_Plain_10);
  display.setTextAlignment(TEXT_ALIGN_CENTER);
  

  //Atualiza informacoes da temperatura
  display.setFont(ArialMT_Plain_10);
  display.setTextAlignment(TEXT_ALIGN_CENTER);
  display.drawString(64, 2, "Hexagono Group");
  display.setFont(ArialMT_Plain_24);
  display.drawString(32, 26, String(temp));
  display.drawCircle(52, 32, 3);

  //Atualiza maxima e minima
  display.setTextAlignment(TEXT_ALIGN_LEFT);
  display.setFont(ArialMT_Plain_24);
  display.drawString(73, 24, "    %");
  display.setFont(ArialMT_Plain_24);
  display.drawString(73, 26, String(hum));

  display.display();
}

void loop() {

  unsigned long currentMillis = millis();

  //Verifica se o intervalo já foi atingido
  if (currentMillis - previousMillis >= intervalo)
  {
    //Armazena o valor da ultima leitura
    previousMillis = currentMillis;

    //Le a temperatura
    temp = dht.readTemperature();

    //Le a humidade
    hum = dht.readHumidity();
    
    //Receber a variavel t do firebase
    
    Firebase.setFloat("temperatures/temperature/value", temp);
    Firebase.setInt("temperatures/temperature/timestamp", testeneg);
    
    //Receber a variavel h do firebase
    Firebase.setFloat("humidities/humidity/value", hum);
    Firebase.setInt("humidities/humidity/timestamp", testeposi);

    
    //Envia as informacoes para o display
    Atualiza_Temperatura_Display(temp, hum);

    //identificação da temperatura e humidade
    testeposi++;
    testeneg=testeneg-1;
  
  }
   
   server.handleClient();
   MDNS.update();
  
}
