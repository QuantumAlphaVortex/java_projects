// Always include this line
import objectdraw.*;
import java.awt.*;
/**
 * Write a description of class TestBlueJ here.
 * 
 * @author (Benjamin Pen) 
 * @version (11-14-18)
 */
//For now all of your classes will extend WindowController
public class DrawingExample extends WindowController
{
    // instance variables - also known as an object property
    private int x;
    private Text label;

    /**
     * Constructor for objects of class TestBlueJ
     * Alice didn't allow you to create objects except in scene setup
     * Java lets you create objects whenever you want to.
     */
    //This is an event method that basically is equivalent to myFirstMethod
    // It runs after WindowController creates the window but before any other events.    
    
    private Location initialPoint; 
      
    public void onMousePress(Location pressPoint)
    {
        //new Text("Pressed", pressPoint, canvas);
        initialPoint = pressPoint;
    }
    
   
    public void onMouseDrag(Location releasePoint)
    {
         //new Text("Release", releasePoint, canvas);
         new Line(initialPoint, releasePoint, canvas);
         
         initialPoint = releasePoint;
    }
    
}
