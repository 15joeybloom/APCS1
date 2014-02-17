
/**
 * @author Joey Bloom
 * Assignment #18
 * caluculates the day and month
 * that easter sunday will fall on
 * in the given year
 */
public class Easter
{
    private int day;
    private int month;
    private int year;

    /**
     * Creates a new Easter, initializing the day and month of easter
     * sunday in the given year
     * 
     * @param y the given year
     */
    public Easter(int y)
    {
        year = y;
        int a = y % 19;
        int b = y / 100;
        int c = y % 100;
        int d = b / 4;
        int e = b % 4;
        int g = ( 8 * b + 13 ) / 25;
        int h =  ( 19 * a + b - d - g + 15 ) % 30;
        int j = c / 4;
        int k = c % 4;
        int m = ( a + 11 * h ) / 319;
        int r = (2* e + 2 * j - k - h - m + 32 ) % 7;
        int n = ( h - m + r + 90 ) / 25;
        int p = ( h - m + r + n + 19 ) % 32;
        
        day = p;
        month = n;
    }
    
    /**
     * returns the year
     * 
     * @return the year
     */
    public int getYear()
    {
        return year;
    }
    /**
     * returns the day of the month of easter sunday in the given year
     * @return the day of the month of easter sunday
     */
    public int getEasterSundayDay()
    {
        return day;
    }
    /**
     * returns the month of easter sunday in the given year
     * @return the month of easter sunday
     */
    public int getEasterSundayMonth()
    {
        return month;
    }
    /**
     * returns the exact date of easter sunday in the given year, as a String.
     * @return the date of easter sunday
     */
    public String toString()
    {
        return "In " + getYear() + ", Easter falls on " +
               getEasterSundayMonth() + 
               "-" + getEasterSundayDay();
    }
}
