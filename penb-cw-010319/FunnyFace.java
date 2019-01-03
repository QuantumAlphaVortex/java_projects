import objectdraw.*;
import java.awt.*;

public class FunnyFace {
    
    private static final int FACE_HEIGHT = 60,  // dimensions of the face
                             FACE_WIDTH = 60,
        
                             EYE_OFFSET = 20,   // eye location and size
                             EYE_RADIUS = 8,
        
                             MOUTH_HEIGHT = 10, // dimensions of the mouth
                             MOUTH_WIDTH = FACE_WIDTH/2;
    
    private FramedOval head,     // oval for head
                       leftEye,  // ovals for eyes
                       rightEye,
                       mouth;    // oval for mouth
                       
    private FilledOval mouthCover;
    // Create pieces of funny face
    public FunnyFace( double left, double top, DrawingCanvas canvas) {
        
        double mouthXCoord, mouthYCoord;
        
        mouthXCoord = left+(FACE_WIDTH-MOUTH_WIDTH)/2;
        mouthYCoord = top + 2*FACE_HEIGHT/3;
        head = new FramedOval( left, top, FACE_WIDTH, FACE_HEIGHT, canvas );
        mouth = new FramedOval( mouthXCoord, 
                                mouthYCoord,
                                MOUTH_WIDTH, MOUTH_HEIGHT, canvas );
        mouthCover = new FilledOval( mouthXCoord, 
                                mouthYCoord - EYE_RADIUS/3,
                                MOUTH_WIDTH, MOUTH_HEIGHT, canvas );
                                
                                
        mouthCover.setColor(Color.WHITE);
                                
        leftEye = new FramedOval( left+EYE_OFFSET-EYE_RADIUS/2, top+EYE_OFFSET, 
                                  EYE_RADIUS, EYE_RADIUS, canvas );
        rightEye = new FramedOval( left+FACE_WIDTH-EYE_OFFSET-EYE_RADIUS/2, 
                                   top+EYE_OFFSET, EYE_RADIUS, EYE_RADIUS, canvas);
    }
    
    public FunnyFace(Location p,DrawingCanvas canvas) {
        this(p.getX(),p.getY(),canvas);
    }
    
    // Move funny face by (dx,dy)
    public void move(double dx, double dy) {
        head.move(dx,dy);
        leftEye.move(dx,dy);
        rightEye.move(dx,dy);
        mouth.move(dx,dy);
        mouthCover.move(dx,dy);
    }
    
    // Determine whether pt is inside funny face
    public boolean contains(Location pt) {
        return head.contains(pt) || 
               mouth.contains(pt) ||
               leftEye.contains(pt) ||
               rightEye.contains(pt);
    }
    
    // Move funny face to (x, y)
    public void moveTo( double x, double y ){
        this.move(x - head.getX(), y - head.getY());        
    }
    
    public void moveTo(Location p) {
        this.moveTo(p.getX(),p.getY());
    }
}