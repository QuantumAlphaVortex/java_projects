import objectdraw.*;
/**
 * Write a description of class BallController here.
 * 
 * @author (174995) 
 * @version (021119)
 */
public class BallController extends WindowController
{
    private FilledOval[] balls;
    
    public void begin()
    {
         /*   
        new FilledOval(0,0,300,300,canvas);
        new Text("Filled oval",0,300,canvas);
        new RubberBall(325,0,300,canvas);
        new Text("Rubber Ball",325,300,canvas); 
        TennisBall myTennisBall = new TennisBall(0,325,300,canvas);
        myTennisBall.move(10,0);
        new Text("Tennis Ball",0,625,canvas); 
        BasketBall myBasketBall = new BasketBall(325,325,300,canvas);
        new Text("Basket Ball", 325,625,canvas);
        myBasketBall.move(40,0);
        resize(500,800);
        /**/
        //An Array of FilledOvals which will include any class that extends a FilledOval
            balls = new FilledOval[4];
            
            balls[0] = new FilledOval(0,0,300,300,canvas);
            new Text("Filled Oval",0,300,canvas);
            //Uncomment these lines as you create each new Class.
        balls[1] = new RubberBall(325,0,300,canvas);
            new Text("Rubber Ball",325,300,canvas);
            balls[2] = new TennisBall(0,325,300,canvas);
            balls[2].move(10,0);
            new Text("Tennis Ball",0,625,canvas);
            balls[3] = new BasketBall(325,325,300,canvas);
            new Text("Basket Ball",325,625,canvas);
            balls[3].move(40,0);
            resize(800,800);
            
           
           
    }
    
}
