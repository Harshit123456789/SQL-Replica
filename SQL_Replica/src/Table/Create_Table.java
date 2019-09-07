/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import java.io.*;

public class Create_Table {

    String database;

    public Create_Table(String database_name) {
        database = database_name;
    }

    public void tables(String s) throws IOException {
        String s1;
        int width = 20, i, j;
        String str[] = new String[100];
        String columns[] = new String[100];
        String typelist[] = new String[100];
        String nullable[] = new String[100];
        String primary_key[] = new String[100];
        String s2[] = new String[100];

        BufferedWriter bw = null;

        str = s.split(" ");
        s1 = "E:/Database/" + database + "/" + str[2] + ".qsv";
        try {

            File file = new File(s1);

            if (file.createNewFile()) {
                bw = new BufferedWriter(new FileWriter(s1, true));
                s2 = str[4].split(">");

                columns = s2[0].split(":");
                bw.write(":");
                for (i = 0; i < columns.length; i++) {
                    bw.write(columns[i]);
                    bw.write(":");
                }
                bw.newLine();
                bw.flush();

                typelist = s2[1].split(":");
                bw.write(":");
                for (i = 0; i < typelist.length; i++) {
                    bw.write(typelist[i]);
                    bw.write(":");
                }
                bw.newLine();
                bw.flush();

                nullable = s2[2].split(":");
                bw.write(":");
                for (i = 0; i < nullable.length; i++) {
                    bw.write(nullable[i]);
                    bw.write(":");
                }
                bw.newLine();
                bw.flush();

                primary_key = s2[3].split(":");
                bw.write(":");
                for (i = 0; i < primary_key.length; i++) {
                    bw.write(primary_key[i]);
                    bw.write(":");
                }
                    bw.newLine();
                    bw.flush();

                    bw.flush();
                    bw.close();
                    System.out.println("Table Created");
                    System.out.println("Query OK 1 row Affected");
                
            } else {
                System.out.println("Table Not Created");
            }

        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Syntax Error"); 
        }

    }
}
