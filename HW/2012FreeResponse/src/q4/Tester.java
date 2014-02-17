package q4;

/**
 * @author Joey Bloom
 * 2012 Free Response Question 4
 * Tests GrayImage
 */
public class Tester
{
    public static void main(String[] args)
    {
        int[][] pixels =
        {
            {221,184,178,84,135},
            {84,255,255,130,84},
            {78,255,0,0,78},
            {84,130,255,130,84},
        };

        GrayImage gray = new GrayImage(pixels);
        System.out.println(gray);
        System.out.println("White pixels: " + gray.countWhitePixels());
        gray.processImage();
        System.out.println(gray);
    }
}
/*
Output:
[[221, 184, 178, 84, 135], [84, 255, 255, 130, 84], [78, 255, 0, 0, 78], [84, 130, 255, 130, 84]]
White pixels: 4
[[221, 184, 100, 84, 135], [0, 125, 171, 130, 84], [78, 255, 0, 0, 78], [84, 130, 255, 130, 84]]
 */
