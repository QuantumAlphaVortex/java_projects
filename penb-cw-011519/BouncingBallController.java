import objectdraw.*;
import java.awt.*;

public class BouncingBallController extends WindowController {

    private static final Location INSTR_LOCATION = new Location(100,25); 
    private BouncingBall myBall;
    private Text instructions;
    
    public void begin() {       
        // display instructions
        instructions = new Text("Click to make a falling ball...", INSTR_LOCATION, canvas);
    }

    public void onMouseClick(Location point ) {
        // make a new ball when the player clicks
        myBall = new BouncingBall(new Location(point.getX(),canvas.getHeight()),canvas);
        myBall.start();
        instructions.setText("Just made a new falling ball.");
    } 
    
}       
