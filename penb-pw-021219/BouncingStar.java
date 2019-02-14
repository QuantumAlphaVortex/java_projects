import objectdraw.*;
import java.awt.*;

public class BouncingStar extends BouncingShape {

    // the size of the star
    private static final int SIZE = 20;
    private static final int DELAY_TIME = 33;
    private RandomIntGenerator rand;

    // the image of the star
    private DecoratedStar starGraphic;

    public BouncingStar (Location initialLocation, Double initialXSpeed, double initialYSpeed, DrawingCanvas aCanvas) {
        super(initialLocation, initialXSpeed, initialYSpeed, aCanvas);
        starGraphic = new DecoratedStar(initialLocation, 5, SIZE/4.0, SIZE, getCanvas());
        rand = new RandomIntGenerator(1,4);
        changeColor();
        start();
    }
    
    //Implementation of abstract methods here:

    public void move (double x, double y)
    {
        starGraphic.move(x,y);
    }

    public boolean contains (Location point)
    {
        return starGraphic.contains(point);
    }

    public double getWidth()
    {
        return starGraphic.getWidth();
    }

    public boolean hitsBottom ()
    {
        return starGraphic.getY() + starGraphic.getHeight() >= getCanvas().getHeight();
    }

    public boolean hitsSide ()
    {
        return starGraphic.getX() + starGraphic.getWidth() >= getCanvas().getWidth() || starGraphic.getX() <= 0;
    }

    public void changeColor ()
    {
        if (rand.nextValue() == 1)
           starGraphic.setColor(Color.RED);
        else if (rand.nextValue() == 2)
            starGraphic.setColor(Color.BLUE);
        else if (rand.nextValue() == 3)
            starGraphic.setColor(Color.YELLOW);
        else 
            starGraphic.setColor(Color.GREEN);
    }
    

}
