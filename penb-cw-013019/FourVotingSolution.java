import objectdraw.*;
import java.awt.*;

public class FourVotingSolution extends WindowController {
    // coordinates of canvas, including x and y coords of middle
    private static final int A_BOUNDARY = 150;
    private static final int B_BOUNDARY = 300; 
    private static final int C_BOUNDARY = 450;
    private static final int TOP = 0;
    private static final int BOTTOM = 200;
    private static final int LEFT = 0;

    // x coordinates of A,C and B,D text messages
    private static final int TEXT_A_X = 20;
    private static final int TEXT_B_X = A_BOUNDARY + 20; 
    private static final int TEXT_C_X = B_BOUNDARY + 20; 
    private static final int TEXT_D_X = C_BOUNDARY + 20; 

    // y coordinates of A,B, C,D text messages
    private static final int DISPLAY_Y = 20;

    private int countA = 0;       // number of votes for A
    private int countB = 0;       // number of votes for B
    private int countC = 0;       // number of votes for C
    private int countD = 0;       // number of votes for D

    private Text infoA;           // display of votes for A
    private Text infoB;           // display of votes for B
    private Text infoC;           // display of votes for C
    private Text winner;           // display of votes for D
    
    // Create displays with instructions on how to vote
    public void begin() {
        resize(700,250);
        infoA = new Text( countA + " votes for A.",  
            TEXT_A_X, DISPLAY_Y, canvas );
        infoB = new Text( countB + " votes for B.",  
            TEXT_B_X, DISPLAY_Y, canvas );
        infoC = new Text( countC + " votes for C.",  
            TEXT_C_X, DISPLAY_Y, canvas );
        winner = new Text( "The winner is undetermined.",  
            TEXT_D_X, DISPLAY_Y, canvas );

        new Line( A_BOUNDARY, TOP, A_BOUNDARY, BOTTOM, canvas );
        new Line( B_BOUNDARY, TOP, B_BOUNDARY, BOTTOM, canvas );
        new Line( C_BOUNDARY, TOP, C_BOUNDARY, BOTTOM, canvas );
    }

    public static void main(String[] args){
        FourVotingSolution myWindow = new FourVotingSolution(); 
        myWindow.startController(700,250);
        for(int i=0;i<args.length;i++){
            System.out.println("Argument " + i + " is: " + args[i]);
        }
    }
    
    // Update votes and display vote counts
    public void onMouseClick( Location location ) 
    {
            if(location.getX() < A_BOUNDARY){
                countA++;
                updateVotes(infoA,countA, 'A');
            } else if (location.getX() < B_BOUNDARY){
                countB++;
                updateVotes(infoB,countB, 'B');
            }else if (location.getX() < C_BOUNDARY){
                countC++;
                updateVotes(infoC,countC, 'C');
            }
                        
            updateWinner();
    }
    
    
    
    public void updateVotes(Text textObj,int votes,char myChar)
    {
        textObj.setText(votes + " votes for " + myChar );
    }
    
     public void updateWinner()
    {
        if(countA == countB && countB == countC)
        {
              winner.setText("The winner is a three way tie");
        } else if (countA == countB && countB> countC){
              winner.setText("The winner is a two way tie between A and B");
        }else if (countC == countB && countB> countA){
              winner.setText("The winner is a two way tie between C and B");
        }else if (countA == countC && countA> countB){
              winner.setText("The winner is a two way tie between A and C");
        }else if (countA > countB && countA > countC){
              winner.setText("The winner is A");
        }else if (countB > countA && countB > countC){
              winner.setText("The winner is B");
        }else if (countC > countB && countC > countA){
              winner.setText("The winner is C");
        }else {
              winner.setText("The updateWinner code must be broken to reach this point");
        }
    }
}   