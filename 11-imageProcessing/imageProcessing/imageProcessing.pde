String[]names;
Kernel[]kernels;
int currentKernel;

void setup() {
  currentKernel = 0;
  names = new String[]{
    "Identity", "Blur", "Sharpen", 
    "Outline", "Left Sobel", "Right Sobel", 
    "Top Sobel", "Emboss"
  };

  kernels = new Kernel[] {
    new Kernel( new float[][] {
      {0, 0, 0}, 
      {0, 1, 0}, 
      {0, 0, 0}
    }), 
    new Kernel( new float[][] {
      {.111, .111, .111}, 
      {.111, .111, .111}, 
      {.111, .111, .111}
    }), 
    new Kernel( new float[][] {
      {0, -1, 0}, 
      {-1, 5, -1}, 
      {0, -1, 0}
    }), 
    new Kernel( new float[][] {
      {-1, -1, -1}, 
      {-1, 8, -1}, 
      {-1, -1, -1}
    }), 
    new Kernel( new float[][] {
      {1, 0, -1}, 
      {2, 0, -2}, 
      {1, 0, -1}
    }), 
    new Kernel( new float[][] {
      {-1, 0, 1}, 
      {-2, 0, 2}, 
      {-1, 0, 1}
    }), 
    new Kernel( new float[][] {
      {1, 2, 1}, 
      {0, 0, 0}, 
      {-1, -2, -1}
    }), 
    new Kernel( new float[][] {
      {-2, -1, 0}, 
      {-1, 1, 1}, 
      {0, 1, 2}
    })
  };
  size(1450, 500);
}

void draw() {
  k.apply(car, output);
  image(car, 0, 0);
  image(output, car.width, 0);
  textSize(30);
  fill(0);
  text(names[currentKernel], 20, 50);
}

void keyPressed() {
  if (key == ' ') {
    currentKernel++;
  } 
  if (currentKernel == names.length) {
    currentKernel = 0;
  }
}
