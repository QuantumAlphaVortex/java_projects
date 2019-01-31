/*
 * HwMain is a template program for use with the image processing homework assignments.
 * 
 */
import objectdraw.*;
import java.awt.*;

public class HwMain extends WindowController{

    /**
     * Entry point for the program
     * @param args
     */
    public void begin() {                    
            // Read a file and create a SimpleImage out of it
            SimpleImage img = new SimpleImage("GREEN.jpg");
            Color[][] pixels = img.getPixelArray();

            Color pixel;
            int r,g,b;
            int redSum=0,greenSum=0,blueSum=0;
            int redMax=0,greenMax=0,blueMax=0;
            int redMin=255,greenMin=255,blueMin=255;
            
            for(int row = 0; row < pixels.length; row++) {
                for(int column = 0; column < pixels[row].length; column++) {
                    r = pixels[row][column].getRed();
                    g = pixels[row][column].getGreen();
                    b = pixels[row][column].getBlue();
                    redSum   += r;
                    if(r > redMax) redMax = r;
                    if(r < redMin) redMin = r;
                    greenSum += g;
                    if(g > greenMax) greenMax = g;
                    if(g < greenMin) greenMin = g;
                    blueSum  += b;
                    if(b > blueMax) blueMax = b;
                    if(b < blueMin) blueMin = b;
                    
                }
            }
            System.out.println("red max is: " + redMax);
            System.out.println("red min is: " + redMin);

            System.out.println("green max is: " + greenMax);
            System.out.println("green min is: " + greenMin);

            System.out.println("blue max is: " + blueMax);
            System.out.println("blue min is: " + blueMin);

            // iterate through all the pixels
            // PUT YOUR CODE HERE
            SimpleImage imgbg = new SimpleImage("nature.JPG");
            pixels = imgbg.getPixelArray();
            
            SimpleImage imgtg = new SimpleImage("green_screen.png");
            Color[][] pixelstg = imgtg.getPixelArray();

            for(int row = 0; row < pixelstg.length; row++) {
                for(int column = 0; column < pixelstg[row].length; column++) {
                    r = pixelstg[row][column].getRed();
                    g = pixelstg[row][column].getGreen();
                    b = pixelstg[row][column].getBlue();
                    //if this pixel is "green"
                    if(r == 91 && g == 255 && b == 8) {
                        //replace current pixel with pixel from bgimage
                        pixelstg[row][column] = pixels[row][column];
                    }
                }
            }

            // Let's create a brand new output image
            SimpleImage output = new SimpleImage(img.width(), img.height());
            
            // and set the pixels to be the values from our pixel array
            output.setPixels(pixelstg);
            output.save("testoutput.jpg");
            
            //Create a visible image on the canvas from the output.
            new VisibleImage(output.getRawImage(),0,0,canvas);
    }  
}
