package chapter1;/*
ID: alan.bi1
LANG: JAVA
TASK: namenum
*/
import java.io.*;
import java.util.*;

public class namenum
{

    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("dict.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        Scanner sc = new Scanner(new File("dict.txt"));

        String[] names = new String[5000];
        int count = 0;


        while(sc.hasNext())
        {
            names[count++] = sc.nextLine();
        }


        //f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));

        String num = f.readLine();
        boolean oneName = false;

        for(int i = 0; i < count; i++)
        {
            boolean valid = true;

            for(int j = 0; j < num.length(); j++)
            {
                if(names[i].length() != num.length())
                {
                    valid = false;
                    break;
                }

                char c = names[i].charAt(j);
                int digit = Character.getNumericValue(num.charAt(j));

                if(c != getChar(digit, 1) && c != getChar(digit, 2) && c != getChar(digit, 3))
                {
                    valid = false;
                    break;
                }
            }
            if(valid)
            {
                oneName = true;
                out.println(names[i]);
            }

        }

        if(!oneName)
        {
            out.println("NONE");
        }

        out.close();
    }

    /*public static void find(int[] arr, int digit, StringBuilder str)
    {
        if(digit == arr.length && names.contains(str.toString()))
        {
            System.out.println(str);
        }
        else if(digit < arr.length)
        {
            find(arr, digit + 1, str.append(getChar(arr[digit], 1)));
            find(arr, digit + 1, str.append(getChar(arr[digit], 2)));
            find(arr, digit + 1, str.append(getChar(arr[digit], 3)));
        }
    }*/

    public static char getChar(int num, int level)
    {
        char letter;

        if(level == 1) {
            switch (num) {
                case 2: letter = 'A';
                break;
                case 3: letter = 'D';
                break;
                case 4: letter = 'G';
                break;
                case 5: letter = 'J';
                break;
                case 6: letter = 'M';
                break;
                case 7: letter = 'P';
                break;
                case 8: letter = 'T';
                break;
                case 9: letter = 'W';
                break;
                default: letter = 'a';
                break;
            }
        }
        else if(level == 2) {
            switch (num) {
                case 2: letter = 'B';
                    break;
                case 3: letter = 'E';
                    break;
                case 4: letter = 'H';
                    break;
                case 5: letter = 'K';
                    break;
                case 6: letter = 'N';
                    break;
                case 7: letter = 'R';
                    break;
                case 8: letter = 'U';
                    break;
                case 9: letter = 'X';
                    break;
                default: letter = 'a';
                    break;
            }
        }
        else {
            switch (num) {
                case 2: letter = 'C';
                    break;
                case 3: letter = 'F';
                    break;
                case 4: letter = 'I';
                    break;
                case 5: letter = 'L';
                    break;
                case 6: letter = 'O';
                    break;
                case 7: letter = 'S';
                    break;
                case 8: letter = 'V';
                    break;
                case 9: letter = 'Y';
                    break;
                default: letter = 'a';
                    break;
            }
        }


        return letter;
    }
}
