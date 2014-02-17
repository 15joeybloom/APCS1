
/*
 * Joey Bloom
 * Assignment #14
 * Writes and prints an instance
 * of the Letter class.
 */
public class LetterPrinter
{
    public static void main(String[] args)
    {
        Letter message = new Letter("John", "Mary");
        message.addLine("I am sorry we must part.");
        message.addLine("I wish you all the best.");
        System.out.println(message.getText());
    }
}

/*
Output:
Dear John,

I am sorry we must part.
I wish you all the best.

Sincerely,

Mary

 */