package chapter1;/*
ID: alan.bi1
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;

public class dualpal
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        //Scanner f = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(f.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int count = 0;
        int k = S + 1;
        while(count < N)
        {
            int bases = 0;

            for(int i = 2; i <= 10; i++)
            {
                if(bases >= 2)
                    break;

                if(isPal(Integer.toString(k, i)))
                {
                    bases++;
                }
            }

            if(bases >= 2)
            {
                out.println(k);
                count++;
            }

            k++;
        }


        out.close();
    }

    public static boolean isPal(String num)
    {
        for(int i = 0; i < num.length() / 2; i++)
        {
            if(num.charAt(i) != num.charAt(num.length() - 1 - i))
            {
                return false;
            }
        }
        return true;
    }

}
