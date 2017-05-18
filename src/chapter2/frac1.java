package chapter2;
/*
ID: alan.bi1
LANG: JAVA
TASK: frac1
*/
import java.io.*;
import java.util.*;

public class frac1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));

        int N = Integer.parseInt(f.readLine());

        int[][] frac = new int[N * (N + 1) / 2 + N][2];
        Map<Double, Integer> map = new TreeMap<Double, Integer>();

        int index = 0;
        for(int i = N; i > 0; i--)
        {
            for(int j = i; j >= 0; j--)
            {
                frac[index][0] = j; //num
                frac[index][1] = i; //denom
                map.put((double) j / i, index++);
            }
        }

        for(double key : map.keySet())
        {
            out.println(frac[map.get(key)][0] + "/" + frac[map.get(key)][1]);
        }

        //Create array [N * something][2], start iterating from 5/5 to 4/5 to 3/5... 4/4 to 3/4 to 2/4
        //Add decimal into map with key being double and maps to index, print results

        out.close();
    }
}
