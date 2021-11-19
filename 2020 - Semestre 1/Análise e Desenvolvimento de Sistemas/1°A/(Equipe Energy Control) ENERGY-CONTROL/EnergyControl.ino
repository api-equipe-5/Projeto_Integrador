 #include <SoftwareSerial.h>

SoftwareSerial serial1={10,11};

int botao = 7;
int led = 13;
bool estadoLed = 0;
int tempo = 0;
double tempototal=0;


 
void setup()
{
  
  pinMode(botao, INPUT_PULLUP); // define o pino do botao como entrada "INPUT"
  pinMode(led, OUTPUT);
  serial1.begin(9600);
}
 
void loop()
{
 if (serial1.available())
 {
 byte byteRecebido =serial1.read();
  //serial1.print(byteRecebido);
  delay(500); 
 // Serial.print(byteRecebido);
  if(byteRecebido== 'D')
  { 
    estadoLed = !estadoLed; // troca o estado do LED
    digitalWrite(led, estadoLed);    
   // while(digitalRead(botao) == LOW);
  }
   
  }
 if(estadoLed == 1)
  {
   serial1.print(tempototal);
   serial1.print("\n");
   delay(1000); 
   tempo++;
   tempototal = tempo;
  }
  
  
  
  
//  if(digitalRead(botao) == LOW) // Se o botão for pressionado
//  {
//    estadoLed = !estadoLed; // troca o estado do LED
//    digitalWrite(led, estadoLed);    
//    while(digitalRead(botao) == LOW);
//  }
 
  
 
}
