public class Orb {
  float x, y;
  float xSpeed, ySpeed;
  float radius;
  color c;

  public Orb(float x_, float y_, float xSpeed_, float ySpeed_, float radius_ ) {
    x = x_;
    y = y_;
    xSpeed = xSpeed_;
    ySpeed = ySpeed_;
    radius = radius_;
    //random color... why not.
    c = color(random(255), random(255), random(255));
  }


  void display() {
    //Part 1:
    //draw a ellipse at the x,y position, with the correct radius.
    //make sure it is the correct color
    //make sure you read the parameters of ellipse, so that you have the correct size.
    //radius is NOT one of the parameters of ellipse by default.
    fill(c);
    ellipse(x, y, radius, radius);
  }

  void move() {
    //PART 2
    //change the x based on the xSpeed
    //change the y based on the ySpeed
    x += xSpeed;
    y += ySpeed;
    //PART 3
    //Change the speed when you collide with the end of the screen (all 4 sides)
    if (MODE == GRAVITY){
      if (x < radius || x > width-radius) {
        if (x < radius) {
          x = radius;
        } else {
          x = width-radius;
        }
        xSpeed = -xSpeed;
      }
      if (y < radius || y > height-radius) {
        if (y < radius) {
          y = radius;
        } else {
          y = height-radius;
        }
        ySpeed = -ySpeed;
      }
      //Part 4
      //Add a small adjustment for gravity. Gravity is a ySpeed acceleration...
      //You don't need a variable for this if every object experiences the same
      //gravitational constant (find the value that looks nice experimentally, 9.8 will not work well).
      final float gravCons = 0.15;
      ySpeed += gravCons;
    }
  }
  
  void attract(Orb b){
    float d = dist(x,y,b.x,b.y);
    b.xSpeed += (20*(x-b.x))/(d*d);
    b.ySpeed += (20*(y-b.y))/(d*d);
  }
  
  void attractSpring(Orb b){
    float d = dist(x,y,b.x,b.y);
    float force = 
    b.xSpeed += (
}
