import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Montana State University
 * Class: Adv/Computational Biology CL - CSCI 451 - 551 - 001
 * @author Olexandr Matveyev
 */

public class FastaReader
{
    // Path to the .txt file
    private URL res = null;

    // Final FASTA string
    private String fasta = "";

    public FastaReader(URL res)
    {
        this.res = res;

        try
        {
            run();
        }
        catch (IOException e)
        {
            System.out.printf("Cannot read FASTA file: %s", e.getMessage());
            //e.printStackTrace();
        }
    }

    private void run() throws IOException
    {
        // Loop via .txt file and get its text using BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(res.openStream()));
        String inputString;

        // Going thought text file and getting lines of text
        while ((inputString = br.readLine()) != null)
        {
            //System.out.printf("%s\n", inputString);

            // Generating FASTA string;
            fasta += inputString;
        }

        // Remove all white spaces for input line
        String tmpStr = fasta.replaceAll("\\s+", "");
        fasta = tmpStr;
    }

    public String getFastaString()
    {
        return this.fasta;
    }
}
