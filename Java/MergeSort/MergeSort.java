/*************************************************************************************************
 * Implemented by Olexandr Matveyev                                                              *
 * --------------------------------------------------------------------------------------------- *
 * Author of the Merge Sort Algorithm is:                                                    *
 *                                                  *
 * --------------------------------------------------------------------------------------------- *
 */


/**
 * Merge sort is a divide-and-conquer algorithm (divide-and-conquer paradigm)
 * based on the idea of breaking
 * down a list into several sub-lists until each sublist consists of a single
 * element and merging those sublists in a manner that results into a sorted list.
 *
 * Idea:
 *     Divide the unsorted list into
 * sublists, each containing
 * element.
 * Take adjacent pairs of two singleton lists and merge them to form a list of 2 elements.
 * will now convert into
 *
 *     lists of size 2.
 *     Repeat the process till a single sorted list of obtained.
 *
 * While comparing two sublists for merging, the first element of both lists
 * is taken into consideration. While sorting in ascending order, the element
 * that is of a lesser value becomes a new element of the sorted list. This procedure
 * is repeated until both the smaller sublists are empty and the new combined sublist
 * comprises all the elements of both the sublists.
 */

/**
 * MergeSort(arr[], l,  r)
 * If r > l
 *      1. Find the middle point to divide the array into two halves:
 *              middle m = (l+r)/2
 *      2. Call mergeSort for first half:
 *              Call mergeSort(arr, l, m)
 *      3. Call mergeSort for second half:
 *              Call mergeSort(arr, m+1, r)
 *      4. Merge the two halves sorted in step 2 and 3:
 *              Call merge(arr, l, m, r)
 */

/**
 * IS NO COMPLETED
 */

public class MergeSort
{
    // 20, 15, 12, 10

    private int[] tmp = null;
    private int k = 0;

    public MergeSort()
    {

    }

    public int[] sortAscending(int[] a)
    {
        // Initializing temporal array
        k = a.length;
        tmp = new int[k];

        sort(a, 0, (a.length - 1), "init");
        //sort(a, 0, a.length, "init");

        return a;
    }

    private void sort(int[] a, int lo, int hi, String side)
    {

        // We stop recursion when we index-hi <= index-lo
        if (hi <= lo)
        {
            return;
        }
        else
        {
            // {20, 1, 5, 25, 4, 10}

            int mid = lo + (hi - lo) / 2;

            // Left: array[left...middle]
            // Working with the left side of the array
            sort(a, lo, mid, "left");

            // Right: array[(middle + 1)...left]
            // Working with the right side of the array
            sort(a, (mid + 1), hi, "right");

            // Merging elements
            merge(a, lo, mid, hi, side);
        }
    }

    private void merge(int[] a, int lo, int mid, int hi, String side)
    {
        System.out.printf("Merge [%s]\n", side);
        System.out.printf("\tlo: %d --- mid: %d --- hi: %d\n", lo, mid, hi);
        System.out.printf("\n");

        int i = lo;
        int j = mid + 1;

    }

    /*
    private void sort(int[] a, int start, int end, String side)
    {
        if ( (end - start) == 1 ||  (end - start) == 0)
        {
            // If difference between 'last' index and 'first' index is '1'
            // then it means we have only two elements to sort-out,
            // and we do not have to divide array anymore, and we can return from stack call.
            return;
        }
        else
        {
            // If difference between 'last' index and 'first' index IS-NOT '1'
            // then we have to divide array.

            // By subtracting the 'end' of given array from its 'start'
            // we getting  its length, after dividing its length by 2,
            // we getting  its middle point.
            int mid = (end - start) / 2;

            // Left side of the array
            sort(a, start, (mid - 1), "left");

            // Right side of the array
            sort(a, (mid + 1), end, "left");

            merge(a, start, mid, end, side);
        }
    }

    private void merge(int[] a, int start, int mid, int end, String side)
    {
        System.out.printf("Merge [%s]\n", side);
        System.out.printf("\tstart: %d --- mid: %d --- end: %d\n", start, mid, end);
        System.out.printf("\n");
    }
    */


    public int[] sortDescending(int[] a)
    {
        return null;
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
