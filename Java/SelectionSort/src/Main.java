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


public class Main
{
    public static void main(String[] args)
    {
        SelectionSort selectionSort = new SelectionSort();

        int[] array = {20, 1, 5, 25, 8, 18, 19, 4, 2, 8};
        //int[] array = {20, 15, 12, 10, 7, 8, 4, 3, 1, 0};

        System.out.println("Selection Sort Algorithm");

        int[] sorted = selectionSort.sortAscending(array);
        //int[] sorted = selectionSort.sortDescending(array);

        for (int i = 0; i < sorted.length; i++)
        {
            System.out.printf("%d: %d\n", i, sorted[i]);
        }
    }
}
