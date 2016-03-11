#include <LedControl.h>

LedControl lc = LedControl(12,11,10,1);

String str = "";
boolean aceso;

void setup(){
  lc.shutdown(0, false);
  lc.setIntensity(0, 5);
  lc.clearDisplay(0);
  
  str.reserve(4);
  
  Serial.begin(9600);
}

void loop(){
  while(Serial.available() > 0){
    int ch = Serial.read();
    
    if(isDigit(ch)) str += (char)ch;
    else if('L' == (char)ch){
      lc.clearDisplay(0);
      str = "";
    }
    else if('T' == (char)ch) aceso = true;
    else if('F' == (char)ch) aceso = false;
    
    if((ch == ';') && (str != "")){
      int coord = (str.toInt())-1;
      int row = coord/8;
      int col = coord%8;
    
      lc.setLed(0, row, col, aceso);
      str = "";
    }
  }
}
