final static int SPRING = 2;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
static float GRAVITY = 0.35;
final static int MODE = SPRING;
OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  orbs.add(new OrbNode(mouseX, mouseY, 0, 0, 30));
  textSize(40);
  text("Spring Length: "+SPRING_LENGTH,10,20);
  text("Spring Dampen: "+SRPING_DAMPEN,10,40);
  text("Spring Constant: "+SPRING_CONSTANT,10,60);
  text("Gravity: "+GRAVITY,10,80);
}
void draw() {
  background(255);
  orbs.processAll();
  orbs.display();
}
void keyPressed() {
  if (key == '1'){
    
