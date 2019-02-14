import objectdraw.*;
import java.awt.*;

public class BouncingTriangle extends BouncingShape {

    // the size of the triangle
    private static final int SIZE = 20;
    private static final int DELAY_TIME = 33;
    private RandomIntGenerator rand;

    // the image of the triangle
    private Triangle triangleGraphic;
    private Location vert1, vert2, vert3;

    public BouncingTriangle (Location initialLocation, Double initialXSpeed, double initialYSpeed, DrawingCanvas aCanvas) {
        super(initialLocation, initialXSpeed, initialYSpeed, aCanvas);
        vert1 = initialLocation;
        vert2 = new Location(initialLocation.getX() + 18, initialLocation.getY() - 17);
        vert3 = new Location(initialLocation.getX() + 50, initialLocation.getY() + 23);
        triangleGraphic = new Triangle(vert1, vert2, vert3, getCanvas());
        rand = new RandomIntGenerator(1, 4);
        changeColor();
        start();
    }
    
    // Implmentation of abstract methods here:

    public void move (double x, double y)
    {
        triangleGraphic.move(x,y);
    }

    public boolean contains (Location point)
    {
        return triangleGraphic.contains(point);
    }

    public double getWidth()
    {
        return triangleGraphic.getWidth();
    }

    public boolean hitsBottom ()
    {
        return triangleGraphic.getY() + triangleGraphic.getHeight() >= getCanvas().getHeight();
    }

    public boolean hitsSide ()
    {
        return triangleGraphic.getX() + triangleGraphic.getWidth() >= getCanvas().getWidth() || triangleGraphic.getX() <= 0;
    }

    public void changeColor ()
    {
        if (rand.nextValue() == 1)
            triangleGraphic.setColor(Color.RED);
        else if (rand.nextValue() == 2)
            triangleGraphic.setColor(Color.BLUE);
        else if (rand.nextValue() == 3)
            triangleGraphic.setColor(Color.YELLOW);
        else 
            triangleGraphic.setColor(Color.GREEN);
    }

}
