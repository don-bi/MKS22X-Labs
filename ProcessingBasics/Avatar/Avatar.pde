void avatar(int x, int y){
  //hair
  fill(255, 204, 0);
  beginShape();
  vertex(x+10,y+20);
  vertex(x+15,y+50);
  vertex(x+5,y+45);
  vertex(x+15,y+60);
  bezierVertex(x+45,y+50,x+75,y+50,x+105,y+60);
  vertex(x+110,y+35);
  vertex(x+100,y+45);
  vertex(x+105,y+15);
  vertex(x+94,y+25);
  vertex(x+87,y+7);
  vertex(x+80,y+22);
  vertex(x+70,y+2);
  vertex(x+63,y+20);
  vertex(x+50,y+5);
  vertex(x+43,y+20);
  vertex(x+31,y+10);
  vertex(x+29,y+31);
  endShape(CLOSE);
  //headband
  fill(#0E5579);
  beginShape();
  vertex(x+15,y+60);
  bezierVertex(x+45,y+50,x+75,y+50,x+105,y+60);
  vertex(x+105,y+84);
  bezierVertex(x+75,y+74,x+45,y+74,x+15,y+84);
  endShape(CLOSE);
  fill(#D1CDC8);
  rect(x+40,y+57,40,16);
  //face
  fill(#F9D8AA);
  beginShape();
  vertex(x+15,y+84);
  vertex(x+15,y+120);
  bezierVertex(x+45,y+150,x+75,y+150,x+105,y+120);
  vertex(x+105,y+84);
  bezierVertex(x+75,y+74,x+45,y+74,x+15,y+84);
  endShape(CLOSE);
  circle(x+45,y+90,5);
  circle(x+75,y+90,5);
  curve(x+45,y+100,x+55,y+105,x+65,y+105,x+75,y+100);
}

int x,y,x2,y2;
int MODE;
void setup(){
         size(800,800);
         MODE = 2;
         x = width/2;
         y = height/2;
}
void draw(){
         background(255);
         x = change(x);
         y = change(y);
         avatar(x,y);
         x2 = mouseX;
         y2 = mouseY;
         avatar(x2,y2);
}
int change(int value){
  /**
   mode 1: return a random location on the screen.
   mode 2: change value by +1, 0, or -1 randomly
   mode 3: change value by +1 , but if it goes past the end of the screen ,
         wrap back around to the other end of the screen.
  */

  switch(MODE){
   case 1:
     return int(random(width));
   case 2:
     return value + (int(random(3))-1);
   case 3:
     if (value > width){
       value = 0;
     } else {
       return value + 1;
     }
   default:
     return width/2;
  }
}
 
void mouseClicked(){
  if (MODE == 3){
    MODE = 1;
  } else {
    MODE ++;
  }
}
