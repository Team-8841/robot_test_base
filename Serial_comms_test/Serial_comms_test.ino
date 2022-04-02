byte oldData;
byte newData;

void setup()
{
  Serial.begin(9600);
}

void loop()
{
  if( Serial.available())
  {
    newData = Serial.read();

    if(newData != oldData)
    {
      if (newData == 0x12)
      {
        Serial.println("I got a message");
        oldData = newData;
      }
    }
  }
  delay(50);
}
