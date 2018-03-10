package chapter1;
/*
ID: alan.bi1
LANG: JAVA
TASK: milk
*/

import java.io.*;
import java.util.*;

public class milk {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        //Scanner f = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(f.readLine());

        int milkNeeded = Integer.parseInt(st.nextToken());
        int cost = 0;

        int[][] farmers = new int[Integer.parseInt(st.nextToken())][2];

        for (int i = 0; i < farmers.length; i++) {
            st = new StringTokenizer(f.readLine());
            farmers[i][0] = Integer.parseInt(st.nextToken());
            farmers[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(farmers, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int k = 0;
        while (k < farmers.length) {
            if (milkNeeded > farmers[k][1]) {
                milkNeeded -= farmers[k][1];
                cost += farmers[k][0] * farmers[k][1];
            } else {
                cost += milkNeeded * farmers[k][0];
                break;
            }

            k++;
        }

        out.println(cost);


        out.close();
    }
}
