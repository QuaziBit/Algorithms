/**
 * Montana State University
 * Class: Adv/Computational Biology CL - CSCI 451 - 551 - 001
 * @author Olexandr Matveyev
 *
 * DSTR: data-structure
 * This class is used to provide minimal data structure for the algorithm results
 * in order to have nice output in console.
 */

public class DSTR
{
    private String s = null;
    private String t = null;
    private Integer alignmentScore = null;
    private Integer ancestorScore = null;

    public DSTR(String s, String t, Integer alignmentScore, Integer ancestorScore)
    {
        this.s = s;
        this.t = t;
        this.alignmentScore = alignmentScore;
        this.ancestorScore = ancestorScore;
    }

    public String getS()
    {
        return this.s;
    }

    public String getT()
    {
        return this.t;
    }

    public Integer getAlignmentScore()
    {
        return this.alignmentScore;
    }

    public Integer getAncestorScore()
    {
        return this.ancestorScore;
    }
}
