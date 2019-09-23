/**
 * Montana State University
 * Class: Adv/Computational Biology CL - CSCI 451 - 551 - 001
 * @author Olexandr Matveyev
 */

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * IMPORTANT: [delta(insertion/deletion) or (indel) value must be negative]
 * This class is used to align two input string 'S' and 'T' by generating scoring-matrix 'V',
 * and by using matrix 'V' scores two strings will be aligned.
 * OUTPUT [1]: Printed scoring-matrix 'V' as table.
 * OUTPUT [2]: Printed aligned strings 'S' and 'T'.
 */
public class GlobalSequenceAlignment
{
    // Global variables
    // ------------------------------------------------------------- //
    private String s = null;
    private String t = null;

    private int matchScore;
    private int missScore;
    private int insrDellScore;

    private String[] S = null;
    private String[] T = null;

    // scoring matrix 'V'
    private int[][] V = null;

    private int dstrID = 0;
    private Map<Integer, DSTR> map_of_dstr = new TreeMap<Integer, DSTR>(Collections.reverseOrder());
    // ------------------------------------------------------------- //

    /**
     * GlobalSequenceAlignment Constructor accepts two DNA sequences.
     * 's' is string we want to align with string 't'.
     * @param s
     * @param t
     */
    public GlobalSequenceAlignment(String s, String t, int matchScore, int missScore, int insrDellScore)
    {
        this.s = s;
        this.t = t;

        this.matchScore = matchScore;
        this.missScore = missScore;
        this.insrDellScore = insrDellScore;

        buildArrays();
        initScoringMatrix();
    }

    /**
     * This method will convert 's' and 't' strings into String arrays
     */
    private void buildArrays()
    {
        // we need to have extra space for 'null' or '-' symbol
        S = new String[s.length() + 1];
        S[0] = "-";

        T = new String[t.length() + 1];
        T[0] = "-";

        int j = 0;
        for (int i = 1; i <= s.length(); i++)
        {
            S[i] = Character.toString(s.charAt(j));
            j++;
        }

        j = 0;
        for (int i = 1; i <= t.length(); i++)
        {
            T[i] = Character.toString(t.charAt(j));
            j++;
        }
    }

    /**
     * Initiating scoring-matrix 'V'.
     */
    private void initScoringMatrix()
    {
        V = new int[S.length][T.length];

        // value for gap/null character
        V[0][0] = 0;

        // init first col and first row with values based on (insertion/deletion) value
        // i: length of 'S' string
        // j: length of 'T' string
        // row
        for (int i = 1; i < V[0].length; i++)
        {
            V[0][i] += V[0][i - 1] + insrDellScore;
        }

        // col
        for (int j = 1; j < V.length; j++)
        {
            V[j][0] += V[j - 1][0] + insrDellScore;
        }
    }

    /**
     * Start sequence alignment.
     */
    public void run()
    {
        generateScoringMatrix();
        stringAlignment(V.length - 1, V[0].length - 1);
    }

    /**
     * This method is used to generate values for the strings alignment.
     * All generated values will be stored in the scoring-matrix 'V'.
     */
    private void generateScoringMatrix()
    {
        // i: length of 'S' string
        // j: length of 'T' string

        // Start generating scoring-matrix
        for (int i = 1; i < V.length; i++)
        {
            String Si = S[i];
            for (int j = 1; j < V[i].length; j++)
            {
                // Temp variables
                String Tj = T[j];
                int horizontalVal = V[i][j - 1] + insrDellScore;
                int verticalVal = V[i - 1][j] + insrDellScore;
                int matchVal = V[i - 1][j - 1] + matchScore;
                int misVal = V[i - 1][j - 1] + missScore;

                // Find what value must be inserted into scoring matrix
                if (Si.equals(Tj))
                {
                    V[i][j] = matchVal;
                    // keep characters from 'S' and 'T': MATCH
                }
                else
                {
                    if (misVal > horizontalVal && misVal > verticalVal)
                    {
                        V[i][j] = misVal;
                        // keep characters from 'S' and 'T': MISMATCH
                    }
                    else if (horizontalVal > verticalVal)
                    {
                        V[i][j] = horizontalVal;
                        // replace character in the 'S' string with '-'
                    }
                    else if (verticalVal > horizontalVal)
                    {
                        V[i][j] = verticalVal;
                        // replace character in the 'T' string with '-'
                    }
                }
            }
        }
    }


