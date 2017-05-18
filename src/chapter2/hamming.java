package chapter2;
/*
ID: alan.bi1
LANG: JAVA
TASK: hamming
*/

import java.io.*;
import java.util.*;

public class hamming
{
    public static int[] nums;
    public static int D;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        nums = new int[N];
        nums[0] = 0;
        int index = 1;

        for (int i = 1; i < Math.pow(2, B) && index < N; i++)
        {
            if (hamming(i, index))
            {
                nums[index++] = i;
            }
        }

        for(int i = 0; i < N; i++)
        {
            out.print(nums[i]);

            if(i % 10 == 9 || i ==  N - 1)
            {
                out.println();
            }
            else
            {
                out.print(" ");
            }
        }

        out.close();
    }

    public static boolean hamming(int num, int index)
    {
        for(int i = 0; i < index; i++)
        {
            if(countDigits(Integer.toString(nums[i] ^ num, 2)) < D)
            {
                return false;
            }
        }
        return true;
    }

    public static int countDigits(String num)
    {
        int count = 0;

        for (int i = 0; i < num.length(); i++)
        {
            if (num.charAt(i) == '1')
            {
                count++;
            }
        }
        return count;
    }
}
