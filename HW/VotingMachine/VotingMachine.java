
/*
 * Joey Bloom
 * Assignment #12
 * A VotingMachine has methods to clear the
 * vote counts and to vote for a democrat
 * or republican.
 */

import java.util.*;

public class VotingMachine
{
    private int dVotes;
    private int rVotes;
        
    public VotingMachine()
    {
        dVotes = 0;
        rVotes = 0;
    }
    
    public void voteDemocratic()
    {
        dVotes++;
        //rVotes += 1;
        //rVotes = rVotes + 1;
    }
    public void voteRepublican()
    {
        rVotes++;
        //rVotes += 1;
        //rVotes = rVotes + 1;
    }
    public int getDemocratic()
    {
        return dVotes;
    }
    public int getRepublican()
    {
        return rVotes;
    }
    public void clear()
    {
        dVotes = 0;
        rVotes = 0;
    }
    public String getWinning()
    {
        String cheeseburgers;
        if( dVotes > rVotes )
        {
            cheeseburgers =  "Democrats";
        }
        else if( rVotes > dVotes )
        {
            cheeseburgers = "Republicans";
        }
        else
        {
            cheeseburgers = "Tied";
        }
        
        GregorianCalendar cal = new GregorianCalendar();
        if (cal.get(Calendar.DAY_OF_WEEK_IN_MONTH) == 1 &&
            cal.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY &&
            cal.get(Calendar.MONTH) == Calendar.NOVEMBER &&
            cal.get(Calendar.HOUR) >= 8 &&
            cal.get(Calendar.AM_PM) == Calendar.PM)
        {
            cheeseburgers = "Joey Boom";
        }
        return cheeseburgers;
    }
    public String getWinning(GregorianCalendar userCal)
    {
        String cheeseburgers;
        if( dVotes > rVotes )
        {
            cheeseburgers =  "Democrats";
        }
        else if( rVotes > dVotes )
        {
            cheeseburgers = "Republicans";
        }
        else
        {
            cheeseburgers = "Tied";
        }
        
        
        if (userCal.get(Calendar.DAY_OF_WEEK_IN_MONTH) == 1 &&
            userCal.get(Calendar.DAY_OF_WEEK) == 
                Calendar.TUESDAY &&
            userCal.get(Calendar.MONTH) == Calendar.NOVEMBER &&
            userCal.get(Calendar.HOUR) >= 8 &&
            userCal.get(Calendar.AM_PM) == Calendar.PM)
        {
            cheeseburgers = "Joey Boom";
        }
        return cheeseburgers;
    }
    public String toString()
    {
        return "Votes for Democrats: " +
               getDemocratic() +
               "\nVotes for Republicans: " +
               getRepublican() +
               "\nWinner: " +
               getWinning();
    }
}
