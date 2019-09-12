public class Main
{
    public static void main(String[] args)
    {
        String str = "aabbccdccbbaa";
        char word[] = str.toCharArray();
        int j = word.length - 1;
        int count = 0;

        for (int i = 0; i < word.length; i++)
        {
            if (word[i] == word[j])
            {
                count++;
            }
            j--;
        }

        if (count == word.length)
        {
            System.out.printf("IS PALINDROME");
        }
        else
        {
            System.out.printf("IS NOT PALINDROME");
        }
    }
}
