package chapter2;
/*
ID: alan.bi1
LANG: JAVA
TASK: nocows
*/

import java.io.*;
import java.util.*;

public class nocows {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("nocows.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] trees = new int[N + 1][K + 1];

        for (int i = 1; i <= K; i++) {
            trees[1][i] = 1;
        }

        for (int i = 3; i <= N; i += 2) {
            for (int j = 1; j <= K; j++) {
                for (int k = 1; k < i - 1; k += 2) {
                    trees[i][j] += trees[k][j - 1] * trees[i - k - 1][j - 1];
                    trees[i][j] %= 9901;
                }
            }
        }

        out.println((trees[N][K] - trees[N][K - 1] + 9901) % 9901);

        out.close();
    }
}
