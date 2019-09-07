/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.File;

/**
 *
 * @author HP
 */
public class Check_Database {

  public  static int check_data(String database) {
        int flag = 0;
        String s = "E:/Database";
        File folder = new File(s);
        File[] listofFiles = folder.listFiles();
        for (int i = 0; i < listofFiles.length; i++) {
            if ((listofFiles[i].getName()).equals(database)) {
                flag = 1;
            }
        }
        return flag;
    }
}
