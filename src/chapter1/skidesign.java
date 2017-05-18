package chapter1;/*
ID: alan.bi1
LANG: JAVA
TASK: skidesign
*/
import java.io.*;
import java.util.*;

public class skidesign
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        //Scanner f = new Scanner(System.in);

        int N = Integer.parseInt(f.readLine());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
        {
            arr[i] = Integer.parseInt(f.readLine());
        }

        Arrays.sort(arr);

        int cost = 999999;

        if(arr[N - 1] - arr[0] <= 17)
        {
            out.println(0);
        }
        else
        {
            for (int i = arr[0]; i < arr[N - 1] - 17; i++)
            {
                cost = Math.min(cost, findCost(arr, arr[0] + i));
            }
            out.println(cost);
        }

        out.close();
    }

    public static int findCost(int[] arr, int min)
    {
        int cost = 0;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] < min)
            {
                cost += Math.pow(min - arr[i], 2);
            }
            else if(arr[i] > min + 17)
            {
                cost += Math.pow(arr[i] - (min + 17), 2);
            }
        }
        return cost;
    }
}

