/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author HP
 */
public class select {

    public static String select(String data[], String database, String table, String columns, int count) throws FileNotFoundException, IOException {
        int i, j, k;
        int index[] = new int[100];
        String abc1[] = new String[100];
        String fi = "E:/Database/" + database + "/" + table + ".qsv";
        //System.out.println(fi);
        FileReader reader = new FileReader(fi);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line,abc2 = null;
        line = bufferedReader.readLine();
        String column_names[] = new String[100];
        column_names = line.split(":");//columns in the database
        String col[] = new String[100];
        col = columns.split(",");//columns asked in the query
        k = 0;
        for (i = 0; i < col.length; i++) {
            for (j = 0; j < column_names.length; j++) {
                if (col[i].equals(column_names[j])) {
                    index[k++] = j;
                }
            }
        }
        abc2 = ":";
        for(i=0;i<col.length;i++)
        {
            abc2 = abc2 + col[i] + ":";
        }
        for (i = 0; i < count; i++) {
            abc1 = data[i].split(":");
            String abc = ":";
            for(j=0;j<index.length;j++)
            {
                abc = abc + abc1[index[j]] + ":";
            }
            data[i] = abc;
        }
        return abc2;
    }
}
