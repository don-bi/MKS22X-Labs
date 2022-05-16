public class Kernel {
  float[][]kernel;

  /**Constructor takes the kernel that will be applied to the image
   *This implementation only allows 3x3 kernels
   */
  public Kernel(float[][]init) {
    kernel = init;
  }

  /**If part of the kernel is off of the image, return black, Otherwise
   *Calculate the convolution of r/g/b separately, and return that color\
   *if the calculation for any of the r,g,b values is outside the range
   *     0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255)
   */
  color calcNewColor(PImage img, int x, int y) {
    if (x == 0 || x == img.width-1 || y == 0 || y == img.height-1){
      return 0;
    } else {
      float[] sumrgb = {0,0,0};
      for (int incx = -1; incx <= 1; incx++){
        for (int incy = -1; incy <= 1; incy++){
          color c = img.get(x+incx,y+incy);
          float[] rgb = {red(c),green(c),blue(c)};
          for (int i = 0; i < rgb.length; i ++){
            float currentc = rgb[i]*kernel[incx+1][incy+1];
            if (currentc < 0) currentc = 0;
            if (currentc > 255) currentc = 255;
            sumrgb[i] += currentc;
          }
        }
      }
      return color(sumrgb[0],sumrgb[1],sumrgb[2]);
    }
  }

  /**You must write this method that applies the kernel to the source,
   *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
  }
}
