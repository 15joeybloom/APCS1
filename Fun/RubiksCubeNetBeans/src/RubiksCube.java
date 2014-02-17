
import java.util.ArrayList;
import java.util.Random;

/**
 * Indexes of corner locations<br/>
 * viewing with red in F and blue on U:<br/>
 * UFL = 0<br/>
 * UFR = 1<br/>
 * UBR = 2<br/>
 * UBL = 3<br/>
 * DFL = 4<br/>
 * DFR = 5<br/>
 * DBR = 6<br/>
 * DBL = 7<br/>
 *<br/>
 * Indexes of edge locations<br/>
 * viewing with red in F and blue on U:<br/>
 * UF = 0<br/>
 * UR = 1<br/>
 * UB = 2<br/>
 * UL = 3<br/>
 * FL = 4<br/>
 * FR = 5<br/>
 * BR = 6<br/>
 * BL = 7<br/>
 * DF = 8<br/>
 * DR = 9<br/>
 * DB = 10<br/>
 * DL = 11<br/>
 */

public class RubiksCube
{
    private CornerPiece[] corners;
    private EdgePiece[] edges;

    private static final CornerPiece[] solvedCorners = solvedCorners();
    private static CornerPiece[] solvedCorners()
    {
        CornerPiece[] cArray = new CornerPiece[8];
        for(int i = 0; i < 8 ; i++)
        {
            cArray[i] = new CornerPiece(i,0);
        }
        return cArray;
    }
    private static final EdgePiece[] solvedEdges = solvedEdges();
    private static EdgePiece[] solvedEdges()
    {
        EdgePiece[] eArray = new EdgePiece[12];
        for(int i = 0; i < 12; i++)
        {
            eArray[i] = new EdgePiece(i,0);
        }
        return eArray;
    }
    private static final EdgePiece[] checkerEdges = checkerEdges();
    private static EdgePiece[] checkerEdges()
    {
        EdgePiece[] eArray = new EdgePiece[12];
        int c = 10;
        for(int i= 0; i < 12;i++)
        {
            eArray[i] = new EdgePiece(c,0);
            c++;
            eArray[++i] = new EdgePiece(c,0);
            c -= 3;
        }
        return eArray;
    }
    private static final CornerPiece[] linesCorners = linesCorners();
    private static CornerPiece[] linesCorners()
    {
        CornerPiece[] cArray = new CornerPiece[8];
        int[] colors = {2,3,0,1,6,7,4,5};
        for(int i = 0; i < 8; i++)
        {
            cArray[i] = new CornerPiece(colors[i],0);
        }
        return cArray;
    }
    private static final EdgePiece[] linesEdges = linesEdges();
    private static EdgePiece[] linesEdges()
    {
        EdgePiece[] eArray = new EdgePiece[12];
        System.arraycopy(solvedEdges,0,
                         eArray, 0, 12);
        eArray[4] = new EdgePiece(6,0);
        eArray[5] = new EdgePiece(7,0);
        eArray[6] = new EdgePiece(4,0);
        eArray[7] = new EdgePiece(5,0);
        return eArray;
    }
    public enum RubiksCubeState
    {
        SOLVED(solvedCorners, solvedEdges),
        CHECKERBOARD(solvedCorners, checkerEdges),
        LINES(linesCorners,linesEdges);

