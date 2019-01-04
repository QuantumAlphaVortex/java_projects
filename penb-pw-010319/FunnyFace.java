import objectdraw.*;
import java.awt.*;

public class FunnyFace {

    private static final int FACE_HEIGHT = 60,  // dimensions of the face
                             FACE_WIDTH = 60,
        
                             EYE_OFFSET = 20,   // eye location and size
                             EYE_RADIUS = 8,
        
                             MOUTH_HEIGHT = 10, // dimensions of the mouth
                             MOUTH_WIDTH = FACE_WIDTH/2,
    
                             BRIM_HEIGHT = 20, // dimensions of the brim of hat
                             BRIM_WIDTH = 60, 
                             
                             STACK_HEIGHT = 40,   // dimensions of the stack of hat
                             STACK_WIDTH = 30;    
                             
    private FramedOval head,     // oval for head
                       leftEye,  // ovals for eyes
                       rightEye,
                       mouth;    // oval for mouth
                       
    private FilledOval brim;    // oval for brim of hat
                       
    private FilledRect stack;   // rect for stack of hat 
    private FilledOval stackTop;    // oval for stack of hat
    private FilledRect stackBand;   // rect for stack of hat for style
     
    private static final int FACE_LEFT = 170, // location of FunnyFace
                             FACE_TOP = 170;
    
    // Create pieces of funny face
    public FunnyFace( double left, double top, DrawingCanvas canvas) {
        head = new FramedOval( left, top, FACE_WIDTH, FACE_HEIGHT, canvas );
        mouth = new FramedOval( left+(FACE_WIDTH-MOUTH_WIDTH)/2, 
                                top + 2*FACE_HEIGHT/3,
                                MOUTH_WIDTH, MOUTH_HEIGHT, canvas );
        leftEye = new FramedOval( left+EYE_OFFSET-EYE_RADIUS/2, top+EYE_OFFSET, 
                                  EYE_RADIUS, EYE_RADIUS, canvas );
        rightEye = new FramedOval( left+FACE_WIDTH-EYE_OFFSET-EYE_RADIUS/2, 
                                   top+EYE_OFFSET, EYE_RADIUS, EYE_RADIUS, canvas);
             // TOP HAT    
                    
        stack = new FilledRect(left, top - BRIM_WIDTH/4, 75, 25, canvas);
        stack.setColor(Color. GRAY);
        
        stackBand = new FilledRect(left, top - BRIM_WIDTH/4, 75, 15, canvas);    
        stackBand.setColor(Color. GRAY);
        
        brim = new FilledOval(left, top, 100, 15, canvas);
        brim.setColor(Color. GRAY);
        
        stackTop = new FilledOval(left, top - BRIM_WIDTH/4 - 12, 75, 25, canvas);
        stackTop.setColor(Color. GRAY);
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
        brim.move(dx,dy);
        stack.move(dx,dy);
        stackTop.move(dx,dy);
        stackBand.move(dx,dy);
    }
    
    // Determine whether pt is inside funny face
    public boolean contains(Location pt) {
        return head.contains(pt) || 
               mouth.contains(pt) ||
               leftEye.contains(pt) ||
               rightEye.contains(pt) ||
               brim.contains(pt) ||
               stack.contains(pt) ||
               stackTop.contains(pt) ||
               stackBand.contains(pt);               
    }
    
    // Move funny face to (x, y)
    public void moveTo( double x, double y ){
        this.move(x - head.getX(), y - head.getY());        
    }
    
    public void moveTo(Location p) {
        this.moveTo(p.getX(),p.getY());
    }
    
    public void setColor(Color newColor) {
            brim.setColor(newColor);
            stack.setColor(newColor);
            stackTop.setColor(newColor);
            stackBand.setColor(newColor);
    }

}