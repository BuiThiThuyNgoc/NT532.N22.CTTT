#include <WiFiClientSecure.h>
#include <ESP8266WiFi.h>
#include <ArduinoJson.h>

const char *ssid = "admin";
const char *password = "12345689";

const char *server = "https://iot-s3aq.onrender.com"; // Server URL

StaticJsonDocument<200> PINS;

WiFiClientSecure client;
int i = 0;

void setup()
{

  pinMode(D1, OUTPUT);

  pinMode(D2, OUTPUT);
  pinMode(D3, OUTPUT);
  pinMode(D4, OUTPUT);
  pinMode(D5, OUTPUT);
  pinMode(D6, OUTPUT);
  pinMode(D7, OUTPUT);
  pinMode(D8, INPUT);
  pinMode(A0, INPUT);

  PINS["D0"] = D0;
  PINS["D1"] = D1;
  PINS["D2"] = D2;
  PINS["D3"] = D3;
  PINS["D4"] = D4;
  PINS["D5"] = D5;
  PINS["D6"] = D6;

  // cảm biến ánh sáng
  pinMode(A0, INPUT);
  pinMode(D8, OUTPUT);
  // cảm biến hồng ngoại
  pinMode(D7, OUTPUT);

  // Initialize serial and wait for port to open:
  Serial.begin(9600);
  delay(100);

  Serial.print("Attempting to connect to SSID: ");
  Serial.println(ssid);
  WiFi.begin(ssid, password);

  // attempt to connect to Wifi network:
  while (WiFi.status() != WL_CONNECTED && i < 10)
  {

    Serial.print(".");
    // wait 1 second for re-trying
    delay(1000);
    i++;

  }
  if (i < 10)
  {
    Serial.print("Connected to ");
    Serial.println(ssid);

    client.setInsecure();

    Serial.println("\nStarting connection to server...");
  }
  else
  {
    offline();
  }

}

void offline()
{
  while (true)
  {
    const int sensorStateHN = digitalRead(D7);
    const int sensorStateAS = analogRead(A0);

    Serial.println("offline");
    Serial.println(sensorStateHN);
    Serial.println(sensorStateAS);
    if (sensorStateHN == 1)
    {
      digitalWrite(D8, HIGH);
    }
    else
    {
      digitalWrite(D8, LOW);
    }
    if (sensorStateAS > 800 && sensorStateHN == 1)
    {
      digitalWrite(D1, HIGH);
      digitalWrite(D2, HIGH);
      digitalWrite(D3, HIGH);
      digitalWrite(D4, HIGH);
      digitalWrite(D5, HIGH);
      digitalWrite(D6, HIGH);
    }
    else
    {
      digitalWrite(D1, LOW);
      digitalWrite(D2, LOW);
      digitalWrite(D3, LOW);
      digitalWrite(D4, LOW);
      digitalWrite(D5, LOW);
      digitalWrite(D6, LOW);
    }
  }
}

void loop()
{

  if (!client.connect(server, 443))
    Serial.println("Connection failed!");
  else
  {
    Serial.println("Connected to server!");
    // Make a HTTP request:
    client.println("GET https://iot-s3aq.onrender.com/api/v1/devices-adv HTTP/1.0");
    client.println("Host: iot-s3aq.onrender.com");
    client.println("Connection: close");
    client.println();

    while (client.connected())
    {
      String line = client.readStringUntil('\n');
      if (line == "\r")
      {
        Serial.println("headers received");
        break;
      }
    }

    String response = client.readString();
    // Serial.println(response);

    const size_t capacity = JSON_ARRAY_SIZE(100) + 3 * JSON_OBJECT_SIZE(3) + 120;
    DynamicJsonDocument doc(capacity);

    DeserializationError error = deserializeJson(doc, response);

    const int errorCode = doc["errorCode"];
    const char *message = doc["message"];
    const JsonArray data = doc["data"];

    Serial.println(errorCode);
    Serial.println(message);
    // Serial.println(data);

    Serial.println("Start check json");

    for (JsonObject obj : data)
    {
      const char *pin = obj["pin"];
      const int statusPin = obj["status"];
      const int intPin = PINS[pin];

      Serial.println(pin);
      Serial.println(intPin);
      Serial.println(statusPin);

      if (statusPin == 0)
      {
        Serial.println("tat");

        digitalWrite(intPin, LOW);
      }
      else if (statusPin == 1)
      {
        Serial.println("bat");

        digitalWrite(intPin, HIGH);
      }
      else
      {
        Serial.println("Status out of range");
      }

      Serial.println("end");
    }
    Serial.println("End check json");
    delay(1000);
    client.stop();
  }
}
