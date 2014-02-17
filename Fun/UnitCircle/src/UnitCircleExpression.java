
import java.util.Random;

/**
 * @author Joey Bloom
 * Assignment #
 *
 */
public class UnitCircleExpression
{
    private static final String[] TRIG_FUNCTIONS = {"sin","cos","tan","cot","sec","csc"};
    private static final String[] ANGLES =
    {
        "0","pi/6","pi/4","pi/3",
        "pi/2","5pi/6","3pi/4","2pi/3",
        "pi","7pi/6","5pi/4","4pi/3",
        "3pi/2","11pi/6","7pi/4","5pi/3",
    };
    private static final String[][] ANSWERS =
    {
        {"0","1/2","rt2/2","rt3/2","1"},
        {"1","rt3/2","rt2/2","1/2","0"},
        {"0","rt3/3","1","rt3","undef"},
        {"undef","rt3","1","rt3/3","0"},
        {"1","2rt3/3","rt2","2","undef"},
        {"undef","2","rt2","2rt3/3","1"},
    };

    private static final byte TF = 0b1110000;
    private static final byte ANGLE = 0b0001111;
    private final byte DAT;
    private final String CORRECT;
    /**
     * creates a new UnitCircleExpression
     */
    public UnitCircleExpression()
    {
        DAT = (byte) (new Random().nextInt(191) - 95);

        byte angleType;
        byte angle = getAngle();
        if(angle % 4 == 0)
            angleType = (byte) (angle % 8);
        else
            angleType = (byte) (angle % 4);

        byte tF = getTF();
        String cor = "";
        try
        {
            cor = ANSWERS[tF][angleType];
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.err.println(e);
            System.err.println(DAT);
            System.err.println(tF);
            System.err.println(angle);
            System.err.println(angleType);
            System.exit(1);
        }
        //if cos/sec and angle is in II or III
        if((tF == 1 || tF == 4) && 4 < angle && angle < 12)
            cor = "-" + cor;
        else if(DAT < 0)
        {
            //if sin/cos and angle is in III or IV
            if((tF == 0 || tF == 5) && angle < 8 && angle > 0)
                cor = "-" + cor;
            //if tan/cot angle is in II or IV
            else if((tF == 2 || tF == 3) && ((angle - 1) / 3 == 0 || angle / 3 == 3))
                cor = "-" + cor;
        }
        else
        {
            //if sin/cos and angle is in III or IV
            if((tF == 0 || tF == 5) && angle > 8)
                cor = "-" + cor;

            //if tan/cot and angle is in II or IV
            else if((tF == 2 || tF == 3) && ((angle + 1) / 3 == 2 || (angle - 1) / 3 == 4))
                cor = "-" + cor;
        }
        CORRECT = cor;
    }
    /**
     * returns the expression
     * @return expression
     */
    @Override
    public String toString()
    {
        String returnMe = TRIG_FUNCTIONS[getTF()] + "(";
        if(DAT < 0) returnMe += "-";
        returnMe += ANGLES[getAngle()] + ")";
        return returnMe;
    }
    /**
     * returns a byte 0-5 indicating the trig function
     * of this expression
     * @return 0-5
     */
    private byte getTF()
    {
        return (byte) ((DAT & TF) >>> 4);
    }
    /**
     * returns a byte 0-15 indicating the
     * absolute value of the angle
     * of this expression
     * @return 0-15
     * @see ANGLES
     */
    private byte getAngle()
    {
        return (byte) (DAT & ANGLE);
    }
    /**
     * checks if ans is the correct simplification of the
     * expression
     * @param ans answer to be checked
     * @return true if correct
     * @see TRIG_FUNCTIONS
     */
    public boolean isCorrect(String ans)
    {

        return ans.equals(CORRECT);
    }
}

