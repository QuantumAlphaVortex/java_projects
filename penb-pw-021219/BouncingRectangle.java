import objectdraw.*;
import java.awt.*;

public class BouncingRectangle extends BouncingShape {

    // the size of the rect
    private static final int SIZE = 20;
    private static final int DELAY_TIME = 33;
    private RandomIntGenerator rand;

    // the image of the rect
    private FramedRect rectGraphic;

    // Constructor requires intial position, x and y speeds, and DrawingCanvas
    public BouncingRectangle (Location initialLocation, Double initialXSpeed, double initialYSpeed, DrawingCanvas aCanvas) {
        super(initialLocation, initialXSpeed, initialYSpeed, aCanvas);
        rectGraphic = new FramedRect(initialLocation, SIZE, SIZE, getCanvas());
        rand = new RandomIntGenerator(1,4);
        changeColor();
        start();
    }

    // Implementation of abstract methods here:

    public void move (double x, double y)
    {
        rectGraphic.move(x,y);
    }

    public boolean contains (Location point)
    {
        return rectGraphic.contains(point);
    }

    public double getWidth()
    {
        return rectGraphic.getWidth();
    }

    public boolean hitsBottom ()
    {
        return rectGraphic.getY() + rectGraphic.getHeight() >= getCanvas().getHeight();
    }

    public boolean hitsSide ()
    {
        return rectGraphic.getX() + rectGraphic.getWidth() >= getCanvas().getWidth() || rectGraphic.getX() <= 0;
    }

    public void changeColor ()
    {
        if (rand.nextValue() == 1)
            rectGraphic.setColor(Color.RED);
        else if (rand.nextValue() == 2)
            rectGraphic.setColor(Color.BLUE);
        else if (rand.nextValue() == 3)
            rectGraphic.setColor(Color.YELLOW);
        else 
            rectGraphic.setColor(Color.GREEN);
    }

}
