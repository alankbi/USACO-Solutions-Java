package chapter1;
/*
ID: alan.bi1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

public class gift1 {

    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

        StringTokenizer st;

        Map<String, Integer> people = new LinkedHashMap<String, Integer>();

        int NP = Integer.parseInt(f.readLine());
        for (int i = 0; i < NP; i++) {
            people.put(f.readLine(), 0);
        }

        for (int i = 0; i < NP; i++) {
            String person = f.readLine();

            st = new StringTokenizer(f.readLine());

            int money = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            for (int j = 0; j < next; j++) {
                String name = f.readLine();
                people.put(name, people.get(name) + money / next);
            }
            if (next != 0) {
                people.put(person, people.get(person) - money + money % next);
            }
        }

        for (String s : people.keySet()) {
            out.println(s + " " + people.get(s));
        }

        out.close();
    }
}
