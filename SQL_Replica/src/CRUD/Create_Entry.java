/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.io.*;
import Table.*;
import Miscellaneous.*;

public class Create_Entry {

    String query1, database, table, s;
    int i, j, width = 20;

    public Create_Entry(String database_name, String table_name, String query, String newentry) {
        s = newentry;
        query1 = query;
        database = database_name;
        table = table_name;
    }

    public void insertion() throws IOException {
        int flag;
        int g1 = Check_Table.check(database, table);//Proportional to number of tables something like c1
        if (g1 == 1) {
            Check_Int a = new Check_Int();
            int l = a.checks(database, table, s);//Proportional to the number of columns in the table something like c2
            if (l != 1) {
                Check_Uniqueness f = new Check_Uniqueness();
                flag = f.check_unique(s, database, table);
                if (flag == 1) {
                    System.out.println("Primary key should be unique");
                } else {
                    String str[] = new String[50];
                    String str1[] = new String[50];
                    String str2[] = new String[50];
                    String str3[] = new String[50];
                    String filename = "E:/Database/" + database + "/" + table + ".qsv";
                    //str = s.split(":");//splitting the new entry
                    str1 = query1.split(" ");//splitting the query
                    //System.out.println(str1[3]);
                    //System.out.println(str1[5]);
                    FileReader reader = new FileReader(filename);
                    BufferedReader br = new BufferedReader(reader);
                    BufferedWriter bw = null;
                    String line1;
                    line1 = br.readLine();
                    str3 = line1.split(":");//splits the column names from the database
                    String data[] = new String[100];
                    for (i = 0; i < str3.length; i++) {
                        data[i] = "NULL";
                    }
                    try {
                        if (str1[3].equals("values")) {
                            str2 = str1[5].split(",");
                            if (str2.length != (str3.length - 1)) {
                                System.out.println("Column count does not match.\n");
                            } else {
                                bw = new BufferedWriter(new FileWriter(filename, true));

                                bw.write(":");
                                for (i = 0; i < str2.length; i++) {
                                    bw.write(str2[i]);
                                    bw.write(":");
                                }
                                bw.newLine();
                                bw.flush();
                                System.out.println("Query OK 1 row Affected");
                            }
                        } else {
                            str1[3] = str1[3].replace("(", "");
                            str1[3] = str1[3].replace(")", "");
                            String column_names[] = new String[100];
                            column_names = str1[3].split(",");
                            //System.out.println(str1[3]);
                            str1[5] = str1[5].replace("(", "");
                            str1[5] = str1[5].replace(")", "");
                            String column_values[] = new String[100];
                            column_values = str1[5].split(",");
                            //System.out.println(str1[5]);
                            for (i = 0; i < str3.length; i++) {
                                for (j = 0; j < column_names.length; j++) {
                                    if (str3[i].equals(column_names[j])) {
                                        data[i] = column_values[j];
                                    }
                                }
                            }
                            String stg = ":";
                            for (i = 1; i < str3.length; i++) {
                                stg = stg + data[i] + ":";
                            }
                            //System.out.println(stg);
                            bw = new BufferedWriter(new FileWriter(filename, true));

                            bw.write(stg);
                            bw.newLine();
                            bw.flush();
                            System.out.println("Query OK 1 row Affected");
                        }

                    } catch (IOException|ArrayIndexOutOfBoundsException e) {
                        System.out.println("Syntax Error");
                    } finally {
                        if (bw != null) {
                            bw.flush();
                            bw.close();
                        }
                    }

                }
            } else {
                System.out.println("Required Int found String.");
            }
        } else {
            System.out.println("No such table is present.");
        }
    }
}
