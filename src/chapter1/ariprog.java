package chapter1;/*
ID: alan.bi1
LANG: JAVA
TASK: ariprog
*/
import java.io.*;
import java.util.*;

public class ariprog
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));


        int N = Integer.parseInt(f.readLine());
        int M = Integer.parseInt(f.readLine());


        int[] arr = new int[(M + 1) * (M + 2) / 2];
        boolean[] contains = new boolean[125001];
        //HashSet<Integer> hs = new HashSet<Integer>();
        int x = 0;

        for(int i = 0; i <= M; i++)
        {
            for(int j = i; j <= M; j++)
            {
                arr[x++] = i * i + j * j;
                contains[i * i + j * j] = true;
                //hs.add(i * i + j * j);
            }
        }
        Arrays.sort(arr);

        /*for(int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i - 1])
            {
                arr[i] = arr[arr.length - 1];
            }
        }*/

        boolean one = false;
        int lastA = -1;
        int lastB = -1;
        for(int b = 1; b <= arr[arr.length - 1] / (N - 1); b++)
        {//System.out.println(b);
            for(int j = 0; arr[j] + b * (N - 1)  <= arr[arr.length - 1]; j++)
            {//System.out.println(arr[j]);
                int a = arr[j];
                int count = 0;
                int index = j + 1;

                /*while(count < N - 1 && index < arr.length)
                {
                    if(arr[index] == a + b)
                    {
                        count++;
                        a = arr[index];
                    }
                    else if(arr[index] > a + b)
                    {
                        break;
                    }
                    index++;
                }*/
                boolean good = true;
                for(int k = 0; k < N; k++)
                {
                    if(!contains[a + b * k])
                    {
                        good = false;
                        break;
                    }
                }


                if(/*count >= N - 1*/good && !(arr[j] == lastA && b == lastB))
                {
                    out.println(arr[j] + " " + b);
                    lastA = arr[j];
                    lastB = b;
                    one = true;
                }
            }
        }
        if(!one)
        {
            out.println("NONE");
        }


        out.close();
    }

}
