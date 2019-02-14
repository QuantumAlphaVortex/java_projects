import objectdraw.*;
/**
 * Write a description of class Diamond here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public  class Diamond extends Polygon
{
    public Diamond(Location loc,double length,DrawingCanvas canvas) {
        super(loc,4,length);
        double sinOf45= Math.sin(Math.toRadians(45));
        double cosOf45 = sinOf45;   //shortcut because I know they are equal
        Location p1,p2,p3,p4;
        p1 = loc;
        p2 = new Location(loc.getX()+ cosOf45*length,loc.getY()- sinOf45*length);
        p3 = new Location(loc.getX()+ 2*cosOf45*length, loc.getY());
        p4 = new Location(loc.getX()+ cosOf45*length,loc.getY()+ sinOf45*length);
        
        sides[0] = new Line(p1,p2,canvas);
        sides[1] = new Line(p2,p3,canvas);
        sides[2] = new Line(p3,p4,canvas);
        sides[3] = new Line(p4,p1,canvas);
    }

        public String whatAmI() {
    
        return "Diamond";
    }
}
