import java.awt.*;
import objectdraw.*;
/**
 * Write a description of class DecisionMaking here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DecisionMaking extends WindowController
{
    // instance variables - replace the example below with your own
    private double midX;
    private Text display;
    private FilledRect myRect;
    private boolean rectanglePressed = false;
    private Location prevPoint;
    /**
     * Constructor for objects of class DecisionMaking
     */
    public void begin()
    {
        // initialise instance variables
        midX = canvas.getWidth()/2;
        myRect =  new FilledRect(100,100,30,70,canvas);
        
        display = new Text("Nothing clicked yet",50,50,canvas);
    }

    
    public void onMousePress(Location point)
    {
       if(myRect.contains(point))
       {
            
            // inside the rectangle
            rectanglePressed = true;
            prevPoint = point;
       } else {

            // Outside the rectangle
            rectanglePressed = false;            
       }
         
    }
    
    public void onMouseDrag(Location point)
    {
       double dx;
       double dy;
       
       if(rectanglePressed)
        {
            dx = point.getX() - prevPoint.getX();
            dy = point.getY() - prevPoint.getY();
            myRect.move(dx, dy);
            prevPoint = point;
        }
        
        
    }
}
