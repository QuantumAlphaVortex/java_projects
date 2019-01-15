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
    private FilledOval ballGraphic;
    // the canvas
    private DrawingCanvas canvas;

    public TargetBall (Location initialLocation, DrawingCanvas aCanvas) {
        this.canvas = aCanvas;
        ballGraphic = new FilledOval(initialLocation, SIZE, SIZE, canvas);
        //start();
        
    }

    public void run() {
        
        while (ballGraphic.getX() >= 0 &&  ballGraphic.getX() <= canvas.getWidth() ) {
            ballGraphic.move(direction,0);
            pause(DELAY_TIME);

            if ( ballGraphic.getX() > canvas.getWidth() && direction == X_STEP_RIGHT) {
               direction =  X_STEP_LEFT;
               ballGraphic.move(direction*2,0);
           }else if(ballGraphic.getX() <= 0) { 
               direction = X_STEP_RIGHT;
               ballGraphic.move(direction*2,0);
            }
        }

    }
}
