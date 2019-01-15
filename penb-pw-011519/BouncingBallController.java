import objectdraw.*;
import java.awt.*;

public class BouncingBallController extends WindowController {

    private static final Location INSTR_LOCATION = new Location(100,25); 
    private BouncingBall myBall;
    private Text instructions;
    private Text score;
    private Text ammo;
    private TargetBall myTarget;
    private FilledRect myRifle;
    
    public void begin() {       
        // display instructions
        instructions = new Text("Shoot the Target!", INSTR_LOCATION, canvas);
        myTarget = new TargetBall((new Location(0,0)),canvas);
        myTarget.start();
        myRifle = new FilledRect(canvas.getWidth(),canvas.getHeight()-50,10,50,canvas);

    }

    public void onMouseDrag(Location point) {
        myRifle.moveTo(point.getX(),canvas.getHeight()-50);
    }
    
    public void onMouseMove(Location point) {
        myRifle.moveTo(point.getX(),canvas.getHeight()-50);
    }
    
    public void onMousePress(Location point ) {
        // make a new ball when the player clicks

        myBall = new BouncingBall(new Location(point.getX(),canvas.getHeight()-50),canvas);
        myBall.start();
        //score = new Text("Your Score is:");
        //ammo = new Text("Bullet Count:");
    } 
    
}       
