
/**
 * Creates an n-point Star.
 * 
 * Demonstration of arrays.
 * 
 * Some ideas for calculating the points taken from Stack Overflow: http://stackoverflow.com/questions/5300938/calculating-the-position-of-points-in-a-circle
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import objectdraw.*;
import java.awt.*;

public class DecoratedStar extends Star
{

    FilledOval[] circles;
    DrawingCanvas canvas;
    Location[] points;
    RandomDoubleGenerator gen;
    private Line[] edges;
    private double radius;
    private Location center;

  
    
    public DecoratedStar(Location centerPoint, int nPoints, double inRadius, double outRadius, DrawingCanvas canvas) {
        super(centerPoint,nPoints,inRadius,outRadius,canvas);
        // create the array of lines. Each point in the star needs 2 lines
        this.canvas = canvas;
        drawCircles();
        }

    public void drawCircles() {
        //FilledOval[i]
        Location[] vertices = super.getVertices();
        circles = new FilledOval[vertices.length];
        int i;
        for(i=0; i<circles.length; i++){ 
            
            circles[i] = new FilledOval(vertices[i],10,10,canvas);
            circles[i].move(-circles.length/2,-circles.length/2);
        }   
    }
    
    // The contains method returns true if the point is within the outer radius of the star
    public boolean contains(Location point) {
        return center.distanceTo(point) < radius;

    }
 
    // Move the star 
    public void move(double dx, double dy) {
        super.move(dx,dy);
        for(int i=0;i<circles.length;i++){
            circles[i].move(dx,dy);
        }
        
    }
    
        public void setColor(Color c) {
        // Just set the color of every edge in the star
        for(int i = 0; i < circles.length; i++) {
            circles[i].setColor(c);
        }
    }
}
