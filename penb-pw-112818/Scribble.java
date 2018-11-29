import objectdraw.*;
import java.awt.*;

// This program allows its user to draw simple lines on the screen
// using the mouse as if it were a pencil.
public class Scribble extends WindowController {

    private Location previousPosition;   // Last known position of mouse
    private Text myText;    
    private boolean drawing;
    private FilledOval myOval;
    // Mode status
    public void begin() {
        myText = new Text("Draw Mode",0,0,canvas);
        drawing = true;
    }

    // When the mouse button is depressed, note its location
    public void onMousePress( Location pressPoint) {
        previousPosition = pressPoint;
    }   
    
    public void onMouseRelease()
    {
         myText.sendToFront();
    }
    
    // Connect current and previous mouse positions with a line
    public void onMouseDrag( Location currentPosition) {

        // If statement 
        if(drawing)
        {
            //Draw line
            new Line( previousPosition, currentPosition, canvas);
            
        } else {
            // Draw white circle 
            //create FilledOval (and save to a variable)
            myOval = new FilledOval( currentPosition, 50, 50, canvas);
            myOval.move(-25,-25);
            myOval.setColor(Color.white);
            //change color of variable
            
            //move oval so mouse is in CENTER of circle.
            // Bring Mode staus to front
            myText.sendToFront();
        }
        previousPosition = currentPosition;
    }
    
    // When clicked switch to draw white circle
    public void onMouseClick( Location status) {
        // switch Mode
        if(drawing)
        {
            // Drawing mode 
            myText.setText("Erase Mode");
            drawing = false;
        } else {
            // Erasing mode
            myText.setText("Draw Mode");
            drawing = true;
        }
    }
    
}
