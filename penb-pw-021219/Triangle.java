import objectdraw.*;
import java.awt.*;

public class Triangle {

    private Line [] edge;
    private double size;

    public Triangle( Location vert1, Location vert2, Location vert3, 
    DrawingCanvas canvas){
        edge = new Line[3];
        edge[0] = new Line(vert1,vert2,canvas);
        edge[1] = new Line(vert2,vert3,canvas);
        edge[2] = new Line(vert1,vert3,canvas);
        size = Math.max(edge[0].getStart().distanceTo(edge[0].getEnd()),
            edge[1].getStart().distanceTo(edge[1].getEnd()));
    }

    public void hide( ) {
        for ( int edgeNum = 0; edgeNum < edge.length; edgeNum++ ){
            edge[edgeNum].hide();
        }
    }

    public void show( ) {
        for ( int edgeNum = 0; edgeNum < edge.length; edgeNum++ ){
            edge[edgeNum].show();
        }
    }

    public Location [ ] getVertices() {
        Location [ ] result = new Location[ edge.length ];

        for ( int edgeNum = 0; edgeNum <edge.length; edgeNum++ ) {
            result[ edgeNum ] = edge[ edgeNum ].getStart();
        }
        return result;
    }

    public void setColor(Color color)
    {
        edge[0].setColor(color);
        edge[1].setColor(color);
        edge[2].setColor(color);
    }

    // Implementation of abstract methods here:
    
    public void move( double dx, double dy) {
        for ( int edgeNum = 0; edgeNum < edge.length; edgeNum++ ){
            edge[edgeNum].move(dx, dy);
        }
    }

    public boolean contains (Location pt)
    {
        return edge[0].getStart().getX() <= pt.getX() && pt.getX() <= edge[2].getEnd().getX() &&
        edge[1].getStart().getY() <= pt.getY() && pt.getY() <= edge[2].getEnd().getY();
    }

    public double getWidth ()
    {
        return size;
    }

    public double getHeight ()
    {
        return getWidth();
    }

    public double getX()
    {
        return edge[0].getStart().getX();
    }

    public double getY()
    {
        return edge[0].getStart().getY();
    }

}
