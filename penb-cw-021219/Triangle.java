import objectdraw.*;

public  class Triangle extends Polygon
{


    /**
     * Constructor for objects of class Triangle
     */
    public Triangle(Location loc,double length,DrawingCanvas canvas)
    {
        super(loc, 3, length);
        Location p1,p2,p3;
        double cosOf60 = Math.cos(Math.toRadians(60));
        double sinOf60 = Math.sin(Math.toRadians(60));
        p1 = loc;
        p2 = new Location(loc.getX() + length,
                          loc.getY());
        p3 = new Location(loc.getX() + cosOf60*length,
                          loc.getY() - sinOf60*length);
        sides[0] = new Line(p1,p2,canvas);
        sides[1] = new Line(p2,p3,canvas);
        sides[2] = new Line(p3,p1,canvas);
    }
    
    public String whatAmI() {
        
        return "Triangle";
    }
}