    /**
     * This method is {-recursive-}.
     * This method will trace-back the soring-matrix,
     * and it will align two strings 'S' and 'T'.
     * @param i
     * @param j
     */
    private void stringAlignment(int i, int j)
    {
        // i: length of 'S' string
        // j: length of 'T' string

        int alignmentScore = V[i][j];

        // Temp variables
        String Si = S[i];
        String Tj = T[j];

        if (Si.equals(Tj))
        {
            int matchVal = 0;
            int ancestorScore = 0;

            // We have to make sure that we are not exiting array limits after shifting indexes
            if (i == 0 && j == 0)
            {
                matchVal = V[i][j] + matchScore;
                ancestorScore = V[i][j];
            }
            else
            {
                matchVal = V[i - 1][j - 1] + matchScore;
                ancestorScore = V[i - 1][j - 1];
            }

            if (alignmentScore == matchVal)
            {
                // keep characters from 'S' and 'T': MATCH

                // Add results to the map
                map_of_dstr.put(dstrID, new DSTR(Si, Tj, alignmentScore, ancestorScore));
                dstrID++;
            }

            i--;
            j--;
        }
        else
        {
            int horizontalVal = 0;
            int verticalVal = 0;
            int misVal = 0;
            int ancestorScore = 0;

            // We have to make sure that we are not exiting array limits after shifting indexes
            if (i == 0)
            {
                horizontalVal = V[i][j - 1] + insrDellScore;
                verticalVal = V[0][j] + insrDellScore;
                misVal = V[0][j - 1] + missScore;
            }
            if (j == 0)
            {
                horizontalVal = V[i][0] + insrDellScore;
                verticalVal = V[i - 1][j] + insrDellScore;
                misVal = V[i - 1][0] + missScore;
            }
            if (i > 0 && j > 0)
            {
                horizontalVal = V[i][j - 1] + insrDellScore;
                verticalVal = V[i - 1][j] + insrDellScore;
                misVal = V[i - 1][j - 1] + missScore;
            }

            if (misVal > horizontalVal && misVal > verticalVal && alignmentScore == misVal)
            {
                // keep characters from 'S' and 'T': MISMATCH

                // Getting ancestor-score
                // ------------------------------------------ //
                if (i == 0)
                {
                    ancestorScore = V[0][j - 1];
                }
                if (j == 0)
                {
                    ancestorScore = V[i - 1][0];
                }
                if (i > 0 && j > 0)
                {
                    ancestorScore = V[i - 1][j - 1];
                }
                // ------------------------------------------ //

                // Add results to the map
                map_of_dstr.put(dstrID, new DSTR(Si, Tj, alignmentScore, ancestorScore));
                dstrID++;

                i--;
                j--;
            }
            else if (horizontalVal > verticalVal && alignmentScore == horizontalVal)
            {
                // replace character in the 'S' string with '-'

                // Getting ancestor-score
                // ------------------------------------------ //
                if (i == 0)
                {
                    ancestorScore = V[i][j - 1];
                }
                if (j == 0)
                {
                    ancestorScore = V[i][0];
                }
                if (i > 0 && j > 0)
                {
                    ancestorScore = V[i][j - 1];
                }
                // ------------------------------------------ //

                // Add results to the map
                map_of_dstr.put(dstrID, new DSTR("-", Tj, alignmentScore, ancestorScore));
                dstrID++;

                j--;
            }
            else if (verticalVal > horizontalVal && alignmentScore == verticalVal)
            {
                // replace character in the 'T' string with '-'

                // Getting ancestor-score
                // ------------------------------------------ //
                if (i == 0)
                {
                    ancestorScore = V[0][j] + insrDellScore;
                }
                if (j == 0)
                {
                    ancestorScore = V[i - 1][j] + insrDellScore;
                }
                if (i > 0 && j > 0)
                {
                    ancestorScore = V[i - 1][j] + insrDellScore;
                }
                // ------------------------------------------ //

                // Add results to the map
                map_of_dstr.put(dstrID, new DSTR(Si, "-", alignmentScore, ancestorScore));
                dstrID++;

                i--;
            }
            else if (misVal == horizontalVal && misVal == verticalVal && horizontalVal == verticalVal)
            {
                // Sometimes we can have 3 possible ways to trace back,
                // so it is really doesn't matter with way we go.

                // keep characters from 'S' and 'T': MISMATCH

                // Getting ancestor-score
                // ------------------------------------------ //
                if (i == 0)
                {
                    ancestorScore = V[0][j - 1];
                }
                if (j == 0)
                {
                    ancestorScore = V[i - 1][0];
                }
                if (i > 0 && j > 0)
                {
                    ancestorScore = V[i - 1][j - 1];
                }
                // ------------------------------------------ //

                // Add results to the map
                map_of_dstr.put(dstrID, new DSTR(Si, Tj, alignmentScore, ancestorScore));
                dstrID++;

                i--;
                j--;
            }
        }

        // Base case: exit from recursion
        if (i < 0 || j < 0)
        {
            return;
        }

        // Recursive call
        stringAlignment(i, j);
    }

