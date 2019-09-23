/**
 * Montana State University
 * Class: Adv/Computational Biology CL - CSCI 451 - 551 - 001
 * @author Olexandr Matveyev
 */

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Problem 3 (15 pts) Implement the global alignment algorithm from class.
 * Your program should read in a FASTA file (see HW1).
 * You can assume that the file just contains two sequences, e.g.
 *
 * > seq1
 * ACTGGGAAA
 * > seq2
 * CTGGAACA
 *
 * Align the first string with the second string.
 *
 * You can assume a simplified scoring function delta that has the following form:
 * delta(match) = x
 * delta(mismatch) = y
 * delta(insertion/deletion) = z
 *
 * You should supply x, y and z as command-line arguments to your program (as well as the fasta filename).
 *
 * [IS NOT IMPLEMENTED]: Demonstrate that the algorithms works on some test cases.
 * [IS NOT IMPLEMENTED]: You should print out the alignment as well as the score
 *                       (only print one in the case of ties).
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

        if(args[0] != null && args[1] != null  && args[2] != null  && args[3] != null)
        {
            // temp input
            String s_x = args[0];
            String s_y = args[1];
            String s_z = args[2];

            // delta(match) = x
            int x = Integer.parseInt(s_x);

            // delta(mismatch) = y
            int y = Integer.parseInt(s_y);

            // delta(insertion/deletion) = z
            int z = Integer.parseInt(s_z);

            if (z >= 0)
            {
                System.out.printf("Provided [delta(insertion/deletion) or (indel) value: %d\n", z);
                System.out.printf("IMPORTANT: This value must be negative.\n");
                System.out.printf("Program terminated.\n");

                return;
            }

            String[] fastaInput = null;

            // Combine "absolute path of the running Main.class" and "file name"
            fileName = args[3];
            filePath = path + "/" + fileName;

            try
            {
                // Get resource from the file path
                res = Paths.get(filePath).toUri().toURL();

                // Read FASTA file
                FastaReader fastaReader = new FastaReader(res);
                fastaInput = fastaReader.getFastaInput();

                String S = fastaInput[0];
                String T = fastaInput[1];

                System.out.printf("[%d]: delta(match)\n", x);
                System.out.printf("[%d]: delta(mismatch)\n", y);
                System.out.printf("[%d]: delta(insertion/deletion)\n\n", z);

                System.out.printf("FASTA input:\n");
                System.out.printf("\tS: %s\n", S);
                System.out.printf("\tT: %s\n", T);
                System.out.printf("\n");

                System.out.printf("Global alignment output:\n");

                GlobalSequenceAlignment gsa = new GlobalSequenceAlignment(S, T, x, y, z);
                gsa.run();

                System.out.printf("Scoring Matrix V:\n");
                gsa.printAlignmentTable();

                System.out.printf("\nString alignment:");
                gsa.printAlignment();
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
