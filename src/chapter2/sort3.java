package chapter2;
/*
ID: alan.bi1
LANG: JAVA
TASK: sort3
*/

import java.io.*;
import java.util.*;

public class sort3 {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));

        int N = Integer.parseInt(f.readLine());
        int[] arr = new int[N];

        int ones = 0, twos = 0, threes = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(f.readLine());

            switch (arr[i]) {
                case 1:
                    ones++;
                    break;
                case 2:
                    twos++;
                    break;
                case 3:
                    threes++;
                    break;
            }
        }

        int twosInOne = 0;
        int threesInOne = 0;
        for (int i = 0; i < ones; i++) {
            if (arr[i] == 2) {
                twosInOne++;
            } else if (arr[i] == 3) {
                threesInOne++;
            }
        }
        int onesInTwo = 0;
        int threesInTwo = 0;
        for (int i = ones; i < ones + twos; i++) {
            if (arr[i] == 1) {
                onesInTwo++;
            } else if (arr[i] == 3) {
                threesInTwo++;
            }
        }

        int onesInThree = 0;
        int twosInThree = 0;
        for (int i = ones + twos; i < N; i++) {
            if (arr[i] == 1) {
                onesInThree++;
            } else if (arr[i] == 2) {
                twosInThree++;
            }
        }


        int temp = Math.min(onesInTwo, twosInOne);
        count += temp;

        int leftOver = Math.max(onesInTwo - temp, twosInOne - temp);

        count += Math.min(onesInThree, threesInOne);
        count += Math.min(twosInThree, threesInTwo);

        count += leftOver * 2;

        out.println(count);

        out.close();
    }
}
