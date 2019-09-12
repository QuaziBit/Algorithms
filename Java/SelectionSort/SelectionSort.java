/*************************************************************************************************
 * Implemented by Olexandr Matveyev                                                              *
 * --------------------------------------------------------------------------------------------- *
 * Author of the Selection Sort Algorithm is:                                                    *
 * The Shell sort was invented by Donald Shell in 1959 and for years (until the Quicksort)       *
 * was considered one of the best comparison based sorts available. The sort is simple to code,  *
 * but a little tricky to understand. It helps to see it visually. When it makes passes,         *
 * it performs an insertion sort on every pass.                                                  *
 * --------------------------------------------------------------------------------------------- *
 */

/**
 * Class: Sorting algorithm
 * Data structure: Array
 * Worst-case performance: О(n^2) comparisons, О(n) swaps
 * Best-case performance: О(n^2) comparisons, О(n) swaps
 * Average performance: О(n^2) comparisons, О(n) swaps
 * Worst-case space complexity: O(1) auxiliary
 */

/**
 * Selection Sort. The Selection sort algorithm is based on the idea
 * of finding the minimum or maximum element in an unsorted array and
 * then putting it in its correct position in a sorted array. Assume
 * that the array A = [ 7 , 5 , 4 , 2 ] needs to be sorted in ascending order.
 *
 * The Selection sort algorithm is based on the idea of finding the minimum
 * or maximum element in an unsorted array and then putting it in its correct
 * position in a sorted array.
 *
 * Assume that the array needs to be sorted in ascending order.
 *
 * The minimum element in the array i.e.
 * is searched for and then swapped with the element that is currently located
 * at the first position, i.e. . Now the minimum element in the remaining unsorted array
 * is searched for and put in the second position, and so on.
 */


public class SelectionSort
{
    public SelectionSort()
    {

    }

    /** Sorting in ascending order
     * @param a
     * @return
     */
    public int[] sortAscending(int[] a)
    {
        // min: store index of the smallest element in an array
        int min;

        // max: store index of the largest element in an array
        int max;

        // shift: we have to shift our index for the second loop on the partially sorted array
        int shift = 0;

        // Initial loop
        for (int i = 0; i < a.length; i++)
        {
            // store indexes
            // ----------------------------------------- //
            min = i;
            max = i;
            // ----------------------------------------- //

            // Second loop is needed to find the smallest element in the array
            for (int j = (shift + 1); j < a.length; j++)
            {
                // In descending order the difference only is  '<',
                // but in ascending order is '>'
                if (a[j] < a[min])
                {
                    // store index of the smallest element of the array
                    min = j;
                }
            }

            // shift starting index for the second loop
            // we have to do it in order to avoid backward element swapping
            shift++;

            // swap the smallest element with the largest element
            a = swap(min, max, a);
        }

        // return sorted array
        return a;
    }


    /** Sorting in ascending order
     * @param a
     * @return
     */
    public int[] sortDescending(int[] a)
    {
        // min: store index of the smallest element in an array
        int min;

        // max: store index of the largest element in an array
        int max;

        // shift: we have to shift our index for the second loop on the partially sorted array
        int shift = 0;

        // Initial loop
        for (int i = 0; i < a.length; i++)
        {
            // store indexes
            // ----------------------------------------- //
            min = i;
            max = i;
            // ----------------------------------------- //

            // Second loop is needed to find the smallest element in the array
            for (int j = (shift + 1); j < a.length; j++)
            {
                // In descending order the difference only is  '<',
                // but in ascending order is '>'
                if (a[j] > a[min])
                {
                    // store index of the smallest element of the array
                    min = j;
                }
            }

            // shift starting index for the second loop
            // we have to do it in order to avoid backward element swapping
            shift++;

            // swap the smallest element with the largest element
            a = swap(min, max, a);
        }

        // return sorted array
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
