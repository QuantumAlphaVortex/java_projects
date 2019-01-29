
/**
 * Write a description of class Calendar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Calendar 
{
    // instance variables - replace the example below with your own
    private int[][] calendar;

    /**
     * Constructor for objects of class Calendar
     */
    public Calendar()
    {
        // initialise instance variables
        String[] monthNames = new String[12];
        calendar = new int[12][];
        int[] january = new int[31];
        calendar[0] = january;
        if(calendar[1] == null) { System.out.println("Calendar 1 is still empty");}
        
        int x = calendar[0][30];  //last day in january
        calendar[1] = new int[28];
        int[] feruary = calendar[1];
        int lastDayOfFeb = calendar[1][27];
        int dayOfYear = 1;
        for(int month = 0; month < calendar.length; month++) {
            for(int day = 0 ; day < calendar[month].length; day++){
                calendar[month][day] = dayOfYear;
                dayOfYear++;
                System.out.println(monthNames[month] + "," + day + " is the " + dayOfYear + " of the year");
            }
        }

    }


}