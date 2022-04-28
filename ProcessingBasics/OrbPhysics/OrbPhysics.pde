final int GRAVITY = 0;
final int ORBIT = 1;
final int SPRING = 2;
final int SPECIAL = 3;
int MODE = GRAVITY;
final float SPRING_CONSTANT = 0.015;
final float SPRING_LENGTH = 120;
final float SPRING_DAMPEN = 0.95;


ArrayList<Orb>orbList;
Orb center;
boolean backgroundMode;
boolean gravityMode;

void setup() {
  size(1000, 800);
  orbList = new ArrayList<Orb>();
  center = new Orb(width/2,height/2,0,0,40);
  backgroundMode = true;
  gravityMode = true;
}
void mouseClicked() {
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the radius should be between in the range [20.0,70.0)
  //the xSpeed and ySpeed should be in the range [-3.0,3.0)
  float mX = mouseX;
  float mY = mouseY;
  orbList.add(new Orb(mX, mY, 5, 0, 20));
}
void draw() {
  if (backgroundMode) background(255);
  stroke(255);
  fill(255);
  rect(0,0,100,80);
  stroke(0);
  for (Orb o : orbList) {
    if (MODE == ORBIT) center.attract(o);
    if (MODE == SPRING) {
      center.attractSpring(o);
      line (center.x,center.y,o.x,o.y);
    }
    if (MODE == SPECIAL) {
      for (int i = 0; i < orbList.size()-1; i ++){
        Orb orb1 = orbList.get(i);
        Orb orb2 = orbList.get(i+1);
        orbList.get(i).attractSpring(orbList.get(i+1));
        line (orb1.x,orb1.y,orb2.x,orb2.y);
      }
    }
    o.move();
    o.display();
    line(o.x,o.y,o.x+o.xSpeed*5,o.y+o.ySpeed*5);
  }
  center.display();
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
  String smode = "";
  switch (MODE){
    case 0: smode = "GRAVITY";
      break;
    case 1: smode = "ORBIT";
      break;
    case 2: smode = "SPRING";
      break;
    case 3: smode = "SPECIAL";
      break;
  }
  text(smode, 20, 60);
  if (gravityMode){
    text("GRAVITY ON", 20, 80);
  } else {
    text("GRAVITY OFF", 20, 80);
  }
      
}
void keyPressed() {
  if (key == BACKSPACE) orbList.clear();
  if (key == 'b') backgroundMode = !backgroundMode;
  if (key == 'g') gravityMode = !gravityMode;
  if (key == ' '){
    if (MODE == 3) MODE = -1;
    MODE ++;
  }
}
 
