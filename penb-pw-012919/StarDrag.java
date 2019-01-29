
/**
 * StarDrag - A program to create and drag star objects.
 * 
 * Click to draw new stars.
 * Press and drag the blue star.
 * 
 * @author John Magee 
 * @version 11/11/2013
 */
import objectdraw.*;
import java.awt.*;

public class StarDrag extends WindowController
{
    
    // whether happy has been grabbed by the mouse
    //private boolean doubleClick = false;
    private boolean[] starGrabbedArray; 
    //private boolean[] allStars;
    private Star grabbedStar;
    private Star[] starArray;
    private int grabbedIndex;
    private int count;
    private Location lastPoint;
    
    
    // make the Star
    public void begin() {
        starArray = new Star[100];
        starGrabbedArray = new boolean[100];
        starArray[count++] = new Star(new Location(50,50),5,10,25,canvas);
        
        starArray[count-1].setColor(Color.GREEN);
    }
    
    // Save starting point and whether point was in happy
    public void onMousePress( Location point ) {
        lastPoint = point;
        grabbedIndex = -1;
        //grabbedStar = null;
            for(int i=0; i < count;i++)
            {
                starGrabbedArray[i] = starArray[i].contains(point);
                if(starGrabbedArray[i]) {
                    //grabbedIndex = i;
                    //break;
                }
            }
    }

    // if mouse is in happy, then drag happy
    public void onMouseDrag( Location point ) {
        for(int i=0; i < count;i++)
        {   
            if ( starGrabbedArray[i]) {
                starArray[i].move( point.getX() - lastPoint.getX(),
                                          point.getY() - lastPoint.getY() );
                //grabbedStar.move( point.getX() - lastPoint.getX(),
                //                  point.getY() - lastPoint.getY() );
                
            }
        }
        lastPoint = point;
    }
    
    public void onMouseClick(Location point) {
        
        starArray[count++] = new Star(point, 6, 5, 15, canvas);
        
    }
    
  
    
}
