package chapter2;
/*
ID: alan.bi1
LANG: JAVA
TASK: zerosum
*/

import java.io.*;
import java.util.*;

public class zerosum {
    public static int N;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("zerosum.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));

        N = Integer.parseInt(f.readLine());

        recurse("1", 2);

        out.close();
    }

    public static void recurse(String sequence, int digit) {
        if (digit > N) {
            checkSequence(sequence);
        } else {
            recurse(sequence + " " + digit, digit + 1);
            recurse(sequence + "+" + digit, digit + 1);
            recurse(sequence + "-" + digit, digit + 1);
        }
    }

    public static void checkSequence(String sequence) {
        int total = 0;
        int pow = 1;
        int temp = 0;

        for (int i = sequence.length() - 2; i > 0; i -= 2) {
            if (sequence.charAt(i) == '+') {
                total += Character.getNumericValue(sequence.charAt(i + 1)) * pow + temp;
                pow = 1;
                temp = 0;
            } else if (sequence.charAt(i) == '-') {
                total -= Character.getNumericValue(sequence.charAt(i + 1)) * pow + temp;
                pow = 1;
                temp = 0;
            } else {
                temp += Character.getNumericValue(sequence.charAt(i + 1)) * pow;
                pow *= 10;
            }
        }
        if (temp != 0) {
            total += pow + temp;
        } else {
            total += 1;
        }

        if (total == 0) {
            out.println(sequence);
        }
    }
}