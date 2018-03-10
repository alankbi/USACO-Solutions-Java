package chapter1;
/*
ID: alan.bi1
LANG: JAVA
TASK: transform
*/

import java.io.*;
import java.util.*;

public class transform {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        //Scanner f = new Scanner(System.in);

        int N = Integer.parseInt(f.readLine());

        char[][] start = new char[N][N];
        char[][] end = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = f.readLine();
            for (int j = 0; j < N; j++) {
                start[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            String s = f.readLine();
            for (int j = 0; j < N; j++) {
                end[i][j] = s.charAt(j);
            }
        }

        //#6
        boolean number6 = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (start[i][j] != end[i][j]) {
                    number6 = false;
                    break;
                }
                if (!number6) {
                    break;
                }
            }
        }


        int first3 = rotated(start, end);
        int fouror5 = number45(start, end);

        if (first3 != -1) {
            out.println(first3);
        } else if (fouror5 != -1) {
            out.println(fouror5);
        } else if (number6) {
            out.println(6);
        } else {
            out.println(7);
        }

        out.close();
    }

    public static int number45(char[][] start, char[][] end) {
        for (int i = 0; i < start.length; i++) {
            for (int j = 0; j < start.length / 2; j++) {
                char temp = start[i][j];
                start[i][j] = start[i][start.length - 1 - j];
                start[i][start.length - 1 - j] = temp;
            }
        }

        boolean equal = true;
        for (int i = 0; i < start.length; i++) {
            for (int j = 0; j < start.length; j++) {
                if (start[i][j] != end[i][j]) {
                    equal = false;
                    break;
                }
                if (!equal) {
                    break;
                }
            }
        }
        if (equal) {
            return 4;
        } else if (rotated(start, end) != -1) {
            return 5;
        } else {
            return -1;
        }


    }

    public static int rotated(char[][] start, char[][] end) {
        boolean equal = true;
        for (int i = 0; i < start.length; i++) {
            for (int j = 0; j < start.length; j++) {
                if (start[start.length - 1 - j][i] != end[i][j]) {
                    equal = false;
                    break;
                }
            }
            if (!equal) {
                break;
            }
        }
        if (equal) {
            return 1;
        }

        equal = true;

        for (int i = 0; i < start.length; i++) {
            for (int j = 0; j < start.length; j++) {
                if (start[start.length - 1 - i][start.length - 1 - j] != end[i][j]) {
                    equal = false;
                    break;
                }
            }
            if (!equal) {
                break;
            }
        }
        if (equal) {
            return 2;
        }

        equal = true;

        for (int i = 0; i < start.length; i++) {
            for (int j = 0; j < start.length; j++) {
                if (start[j][start.length - 1 - i] != end[i][j]) {
                    equal = false;
                    break;
                }
            }
            if (!equal) {
                break;
            }
        }
        if (equal) {
            return 3;
        }

        return -1;
    }

}
