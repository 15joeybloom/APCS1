
/*
 * Joey Bloom
 * Assignment #14
 * Writes a letter with a sender and a recipient.
 */
public class Letter
{
    private String sender;
    private String recipient;
    private String text;
    
    public Letter(String from, String to)
    {
        sender = from;
        recipient = to;
        text = "Dear " + sender + ",\n\n";
    }
    
    public void addLine(String line)
    {
        text = text.concat(line.concat("\n"));
    }
    
    public String getText()
    {
        return text + "\nSincerely,\n\n" + recipient;
    }   
}
