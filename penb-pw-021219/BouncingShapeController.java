import objectdraw.*;
import java.awt.*;

public class BouncingShapeController extends WindowController {

    private static final Location INSTR_LOCATION = new Location(100,25); 
    private static final int MAX_NUM = 1000;
    private int number;
    private RandomDoubleGenerator randSpeed;
    private RandomDoubleGenerator rand0To1;
    private BouncingShape lastBouncingShape;
    private BouncingShape [] shape;
    private Location lastPoint;
    private boolean dragging;
    private int indexDragged;

    public void begin() { 
        shape = new BouncingShape[MAX_NUM];
        dragging = false;
        number = 0;
        resize(600, 500);
        // display instructions
        new Text("Click to make a falling shape...", INSTR_LOCATION, canvas);
        randSpeed = new RandomDoubleGenerator(-0.5, 0.5);
        rand0To1 = new RandomDoubleGenerator(0, 1);
        //new FilledRect(0, 0, canvas.getWidth(), canvas.getHeight(), canvas);
    }

    public void onMousePress (Location pressPoint)
    {
        boolean shapeContainsPoint = false;

        for (int i = 0; i < number; i++)
            if (shape[i].contains(pressPoint)) {
                indexDragged = i;
                shapeContainsPoint = true;
                break;
        }

        if (!shapeContainsPoint) {
            dragging = false;
        }
        else {
            lastPoint = pressPoint;
            dragging = true;
            shape[indexDragged].setDragging();
        }
    }

    public void onMouseRelease (Location point)
    {
        if (shape[indexDragged] != null) {
            shape[indexDragged].clearDragging();
            shape[indexDragged].resetRecoil();
        }
    }

    public void onMouseClick(Location point) {
        // make a new Shape when the player clicks
        // don't create if it's to the right of the "wall."
        if (point.getX() < canvas.getWidth()) {
            if (point.getX() < canvas.getWidth()) {
                if (rand0To1.nextValue() <= 0.25)
                    shape[number] = new BouncingBall(point, 10*randSpeed.nextValue(), randSpeed.nextValue(), canvas);
                else if (rand0To1.nextValue() <= 0.5)
                    shape[number] = new BouncingRectangle(point, 10*randSpeed.nextValue(), randSpeed.nextValue(), canvas);
                else if (rand0To1.nextValue() <= 0.75)         
                    shape[number] = new BouncingStar(point, 10*randSpeed.nextValue(), randSpeed.nextValue(), canvas);
                else
                    shape[number] = new BouncingTriangle(point, 10*randSpeed.nextValue(), randSpeed.nextValue(), canvas);
                number++;
            } 
        }
    }

    public void onMouseDrag(Location point) {
        // make a new Shape when the player clicks
        if (!dragging)
        {
            if (point.getX() < canvas.getWidth()) {
                if (rand0To1.nextValue() <= 0.25)
                    shape[number] = new BouncingBall(point, 10*randSpeed.nextValue(), randSpeed.nextValue(), canvas);
                else if (rand0To1.nextValue() <= 0.5)
                    shape[number] = new BouncingRectangle(point, 10*randSpeed.nextValue(), randSpeed.nextValue(), canvas);
                else if (rand0To1.nextValue() <= 0.75)         
                    shape[number] = new BouncingStar(point, 10*randSpeed.nextValue(), randSpeed.nextValue(), canvas);
                else
                    shape[number] = new BouncingTriangle(point, 10*randSpeed.nextValue(), randSpeed.nextValue(), canvas);
                number++;
            }              dragging = false;
        }
        else
        {
            if (shape[indexDragged] != null)
            {
                shape[indexDragged].move(point.getX()-lastPoint.getX(), point.getY() - lastPoint.getY());
                lastPoint = point;
                dragging = true;
            }
        }
    }

}       
