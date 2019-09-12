/**
 * Implemented by Olexandr Matveyev
 *
 * Binary Search: Search a sorted array by repeatedly dividing the search interval in half.
 * Begin with an interval covering the whole array. If the value of the search
 * key is less than the item in the middle of the interval, narrow the interval
 * to the lower half. Otherwise narrow it to the upper half. Repeatedly check
 * until the value is found or the interval is empty.
 */

public class Main
{
    public static void main(String[] args)
    {
        boolean found = false;
        int range = 100;
        int low = 0;
        int mid = 0;
        int max = 0;
        int searchNum = 21;
        int numbers[] = new int[range];

        // Generate numbers
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = i + 1;
        }

        low = 0;
        mid = (numbers.length / 2) - 1;
        max = numbers.length - 1;

        // Binary Search
        while (!found)
        {
            if (searchNum == numbers[mid])
            {
                found = true;
                System.out.printf("Number: %d is at index: %d\n", searchNum, mid);
            }
            if (searchNum < numbers[mid])
            {
                // Create new low, mid, max
                max = mid - 1;

                System.out.printf("[2]: %d -- %d -- %d\n", low, mid, max);
            }
            if (searchNum > numbers[mid])
            {
                // Create new low, mid, max
                low = mid + 1;

                System.out.printf("[1]: %d -- %d -- %d\n", low, mid, max);
            }
            mid = (low + max) / 2;
        }
    }
}
