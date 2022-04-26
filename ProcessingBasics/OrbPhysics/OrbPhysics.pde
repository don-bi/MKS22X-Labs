ArrayList<Orb>orbList;
Orb center;
boolean backgroundMode;
int mode;

void setup() {
  size(1000, 800);
  orbList = new ArrayList<Orb>();
  center = new Orb(width/2,height/2,0,0,50);
  backgroundMode = true;
  mode = 0;
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
    o.attract(center);
    o.move();
    o.display();
    center.display();
  }
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
  String smode = "";
  switch (mode){
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
  if (key == ' '){
    if (mode == 1) mode = -1;
    mode ++;
  }
}
  
 
