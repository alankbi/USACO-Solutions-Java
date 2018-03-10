package chapter1;
/*
ID: alan.bi1
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.*;

public class beads {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        //Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        int N = Integer.parseInt(f.readLine());

        String bead = f.readLine();

        int max = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            char current = bead.charAt(i);
            boolean hitOther = false;
            boolean notWhite = true;
            if (current == 'w') {
                notWhite = false;
            }

            for (int j = i; j < i + N; j++) {
                if (!notWhite && bead.charAt(j % N) != 'w') {
                    current = bead.charAt(j % N);
                    notWhite = true;
                } else if (hitOther && bead.charAt(j % N) == current) {
                    //count++;
                    break;
                } else if (bead.charAt(j % N) != current && bead.charAt(j % N) != 'w') {
                    hitOther = true;
                }
                count++;
            }
            max = Math.max(max, count);
            count = 0;

        }
        out.println(max);
        out.close();
    }
}
