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
 * Problem 4 (20 pts) Programming project: Center Sequence Finder
 *
 * Implement the first two steps of the Center Star Algorithm.
 * Your program should take as input a FASTA file specifying a set of sequences,
 * as well as two cost function parameters, alpha and beta,
 * where delta(x,y) = alpha > 0 and delta(x,-) = beta > 0    (Note: delta(x,x) = 0).
 *
 * The program should output the center sequence, based on the specified distance function.
 * Demonstrate the algorithm works on several examples, including the set of sequences from Problem 1.
 *
 * Bonus (5 pts) Implement the entire Center Star Algorithm so
 * that your program also finds and prints out the multiple sequence alignment.
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
            String a = args[3];
            String b = args[4];

            // gp is option to choose scoring method,
            // it can be global alignment scoring
            // or pairwise scoring
            String gp = args[5];

            // delta(match) = x
            int x = Integer.parseInt(s_x);

            // delta(mismatch) = y
            int y = Integer.parseInt(s_y);

            // delta(insertion/deletion) = z
            int z = Integer.parseInt(s_z);

            // delta(x,y) = alpha > 0
            int alpha = Integer.parseInt(a);

            // delta(x,-) = beta > 0
            int beta = Integer.parseInt(b);

            // delta(x,x) = theta = 0
            int theta = 0;

            // it is option to pick 'global alignment scoring'
            // based on: delta(match), delta(mismatch), delta(insertion/deletion)'
            // or 'pairwise scoring based on 'alpha' and 'beta''
            int option = Integer.parseInt(gp);

            if (z >= 1)
            {
                System.out.printf("Provided [delta(insertion/deletion)] or (indel) value: %d\n", z);
                System.out.printf("IMPORTANT: This value must be negative or zero.\n");
                System.out.printf("Program terminated.\n");

                return;
            }
            if (alpha <= 0)
            {
                System.out.printf("Provided [delta(x,y) = alpha > 0] value: %d\n", alpha);
                System.out.printf("IMPORTANT: This value must be greater than zero.\n");
                System.out.printf("Program terminated.\n");

                return;
            }
            if (beta <= 0)
            {
                System.out.printf("Provided [delta(x,-) = beta > 0] value: %d\n", beta);
                System.out.printf("IMPORTANT: This value must be greater than zero.\n");
                System.out.printf("Program terminated.\n");

                return;
            }
            if (option < 0 || option > 1)
            {
                System.out.printf("Provided [option] value: %d\n", option);
                System.out.printf("if option: 0 { use global alignment scoring }\n");
                System.out.printf("if option: 1 { use pairwise scoring based on 'alpha' and 'beta' }\n");
                System.out.printf("IMPORTANT: This value must be 'zero' or 'one'.\n");
                System.out.printf("Program terminated.\n");

                return;
            }


            String[] fastaInput = null;

            // Combine "absolute path of the running Main.class" and "file name"
            fileName = args[6];
            filePath = path + "/" + fileName;

            try
            {
                if (option == 0)
                {
                    System.out.printf("Option: global alignment scoring based on: delta(match), delta(mismatch), delta(insertion/deletion).\n\n");
                }
                else if (option == 1)
                {
                    System.out.printf("pairwise scoring based on: 'alpha' and 'beta'.\n\n");
                }

                System.out.printf("Global Alignment Parameters:\n");
                System.out.printf("\t[%d]: delta(match)\n", x);
                System.out.printf("\t[%d]: delta(mismatch)\n", y);
                System.out.printf("\t[%d]: delta(insertion/deletion)\n\n", z);

                System.out.printf("Pairwise Alignment Parameters:\n");
                System.out.printf("\t[%d]: delta(x,y) = alpha\n", alpha);
                System.out.printf("\t[%d]: delta(x,-) = beta\n\n", beta);

                // Get resource from the file path
                res = Paths.get(filePath).toUri().toURL();

                // Read FASTA file
                FastaReader fastaReader = new FastaReader(res);
                fastaInput = fastaReader.getFastaInput();


                // Section from Assignment 2
                // -------------------------------------------------------------------------- //
                /*
                String S = fastaInput[0];
                String T = fastaInput[1];

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
                */
                // -------------------------------------------------------------------------- //

                // Section from Assignment 4
                // -------------------------------------------------------------------------- //
                String[] set = fastaInput;
                MPAD[] mpad_set = new MPAD[set.length];
                String original_S1 = set[0];

                // Generate paired alignments
                for (int i = 1; i < mpad_set.length; i++)
                {
                    // align S1 with all Si
                    String S1 = set[0];
                    String Si = set[i];

                    GlobalSequenceAlignment gsa = new GlobalSequenceAlignment(S1, Si, x, y, z);
                    gsa.run();
                    gsa.generatePairedAlignment();


                    // --------------------------------------------------------------------- //
                    // we have to check if S1 was modified according to global alignment;
                    // if it was modified, then we have to update previous version of S1;
                    if (!gsa.getModified_S1().equals(S1))
                    {
                        set[0] = gsa.getModified_S1();
                    }
                    // --------------------------------------------------------------------- //


                    mpad_set[i] = gsa.getMPAD(alpha, beta, theta);

                    // add first string without any extra information
                    if ( (i + 1) ==  mpad_set.length)
                    {
                        mpad_set[0] = new MPAD(original_S1, null, null, null, null, alpha, beta, theta);
                    }

                    // Uncomment this portion of code if you want to see Global Alignment
                    // table for each pairwise alignment
                    // ------------------------------------------------------------------------ //
                    /*
                    System.out.printf("Scoring Matrix V:\n");
                    gsa.printAlignmentTable();

                    System.out.printf("\nString alignment:");
                    gsa.printAlignment();

                    System.out.printf("\n");
                    */
                    // ------------------------------------------------------------------------ //

                }

                // Run Center Star Alignment
                CenterStarAlignment csa = new CenterStarAlignment(option, mpad_set, set.length);
                csa.run();
                // -------------------------------------------------------------------------- //

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
