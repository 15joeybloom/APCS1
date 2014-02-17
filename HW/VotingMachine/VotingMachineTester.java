
/**
 * Joey Bloom
 * Assignment #12
 * Tests the VotingMachine class.
 */

import java.util.*;

public class VotingMachineTester
{
    public static void main(String[] args)
    {
        VotingMachine vm = new VotingMachine();
        GregorianCalendar electionDay = 
            new GregorianCalendar(2012, 
                                  Calendar.NOVEMBER, 
                                  6,
                                  21,
                                  34);
        vm.voteDemocratic();
        vm.voteRepublican();
        vm.voteDemocratic();
        vm.voteDemocratic();
        vm.voteRepublican();
        
        System.out.println(
            "On any given day, this VotingMachine\n" +
            "will print the following: ");
        System.out.println(vm + "\n");
        System.out.println(
            "However, on election day after\n" +
            "8pm, it appears the results have\n" +
            "been tampered with!");
        System.out.println(
            "Winner: " + 
            vm.getWinning(electionDay));
    }
}

/*
Output:
On any given day, this VotingMachine
will print the following: 
Votes for Democrats: 3
Votes for Republicans: 2
Winner: Democrats

However, on election day after
8pm, it appears the results have
been tampered with!
Winner: Joey Boom

 */
