package q3;

/**
 * @author Joey Bloom
 * 2011 Free Response Question 3
 */
public interface FuelRobot
{
    int getCurrentIndex();

    boolean isFacingRight();

    void changeDirection();

    void moveForward(int numLocs);
}
