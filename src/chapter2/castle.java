package chapter2;
/*
ID: alan.bi1
LANG: JAVA
TASK: castle
*/
import java.io.*;
import java.util.*;

public class castle
{
    public static int C, R;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("castle.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][][] castle = new int[R][C][2];

        for(int i = 0; i < R; i++)
        {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < C; j++)
            {
                castle[i][j][0] = Integer.parseInt(st.nextToken());
                castle[i][j][1] = -1;
            }
        }

        List<Integer> components = findComponents(castle);

        out.println(components.size());

        int max = 0;
        for(int i = 0; i < components.size(); i++)
        {
            max = Math.max(max, components.get(i));
        }
        out.println(max);

        /*for(int i = 0; i < R; i++)
        {
            for(int j = 0; j < C; j++)
            {
                System.out.print(castle[i][j][1] + " ");
            }
            System.out.println();
        }*/

        removeWallLargest(castle, components);


        //Find all components using Queue while not empty, at end, do for loop to check if still any unassigned
        //Go through list of components, max size
        //Go through combinations of largest - next largest, for each, check if there's a wall that can be removed
        //Check for walls from left bottom to get the N E thing right

        out.close();
    }

    public static List<Integer> findComponents(int[][][] castle)
    {
        Queue<Integer> q = new ArrayDeque<Integer>();
        List<Integer> components = new ArrayList<Integer>();

        q.add(0);
        components.add(0);

        boolean done = false;
        while(!done)
        {
            while(!q.isEmpty())
            {
                int room = q.remove();
                int i = room / C;
                int j = room % C;
                int compIndex = components.size() - 1;

                castle[i][j][1] = compIndex;
                components.set(compIndex, components.get(compIndex) + 1);


                int walls = castle[i][j][0];
                if(j > 0 && walls % 2 != 1 && castle[i][j - 1][1] == -1) {
                    if(!q.contains(i * C + j - 1)) {
                        q.add(i * C + j - 1);
                    }
                }
                if(i > 0 && walls % 4 < 2 && castle[i - 1][j][1] == -1) {
                    if(!q.contains((i - 1) * C + j)) {
                        q.add((i - 1) * C + j);
                    }
                }
                if(j < C - 1 && walls % 8 < 4 && castle[i][j + 1][1] == -1) {
                    if(!q.contains(i * C + j + 1)) {
                        q.add(i * C + j + 1);
                    }
                }
                if(i < R - 1 && walls / 8 != 1 && castle[i + 1][j][1] == -1) {
                    if(!q.contains((i + 1) * C + j)) {
                        q.add((i + 1) * C + j);
                    }
                }
            }

            boolean finished = true;
            for(int i = 0; i < R; i++)
            {
                for(int j = 0; j < C; j++)
                {
                    if(castle[i][j][1] == -1)
                    {
                        q.add(i * C + j);
                        components.add(0);
                        finished = false;
                        break;
                    }
                }
                if(!finished)
                {
                    break;
                }
            }

            if(finished)
            {
                break;
            }
        }

        return components;
    }

    public static void removeWallLargest(int[][][] castle, List<Integer> components)
    {
        int indexR = -1;
        int indexC = -1;
        String dir = "";
        int max = 0;

        for(int j = 0; j < C; j++)
        {
            for(int i = R - 1; i >= 0; i--)
            {
                int walls = castle[i][j][0];
                if(i > 0 && walls % 4 >= 2 && castle[i - 1][j][1] != castle[i][j][1])
                {
                    int num = components.get(castle[i - 1][j][1]) + components.get(castle[i][j][1]);
                    if(num > max)
                    {
                        max = num;
                        indexR = i + 1;
                        indexC = j + 1;
                        dir = "N";
                    }
                }
                if(j < C - 1 && walls % 8 >= 4 && castle[i][j + 1][1] != castle[i][j][1])
                {
                    int num = components.get(castle[i][j + 1][1]) + components.get(castle[i][j][1]);
                    if(num > max)
                    {
                        max = num;
                        indexR = i + 1;
                        indexC = j + 1;
                        dir = "E";
                    }
                }
            }
        }

        if(indexR != -1)
        {
            out.println(max);
            out.println(indexR + " " + indexC + " " + dir);
        }
    }
}
