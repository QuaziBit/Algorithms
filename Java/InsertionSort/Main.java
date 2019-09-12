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
