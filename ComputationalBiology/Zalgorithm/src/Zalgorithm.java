import java.util.HashMap;
import java.util.Map;

/**
 * Montana State University
 * Class: Adv/Computational Biology CL - CSCI 451 - 551 - 001
 * @author Olexandr Matveyev
 */

public class Zalgorithm
{
    private String pattern = null;
    private String fastaString = null;
    private String zstring = null;

    private int counter = 0;

    private Map<Integer, DSTR> map_of_dstr = new HashMap<Integer, DSTR>();

    public Zalgorithm(String pattern, String fastaString)
    {
        this.pattern = pattern.toUpperCase();
        this.fastaString = fastaString.toUpperCase();

        // Combine pattern and fasta-string
        this.zstring = pattern + "$" + fastaString;
    }

    /**
     * This function is used to run Z-algorithm, as well as Exact Pattern Matching algorithm.
     */
    public void run()
    {
        // index counter of the pattern string
        int j = 0;

        int zval = 0;

        // Time complexity should be Big-Oh(n)
        for (int i = 0; i < fastaString.length(); i++)
        {
            // character from input-string
            char c1 = fastaString.charAt(i);

            // character from patter
            char c2 = pattern.charAt(j);

            if (c1 == c2)
            {
                map_of_dstr.put(i, new DSTR(c1, 1, i));
                j++;
            }

            if (c1 != c2)
            {
                map_of_dstr.put(i, new DSTR(c1, 0, i));
                j = 0;
            }

            // if index counter of the pattern == to pattern size then we have to reset index counter
            if (j == pattern.length())
            {
                j = 0;
            }
        }

        map_of_dstr.put(fastaString.length(), new DSTR('*', 0, fastaString.length()));
    }


    /**
     * Print result
     */
    public void print()
    {
        int total = 0;

        // Time complexity Big-Oh(n)
        for (Map.Entry<Integer, DSTR> entry : map_of_dstr.entrySet())
        {
            DSTR tmp = entry.getValue();
            System.out.printf("[%c] : (%d) ::: {%d}\n", tmp.getSymbol(), tmp.getCount(), tmp.getIndex());
        }
        System.out.printf("\n");

        System.out.printf("Given Pattern: %s\n", pattern);
        System.out.printf("Given String:  %s\n\n", fastaString);

        // Time complexity Big-Oh(n)
        for (Map.Entry<Integer, DSTR> entry : map_of_dstr.entrySet())
        {
            if (entry.getValue().getCount() != 0)
            {
                total += entry.getValue().getCount();
            }
            else if(entry.getValue().getCount() == 0)
            {
                int index = entry.getValue().getIndex() - 1;
                if (total == pattern.length())
                {
                    index = index - pattern.length() + 1;
                    System.out.printf("At index [%d] in given string z-value is <exact match> [%d]\n", index, total);
                }
                else if (total > pattern.length())
                {
                    index = index - total + 1;
                    System.out.printf("At index [%d] in given string z-value is <max> [%d]\n", index, total);
                }

                total = 0;
            }
        }
    }
}
