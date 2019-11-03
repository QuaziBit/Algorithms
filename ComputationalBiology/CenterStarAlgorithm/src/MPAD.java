/**
 * Montana State University
 * Class: Adv/Computational Biology CL - CSCI 451 - 551 - 001
 * @author Olexandr Matveyev
 *
 * MPAD: Multiple Paired Alignment Data is data-structure
 * This class is used to provide minimal data structure for the paired-alignment algorithm results
 * in order to have nice output in console.
 */

public class MPAD
{
    private String original_S1 = null;
    private String original_S2 = null;
    private String modified_S1 = null;
    private String modified_S2 = null;
    private Integer alignmentScore = null;
    private Integer pairwiseScore = 0;

    /*
     * Two cost function parameters:
     * alpha and beta,
     * where delta(x,y) = alpha > 0 and delta(x,-) = beta > 0
     * (Note: delta(x,x) = 0).
     * */
    private int alpha = 0;
    private int beta = 0;
    private int theta = 0;


    public MPAD(String original_S1, String original_S2, String modified_S1, String modified_S2, Integer alignmentScore, int alpha, int beta, int theta)
    {
        this.original_S1 = original_S1;
        this.original_S2 = original_S2;
        this.modified_S1 = modified_S1;
        this.modified_S2 = modified_S2;
        this.alignmentScore = alignmentScore;
        this.alpha = alpha;
        this.beta = beta;
        this.theta = theta;

        if (modified_S1 != null && modified_S2 != null)
        {
            compare();
        }
    }

    /**
     * Calculating pairwise scores based on: alpha, beta, and theta.
     */
    private void compare()
    {
        for (int i = 0; i < modified_S1.length(); i++)
        {
            String S1 = Character.toString(modified_S1.charAt(i));
            for (int j = 0; j < modified_S2.length(); j++)
            {
                String S2 = Character.toString(modified_S2.charAt(i));

                if (!S1.equals("-") && !S2.equals("-"))
                {
                    if (!S1.equals(S2))
                    {
                        // delta(x,y) = alpha > 0
                        pairwiseScore += alpha;
                    }
                    else
                    {
                        // delta(x,x) = theta = 0
                        pairwiseScore += theta;
                    }
                }
                else if (!S1.equals("-") && S2.equals("-"))
                {
                    // delta(x,-) = beta > 0
                    pairwiseScore += beta;
                }
            }
        }

    }

    public String getOriginal_S1()
    {
        return original_S1;
    }

    public String getOriginal_S2()
    {
        return original_S2;
    }

    public String getModified_S1()
    {
        return modified_S1;
    }

    public String getModified_S2()
    {
        return modified_S2;
    }

    public Integer getAlignmentScore()
    {
        return alignmentScore;
    }

    public Integer getPairwiseScore()
    {
        return pairwiseScore;
    }
}
