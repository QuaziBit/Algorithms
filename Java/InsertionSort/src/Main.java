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

public class Main
{
    public static void main(String[] args)
    {
        InsertionSort insertionSort = new InsertionSort();


        int[] array = {20, 1, 5, 25, 8, 18, 19, 4, 2, 8};
        //int[] array = {20, 15, 12, 10, 7, 8, 4, 3, 1, 0, 50};

        System.out.println("Selection Sort Algorithm");

        int[] sorted = insertionSort.sortAscending(array);
        //int[] sorted = insertionSort.sortDescending(array);

        for (int i = 0; i < sorted.length; i++)
        {
            System.out.printf("%d: %d\n", i, sorted[i]);
        }
    }
}
