import objectdraw.*;
import java.awt.Color;
/**
 * Write a description of class DrawShapeController here.
 * 
 * @author (ankiewiczk) 
 * @version (4-3-18)
 */
public class DrawShapeController extends WindowController
{
    RandomIntGenerator gen = new RandomIntGenerator(1,3);
    RandomDoubleGenerator lengthGen = new RandomDoubleGenerator(30,100);
    RandomDoubleGenerator coordXGen,coordYGen;
    
    Polygon lastShape;
    
    public void begin() {
         coordXGen = new RandomDoubleGenerator(0,canvas.getWidth());
         coordYGen = new RandomDoubleGenerator(0,canvas.getHeight());
    }
    
    public void onMouseClick(Location loc) {
        int next = gen.nextValue();
        double length = lengthGen.nextValue();
        
        if(lastShape!= null)
        {
            lastShape.moveTo(coordXGen.nextValue(),coordYGen.nextValue());
        }

        if(next ==1) {
            lastShape = new Triangle(loc,length,canvas);
        } else if (next==2) {
            lastShape = new Diamond(loc,length,canvas);
        } else {
            lastShape = new Pentagon(loc,length,canvas);
        }
        
        if(gen.nextValue() ==1) {
            lastShape.setColor(Color.RED);
        } else if (next==2) {
            lastShape.setColor(Color.GREEN);            
        } else {
            lastShape.setColor(Color.BLUE);
        }
    }
}
