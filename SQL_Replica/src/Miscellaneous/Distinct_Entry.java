/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Miscellaneous;

import java.io.*;

public class Distinct_Entry {

    /*public static void main(String args[])throws IOException
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter the query:");
String s = br.readLine();
distinct a = new distinct();
a.display("harshit",s);
}*/
  public  static int delete_duplicate(String st[], int count) {
        String st1[] = new String[50];
        int i, j, k;
        for (i = 0; i < count; i++) {
            st1[i] = st[i];
        }
        for (i = 0; i < count; i++) {
            for (j = i; j < count; j++) {
                if (i != j) {
                    if (st1[j].equals(st[i])) {
                        st1[j] = " ";
                    }
                }
            }
        }
        k = 0;
        for (i = 0; i < count; i++) {
            if (!(st1[i].equals(" "))) {
                st[k++] = st1[i];
            }
        }
        return k;
    }

   public void display(String database, String query) {
        int i, index = 0, j;
        String str[] = new String[20];
        str = query.split(" ");
        String s = "E:/Database/" + database;
        s = s + "/" + str[4] + ".qsv";
        String column_name = str[2];
        try {
            String s1[] = new String[50];
            String s2[] = new String[50];
            String st[] = new String[50];
            int count = 0, width = 20, g;
            FileReader reader = new FileReader(s);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line, line1, line2, line3, line4;
            line1 = bufferedReader.readLine();
            s1 = line1.split(":");//splits the columns name from ths database text file
            line2 = bufferedReader.readLine();
            line3 = bufferedReader.readLine();
            line4 = bufferedReader.readLine();
            for (i = 0; i < s1.length; i++) {
                if (s1[i].equals(column_name)) {
                    index = i;
                }
            }

            while ((line = bufferedReader.readLine()) != null) {
                s2 = line.split(":");//splits the entry one by one
                st[count++] = s2[index];
            }
            int z = delete_duplicate(st, count);
            for (j = 0; j < (width - s1[index].length()); j++) {
                s1[index] = s1[index] + " ";
            }
            System.out.println(":" + s1[index] + ":");
            for (g = 0; g <= width + 2; g++) {
                System.out.print("-");
            }
            System.out.println();
            for (i = 0; i < z; i++) {
                System.out.print(":");
                for (j = 0; j < (width - st[i].length()); j++) {
                    st[i] = st[i] + " ";
                }
                System.out.println(st[i] + ":");
            }
            System.out.println("Query OK " + z + " rows Affected.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
