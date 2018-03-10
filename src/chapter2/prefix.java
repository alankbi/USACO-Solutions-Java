package chapter2;
/*
ID: alan.bi1
LANG: JAVA
TASK: prefix
*/

import java.io.*;
import java.util.*;

public class prefix {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("prefix.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
        StringTokenizer st;

        List<String> prim = new ArrayList<String>();

        while (true) {
            st = new StringTokenizer(f.readLine());
            String temp = st.nextToken();

            if (temp.equals("."))
                break;

            prim.add(temp);

            while (st.hasMoreTokens()) {
                prim.add(st.nextToken());
            }
        }

        StringBuilder temp = new StringBuilder();
        String line;

        while ((line = f.readLine()) != null) {
            temp.append(line);
        }
        String str = temp.toString();

        boolean[] max = new boolean[str.length() + 1];
        max[0] = true;

        int maxLength = 0;

        for (int i = 0; i <= str.length(); i++) {
            for (int j = 0; j < prim.size(); j++) {
                int startIndex = i - prim.get(j).length();

                if (startIndex >= 0 && max[startIndex] && str.substring(startIndex, startIndex + prim.get(j).length()).equals(prim.get(j))) {
                    maxLength = i;
                    max[i] = true;
                    break;
                }
            }
        }

        out.println(maxLength);

        out.close();
    }
}
