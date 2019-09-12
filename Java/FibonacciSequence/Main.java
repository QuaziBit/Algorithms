public class Main
{
    public static void main(String[] args)
    {
        // (0, ) 1,  1,  2,  3,  5,  8,  13,  21,  34,  55,  89, ...
        // F0 = 0; F1 = 1;
        // Fn = F<n - 1> + F<n - 2>
        // for n > 1

        int n0 = 0;
        int n1 = 1;
        int n2;

        System.out.printf("Fibonacci Sequence\n");
        System.out.printf("::: => %d %d ", n0, n1);

        for (int i = 2; i <= 11; i++)
        {
            n2 = n0 + n1;
            System.out.printf("%d ", n2);
            n0 = n1;
            n1 = n2;
        }
    }
}
