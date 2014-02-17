
/*
 * Joey Bloom
 * 
 * Tests the MeanMedianMode class
 */

import java.util.*;

public class MeanMedianModeTester
{
    public static void main(String[] args)
    {
        ArrayList<Double> dataSetOne = 
            new ArrayList<Double>();
        ArrayList<Double> dataSetTwo =
            new ArrayList<Double>();
        ArrayList<Double> dataSetThree = 
            new ArrayList<Double>();
        ArrayList<Double> dataSetFour =
            new ArrayList<Double>();
        
        dataSetOne.add( 5.6 );
        dataSetOne.add( 2.3 );
        dataSetOne.add( 2.3 );
        dataSetOne.add( 2.33 );
        dataSetOne.add( 2.3 );
        dataSetOne.add( 4.7 );
        
        dataSetTwo.add( 5.0 );
        dataSetTwo.add( 6.0 );
        dataSetTwo.add( 8.8 );
        dataSetTwo.add( 4.0 );
        dataSetTwo.add( 9.5 );
        dataSetTwo.add( 1.1 );
        dataSetTwo.add( 8.7 );
        
        dataSetThree.add( 2.34 );
        dataSetThree.add( 2.3 );
        dataSetThree.add( 2.3 );
        dataSetThree.add( 2.34 );
        dataSetThree.add( 2.3 );
        dataSetThree.add( 2.34 );
        
        dataSetFour.add( 5.0 );
        dataSetFour.add( 6.0 );
        dataSetFour.add( 6.0 );
        dataSetFour.add( 4.0 );
        dataSetFour.add( 5.0 );
        dataSetFour.add( 1.1 );
        dataSetFour.add( 8.7 );
        
        System.out.println("Mean of data set 1: " + 
            MeanMedianMode.mean(dataSetOne) + 
            "\n\t Expected: 3.255" );
        System.out.println("Median of data set 1: " +
            MeanMedianMode.median(dataSetOne) +
            "\n\t Expected: 2.315");
        System.out.println("Mode(s) of data set 1: " +
            MeanMedianMode.mode(dataSetOne) +
            "\n\t Expected: 2.3\n");
            
        System.out.println("Mean of data set 2: " + 
            MeanMedianMode.mean(dataSetTwo) + 
            "\n\t Expected: 6.157142857" );
        System.out.println("Median of data set 2: " +
            MeanMedianMode.median(dataSetTwo) +
            "\n\t Expected: 6.0");
        System.out.println("Mode(s) of data set 2: " +
            MeanMedianMode.mode(dataSetTwo) +
            "\n\t Expected: []\n");
            
        System.out.println("Mean of data set 3: " + 
            MeanMedianMode.mean(dataSetThree) + 
            "\n\t Expected: 2.32" );
        System.out.println("Median of data set 3: " +
            MeanMedianMode.median(dataSetThree) +
            "\n\t Expected: 2.32");
        System.out.println("Mode(s) of data set 3: " +
            MeanMedianMode.mode(dataSetThree) +
            "\n\t Expected: [] \n");
            
        System.out.println("Mean of data set 4: " + 
            MeanMedianMode.mean(dataSetFour) + 
            "\n\t Expected: 5.114285714" );
        System.out.println("Median of data set 4: " +
            MeanMedianMode.median(dataSetFour) +
            "\n\t Expected: 5.0");
        System.out.println("Mode(s) of data set 4: " +
            MeanMedianMode.mode(dataSetFour) +
            "\n\t Expected: [5.0, 6.0]\n");
    }
}

/*

Output:
Median of data set 1: 2.315
	 Expected: 2.315
Mode(s) of data set 1: [2.3]
	 Expected: 2.3

Mean of data set 2: 6.157142857142857
	 Expected: 6.157142857
Median of data set 2: 6.0
	 Expected: 6.0
Mode(s) of data set 2: []
	 Expected: []

Mean of data set 3: 2.32
	 Expected: 2.32
Median of data set 3: 2.32
	 Expected: 2.32
Mode(s) of data set 3: []
	 Expected: [] 

Mean of data set 4: 5.114285714285714
	 Expected: 5.114285714
Median of data set 4: 5.0
	 Expected: 5.0
Mode(s) of data set 4: [5.0, 6.0]
	 Expected: [5.0, 6.0]


 */