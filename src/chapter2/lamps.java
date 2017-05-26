package chapter2;

/*
ID: alan.bi1
LANG: JAVA
TASK: lamps
*/
import java.io.*;
import java.util.*;

public class lamps
{
    public static PrintWriter out;
    public static int[] lamps;
    public static List<Integer> on, off;

    public static Set<String> set;

    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("lamps.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));

        int N = Integer.parseInt(f.readLine());
        int C = Integer.parseInt(f.readLine());
        lamps = new int[N + 1];

        set = new TreeSet<String>();

        for(int i = 1; i <= N; i++) { lamps[i] = 1; }

        on = new ArrayList<Integer>();
        off = new ArrayList<Integer>();

        StringTokenizer st = new StringTokenizer(f.readLine());
        int num = Integer.parseInt(st.nextToken());
        while(num != -1)
        {
            on.add(num);
            num = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(f.readLine());
        num = Integer.parseInt(st.nextToken());
        while(num != -1)
        {
            off.add(num);
            num = Integer.parseInt(st.nextToken());
        }

        recurse(Math.min(4, C));

        for(String s : set)
        {
            out.println(s);
        }

        if(set.size() == 0)
        {
            out.println("IMPOSSIBLE");
        }

        out.close();
    }

    public static void recurse(int C)
    {
        if(C <= 0)
        {
            for(int i = 0; i < on.size(); i++)
            {
                if(lamps[on.get(i)] != 1)
                {
                    return;
                }
            }
            for(int i = 0; i < off.size(); i++)
            {
                if(lamps[off.get(i)] != 0)
                {
                    return;
                }
            }
            StringBuilder s = new StringBuilder();
            for(int i = 1; i < lamps.length; i++)
            {
                s.append(lamps[i]);
            }
            set.add(s.toString());
        }
        else
        {
            //Button 1
            for(int i = 1; i < lamps.length; i++)
            {
                if(lamps[i] == 1) {
                    lamps[i] = 0;
                } else {
                    lamps[i] = 1;
                }
            }
            recurse(C - 1);
            for(int i = 1; i < lamps.length; i++)
            {
                if(lamps[i] == 1) {
                    lamps[i] = 0;
                } else {
                    lamps[i] = 1;
                }
            }

            //Button 2
            for(int i = 1; i < lamps.length; i += 2)
            {
                if(lamps[i] == 1) {
                    lamps[i] = 0;
                } else {
                    lamps[i] = 1;
                }
            }
            recurse(C - 1);
            for(int i = 1; i < lamps.length; i += 2)
            {
                if(lamps[i] == 1) {
                    lamps[i] = 0;
                } else {
                    lamps[i] = 1;
                }
            }

            //Button 3
            for(int i = 2; i < lamps.length; i += 2)
            {
                if(lamps[i] == 1) {
                    lamps[i] = 0;
                } else {
                    lamps[i] = 1;
                }
            }
            recurse(C - 1);
            for(int i = 2; i < lamps.length; i += 2)
            {
                if(lamps[i] == 1) {
                    lamps[i] = 0;
                } else {
                    lamps[i] = 1;
                }
            }

            //Button 4
            for(int i = 1; i < lamps.length; i += 3)
            {
                if(lamps[i] == 1) {
                    lamps[i] = 0;
                } else {
                    lamps[i] = 1;
                }
            }
            recurse(C - 1);
            for(int i = 1; i < lamps.length; i += 3)
            {
                if(lamps[i] == 1) {
                    lamps[i] = 0;
                } else {
                    lamps[i] = 1;
                }
            }
        }
    }
}
