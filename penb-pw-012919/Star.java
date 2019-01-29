
/**
 * Creates an n-point Star.
 * 
 * Demonstration of arrays.
 * 
 * Some ideas for calculating the points taken from Stack Overflow: http://stackoverflow.com/questions/5300938/calculating-the-position-of-points-in-a-circle
 * 
 * @author John Magee
 * @version 11/11/2013
 */

import objectdraw.*;
import java.awt.*;

public class Star
{
    
    private Line[] edges;
    private double radius;
    private Location center;
    
    public Star(Location centerPoint, int nPoints, double inRadius, double outRadius, DrawingCanvas canvas) {
        
        // create the array of lines. Each point in the star needs 2 lines
        edges = new Line[2 * nPoints];
        
        // store the center and the radius (used for the contains method)
        radius = outRadius;
        center = centerPoint;
        
        // A slice is how many radius are between each point
        double slice = 2 * Math.PI / nPoints;
        
        // Used to calculate the x,y coordinates of each point in the star
        double inAngle, outAngle;
        double inX, inY, outX, outY;
        
        
        // Each outside point of the star needs 2 lines drawn (to two consecutive inner points)
        for(int i = 0; i < nPoints; i++) {
            inAngle = slice * i;
            outAngle = slice * (i + 0.5);
            
            inX = centerPoint.getX() + inRadius * Math.cos(inAngle);
            inY = centerPoint.getY() + inRadius * Math.sin(inAngle);
           
            outX = centerPoint.getX() + outRadius * Math.cos(outAngle);
            outY = centerPoint.getY() + outRadius * Math.sin(outAngle);
            
            // create one edge from the outer point to the inner point
            // edges 0, 2, 4, 6, 8....
            edges[2 * i] = new Line(inX, inY, outX, outY, canvas);
            
            // calculate the coordinates of the next inner circle point
            inX = centerPoint.getX() + inRadius * Math.cos(inAngle + slice);
            inY = centerPoint.getY() + inRadius * Math.sin(inAngle + slice);
                       
            // create an edge from the outer poin to the next inner point
            // edges 1, 3, 5, 7,....
            edges[2 * i + 1] = new Line(inX, inY, outX, outY, canvas);            
        }
        
    }
    
    
    // The contains method returns true if the point is within the outer radius of the star
    public boolean contains(Location point) {
        return center.distanceTo(point) < radius;
        
    }
   
    
    // Move the star 
    public void move(double dx, double dy) {
        
        // Just move every single line in the star
        for(int i = 0; i < edges.length; i++) {
            edges[i].move(dx, dy);
        }
        
        center.translate(dx, dy);
        
    }
    
    
    // Change the color of the lines
    public void setColor(Color c) {
         // Just set the color of every edge in the star
        for(int i = 0; i < edges.length; i++) {
            edges[i].setColor(c);
        }
    }
    
}
