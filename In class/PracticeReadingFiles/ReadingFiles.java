import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;
/**
 * @author Joey Bloom
 * In-class example for Chapter 14
 * Introduction to reading from a file
 * specifically using Scanner
 */
public class ReadingFiles
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File inFile = new File("Test.txt");
        Scanner in = new Scanner(inFile);
        ArrayList<String> contents = new ArrayList<>();
        while(in.hasNextLine())
        {
            contents.add(in.nextLine());
        }
        System.out.println(contents);
    }
}
