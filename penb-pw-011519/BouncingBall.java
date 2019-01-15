import objectdraw.*;
import java.awt.*;

public class BouncingBall extends ActiveObject {

    // the size of the ball
    private static final int SIZE = 10;

    // the delay between successive moves of the ball
    private static final int DELAY_TIME = 33;
    // number of pixels ball falls in a single move
    private static final double Y_STEP = -4;

    // the image of the ball
    private FilledOval ballGraphic;
    // the canvas
    private DrawingCanvas canvas;

    public BouncingBall (Location initialLocation, DrawingCanvas aCanvas) {
        this.canvas = aCanvas;
        ballGraphic = new FilledOval(initialLocation, SIZE, SIZE, canvas);
        //start();
        
    }
    
    public void run() {
        while (ballGraphic.getY() <= canvas.getHeight() && ballGraphic.getY() >= 0 ) {
           ballGraphic.move(0, Y_STEP);
            pause(DELAY_TIME);
        }
        ballGraphic.removeFromCanvas();
    }
}
