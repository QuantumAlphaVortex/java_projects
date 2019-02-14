import objectdraw.*;
import java.awt.Color;
/**
 * Abstract class Polygon - write a description of the class here
 * 
 * @author (Ankiewiczk)
 * @version (4/3/18)
 */
public abstract class Polygon
{
    // instance variables - replace the example below with your own
    protected Location origin;
    protected final Line[] sides;
    protected double length;   //meant to represent length of side.
    
    Polygon lastShape;
    public Polygon(Location origin, int numOfSides, double lengthOfSide) {
        this.origin = origin;
        sides = new Line[numOfSides];
        this.length = length;
    }
    
    public Polygon(double x, double y, int numOfSides, int lengthOfSide) {
        this(new Location(x,y),numOfSides,lengthOfSide);
    }
    public abstract String whatAmI(); //abstrat method with no body
    public int getNumberOfSides() {
        return sides.length;
    }
    
    public double getLength() {
        return length;
    }
    
    public void show() {
        for(int i=0; i< sides.length; i++) {
            sides[i].show();
        }
    }
    
    public void hide() {
        for(int i=0; i< sides.length; i++) {
            sides[i].hide();
        } 
    }
        
    public void moveTo(Location loc){
        double dx = origin.getX()- loc.getX();
        double dy = origin.getY()- loc.getY();
        
        origin.translate(dx, dy);
        for(int i=0; i< sides.length; i++) {
            sides[i].move(dx,dy);
        }        
    }
    
    public void moveTo(double x, double y){
        this.moveTo(new Location(x,y));
    }
   
    public void move(double dx, double dy) { 
        origin.translate(dx,dy);
        for(int i=0; i< sides.length; i++) {
            sides[i].move(dx,dy);
        }
    }
    
    public void setColor(Color color){
        for(int i=0; i< sides.length; i++) {
            sides[i].setColor(color);
        }
    }
    
}
