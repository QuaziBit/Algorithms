/*************************************************************************************************
 * Implemented by Olexandr Matveyev                                                              *
 * --------------------------------------------------------------------------------------------- *
 * Author of the Selection Sort Algorithm is:                                                    *
 * Shellsort was invented by Donald Shell in 1959. It improves upon insertion sort by            *
 * moving out of order elements more than one position at a time. The concept behind             *
 * Shellsort is that insertion sort performs in time, where k is the greatest distance           *
 * between two out-of-place elements.                                                            *
 * --------------------------------------------------------------------------------------------- *
 */

/**
 * Class: Sorting algorithm
 * Data structure: Array
 * Worst-case performance: O(n^2) comparisons, O(n^2) swaps
 * Best-case performance: O(n) comparisons, O(1) swaps
 * Average performance: O(n^2) comparisons, O(n^2) O(n^2) swaps
 * Worst-case space complexity: O(1) auxiliary
 */

/**
 * Sorting Algorithms are concepts that every competitive programmer must know.
 * Sorting algorithms can be used for collections of numbers, strings, characters,
 * or a structure of any of these types.
 *
 * Bubble sort is based on the idea of repeatedly comparing pairs of adjacent elements
 * and then swapping their positions if they exist in the wrong order.
 *
 * Assume that A[] is an unsorted array of elements. This array needs to be sorted in ascending order.
 * The pseudo code is as follows:
 */

public class BubbleSort
{
    public BubbleSort()
    {

    }

    /**
     * Sorting in ascending order
     * @param array
     * @return
     */
    public int[] sortAscending(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                int left = array[i];
                int right = array[j];

                // In descending order the difference only is  '<',
                // but in ascending order is '>'
                if (right > left)
                {
                    // Swap elements
                    array = swap(i, j, array);
                }
            }
        }

        return array;
    }

    /**
     * Sorting in descending order
     * @param array
     * @return
     */
    public int[] sortDescending(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                int left = array[i];
                int right = array[j];

                // In descending order the difference only is  '<',
                // but in ascending order is '>'
                if (right < left)
                {
                    // Swap elements
                    array = swap(i, j, array);
                }
            }
        }

        return array;
    }

    public int[] swap(int i, int j, int[] array)
    {
        int left = array[i];
        int right = array[j];

        int tmp = left;

        // Swap elements
        array[i] = right;
        array[j] = left;

        return array;
    }
}