        private CornerPiece[] corners;
        private EdgePiece[] edges;
        RubiksCubeState(CornerPiece[] corners, EdgePiece[] edges)
        {
            this.corners = corners;
            this.edges = edges;
        }
        /**
         * returns this RubiksCubeState's corners
         * @return corners
         */
        public CornerPiece[] getCorners()
        {
            return corners;
        }
        /**
         * returns this RubiksCubeState's edges
         * @return edges
         */
        public EdgePiece[] getEdges()
        {
            return edges;
        }
    }
    /**
     * Creates a new Rubik's Cube at the solved state
     */
    public RubiksCube()
    {
        this(RubiksCubeState.SOLVED);
    }
    /**
     * Creates a new, scrambled, Rubiks Cube
     * @param gen Random generator
     */
    public RubiksCube(Random gen)
    {
        ArrayList<Integer> cC = randomArrayListNoRepeats(8,0,8,gen);
        ArrayList<Integer> cO = randomArrayListSumMod(8,0,3,gen);
        ArrayList<Integer> eC = randomArrayListNoRepeats(12,0,12,gen);
        ArrayList<Integer> eO = randomArrayListSumMod(12,0,2,gen);

        CornerPiece[] c = new CornerPiece[8];
        EdgePiece[] e = new EdgePiece[12];

        for(int i = 0; i < 8; i++)
        {
            c[i] = new CornerPiece(cC.get(i),cO.get(i));
        }
        for(int i = 0; i < 12; i++)
        {
            e[i] = new EdgePiece(eC.get(i),eO.get(i));
        }

        corners = c;
        edges = e;
    }
    /**
     * Helper method
     * returns an ArrayList<Integer> of the given <code>size</code>,
     * containing integers between <code>low</code> inclusive
     * and <code>high</code> exclusive randomly generated
     * using the Random generator <code>gen</code> with no repeated
     * numbers
     *
     * precondition: size >= low - high
     * @param size the size of the returned ArrayList
     * @param low inclusive low end of range
     * @param high exclusive high end of range
     * @param gen Random number generator
     * @return ArrayList<Integer> with no repeats
     */
    private static ArrayList<Integer> randomArrayListNoRepeats(
        int size,
        int low, int high,
        Random gen)
    {
        assert size >= low - high;
        ArrayList<Integer> lowToHigh = 
            new ArrayList<Integer>(high - low);
        for(int i = low; i < high; i++)
        {
            lowToHigh.add(i);
        }
        ArrayList<Integer> returnMe = new ArrayList<>(size);
        for(int i = 0; i < size; i++)
        {
            returnMe.add(
                lowToHigh.remove(
                gen.nextInt(lowToHigh.size())));
            
        }
        return returnMe;
    }
    /**
     * Helper method
     * returns an ArrayList<Integer> of the given <code>size</code>,
     * containing integers between <code>low</code> inclusive
     * and <code>high</code> exclusive randomly generated
     * using the Random generator <code>gen</code> whose sum
     * divides evenly by <code>high</code>
     *
     * @param size the size of the returned ArrayList
     * @param low inclusive low end of range
     * @param high exclusive high end of range, and the sum
     *             of the numbers will be evenly divisible by this
     * @param gen Random number generator
     * @return ArrayList<Integer> whose sum is
     *         evenly divisible by high    */
    private static ArrayList<Integer> randomArrayListSumMod(
        int size,
        int low, int high,
        Random gen)
    {
        ArrayList<Integer> returnMe = new ArrayList<>(size);
        //fill all but last spot, and then add to the sum
        int sum = 0;
        for(int i = 0; i < size - 1; i++)
        {
            returnMe.add(gen.nextInt(high - low) + low);
            sum += returnMe.get(i);
        }
        //fill last spot such that the sum is divisible by high
        returnMe.add(sum % high == 0 ? 0 : high - sum % high);
        return returnMe;
    }
    /**
     * Creates a new Rubiks Cube at the given RubiksCubeState
     * @param st the Rubiks Cube's initial state
     */
    public RubiksCube(RubiksCubeState st)
    {
        this(st.getCorners(),st.getEdges());
    }
    /**
     * Creates a new Rubiks cube with the pieces at the given locations.
     */
    public RubiksCube(CornerPiece[] c, EdgePiece[] e)
    {
        assert c.length == 8;
        assert e.length == 12;
        corners = c;
        edges = e;
    }
    /**
     * returns this RubiksCube's corners
     * @return corners
     */
    public CornerPiece[] getCorners()
    {
        return corners;
    }
    /**
     * returns this RubiksCube's edges
     * @return edges
     */
    public EdgePiece[] getEdges()
    {
        return edges;
    }
    /**
     * Turns the right face of the cube 90 degrees
     * clockwise
     */
    public void r()
    {
        CornerPiece[] newCorners = new CornerPiece[8];
        System.arraycopy(corners, 0, newCorners, 0, 8);
        newCorners[1] = corners[5];
        newCorners[2] = corners[1];
        newCorners[6] = corners[2];
        newCorners[5] = corners[6];

        newCorners[1].turnCCW();
        newCorners[5].turnCW();
        newCorners[6].turnCCW();
        newCorners[2].turnCW();

        corners = newCorners;

        EdgePiece[] newEdges = new EdgePiece[12];
        System.arraycopy(edges, 0, newEdges, 0, 12);
        newEdges[1] = edges[5];
        newEdges[6] = edges[1];
        newEdges[9] = edges[6];
        newEdges[5] = edges[9];

        edges = newEdges;
    }
    /**
     * Turns the right face of the cube 180 degrees
     */
    public void r2()
    {
        r(); r();
    }
    /**
     * Turns the right face of the cube 90 degrees
     * counterclockwise
     */
    public void ri()
    {
        r(); r(); r();
    }
    /**
     * Turns the left face of the cube 90 degrees
     * clockwise
     */
    public void l()
    {
        CornerPiece[] newCorners = new CornerPiece[8];
        System.arraycopy(corners, 0, newCorners, 0, 8);
        newCorners[0] = corners[3];
        newCorners[4] = corners[0];
        newCorners[7] = corners[4];
        newCorners[3] = corners[7];

        newCorners[3].turnCCW();
        newCorners[0].turnCW();
        newCorners[4].turnCCW();
        newCorners[7].turnCW();

        corners = newCorners;

        EdgePiece[] newEdges = new EdgePiece[12];
        System.arraycopy(edges, 0, newEdges, 0, 12);

        newEdges[3] = edges[7];
        newEdges[4] = edges[3];
        newEdges[11] = edges[4];
        newEdges[7] = edges[11];

        edges = newEdges;
    }
    /**
     * Turns the left face of the cube 180 degrees
     */
    public void l2()
    {
        l(); l();
    }
    /**
     * Turns the left face of the cube 90 degrees
     * counterclockwise
     */
    public void li()
    {
        l(); l(); l();
    }
    /**
     * Turns the up face of the cube 90 degrees
     * clockwise
     */
    public void u()
    {
        CornerPiece[] newCorners = new CornerPiece[8];
        System.arraycopy(corners, 0, newCorners, 0, 8);
        newCorners[0] = corners[1];
        newCorners[1] = corners[2];
        newCorners[2] = corners[3];
        newCorners[3] = corners[0];

        corners = newCorners;

        EdgePiece[] newEdges = new EdgePiece[12];
        System.arraycopy(edges, 0, newEdges, 0, 12);

        newEdges[0] = edges[1];
        newEdges[1] = edges[2];
        newEdges[2] = edges[3];
        newEdges[3] = edges[0];

        edges = newEdges;
    }
    /**
     * Turns the up face of the cube 180 degrees
     */
    public void u2()
    {
        u(); u();
    }
    /**
     * Turns the up face of the cube 90 degrees
     * counterclockwise
     */
    public void ui()
    {
        u(); u(); u();
    }
    /**
     * Turns the down face of the cube 90 degrees
     * clockwise
     */
    public void d()
    {
        CornerPiece[] newCorners = new CornerPiece[8];
        System.arraycopy(corners, 0, newCorners, 0, 8);
        newCorners[4] = corners[7];
        newCorners[5] = corners[4];
        newCorners[6] = corners[5];
        newCorners[7] = corners[6];

        corners = newCorners;

        EdgePiece[] newEdges = new EdgePiece[12];
        System.arraycopy(edges, 0, newEdges, 0, 12);

        newEdges[8] = edges[11];
        newEdges[9] = edges[8];
        newEdges[10] = edges[9];
        newEdges[11] = edges[10];

        edges = newEdges;
    }
    /**
     * Turns the down face of the cube 180 degrees
     */
    public void d2()
    {
        d(); d();
    }
    /**
     * Turns the down face of the cube 90 degrees
     * counterclockwise
     */
    public void di()
    {
        d(); d(); d();
    }
    /**
     * Turns the front face of the cube 90 degrees
     * clockwise
     */
    public void f()
    {
        CornerPiece[] newCorners = new CornerPiece[8];
        System.arraycopy(corners, 0, newCorners, 0, 8);
        newCorners[0] = corners[4];
        newCorners[1] = corners[0];
        newCorners[5] = corners[1];
        newCorners[4] = corners[5];

        newCorners[0].turnCCW();
        newCorners[1].turnCW();
        newCorners[5].turnCCW();
        newCorners[4].turnCW();

        corners = newCorners;

        EdgePiece[] newEdges = new EdgePiece[12];
        System.arraycopy(edges, 0, newEdges, 0, 12);

        newEdges[0] = edges[4];
        newEdges[5] = edges[0];
        newEdges[8] = edges[5];
        newEdges[4] = edges[8];

        newEdges[0].toggleOrientation();
        newEdges[5].toggleOrientation();
        newEdges[8].toggleOrientation();
        newEdges[4].toggleOrientation();

        edges = newEdges;
    }
    /**
     * Turns the front face of the cube 180 degrees
     */
    public void f2()
    {
        f(); f();
    }
    /**
     * Turns the front face of the cube 90 degrees
     * counterclockwise
     */
    public void fi()
    {
        f(); f(); f();
    }
    /**
     * Turns the back face of the cube 90 degrees
     * clockwise
     */
    public void b()
    {
        CornerPiece[] newCorners = new CornerPiece[8];
        System.arraycopy(corners, 0, newCorners, 0, 8);
        newCorners[2] = corners[6];
        newCorners[3] = corners[2];
        newCorners[7] = corners[3];
        newCorners[6] = corners[7];

        newCorners[2].turnCCW();
        newCorners[3].turnCW();
        newCorners[7].turnCCW();
        newCorners[6].turnCW();

        corners = newCorners;

        EdgePiece[] newEdges = new EdgePiece[12];
        System.arraycopy(edges, 0, newEdges, 0, 12);

        newEdges[2] = edges[6];
        newEdges[7] = edges[2];
        newEdges[10] = edges[7];
        newEdges[6] = edges[10];

        newEdges[2].toggleOrientation();
        newEdges[7].toggleOrientation();
        newEdges[10].toggleOrientation();
        newEdges[6].toggleOrientation();

        edges = newEdges;
    }
    /**
     * Turns the back face of the cube 180 degrees
     */
    public void b2()
    {
        b(); b();
    }
    /**
     * Turns the back face of the cube 90 degrees
     * counterclockwise
     */
    public void bi()
    {
        b(); b(); b();
    }
    /**
     * Returns a picture of the right side of the cube.<br/>
     * Example:<br/>
     * Y Y Y<br/>
     * Y Y Y<br/>
     * Y Y Y<br/>
     * would be the returned String for the solved
     * cube held with blue on U and red in F.
     * @return the String representing the right side
     */
    public String printR()
    {
        CornerPiece[] rCorners =
            {corners[1], corners[2],
             corners[5], corners[6]};
        EdgePiece[] rEdges =
            {        edges[1],
             edges[5],       edges[6],
                     edges[9]        };
        String ul = rCorners[0].getColorLetter(CornerPiece.CCW);
        String u = rEdges[0].getColorLetter(EdgePiece.UNORIENTED);
        String ur = rCorners[1].getColorLetter(CornerPiece.CW);
        String l = rEdges[1].getColorLetter(EdgePiece.UNORIENTED);
        String r = rEdges[2].getColorLetter(EdgePiece.UNORIENTED);
        String dl = rCorners[2].getColorLetter(CornerPiece.CW);
        String d = rEdges[3].getColorLetter(EdgePiece.UNORIENTED);
        String dr = rCorners[3].getColorLetter(CornerPiece.CCW);
        return ul + " " + u + " " + ur + "\n" +
               l +      " Y " +      r + "\n" +
               dl + " " + d + " " + dr;
    }
    /**
     * Returns a picture of the up side of the cube.
     * 
     * @return the String representing the up side
     * @see printR()
     */
    public String printU()
    {
        CornerPiece[] uCorners =
            {corners[3], corners[2],
             corners[0], corners[1]};
        EdgePiece[] uEdges =
            {        edges[2],
             edges[3],       edges[1],
                     edges[0]        };
        String ul = uCorners[0].getColorLetter(CornerPiece.ORIENTED);
        String u = uEdges[0].getColorLetter(EdgePiece.ORIENTED);
        String ur = uCorners[1].getColorLetter(CornerPiece.ORIENTED);
        String l = uEdges[1].getColorLetter(EdgePiece.ORIENTED);
        String r = uEdges[2].getColorLetter(EdgePiece.ORIENTED);
        String dl = uCorners[2].getColorLetter(CornerPiece.ORIENTED);
        String d = uEdges[3].getColorLetter(EdgePiece.ORIENTED);
        String dr = uCorners[3].getColorLetter(CornerPiece.ORIENTED);
        return ul + " " + u + " " + ur + "\n" +
               l +      " B " +      r + "\n" +
               dl + " " + d + " " + dr;
    }
    /**
     * Returns a picture of the front side of the cube.
     * 
     * @return the String representing the front side
     * @see printR()
     */
    public String printF()
    {
        CornerPiece[] fCorners =
            {corners[0], corners[1],
             corners[4], corners[5]};
        EdgePiece[] fEdges =
            {        edges[0],
             edges[4],       edges[5],
                     edges[8]        };
        String ul = fCorners[0].getColorLetter(CornerPiece.CCW);
        String u = fEdges[0].getColorLetter(EdgePiece.UNORIENTED);
        String ur = fCorners[1].getColorLetter(CornerPiece.CW);
        String l = fEdges[1].getColorLetter(EdgePiece.ORIENTED);
        String r = fEdges[2].getColorLetter(EdgePiece.ORIENTED);
        String dl = fCorners[2].getColorLetter(CornerPiece.CW);
        String d = fEdges[3].getColorLetter(EdgePiece.UNORIENTED);
        String dr = fCorners[3].getColorLetter(CornerPiece.CCW);
        return ul + " " + u + " " + ur + "\n" +
               l +      " R " +      r + "\n" +
               dl + " " + d + " " + dr;
    }
    /**
     * Performs a T permutation on the blue face, effectively
     * swapping edges[1] with edges[3] and swapping corners[1]
     * with corners[2]
     */
    public void tPerm()
    {
        r(); u(); ri(); ui();
        ri(); f();
        r2(); ui(); ri(); ui();
        r(); u(); ri(); fi();
    }
}