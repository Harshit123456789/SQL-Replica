/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.*;

public class Show_Databases {

    public void show_database() {
        String s = "E:/Database/";
        File folder = new File(s);
        File[] listofFiles = folder.listFiles();
        System.out.println("List of databases:");
        for (int i = 0; i < listofFiles.length; i++) {
            if (listofFiles[i].isDirectory()) {
                System.out.println(listofFiles[i].getName());
            }
        }
    }
}
