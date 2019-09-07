/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import java.io.*;

public class Drop_Table {

    /*public static void main(String args[])throws IOException
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter the query:");
String query = br.readLine();
String str[] = new String[10];
str = query.split(" ");
String s = System.getProperty("user.dir") + "/student/" + str[1] + ".qsv";
System.out.println(s);
drop_table a = new drop_table(s);
System.out.println("Query OK table deleted.");
}*/
   public Drop_Table(String database, String table) {
        String s = "E:/Database/" + database + "/" + table + ".qsv";
        File file = new File(s);
        if (file.exists()) {
            do {
                System.gc();
                file.delete();
            } while (file.exists());
        } else {
            System.out.println("Table not found : " + table);
        }

    }
}
