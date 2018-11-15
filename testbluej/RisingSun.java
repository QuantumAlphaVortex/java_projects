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
public class RisingSun extends WindowController
{
    // instance variables - also known as an object property
    private int x;
    private Text label;

    /**
     * Constructor for objects of class TestBlueJ
     * Alice didn't allow you to create objects except in scene setup
     * Java lets you create objects whenever you want to.
     */
    

    private FilledOval sun; 
	private Text instructions;
	private Location initialLocation = new Location(150,300);

    //This is an event method that basically is equivalent to myFirstMethod
    // It runs after WindowController creates the window but before any other events.    
    public void begin()
    {
       sun = new FilledOval ( initialLocation, 100, 100, canvas );
	
		Color myColor = new Color(0, 200, 255);

       sun.setColor(myColor);
       instructions = new Text( " Please click the mouse repeatedly", 20, 20, canvas);

    }
    
      
    public void onMouseExit(Location p)
    {
        sun.moveTo(initialLocation);
		instructions.show();
    }
    
   
    public void onMouseClick(Location point)
    {
        sun.move(0,-10);
		instructions.hide();
    }
    
}
