/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import java.io.*;

public class Show_Tables {

    /*public static void main(String args[])
{
listfiles a = new listfiles();
a.show_tables();
}*/
    String database;

    public Show_Tables(String database_name) {
        database = database_name;
    }

    public void show_tables() {
        String s =  "E:/Database/" + database;
        File folder = new File(s);
        File[] listOfFiles = folder.listFiles();
        System.out.println("List of tables:");
        for (int i = 0; i < listOfFiles.length; i++) {
            String name = listOfFiles[i].getName();
            name = name.replace(".qsv", "");
            System.out.println(name);
        }
    }
}
