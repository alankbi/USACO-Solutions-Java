package chapter1;/*
ID: alan.bi1
LANG: JAVA
TASK: milk3
*/
import java.io.*;
import java.util.*;

public class milk3
{
    public static int A;
    public static int B;
    public static int C;

    public static TreeSet<Integer> ts;

    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        ts = new TreeSet<Integer>();

        recurse(0, 0, C, 0);

        int size = ts.size();
        int count = 0;
        for(Integer i : ts)
        {
            if(count == size - 1)
            {
                out.println(i);
            }
            else
            {
                out.print(i + " ");
            }
            count++;
        }

        out.close();
    }

    public static void recurse(int currentA, int currentB, int currentC, int depth)
    {
        if(currentA == 0)
        {
            ts.add(currentC);
        }
        if(depth <= 13)
        {
            if(currentA != 0)
            {
                if(currentB != B)
                {
                    recurse(Math.max(0, currentA - (B - currentB)), Math.min(currentB + currentA, B), currentC, depth + 1);
                }
                if(currentC != C)
                {
                    recurse(Math.max(0, currentA - (C - currentC)), currentB, Math.min(currentC + currentA, C), depth + 1);
                }
            }
            if(currentB != 0)
            {
                if(currentA != A)
                {
                    recurse(Math.min(currentB + currentA, A), Math.max(0, currentB - (A - currentA)), currentC, depth + 1);
                }
                if(currentC != C)
                {
                    recurse(currentA, Math.max(0, currentB - (C - currentC)), Math.min(currentC + currentB, C), depth + 1);
                }
            }
            if(currentC != 0)
            {
                if(currentB != B)
                {
                    recurse(currentA, Math.min(currentB + currentC, B), Math.max(0, currentC - (B - currentB)),depth + 1);
                }
                if(currentA != A)
                {
                    recurse(Math.min(currentC + currentA, A), currentB, Math.max(0, currentC - (A - currentA)), depth + 1);
                }
            }
        }
    }
}