    /**
     * Print alignment of 'S' and 'T' strings.
     */
    public void printAlignment()
    {
        System.out.printf("\n");

        String strS = "";
        String strT = "";
        String completeMatch = "";
        String alignmentScoreStr = "";
        String ancestorScore = "";
        int total = 0;

        for (Map.Entry<Integer, DSTR> entry : map_of_dstr.entrySet())
        {
            strS += entry.getValue().getS() + "  ";
            strT += entry.getValue().getT() + "  ";
            alignmentScoreStr += "" + String.format("%+d", entry.getValue().getAlignmentScore()) + " ";
            total += entry.getValue().getAlignmentScore();
            //ancestorScore += "" + String.format("%+d", entry.getValue().getAncestorScore()) + " ";

            // The completeMatch string will be used to show connections between matched characters
            if (!entry.getValue().getS().equals(entry.getValue().getT()))
            {
                completeMatch += "   ";
            }
            else
            {
                completeMatch += "|  ";
            }
        }
        System.out.printf("S: %s\n   %s\nT: %s\n   %s ::: total: %+d\n", strS, completeMatch, strT, alignmentScoreStr, total);
    }

    /**
     * Print soring-matrix 'V'.
     */
    public void printAlignmentTable()
    {
        String tmpS = "";
        String tmpT = "";
        String tmpN = "";

        // Generating top of the table
        for (int i = 0; i < T.length; i++)
        {
            if (i != (T.length - 1) )
            {
                tmpS += T[i] + "  ";
            }
            else
            {
                tmpS += T[i];
            }
        }
        tmpS = "V   " + tmpS + "  > > T";

        // Generating left side of the table and scores
        for (int i = 0; i < V.length; i++)
        {
            for (int j = 0; j < V[i].length; j++)
            {
                String n = String.format("%+d", V[i][j]);
                tmpN += " " + n;
            }
            tmpT += S[i] + " " + tmpN + "\n";
            tmpN = "";
        }
        tmpT += "^\n" + "^\n" + "S\n";

        // Printing table
        System.out.printf("%s\n", tmpS);
        System.out.printf("%s", tmpT);
    }
}
