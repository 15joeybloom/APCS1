package reverse;

/**
 * @author 151bloomj
 * Assignment #10
 * Reverses a String
 */
public class Reverse
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        String str1 = "Jack is angry!";
        String str2 = "!@#$%^&*";
        String str3 = "7";
        String str4 = "74";
        System.out.println(str1);
        System.out.println(reverse(str1));
        System.out.println(str2);
        System.out.println(reverse(str2));
        System.out.println(str3);
        System.out.println(reverse(str3));
        System.out.println(str4);
        System.out.println(reverse(str4));
        System.out.println("");
        System.out.println(reverse(""));
    }

    /**
     * Returns a reversed String
     * @param str string to be reversed
     * @return str reversed
     */
    private static String reverse(String str)
    {
        if(str.length() <= 1)
        {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
}

/*
Output:
Jack is angry!
!yrgna si kcaJ
!@#$%^&*
*&^%$#@!
7
7
74
47


 */