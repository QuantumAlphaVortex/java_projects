import objectdraw.*;
import java.awt.*;

/*
 * This is a class that abstracts the behavior of falling under the
 * force of gravity, as well as bouncing off the bottom and the sides
 * of the canvas.
 */
public abstract class BouncingShape extends ActiveObject {

    private static final int SIZE = 20;

    // the delay between successive moves of the ball
    private static final int DELAY_TIME = 33;
    
    // "speed" of motion, in pixels per move, both x and y components:
    private double ySpeed, xSpeed;
    
    //acceleration of "gravity"
    private double g = 0.2;
    //used to dampen the bounce of the object:
    private double recoil;
    private double initialRecoil;
    //boolean variable that determines if object is falling:
    private boolean falling;
    //boolean variable that determines if object is being dragged:
    private boolean dragging;
    
    private DrawingCanvas canvas;

    /*
     * Constructor requires initial location, initial x and y speeds, and the canvas.
     * NOTE: After calling this constructor in a derived class (via super(...)), you
     * must invoke start(), otherwise the ActiveObject features will not work.
     */
    public BouncingShape (Location initialLocation, Double initialXSpeed, double initialYSpeed, DrawingCanvas aCanvas) {
        canvas = aCanvas;
        xSpeed = initialXSpeed;
        ySpeed = initialYSpeed;
        recoil = 0.9999;
        initialRecoil = recoil;
        falling = true;
        dragging = false;
    }

    //Return current DrawingCanvas
    public DrawingCanvas getCanvas () {
        return canvas;
    }

    /*
     * Resets the recoil. Use this after the object has been dragged and
     * dropped (see BouncingShapeController.onMouseRelease()).
     */
    public void resetRecoil()
    {
        recoil = initialRecoil;
    }

    /*
     * To stop the object from falling
     */
    public void stopFalling ()
    {
        falling = false;
    }

    /*
     * To determine if the object is falling
     */
    public boolean getFalling() {
        return falling;
    }

    /*
     * To make it so the object is being dragged
     */
    public void setDragging ()
    {
        dragging = true;
    }

    /*
     * To make it so the object is not being dragged
     */
    public void clearDragging ()
    {
        dragging = false;
    }

    /*
     * To move the object. To use this in a derived class,
     */
    public void move ()
    {
        if (!dragging)
        {
            ySpeed = ySpeed + g;

            //If ball hits the bottom, change vertical direction, and recoil
            if (hitsBottom())
            {
                ySpeed = -recoil * ySpeed;
                recoil = recoil * 0.97;
                changeColor();
            }

            //If ball hits left or right, change horizontal direction
            if (hitsSide())
            {
                xSpeed = -xSpeed;
                changeColor();
            }

            //Set speed to 0 if too small and ball is at bottom
            if (Math.abs(ySpeed) <= 0.001 && hitsBottom())
            {
                xSpeed = 0;
            }

            move(xSpeed, ySpeed);
        }
    }

    public void run() {
        while (getFalling()) {
            move();
            pause(DELAY_TIME);
        }
    }

    /*
     * The following methods MUST all be implemented in a derived class
     * if it is to be used to create objects.
     */
    
    /*
     * Moves the object by dx and dy
     */
    public abstract void move (double x, double y);
    /*
     * Determines if object has hit the bottom of the canvas
     */
    public abstract boolean hitsBottom ();
    /*
     * Determines if the object has hit the sides of the canvas
     */
    public abstract boolean hitsSide ();
    /*
     * Returns the width of the object
     */
    public abstract double getWidth();
    /*
     * Returns true iff the object contains the point
     */
    public abstract boolean contains (Location point);
    /*
     * Changes the color of the object (in a manner determined
     * by the derived class).
     */
    public abstract void changeColor();
}
