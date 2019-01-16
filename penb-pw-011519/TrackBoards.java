import objectdraw.*;
import java.awt.*;

public class TrackBoards {
    private int AmmoCount = 100;
    private int ScoreCount = 0;
    private Text TrackScore;
    private Text TrackAmmo;
    private BouncingBall myBall;
    private TargetBall myTarget;
    private DrawingCanvas canvas;
    public TrackBoards (DrawingCanvas aCanvas) {
        this.canvas = aCanvas;
        TrackAmmo = new Text("Bullet Count: " + AmmoCount, canvas.getWidth()-135, 0, canvas);
        TrackScore = new Text("Score: " + ScoreCount, 0, 0, canvas);
        //start();
        
    }

    public boolean isAmmo()
    {
        return AmmoCount > 0;
    }
    
    public void removeAmmo() {
       AmmoCount--;
       TrackAmmo.setText("Bullet Count: " + AmmoCount);
    }
     
    public void reload() {
        AmmoCount = 100;
        TrackAmmo.setText("Bullet Count: " + AmmoCount);
    }

    
    public void addPoint() {
        ScoreCount++;
        
        TrackScore.setText("Score: " + ScoreCount);
    }
    
}