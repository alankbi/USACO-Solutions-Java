package chapter1;
/*
ID: alan.bi1
LANG: JAVA
TASK: wormhole
*/

import java.io.*;
import java.util.*;

public class wormhole {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        //Scanner f = new Scanner(System.in);

        int N = Integer.parseInt(f.readLine());

        int[][] arr = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = -1;
        }


        out.println(solve(arr, 0, 0));

        out.close();
    }

    public static int solve(int[][] arr, int index, int count) {
        if (index >= arr.length) {
            count += isCycle(arr);
        } else if (arr[index][2] != -1) {
            count = solve(arr, index + 1, count);
        } else {
            for (int i = index + 1; i < arr.length; i++) {
                if (arr[i][2] == -1) {
                    //int[][] temp = copy(arr);
                    arr[index][2] = i;
                    arr[i][2] = index;
                    count = solve(arr, index + 1, count);
                    arr[index][2] = -1;
                    arr[i][2] = -1;
                }
            }
        }
        return count;
    }

    public static int isCycle(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            boolean broken = false;

            for (int j = 0; j < arr.length; j++) {
                boolean found = false;
                int smallest = 999999999;
                int index = -1;
                for (int k = 0; k < arr.length; k++) {
                    if (arr[k][1] == y && arr[k][0] > x) {
                        if (arr[k][0] - x < smallest) {
                            smallest = arr[k][0] - x;
                            index = k;
                        }
                        found = true;
                    }
                }
                if (!found) {
                    broken = true;
                    break;
                } else {
                    x = arr[arr[index][2]][0];
                    y = arr[arr[index][2]][1];
                }
            }
            if (!broken) {
                return 1;
            }
        }
        return 0;

    }

    public static int[][] copy(int[][] arr) {
        int temp[][] = new int[arr.length][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }
}