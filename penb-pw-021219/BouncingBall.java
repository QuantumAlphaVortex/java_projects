import objectdraw.*;
import java.awt.*;

public class BouncingBall extends BouncingShape {

    // the size of the ball
    private static final int SIZE = 20;
    private static final int DELAY_TIME = 33;
    // random number generator used for random colors
    private RandomIntGenerator rand;

    // the image of the ball
    private FramedOval ballGraphic;

    // Constructor requires intial position, x and y speeds, and DrawingCanvas
    public BouncingBall (Location initialLocation, Double initialXSpeed, double initialYSpeed, DrawingCanvas aCanvas) {
        super(initialLocation, initialXSpeed, initialYSpeed, aCanvas);
        ballGraphic = new FramedOval(initialLocation, SIZE, SIZE, getCanvas());
        rand = new RandomIntGenerator(1,4);
        changeColor();
        start();
    }

    // Implementation of abstract methods here:
    
    public void move (double x, double y)
    {
        ballGraphic.move(x,y);
    }

    public boolean contains (Location point)
    {
        return ballGraphic.contains(point);
    }

    public double getWidth()
    {
        return ballGraphic.getWidth();
    }

    public boolean hitsBottom ()
    {
        return ballGraphic.getY() + ballGraphic.getHeight() >= getCanvas().getHeight();
    }

    public boolean hitsSide ()
    {
        return ballGraphic.getX() + ballGraphic.getWidth() >= getCanvas().getWidth() || ballGraphic.getX() <= 0;
    }

    public void changeColor ()
    {
        if (rand.nextValue() == 1)
            ballGraphic.setColor(Color.RED);
        else if (rand.nextValue() == 2)
            ballGraphic.setColor(Color.BLUE);
        else if (rand.nextValue() == 3)
            ballGraphic.setColor(Color.YELLOW);
        else 
            ballGraphic.setColor(Color.GREEN);
    }
}
