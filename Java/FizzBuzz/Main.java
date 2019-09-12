/**
 * Write a program that prints the numbers from 1 to 100
 * and for multiples of '3' print "Fizz"
 * instead of the number and for
 * the multiples of '5' print "Buzz".
 *
 */

public class Main
{

    public static void main(String[] args)
    {
        int range = 100;
        int num1 = 3;
        int num2 = 5;

        for (int i = 1; i <= 100; i++)
        {
            if ( (i % num1) == 0)
            {
                System.out.printf("Fizz, ", i);
            }
            else if ( (i % num2) == 0)
            {
                System.out.printf("Buzz, ", i);
            }
            else
            {
                System.out.printf("%d, ", i);
            }

            if ( (i % 10) == 0)
            {
                System.out.printf("\n");
            }
        }
    }
}
