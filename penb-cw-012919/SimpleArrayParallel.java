import objectdraw.*;
import java.awt.*;
/**
 *  A simple array example.  Look for at least comments listing steps 1-5
 * 
 * @author Mr. Ankiewicz 

 */
public class SimpleArrayParallel extends WindowController
{
    
    //Step 1 with arrays.
    //Declare an array
    private int[]   clickCount;
    //You can declare an array of any type you know... Here is another example
    private FilledRect[] rectArray;
    private int rectCount = 0;
    
    /**
     * Constructor for objects of class SimpleArray
     */
    public SimpleArrayParallel()
    {
        // Step2 create the array (the array is still empty slots at this point)
        // you need to tell it how many empty slots you need.  

        //Parallel Arrays should be created in parallel so they 
        //  both have the same number of elements  
        clickCount = new int[100];
        rectArray  = new FilledRect[100];
                
        rectArray[rectCount++] = new FilledRect(0,0,10,10,canvas);
        //NOTE you can use any expression that evaluates to an integer inside the square brackets
        // here are some examples that evaluate to [1] and [2] respectively
        rectArray[rectCount++] = new FilledRect(50,50,30,30,canvas);
        rectArray[rectCount++] = new FilledRect(100,100,50,50,canvas);
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void begin()
    {
        //STEP 4 You use the arrayname[index] anywhere you would use a single object of that type
        //Let's use all 3 rectangles in my array that aren't empty.  I am going to use a loop for this example
        for(int i=0;i<rectCount;i++)
        {
            rectArray[i].setSize(50,50);
            clickCount[i] = 0;
        }
        
    }
    
    public void onMousePress(Location point)
    {
        //Lets remove one rectangle IF the user clicks in it 
        //Step 5 how to delete something from a slot(assign it the special value of null which means nothing)
        for(int i=0;i<rectCount;i++)
        {
            //We need to make sure the slot is not empty here before we ask if it contains the point.
            //This is called short circuiting because if the first part of an AND is false, it never runs the second part.
            if(rectArray[i] != null && rectArray[i].contains(point))
            {
                //rectArray[i].removeFromCanvas();  //remove it from canvas first
                //rectArray[i] = null;   //this removes item from the slot and the slot is empty again
                //break;
                //return;
                clickCount[i]++;
            }
            System.out.println("Click Count for Rectangle" + i + " is "+clickCount[i]);
        }
        
        
    }
}