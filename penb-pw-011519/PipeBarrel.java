import objectdraw.*;
import java.awt.*;

public class PipeBarrel extends ActiveObject {

    // the image of the box
    private FilledRect boxGraphic;
    // the canvas
    private DrawingCanvas canvas;

    public PipeBarrel (Location initialLocation, DrawingCanvas aCanvas) {
        this.canvas = aCanvas;
        boxGraphic = new FilledRect(initialLocation, 50, 100, canvas);
        //start();
        
    }
    
    public void run() {


    }
}
