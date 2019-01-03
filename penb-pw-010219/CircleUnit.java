/**
 * A demonstration of using repetition (while loops) in drawing.
 */

import objectdraw.*;
import java.awt.*;

public class CircleUnit extends WindowController
{
    // Define sizes and spacing for the bricks
    private final static int CIRCLE_HEIGHT = 12;
    private final static int CIRCLE_WIDTH = 12;
    private final static int CIRCLE_SPACING = -4;
    private final static int CIRCLES_PER_ROW = 12;
    private final static int SCARF_ROWS = 40;
    private final static int PYRAMID_ROWS = 9;
    private boolean TOGGLE = true;

    public void drawScarf() 
   {
       FramedOval currentCircle;
        
        int nextCircleX = 50;
        int numCircles = 0;
        int numRows = 0;
        int nextCircleY = 10;
        
        while(numRows < SCARF_ROWS) {
            while(numCircles < CIRCLES_PER_ROW) {
        

                    currentCircle = new FramedOval(nextCircleX, nextCircleY, CIRCLE_WIDTH, CIRCLE_HEIGHT, canvas); 
                 
                    nextCircleX += CIRCLE_WIDTH + CIRCLE_SPACING;
                    
                    numCircles++;
            }
            nextCircleX = 50;
            numCircles = 0;
            
            nextCircleY += CIRCLE_HEIGHT + CIRCLE_SPACING;
            numRows++;
        }
    
    }
    
    public void drawPyramid()
    {
       FramedOval currentCircle;
        
        int nextCircleX = 0;
        int numCircles = 0;
        int numRows = 0;
        int nextCircleY = 0;
        
        while(numRows < PYRAMID_ROWS) {
            
            numCircles = 0;
            while(numCircles < numRows) {
        
                    currentCircle = new FramedOval(nextCircleX, nextCircleY, CIRCLE_WIDTH, CIRCLE_HEIGHT, canvas); 

                    nextCircleX += CIRCLE_WIDTH + CIRCLE_SPACING;
               
                    numCircles++;
            }
            nextCircleX = 0;
            numCircles = 0;
            
            nextCircleY += CIRCLE_HEIGHT + CIRCLE_SPACING;
            numRows++;
        }  
       
        numRows = PYRAMID_ROWS;
        while(numRows > 0) {
            
            numCircles = 0;
            while(numCircles < numRows) {
        
                    currentCircle = new FramedOval(nextCircleX, nextCircleY, CIRCLE_WIDTH, CIRCLE_HEIGHT, canvas); 

                    nextCircleX += CIRCLE_WIDTH + CIRCLE_SPACING;
               
                    numCircles++;
            }
            nextCircleX = 0;
            numCircles = 0;
            
            nextCircleY += CIRCLE_HEIGHT + CIRCLE_SPACING;
            numRows--;
        }  
    }
    
    public void onMouseClick(Location point) {
        if(TOGGLE == true) {
            canvas.clear();
            drawScarf();
            TOGGLE = false;
        } else {
            canvas.clear();
            drawPyramid(); 
            TOGGLE = true;
        }   
        
    }
} 
