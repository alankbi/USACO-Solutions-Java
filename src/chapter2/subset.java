package chapter2;
/*
ID: alan.bi1
LANG: JAVA
TASK: subset
*/
import java.io.*;
import java.util.*;

public class subset
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("subset.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));

        int N = Integer.parseInt(f.readLine());


        if(N * (N + 1) / 2 % 2 != 0)
        {
            out.println(0);
            out.close();
            return;
        }

        long[][] arr = new long[N + 1][N * (N + 1) / 4 + 1];

        for(int i = 0; i <= N; i++)
        {
            arr[i][0] = 1;
        }

        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j <= N * (N + 1) / 4; j++)
            {
                arr[i][j] += arr[i - 1][j];
                if(j - i >= 0)
                {
                    arr[i][j] += arr[i - 1][j - i];
                }
            }
        }

        out.println(arr[N][N * (N + 1) / 4] / 2);

        out.close();
    }
}
