#include <ArduinoJson.h>
#include <ESP8266HTTPClient.h>
#include <ESP8266WiFi.h>
#include "FirebaseESP8266.h"
FirebaseData firebaseData;
HTTPClient http;
String state_luz_sala;
String state_luz_coz;
float current_temp;
String state_cooler;

void setup() {
  pinMode(2, OUTPUT);
  pinMode(16, OUTPUT);
  pinMode(5, OUTPUT);
  pinMode(14, OUTPUT);
  Serial.begin(9600);
  connectWifi("Cembranelli","eunaosei");
  Firebase.begin("https://projeto-smartkey.firebaseio.com/", "O66MUynB7ndUBrpQqiqqDUYmTQCDTbj45rG5ZHZF");
  Firebase.setString(firebaseData, "casa%2001/sala", "true");
  Firebase.setString(firebaseData, "casa%2001/cozinha", "true");
}

void loop() {
  if (WiFi.status()==WL_CONNECTED){

    http.begin("http://api.openweathermap.org/data/2.5/weather?q=Cacapava&APPID=928f7f13aaef33c96af9e76ba8794082");
 
    int httpCode = http.GET();  // send the request
 
    if (httpCode > 0) { // check the returning code
      String payload = http.getString();
      DynamicJsonBuffer jsonBuffer(512);
      // Parse JSON object
      JsonObject& root = jsonBuffer.parseObject(payload);
      if (!root.success()) {
        Serial.println(F("Parsing failed!"));
        return;
      }
      float temp = (float)(root["main"]["temp"]) - 273.15;
      if(temp!=current_temp){
        current_temp=temp;
        Firebase.setFloat(firebaseData, "casa%2001/current_value", temp);
      }
    }

    if (Firebase.getString(firebaseData, "casa%2001/Liga%20cooler")) {
      String state_cooler_DB=firebaseData.stringData();
      if(state_cooler != state_cooler_DB){
        state_cooler=state_cooler_DB;
        Serial.print(state_cooler);
        if(state_cooler_DB=="true"){
          digitalWrite(14, HIGH);
        }
        else{
          digitalWrite(14, LOW);
        }
      }
    }

    if (Firebase.getString(firebaseData, "casa%2001/cozinha")) {
      String state_coz_DB=firebaseData.stringData();
      if(state_luz_coz != state_coz_DB){
        state_luz_coz=state_coz_DB;
        if(state_coz_DB=="false"){
          digitalWrite(16, HIGH);
        }
        else{
          digitalWrite(16, LOW);
        }
      }
    }

    if (Firebase.getString(firebaseData, "casa%2001/sala")) {
      String state_sala_DB=firebaseData.stringData();
      if(state_luz_sala != state_sala_DB){
        state_luz_sala=state_sala_DB;
        if(state_luz_sala=="false"){
          digitalWrite(5, HIGH);
        }
        else{
          digitalWrite(5, LOW);
        }
      }
    }
    
  }
}

void connectWifi(String ssid, String password){
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    digitalWrite(2,HIGH);
    delay(250);
    digitalWrite(2,LOW);
    delay(250);
    Serial.print(".");
  }
  if (WiFi.status() == WL_CONNECT_FAILED){
    digitalWrite(2,HIGH);
    Serial.println();
    Serial.println("Failed to connect");
  }
  digitalWrite(2,LOW);
  Serial.println();
  Serial.println("WiFi Connected....IP Address:");
  Serial.println(WiFi.localIP());
}
