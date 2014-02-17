
/*
 * Joey Bloom
 * 
 * Tests the MeanMedianMode class
 */

import java.util.*;

public class ModeTester
{
    public static void main(String[] args)
    {
        ArrayList<Double> dataSetThree = 
            new ArrayList<Double>();
        ArrayList<Double> dataSetFour =
            new ArrayList<Double>();
        
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
        
        System.out.println("Mean of data set 3: " + 
            MeanMedianMode.mean(dataSetThree) + 
            "\n\t Expected: 2.32" );
        System.out.println("Median of data set 3: " +
            MeanMedianMode.median(dataSetThree) +
            "\n\t Expected: 2.32");
        System.out.println("Mode(s) of data set 3: " +
            MeanMedianMode.mode(dataSetThree) +
            "\n\t Expected: []");
            
        System.out.println("Mean of data set 4: " + 
            MeanMedianMode.mean(dataSetFour) + 
            "\n\t Expected: 5.114285714" );
        System.out.println("Median of data set 4: " +
            MeanMedianMode.median(dataSetFour) +
            "\n\t Expected: 5.0");
        System.out.println("Mode(s) of data set 4: " +
            MeanMedianMode.mode(dataSetFour) +
            "\n\t Expected: [5.0, 6.0]");
    }
}

/*

Output:
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
