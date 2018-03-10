package chapter1;
/*
ID: alan.bi1
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

public class milk2 {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        //Scanner f = new Scanner(System.in);
        StringTokenizer st;// = new StringTokenizer(f.readLine());

        List<Integer> starts = new ArrayList<Integer>();
        List<Integer> ends = new ArrayList<Integer>();

        int N = Integer.parseInt(f.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            boolean hit = false;

            for (int j = 0; j < starts.size(); j++) {
                if (startTime >= starts.get(j) && startTime <= ends.get(j)) {
                    ends.set(j, Math.max(ends.get(j), endTime));
                    hit = true;
                    break;
                } else if (endTime >= starts.get(j) && endTime <= ends.get(j)) {
                    starts.set(j, Math.min(starts.get(j), startTime));
                    hit = true;
                    break;
                } else if (startTime <= starts.get(j) && endTime >= ends.get(j)) {
                    starts.set(j, startTime);
                    ends.set(j, endTime);
                    hit = true;
                    break;
                }
            }

            if (!hit) {
                starts.add(startTime);
                ends.add(endTime);
            }
        }

        for (int i = 0; i < starts.size(); i++) {
            for (int j = 0; j < starts.size(); j++) {
                if (i != j && starts.get(j) >= starts.get(i) && starts.get(j) <= ends.get(i)) {
                    ends.set(i, Math.max(ends.get(i), ends.get(j)));
                    starts.remove(j);
                    ends.remove(j);
                    j--;
                    if (i > 0) {
                        i--;
                    }
                } else if (i != j && ends.get(j) <= ends.get(i) && ends.get(j) >= starts.get(i)) {
                    starts.set(i, Math.min(starts.get(i), starts.get(j)));
                    starts.remove(j);
                    ends.remove(j);
                    j--;
                    if (i > 0) {
                        i--;
                    }
                } else if (i != j && ends.get(j) >= ends.get(i) && starts.get(j) <= starts.get(i)) {
                    starts.set(i, starts.get(j));
                    ends.set(i, ends.get(j));
                    starts.remove(j);
                    ends.remove(j);
                    j--;
                    if (i > 0) i--;
                    //System.out.println("hit");
                }
            }
        }


        int maxMilked = 0;
        int maxNot = 0;
        for (int i = 0; i < starts.size(); i++) {
            maxMilked = Math.max(maxMilked, ends.get(i) - starts.get(i));
        }
        for (int i = 0; i < ends.size(); i++) {
            for (int k = 0; k < ends.size(); k++) {
                boolean valid = true;
                int dist = starts.get(i) - ends.get(k);
                if (k == i) {
                    //break;
                }

                for (int j = 0; j < starts.size(); j++) {
                    if (starts.get(j) > ends.get(k) && starts.get(j) < starts.get(i)) {
                        valid = false;
                        break;
                    } else if (ends.get(j) > ends.get(k) && ends.get(j) < starts.get(i)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    maxNot = Math.max(maxNot, dist);
                }
            }
        }
        out.println(maxMilked + " " + maxNot);

        out.close();
    }
}
