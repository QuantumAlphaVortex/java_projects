import objectdraw.*;
import java.awt.*;

public class TargetBall extends ActiveObject {

    // the size of the ball
    private static final int SIZE = 50;

    // the delay between successive moves of the ball
    private static final int DELAY_TIME = 33;
    // number of pixels ball falls in a single move
    private static final double X_STEP_RIGHT = +5;
    private static final double X_STEP_LEFT = -5;
    private double direction = X_STEP_RIGHT;
    // the image of the ball
    private FilledOval targetGraphic;
    // the canvas
    private DrawingCanvas canvas;

    public TargetBall (Location initialLocation, DrawingCanvas aCanvas) {
        this.canvas = aCanvas;
        targetGraphic = new FilledOval(initialLocation, SIZE, SIZE, canvas);
        //start();
        
    }

    public void run() {
        
        while (targetGraphic.getX() >= 0 &&  targetGraphic.getX() <= canvas.getWidth() ) {
            targetGraphic.move(direction,0);
            pause(DELAY_TIME);

            if ( targetGraphic.getX() > canvas.getWidth() && direction == X_STEP_RIGHT) {
               direction =  X_STEP_LEFT;
               targetGraphic.move(direction*2,0);
           }else if(targetGraphic.getX() <= 0) { 
               direction = X_STEP_RIGHT;
               targetGraphic.move(direction*2,0);
            }
        }

    }
    
    public FilledOval targetGraphic() {
        return targetGraphic;
    }
}
