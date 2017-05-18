package chapter1;/*
ID: alan.bi1
LANG: JAVA
TASK: numtri
*/
import java.io.*;
import java.util.*;

public class numtri
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));

        int N = Integer.parseInt(f.readLine());

        StringTokenizer st;

        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j <= i; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = N - 1; i > 0; i--)
        {
            for(int j = 0; j < i; j++)
            {
                arr[i - 1][j] += Math.max(arr[i][j], arr[i][j + 1]);
            }
        }

        out.println(arr[0][0]);

        out.close();
    }
}
