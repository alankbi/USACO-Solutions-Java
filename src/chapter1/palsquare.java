package chapter1;/*
ID: alan.bi1
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import java.util.*;

public class palsquare
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        //Scanner f = new Scanner(System.in);

        int B = Integer.parseInt(f.readLine());

        for(int i = 1; i <= 300; i++)
        {
            if(isPal(Integer.toString(i * i, B)))
            {
                out.println((Integer.toString(i, B).toUpperCase()) + " " + (Integer.toString(i * i, B)).toUpperCase());
            }

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
