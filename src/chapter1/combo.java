package chapter1;
/*
ID: alan.bi1
LANG: JAVA
TASK: combo
*/

import java.io.*;
import java.util.*;

public class combo {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("combo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        //Scanner f = new Scanner(System.in);

        int N = Integer.parseInt(f.readLine());

        StringTokenizer st = new StringTokenizer(f.readLine());

        int[] john = new int[3];
        int[] master = new int[3];

        john[0] = Integer.parseInt(st.nextToken());
        john[1] = Integer.parseInt(st.nextToken());
        john[2] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(f.readLine());

        master[0] = Integer.parseInt(st.nextToken());
        master[1] = Integer.parseInt(st.nextToken());
        master[2] = Integer.parseInt(st.nextToken());

        HashSet<String> s = new HashSet<String>();

        for (int i = john[0] - 2; i <= john[0] + 2; i++) {
            for (int j = john[1] - 2; j <= john[1] + 2; j++) {
                for (int k = john[2] - 2; k <= john[2] + 2; k++) {
                    s.add("" + (i + N) % N + (j + N) % N + (k + N) % N);
                }
            }
        }


        for (int i = master[0] - 2; i <= master[0] + 2; i++) {
            for (int j = master[1] - 2; j <= master[1] + 2; j++) {
                for (int k = master[2] - 2; k <= master[2] + 2; k++) {
                    s.add("" + (i + N) % N + (j + N) % N + (k + N) % N);
                }
            }
        }

        out.println(s.size());

        out.close();
    }
}
