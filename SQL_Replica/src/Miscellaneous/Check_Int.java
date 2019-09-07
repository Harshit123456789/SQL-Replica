/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Miscellaneous;

import java.io.*;

public class Check_Int {

    /*public static void main(String args[])throws IOException
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter the query:");
String query = br.readLine();
String st[] = new String[100];
st = query.split(" ");
check_Int a = new check_Int();
a.checks("Narula","CSE",st[3]);
}*/
  public int checks(String database, String table, String entry) throws IOException {
        int ind[], i, number, k, flag = 1;
        ind = new int[10];
        String s = "E:/Database/" + database;
        s = s + "/" + table + ".qsv";
        FileReader reader = new FileReader(s);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line, line1, line2, line3, line4;
        line1 = bufferedReader.readLine();
        line2 = bufferedReader.readLine();
        line3 = bufferedReader.readLine();
        line4 = bufferedReader.readLine();
        String str[] = new String[100];
        String str1[] = new String[100];
        str1 = entry.split(",");
        str = line2.split(":");
        k = 0;
        for (i = 0; i < str.length; i++) {//Proportional to the number of columns of the table:-constnt
            if (str[i].equals("Int")) {
                ind[k++] = i;
            }
        }
        for (i = 0; i < k; i++) {
            //System.out.println(ind[i] + "\n" + "__________________");
            //System.out.println(str1[ind[i]-1]);
            try {
                int n = Integer.parseInt(str1[ind[i] - 1]);
            } catch (java.lang.NumberFormatException e) {
                //System.out.println("Required Int found String.");
                return 1;
            }
        }
        reader.close();
        bufferedReader.close();
        return 0;
    }
}
