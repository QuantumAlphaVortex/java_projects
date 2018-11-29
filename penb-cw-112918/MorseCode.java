import objectdraw.*;
import java.awt.*;

// A program to display Morse code entered by pressing
// the mouse as dots and dashes on the canvas.
public class MorseCode extends WindowController {
    
    // Location where code entered is displayed
    private static final Location DISPLAY_POS = new Location( 30, 30);
    // Minimum time (in milliseconds) for a dash
    private static final double DASH_TIME = 200;
    
    // String to hold sequence entered so far
    private String currentCode = "Code =";
    // Text used to display sequence on canvas
    private Text display;
	private Text sosDisplay;
   
    // Time when mouse was last depressed
    private double pressTime;
    
    
    // Create display
    public void begin()
    {
        display = new Text(currentCode, DISPLAY_POS, canvas);
		sosDisplay = new Text("",30,50,canvas);
    }
    
    // Record time at which mouse was depressed
    public void onMousePress (Location point)
    {
        pressTime = System.currentTimeMillis();
    }
    
    // Add a dot or dash depending on click length
    public void onMouseRelease( Location point)
    {
        if ( System.currentTimeMillis() - pressTime > DASH_TIME )
            {
                currentCode = currentCode + " -";
            }  
        else  
            {
                currentCode = currentCode + " .";
            }
        display.setText( currentCode );
        //cannot use == on String objects    
		if (currentCode.equals("Code = . . . - - -"))
			sosDisplay.setText("SOS");   
		else
			sosDisplay.setText("");
    }
}
