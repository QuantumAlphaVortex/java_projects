import objectdraw.*;
import java.awt.*;
/**
 * Write a description of class RubberBall here.
 * 
 * @author (174995) 
 * @version (021119)
 */
public class RubberBall extends FilledOval
{
    // instance variables - replace the example below with your own

    private FramedOval outline;
    public RubberBall(int x, int y, int size,DrawingCanvas canvas)
    {
        super(x,y,size,size,canvas);
        // FilledOval(x,y,size,size,canvas);
        setColor(Color.RED);
        outline = new FramedOval(x,y,size,size,canvas);
    }

    public void move(double dx, double dy)
    {
        super.move(dx,dy);
        outline.move(dx,dy);
    }
}
