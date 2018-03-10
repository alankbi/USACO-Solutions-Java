package chapter1;
/*
ID: alan.bi1
LANG: JAVA
TASK: barn1
*/

import java.io.*;
import java.util.*;

public class barn1 {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        //Scanner f = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(f.readLine());

        int noOfBoards = Integer.parseInt(st.nextToken());
        boolean[] stalls = new boolean[Integer.parseInt(st.nextToken())];


        int min = 200, max = 0;
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(f.readLine());
            min = Math.min(min, index);
            max = Math.max(max, index);

            stalls[index - 1] = true;
        }

        PriorityQueue<Integer> pq = findMax(stalls, min, max);

        int total = max - min + 1;

        for (int i = 0; i < noOfBoards - 1; i++) {
            Integer num = pq.poll();

            if (num != null) {
                total -= num;
            }
        }

        out.println(total);


        out.close();
    }

    public static PriorityQueue<Integer> findMax(boolean[] stalls, int minIndex, int maxIndex) {
        int temp = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(20, Collections.<Integer>reverseOrder());

        for (int i = minIndex; i < maxIndex; i++) {
            if (stalls[i] && temp > 0) {
                pq.add(temp);
                temp = 0;
            } else if (!stalls[i]) {
                temp++;
            }
        }

        return pq;
    }
}
