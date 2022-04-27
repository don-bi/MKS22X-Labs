final int GRAVITY = 0;
final int ORBIT = 1;
final int MODE = GRAVITY;
final float SPRING_CONSTANT = 0.9;
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
  for (Orb o : orbList) {
    if (MODE == ORBIT) center.attract(o);
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
  }
  text(smode, 20, 60);
      
}
void keyPressed() {
  if (key == BACKSPACE) orbList.clear();
  if (key == 'b') backgroundMode = !backgroundMode;
  if (key == 'g') gravityMode = !gravityMode;
  if (key == ' '){
    if (MODE == 1) MODE = -1;
    MODE ++;
  }
}
 
