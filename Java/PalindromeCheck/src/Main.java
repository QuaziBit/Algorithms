/**
 * Implemented by Olexandr Matveyev
 */

public class Main
{
    public static void main(String[] args)
    {
        String palindrome = "abcba";

        boolean isPalindrome = false;

        isPalindrome = nonRecurrenceApproach(palindrome);
        //isPalindrome = recurrenceApproach(palindrome);

        if (isPalindrome)
        {
            System.out.printf("IS PALINDROME");
        }
        else
        {
            System.out.printf("IS NOT PALINDROME");
        }

    }

    private static boolean nonRecurrenceApproach(String palindrome)
    {
        boolean isPalindrome = false;

        char word[] = palindrome.toCharArray();
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
            isPalindrome = true;
        }
        else
        {
            isPalindrome = false;
        }

        return isPalindrome;
    }

    private static boolean recurrenceApproach(String palindrome)
    {
        // aabbcbbaa

        if (palindrome.length() == 1)
        {
            return true;
        }
        else
        {
            if ( palindrome.charAt(0) == palindrome.charAt( (palindrome.length() - 1) ) )
            {
                // get starting index of new string
                int start = (palindrome.length() + 1) - palindrome.length();

                // get ending index of new string
                int end = palindrome.length() - 1;

                // build new string
                String str = palindrome.substring(start, end);

                // recurrence call, and return
                return recurrenceApproach(str);
            }
            else
            {
                return false;
            }
        }
    }
}
