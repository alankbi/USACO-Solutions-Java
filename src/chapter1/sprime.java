package chapter1;
/*
ID: alan.bi1
LANG: JAVA
TASK: sprime
*/
import java.io.*;
import java.util.*;

public class sprime
{
    public static int[] prime;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));

        int N = Integer.parseInt(f.readLine());

        generatePrimes();

        superPrimes(2, N - 1);
        superPrimes(3, N - 1);
        superPrimes(5, N - 1);
        superPrimes(7, N - 1);


        out.close();
    }
    public static void superPrimes(int num, int level)
    {
        if(level == 0)
        {
            if(isPrime(num))
            {
                out.println(num);
            }
        }
        else if(isPrime(num))
        {
            for(int i = 1; i <= 9; i += 2)
            {
                superPrimes(num * 10 + i, level - 1);
            }
        }
    }

    public static boolean isPrime(int num)
    {
        for(int i = 0; i < prime.length; i++)
        {
            if(prime[i] * prime[i] > num)
            {
                return true;
            }
            if(num % prime[i] == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static void generatePrimes()
    {
        prime = new int[1229];
        prime[0] = 2;
        int maxIndex = 1;
        boolean b = true;

        for (int i = 3; i < 10000; i += 2)
        {
            for (int j = 0; j < maxIndex; j++)
            {
                if (i % prime[j] == 0)
                {
                    b = false;
                    break;
                }
            }
            if (b) {
                prime[maxIndex++] = i;
            }
            b = true;
        }
    }
}
