/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.*;

public class Drop_Database {

    /*public static void main(String args[])throws IOException
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter the query:");
String query = br.readLine();
String str[] = new String[10];
str = query.split(" ");
String s = System.getProperty("user.dir") + "/" + str[1];
//System.out.println(s);
drop_database a = new drop_database(s);
System.out.println("Query OK database deleted.");
}*/
  public  Drop_Database(String database) {
        String s =  "E:/Database/" + database;
        File file = new File(s);
        if (file.exists()) {
            do {
                delete(file);
            } while (file.exists());
        } else {
            System.out.println("Database not found : " + database);
        }

    }

    private void delete(File file) {
        if (file.isDirectory()) {
            String fileList[] = file.list();
            if (fileList.length == 0) {
                file.delete();
            } else {
                int size = fileList.length;
                for (int i = 0; i < size; i++) {
                    String fileName = fileList[i];
                    String fullPath = file.getPath() + "/" + fileName;
                    File fileOrFolder = new File(fullPath);
                    delete(fileOrFolder);
                }
            }
        } else {
            System.gc();
            file.delete();
        }
    }
}
