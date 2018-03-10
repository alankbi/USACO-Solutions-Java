package chapter2;
/*
ID: alan.bi1
LANG: JAVA
TASK: preface
*/

import java.io.*;
import java.util.*;

public class preface {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("preface.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));

        int N = Integer.parseInt(f.readLine());

        int[][] nums = new int[N + 1][7];

        for (int i = 1; i <= Math.min(N, 10); i++) {
            if (i == 4) {
                nums[i][0] = 1;
                nums[i][1] = 1;
            } else if (i == 10) {
                nums[i][2] = 1;
            } else if (i == 9) {
                nums[i][0] = 1;
                nums[i][2] = 1;
            } else if (i >= 5) {
                nums[i][0] = i - 5;
                nums[i][1] = 1;
            } else {
                nums[i][0] = i;
            }
        }


        for (int i = 11; i <= N; i++) {
            addLetters(i, nums);
        }

        int[] total = new int[7];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 7; j++) {
                total[j] += nums[i][j];
            }
        }

        if (total[0] != 0)
            out.println("I " + total[0]);
        if (total[1] != 0)
            out.println("V " + total[1]);
        if (total[2] != 0)
            out.println("X " + total[2]);
        if (total[3] != 0)
            out.println("L " + total[3]);
        if (total[4] != 0)
            out.println("C " + total[4]);
        if (total[5] != 0)
            out.println("D " + total[5]);
        if (total[6] != 0)
            out.println("M " + total[6]);

        out.close();
    }

    public static void addLetters(int num, int[][] nums) {
        int len = Integer.toString(num).length();

        int firstDigit = num / (int) Math.pow(10, len - 1);
        int temp = num % (int) Math.pow(10, len - 1);

        for (int i = 0; i < 7; i++) {
            nums[num][i] = nums[temp][i];
        }

        if (firstDigit == 4) {
            nums[num][(len - 1) * 2] += 1;
            nums[num][-1 + len * 2] += 1;
        } else if (firstDigit == 9) {
            nums[num][(len - 1) * 2] += 1;
            nums[num][len * 2] += 1;
        } else if (firstDigit >= 5) {
            nums[num][(len - 1) * 2] += firstDigit - 5;
            nums[num][-1 + len * 2] += 1;
        } else {
            nums[num][(len - 1) * 2] += firstDigit;
        }

    }
}
