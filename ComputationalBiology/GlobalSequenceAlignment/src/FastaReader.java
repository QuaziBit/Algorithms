/**
 * Montana State University
 * Class: Adv/Computational Biology CL - CSCI 451 - 551 - 001
 * @author Olexandr Matveyev
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class FastaReader
{
    // Path to the .txt file
    private URL res = null;

    // Final FASTA string
    private String fasta = "";

    private String[] fastaInput = null;

    public FastaReader(URL res)
    {
        this.res = res;

        try
        {
            run();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void run() throws IOException
    {
        // Loop via .txt file and get its text using BufferedReader

        // [1]: Getting number of lines
        // --------------------------------------------------------------------------------- //
        BufferedReader br = new BufferedReader(new InputStreamReader(res.openStream()));
        // Getting number of lines in FASTA file
        int inputSize = (int) br.lines().count();

        br.close();
        // --------------------------------------------------------------------------------- //

        // [2]: We have to open InputStreamReader one more time to loop over files
        // --------------------------------------------------------------------------------- //
        // init BufferedReader --> InputStreamReader --> file
        br = new BufferedReader(new InputStreamReader(res.openStream()));
        String inputString;

        // init fastaInput
        fastaInput = new String[inputSize];

        // fastaInput indexes
        int i = 0;

        // Going thought text file and getting lines of text
        while ((inputString = br.readLine()) != null)
        {
            fastaInput[i] = inputString;
            i++;
        }
        br.close();
        // --------------------------------------------------------------------------------- //
    }

    public String[] getFastaInput()
    {
        return this.fastaInput;
    }
}
