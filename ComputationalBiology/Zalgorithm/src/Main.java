import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Montana State University
 * Class: Adv/Computational Biology CL - CSCI 451 - 551 - 001
 * @author Olexandr Matveyev
 *
 * Problem 2 (10 pts) Implement the Z-algorithm in the language of your choice. Also, code up
 * the Exact Pattern Matching algorithm that makes use of the Z algorithm.
 * Demonstrate both algorithms on some test strings.
 * Bonus (1 pt): Modify your program to find all occurence of a pattern string in a given FASTA file
 * (https://en.wikipedia.org/wiki/FASTA_format). Your program should run
 * like this: myprogram ACTGA test.fasta
 * Demonstrate this works on a test file of your choice.
 */

public class Main
{
    public static void main(String[] args)
    {
        String fileName = null;
        String path = null;
        String filePath = null;

        // Get absolute path of the running Main.class
        Path currentDir = Paths.get(".");
        path = currentDir.toAbsolutePath().toString();

        // Initialize URL
        URL res = null;

        if(args[0] != null && args[1] != null)
        {
            // Patter
            String pattern = args[0];
            String fastaString = null;

            // Combine "absolute path of the running Main.class" and "file name"
            fileName = args[1];
            filePath = path + "/" + fileName;

            try
            {
                // Get resource from the file path
                res = Paths.get(filePath).toUri().toURL();

                // Read FASTA file
                FastaReader fastaReader = new FastaReader(res);
                fastaString = fastaReader.getFastaString();

                Zalgorithm zalgorithm = new Zalgorithm(pattern, fastaString);

                // Time complexity Big-Oh(n)
                zalgorithm.run();

                // Time complexity Big-Oh(n)
                zalgorithm.print();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.printf("You did not provide <PATTERN> or <complete file name>!\n");
        }
    }
}
