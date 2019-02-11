import java.awt.*;
import objectdraw.*;
/**
 * Write a description of class TennisBall here.
 * 
 * @author (174995) 
 * @version (021119)
 */
public class TennisBall extends RubberBall
{
    // instance variables - replace the example below with your own
    private FramedArc leftCut,rightCut;
    public TennisBall(int x, int y, int size, DrawingCanvas canvas)
    {
        super(x,y,size,canvas);
        setColor(Color.YELLOW);
        rightCut = new FramedArc(x + size*2/3,y,size,size,130,100,canvas);
        leftCut = new FramedArc(x - size*2/3,y,size,size,310,100,canvas);
        
    }
    
    public void move(double dx, double dy)
    {
        super.move(dx,dy);
        rightCut.move(dx,dy);
        leftCut.move(dx,dy);
    
    }
}
