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
    private char c = '\n';
    private int count = 0;
    private int index = 0;

    public DSTR(char c, int count, int index)
    {
        this.c = c;
        this.count = count;
        this.index = index;
    }

    public char getSymbol()
    {
        return this.c;
    }

    public int getCount()
    {
        return this.count;
    }

    public int getIndex()
    {
        return this.index;
    }
}
