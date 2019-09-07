package Main_Package;

/*
 * This class processes the input until 
 * it encounters a semi-colon and then passes it onto the main program
 */

import java.io.*;

/**
 * @Harshit Gupta
 */
public class Input {

     /*public static void main(String args[])throws IOException
    {
        String s = input(); 
        System.out.println(s);
    }*/
    public static String input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        int flag = 0;
        do {
            if(flag == 0)
            {
             System.out.print("hsql>>");   
            }
            else
            {
                System.out.print("    >>");
            }
            s = s + " " + br.readLine();
            flag = 1;
        } while (!(s.endsWith(";")));
        s = s.replace(";", " ");
        s = s.trim();
        return s;
    }
}
