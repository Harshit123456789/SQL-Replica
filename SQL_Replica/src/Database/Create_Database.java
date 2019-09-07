/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.*;

public class Create_Database {

    String s;

    public Create_Database(String name) {
        s = "E:/Database/"+name;
    }

    public void creation_database() throws IOException {
        File file = new File(s);
        if (!file.exists()) {
            file.mkdir();
            System.out.println("Query OK 1 row Affected.");
        } else {
            System.out.println("Database with this name already present.");
        }
    }
}
