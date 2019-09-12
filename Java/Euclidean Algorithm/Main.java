//Алгори́тм Евкли́да

public class Main
{
    public static void main(String args[])
    {
        int a = 8;
        int b = 4;
        System.out.println(gcd1(a, b));

        System.out.println(gcd2(a, b));

    }

    public static int gcd1(int a,int b)
    {
        while (b != 0)
        {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static int gcd2(int p,int q)
    {
        if (q == 0)
        {
            return p;
        }

        int r = p % q;

        return gcd2(p, r);
    }
}
