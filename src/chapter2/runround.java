package chapter2;
/*
ID: alan.bi1
LANG: JAVA
TASK: runround
*/
import java.io.*;
import java.util.*;

public class runround
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("runround.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));

        long N = Integer.parseInt(f.readLine());

        boolean found = false;

        long num = N + 1;
        while(!found)
        {
            if(isSolution(num))
            {
                out.println(num);
                found = true;
            }
            num++;
        }

        out.close();
    }

    public static boolean isSolution(long num)
    {
        boolean[] digits = new boolean[10];

        long temp = num;
        while(temp > 0)
        {
            if(digits[(int) (temp % 10)] || temp % 10 == 0)
            {
                return false;
            }
            digits[(int) (temp % 10)] = true;
            temp /= 10;
        }

        String str = Long.toString(num);
        int index = 0;

        for(int i = 0; i < str.length(); i++)
        {
            int digitIndex = Character.getNumericValue(str.charAt(index));
            if(!digits[digitIndex])
            {
                return false;
            }
            else
            {
                digits[digitIndex] = false;
                index = (index + digitIndex) % str.length();
            }
        }

        if(index == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
