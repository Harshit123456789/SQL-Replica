/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Miscellaneous;

import java.io.*;

public class Count_Rows {

   public void counts(String database, String table) {
        String s = "E:/Database/" + database;
        s = s + "/" + table + ".qsv";
        try {
            int count = 0;
            FileReader reader = new FileReader(s);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line, line1, line2, line3, line4;
            line1 = bufferedReader.readLine();
            line2 = bufferedReader.readLine();
            line3 = bufferedReader.readLine();
            line4 = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                count++;
            }
            System.out.println("Total number of rows:" + count);
            reader.close();
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
