/*************************************************************************************************
 * Implemented by Olexandr Matveyev                                                              *
 * --------------------------------------------------------------------------------------------- *
 * Author of the Merge Sort Algorithm is:                                                    *
 *                                                  *
 * --------------------------------------------------------------------------------------------- *
 */

/**
 * IS NO COMPLETED
 */

public class Main
{
    public static void main(String[] args)
    {
        MergeSort mergeSort = new MergeSort();

        int[] array = {20, 1, 5, 25, 4, 10};
        //int[] array = {20, 1, 5, 25, 8, 18, 19, 4, 2, 8};
        //int[] array = {20, 15, 12, 10, 7, 8, 4, 3, 1, 0};

        System.out.println("Merge Sort Algorithm");

        int[] sorted = null;
        mergeSort.sortAscending(array);
        //int[] sorted = mergeSort.sortAscending(array, 0, array.length);
        //int[] sorted = mergeSort.sortDescending(array);

        /*
        for (int i = 0; i < sorted.length; i++)
        {
            System.out.printf("%d: %d\n", i, sorted[i]);
        }
        */
    }
}
