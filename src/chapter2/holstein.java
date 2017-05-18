package chapter2;
/*
ID: alan.bi1
LANG: JAVA
TASK: holstein
*/
import java.io.*;
import java.util.*;

public class holstein
{
    public static int[][] feeds;
    public static int V, G;
    public static int[] req;
    public static boolean[] bestFeeds;

    public static int maxnoOfFeeds, maxTotalFeeds;

    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));

        V = Integer.parseInt(f.readLine());

        StringTokenizer st = new StringTokenizer(f.readLine());

        req = new int[V];

        for(int i = 0; i < V; i++)
        {
            req[i] = Integer.parseInt(st.nextToken());
        }

        G = Integer.parseInt(f.readLine());
        feeds = new int[G][V];

        for(int i = 0; i < G; i++)
        {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < V; j++)
            {
                feeds[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bestFeeds = new boolean[G];
        for(int i = 0; i < G; i++) { bestFeeds[i] = true; }
        maxnoOfFeeds = G;
        maxTotalFeeds = 999;

        recurse(new int[V], new boolean[G], 0);

        out.print(maxnoOfFeeds + " ");

        int temp = 0;
        for(int i = 0; i < G; i++)
        {
            if(bestFeeds[i])
            {
                out.print(i + 1);
                temp++;
                if(temp < maxnoOfFeeds)
                {
                    out.print(" ");
                }
            }
        }
        out.println();

        out.close();
    }

    public static void recurse(int[] total, boolean[] allIndex, int index)
    {
        if(index >= G)
        {
            for(int i = 0; i < V; i++)
            {
                if(total[i] < req[i])
                {
                    return;
                }
            }
            int noOfFeeds = 0;
            int totalFeeds = 0;

            for(int i = 0; i < G; i++)
            {
                if(allIndex[i])
                {
                    noOfFeeds++;
                    totalFeeds += i;
                }
            }

            if(noOfFeeds < maxnoOfFeeds || noOfFeeds == maxnoOfFeeds && totalFeeds <= maxTotalFeeds)
            {
                for(int i = 0; i < G; i++)
                {
                    bestFeeds[i] = allIndex[i];
                }
                maxnoOfFeeds = noOfFeeds;
                maxTotalFeeds = totalFeeds;
            }
        }
        else
        {
            recurse(total, allIndex, index + 1);

            for (int i = 0; i < V; i++)
            {
                total[i] += feeds[index][i];
            }
            allIndex[index] = true;
            recurse(total, allIndex, index + 1);

            for (int i = 0; i < V; i++)
            {
                total[i] -= feeds[index][i];
            }
            allIndex[index] = false;
        }
    }
}
