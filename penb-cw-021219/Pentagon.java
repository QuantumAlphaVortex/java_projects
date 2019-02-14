import objectdraw.*;
/**
 * Write a description of class Pentagon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public  class Pentagon extends Polygon
{
    
    public Pentagon(Location loc,double length,DrawingCanvas canvas)
    {
      super(loc,5,length);
      double sinOf18 = Math.sin(Math.toRadians(18));
      double cosOf18 = Math.cos(Math.toRadians(18));
      double apo = length/2* Math.sqrt(5+ 2* Math.sqrt(5));
      Location p1,p2,p3,p4,p5;
      p1 = loc;
      p2 = new Location(loc.getX()- sinOf18*length, loc.getY() - cosOf18*length);
      p3 = new Location(loc.getX()+ length/2, loc.getY() - apo);
      p4 = new Location(loc.getX()+ length + sinOf18*length, loc.getY() - cosOf18*length);
      p5 = new Location(loc.getX()+length,loc.getY());
      sides[0] = new Line(p1,p2,canvas);
      sides[1] = new Line(p2,p3,canvas);
      sides[2] = new Line(p3,p4,canvas);
      sides[3] = new Line(p4,p5,canvas);
      sides[4] = new Line(p5,p1,canvas);
      
    }

    
    public String whatAmI() {
    
        return "Pentagon";
    }
}
