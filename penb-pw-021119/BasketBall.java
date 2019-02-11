import objectdraw.*;
import java.awt.*;
/**
 * Write a description of class BasketBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BasketBall extends TennisBall
{
    // instance variables - replace the example below with your own

    private Line horizontalLine,verticalLine; 
    
    public BasketBall(int x, int y, int size, DrawingCanvas canvas)
    {
        super(x,y,size,canvas);
        setColor(Color.ORANGE);
        horizontalLine = new Line(x,y+size/2,x+size,y+size/2,canvas);
        verticalLine = new Line(x+size/2,y,x+size/2,y+size,canvas);
    }
    
    public void move(double dx, double dy)
    {
        super.move(dx,dy);
        horizontalLine.move(dx,dy);
        verticalLine.move(dx,dy);
    
    }
}
