public class Main
{
    public static void main(String[] args)
    {
        int n = 7;

        System.out.printf("Factorial of !%d = %d\n", n, noRecFactorial(n));
        System.out.printf("Factorial of !%d = %d\n", n, recFactorial(n));
    }

    private static int noRecFactorial(int n)
    {
        if (n == 0) return 1;

        int f = 1;

        for (int i = n; i > 0; i--)
        {
            f *= i;
        }

        return f;
    }

    private static int recFactorial(int n)
    {
        if (n == 0)
        {
            return 1;
        }
        else
        {
            return n * recFactorial(n - 1);
        }
    }
}
