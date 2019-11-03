/**
 * Montana State University
 * Class: Adv/Computational Biology CL - CSCI 451 - 551 - 001
 * @author Olexandr Matveyev
 */

/**
 * IMPORTANT: FOR GLOBAL ALIGNMENT PORTION
 * [delta(insertion/deletion) or (indel) value must zero be negative]
 * This class is used to align two input string 'S' and 'T' by generating scoring-matrix 'V',
 * and by using matrix 'V' scores two strings will be aligned.
 * OUTPUT [1]: Printed scoring-matrix 'V' as table.
 * OUTPUT [2]: Printed aligned strings 'S' and 'T'.
 */

/**
 * Center Star Algorithm
 */

public class CenterStarAlignment
{
    private int option = 0;

    private MPAD[] mpad_set = null;

    // number of Strings
    private int n = 0;

    private int[][] V = null;

    public CenterStarAlignment(int option, MPAD[] mpad_set, int n)
    {
        this.option = option;

        this.mpad_set = mpad_set;
        this.n = n;

        V = new int[n][n];
    }

    /**
     * Run Center Star Algorithm
     */
    public void run()
    {
        generateScoringMatrix();
        printScoringMatrix();
    }

    /**
     * Generation table of pairwise alignment scores
     */
    private void generateScoringMatrix()
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = (i + 1); j < n; j++)
            {
                if (j == 0 || i == j)
                {
                    V[i][j] = 0;
                }
                else
                {
                    if (option == 0)
                    {
                        // this method is using global alignment score
                        V[i][j] = mpad_set[j].getAlignmentScore();

                    }
                    else if (option == 1)
                    {
                        // this method is using alpha and beta values
                        // to generate scores for alignment
                        V[i][j] = mpad_set[j].getPairwiseScore();
                    }
                }
            }
        }
    }

    /**
     * Print results of pairwise alignments
     */
    public void printScoringMatrix()
    {
        // Print results of Global Alignment
        // --------------------------------------------------------- //
        for (int i = 1; i < mpad_set.length; i++)
        {
            System.out.printf("SET: %d\n", i);
            System.out.printf("::: -{ ORIGINAL }- ::: -{ MODIFIED }-\n");
            System.out.printf("S1: -{ %s }- ::: -{ %s }-\n", mpad_set[i].getOriginal_S1(), mpad_set[i].getModified_S1());
            System.out.printf("S%d: -{ %s }- ::: -{ %s }-\n", (i + 1), mpad_set[i].getOriginal_S2(), mpad_set[i].getModified_S2());
            System.out.printf("::: Global Alignment Score: %d\n\n", mpad_set[i].getAlignmentScore());
        }
        // --------------------------------------------------------- //

        // Generating scoring table of paired alignment
        // --------------------------------------------------------- //
        String tmpS = "";
        String tmpT = "";
        String tmpN = "";

        // Generating top of the table
        for (int i = 0; i < n; i++)
        {
            if (i != (n - 1) )
            {
                tmpS += "S" + (i + 1) + "  ";
            }
            else
            {
                tmpS += "S" + (i + 1);
            }
        }
        tmpS = "V   " + tmpS + "  > > Sj";

        // Generating left side of the table and scores
        int d = Integer.MIN_VALUE;
        int index = 0;
        String Sc = "";
        for (int i = 0; i < n; i++)
        {
            int tmp = 0;
            for (int j = 0; j < n; j++)
            {
                String n = "";
                int abs = Math.abs(V[i][j]);
                if (j > 0 && abs < 10)
                {
                    n = String.format(" %+d", V[i][j]);
                    tmp += V[i][j];
                }
                else
                {
                    n = String.format("%+d", V[i][j]);
                    tmp += V[i][j];
                }
                tmpN += " " + n;
            }
            tmpN += String.format(" |:= %+d", tmp);
            tmpT += "S" + (i + 1) + " " + tmpN + "\n";
            tmpN = "";

            if (tmp > d)
            {
                d = tmp;
                index = i;
                Sc = String.format("S%d", (i + 1) );
            }
        }
        tmpT += "^\n" + "^\n" + "Si\n";

        // Printing table
        System.out.printf("%s\n", tmpS);
        System.out.printf("%s", tmpT);

        // Over here we are getting our 'Sc' string,
        // we need to get modified version of S1 string if S1 is Sc
        // ------------------------------------------------------------------ //
        String tmp_str = "";
        if (mpad_set[index].getModified_S2() == null)
        {
            tmp_str = mpad_set[ (mpad_set.length - 1) ].getOriginal_S1();
        }
        else
        {
            tmp_str = mpad_set[index].getModified_S2();
        }
        // ------------------------------------------------------------------ //

        System.out.printf("\nSc: %s ::: -{ %s }-\n", Sc, tmp_str);
        // --------------------------------------------------------- //
    }
}
