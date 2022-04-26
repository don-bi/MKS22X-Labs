ArrayList<Orb>orbList;
Orb center;
void setup() {
  size(1000, 800);
  orbList = new ArrayList<Orb>();
  center = new Orb(width/2,height/2,0,0,50);
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
  background(255);
  for (Orb o : orbList) {
    o.attract(center);
    o.move();
    o.display();
    center.display();
  }
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
}
