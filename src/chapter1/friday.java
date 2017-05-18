package chapter1;/*
ID: alan.bi1
LANG: JAVA
TASK: friday
*/
import java.io.*;
//import java.util.*;

public class friday {

    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

        int[] count = new int[7];

        int day = 0;

        int N = Integer.parseInt(f.readLine());

        for(int year = 1900; year < N + 1900; year++)
        {
            for(int month = 1; month <= 12; month++)
            {
                count[day]++;
                if(month == 2)
                {
                    if(year % 400 == 0 || year % 4 == 0 && year % 100 != 0)
                    {
                        day = (day + 29) % 7;
                    }
                    else
                    {
                        day = (day + 28) % 7;
                    }
                }
                else if(month == 4 || month == 6 || month == 9 || month == 11)
                {
                    day = (day + 30) % 7;
                }
                else
                {
                    day = (day + 31) % 7;
                }


            }
        }
        for(int i = 0; i < count.length - 1; i++) {
            out.print(count[i] + " ");
        }
        out.println(count[6]);

        out.close();
    }
}
