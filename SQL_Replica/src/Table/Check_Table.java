/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*

The complexity of this file is something like :-
Directly proportional to the number of tables present in the database or the umber of files in tha folder
*/
package Table;

import java.io.*;

public class Check_Table {

    /*public static void main(String args[])
{
int flag = check("harshit","sourav");
if(flag==1)
System.out.println("Table present.");
}*/
  public  static int check(String database, String table_name) {
        int flag = 0;
        String table = table_name + ".qsv";
        //System.out.println(s);
        String s =  "E:/Database/" + database;
        //System.out.println(s);
        File folder = new File(s);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if ((listOfFiles[i].getName()).equals(table)) {
                    flag = 1;
                }

            }
        }
        return flag;
    }
}
