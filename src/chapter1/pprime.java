package chapter1;
/*
ID: alan.bi1
LANG: JAVA
TASK: pprime
*/

import java.io.*;
import java.util.*;

public class pprime {
    public static int min;
    public static int max;

    public static int[] prime;
    public static int maxIndex;

    public static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());

        min = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());

        set = new TreeSet<Integer>();

        prime = new int[1500];
        prime[0] = 2;
        maxIndex = 1;
        boolean b = true;

        for (int i = 3; i < 10000; i++) {
            for (int j = 0; j < maxIndex; j++) {
                if (i % prime[j] == 0) {
                    b = false;
                    break;
                }
            }
            if (b) {
                prime[maxIndex++] = i;
            }
            b = true;
        }


        if (11 >= min && 11 <= max) {
            set.add(11);
        }

        for (int i = 0; i <= 9; i++) {
            findPal(i);
        }

        for (int i : set) {
            out.println(i);
        }

        out.close();
    }


    public static void findPal(int num) {
        if (num >= min && num <= max && isPrime(num)) {
            set.add(num);
        }
        if (num <= max && Integer.toString(num).length() + 2 <= Integer.toString(max).length()) {
            for (int i = 1; i <= 9; i++) {
                int temp = num;
                if (num == 0) {
                    num += i;
                    num += i * Math.pow(10, Integer.toString(num).length() + 1);
                } else {
                    num *= 10;
                    num += i;
                    num += i * Math.pow(10, Integer.toString(num).length());
                }

                findPal(num);
                num = temp;

                for (int j = 2; j <= Integer.toString(max).length() / 2; j++) {
                    if (num == 0) {
                        num += i;
                        num += i * Math.pow(10, j * 2);
                        findPal(num);
                        //System.out.println(num);
                        num = temp;
                    } else {
                        num *= Math.pow(10, j);
                        num += i;
                        num += i * Math.pow(10, Integer.toString(num).length() + j - 1);
                        findPal(num);
                        num = temp;
                    }
                }
            }
        }
    }

    public static boolean isPrime(int num) {
        for (int i = 0; i < maxIndex; i++) {
            if (prime[i] >= num) {
                break;
            }
            if (num % prime[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
