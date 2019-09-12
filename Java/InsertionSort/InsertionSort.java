/*************************************************************************************************
 * Implemented by Olexandr Matveyev                                                              *
 * --------------------------------------------------------------------------------------------- *
 * Author of the Insertion Sort Algorithm is:                                                    *
 * Shellsort was invented by Donald Shell in 1959. It improves upon insertion sort               *
 * by moving out of order elements more than one position at a time.                             *                    *
 * --------------------------------------------------------------------------------------------- *
 */

/**
 * Insertion sort is based on the idea that one element from the input elements is
 * consumed in each iteration to find its correct position i.e, the position to which
 * it belongs in a sorted array.
 *
 * It iterates the input elements by growing the sorted array at each iteration.
 * It compares the current element with the largest value in the sorted array.
 * If the current element is greater, then it leaves the element in its place and moves
 * on to the next element else it finds its correct position in the sorted array and moves
 * it to that position. This is done by shifting all the elements, which are larger than
 * the current element, in the sorted array to one position ahead
 */

/**
 * Class: Sorting algorithm
 * Data structure:	Array
 * Worst-case performance: О(n2) comparisons and swaps
 * Best-case performance: O(n) comparisons, O(1) swaps
 * Average performance: О(n2) comparisons and swaps
 * Worst-case space complexity: О(n) total, O(1) auxiliary
 */

public class InsertionSort
{
    public InsertionSort()
    {

    }

    /**
     * Sorting in ascending order
     * @param a
     * @return
     */
    public int[] sortAscending(int[] a)
    {
        // store number on the left side of specific number
        int leftNum;

        // current number that we will compare to a number in the left side
        int currentNum;

        // arrays' indexes
        int i, j;

        // Outer loop
        for (i = 1; i < a.length; i++)
        {
            // Inner loop
            for (j = (i - 1); j >= 0; j--)
            {
                // store current number and a number on the right side
                leftNum = a[j];
                currentNum = a[j + 1];

                // In descending order the difference only is  '<',
                // but in ascending order is '>'
                if (leftNum > currentNum)
                {
                    // Swap
                    //a[j] = currentNum;
                    //a[j + 1] = leftNum;

                    // Function to swap elements
                    swap(j, (j + 1), a);
                }
            }
        }

        return a;
    }

    /**
     * Sorting in ascending order
     * @param a
     * @return
     */
    public int[] sortDescending(int[] a)
    {
        // store number on the left side of specific number
        int leftNum;

        // current number that we will compare to a number in the left side
        int currentNum;

        // arrays' indexes
        int i, j;

        // Outer loop
        for (i = 1; i < a.length; i++)
        {
            // Inner loop
            for (j = (i - 1); j >= 0; j--)
            {
                // store current number and a number on the right side
                leftNum = a[j];
                currentNum = a[j + 1];

                // In descending order the difference only is  '>',
                // but in ascending order is '<'
                if (leftNum < currentNum)
                {
                    // Swap
                    //a[j] = currentNum;
                    //a[j + 1] = leftNum;

                    // Function to swap elements
                    swap(j, (j + 1), a);
                }
            }
        }

        return a;
    }

    /**
     * Swap an array elements
     * @param min
     * @param max
     * @param a
     * @return
     */
    private int[] swap(int min, int max, int[] a)
    {
        int minNum = a[min];
        int maxNum = a[max];

        a[max] = minNum;
        a[min] = maxNum;

        return a;
    }
}
