import objectdraw.*;
import java.awt.*;

/**
 * Write a description of class TextBoxMiddleOfCanvas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBoxMiddleOfCanvas extends WindowController{
    
    private Location firstPoint; 
    private FramedRect box; 
    Text myTextS, myTextM;
    // The location where button was pressed
   //DrawingCanvas canvas;
     public void begin()
    {
        box = new FramedRect(0,0,0,0,canvas);
        myTextS = new Text("(x,y)", 0,0  , canvas);
        double x = canvas.getWidth()/2 - myTextS.getWidth()/2;
        double y = canvas.getHeight() - (myTextS.getHeight());
        myTextS.moveTo(x,y);
        myTextM = new Text("(x,y)", 0,0  , canvas);        
        
    }    
    // Display "Pressed" when the button is pressed.
    public void onMousePress(Location pressPoint){
        firstPoint = pressPoint;
        System.out.println("This goes to the console");
        myTextS.setText("X:" + pressPoint.getX() + "Y:" + pressPoint.getY());

        double x = pressPoint.getX();
        double y = pressPoint.getY();
        

                  
    }
    
    public void onMouseDrag(Location dragP)
    {
        
       if( box != null)
       {
          box.hide(); 
       }
  
       myTextS.setText("X:" + dragP.getX() + "Y:" + dragP.getY());

       double newX, newY ,width,height;
         
        //New x coordinate is the lesser of both x coordinates
        newX = Math.min(firstPoint.getX(),dragP.getX());
        //New Y coordinate is the lesser of both Y coordinates
        newY = Math.min(firstPoint.getY(),dragP.getY());
        
        // width is absolute value of the difference of both X coords
        width = Math.abs(firstPoint.getX() - dragP.getX());
        //height is absolute value of the difference of both Y coords
        height = Math.abs(firstPoint.getY() - dragP.getY());
        
        //Move to new location
        box.moveTo(newX,newY);
        //resize current rectangle.
        box.setHeight(height);
        box.setWidth(width);
        //Make sure rectangle is visible
        box.show();       
        
        myTextM.moveTo(box.getX() + box.getWidth()/2 - myTextM.getWidth()/2,
                       box.getY() + box.getHeight()/2 - myTextM.getHeight()/2);
        //now I will move the text box where I want it...
        myTextM.setText("X:" + box.getWidth() + "Y:" + box.getHeight());
    }

    // Display "Released" and draw a line from where the mouse
    // was last pressed.
    public void onMouseRelease(Location releasePoint){
        new FramedRect(firstPoint, releasePoint, canvas);
        box.hide();
    }

   
}