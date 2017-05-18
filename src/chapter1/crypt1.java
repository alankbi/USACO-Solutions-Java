package chapter1;/*
ID: alan.bi1
LANG: JAVA
TASK: crypt1
*/
import java.io.*;
import java.util.*;

public class crypt1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        //Scanner f = new Scanner(System.in);
        StringTokenizer st;

        int N = Integer.parseInt(f.readLine());

        st = new StringTokenizer(f.readLine());

        int[] digits = new int[N];

        for(int i = 0; i < N; i++)
        {
            digits[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for(int a = 0; a < N; a++)
        {
            for(int b = 0; b < N; b++)
            {
                for(int c = 0; c < N; c++)
                {
                    for(int d = 0; d < N; d++)
                    {
                        for(int e = 0; e < N; e++)
                        {
                            if(isSol(digits, digits[a], digits[b], digits[c], digits[d], digits[e]))
                            {
                                count++;
                            }
                        }
                    }
                }
            }
        }

        out.println(count);

        out.close();
    }

    public static boolean isSol(int[] digits, int a, int b, int c, int d, int e)
    {
        int top = e * (c + b * 10 + a * 100);
        int bottom = d * (c + b * 10 + a * 100);

        String topStr = Integer.toString(top);
        String bottomStr = Integer.toString(bottom);

        if(topStr.length() != 3 || bottomStr.length() != 3)
        {
            return false;
        }
        if(!checkDigits(digits, topStr) || !checkDigits(digits, bottomStr))
        {
            return false;
        }
        //System.out.println(topStr + " " + bottomStr);
        int sum = top + bottom * 10;
        if(!checkDigits(digits, Integer.toString(sum)))
        {
            return false;
        }
        //System.out.println("" + a + b + c + " \n" + d + e + "\n" + top + " " + bottom + " " + sum);

        return true;
    }

    public static boolean checkDigits(int[] digits, String temp)
    {
        boolean solution = false;
        for(int i = 0; i < temp.length(); i++)
        {
            for(int j = 0; j < digits.length; j++)
            {
                if(Character.getNumericValue(temp.charAt(i)) == digits[j])
                {
                    solution = true;
                    break;
                }
            }
            if(!solution)
            {
                return false;
            }
            solution = false;
        }
        return true;
    }
}
