/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import Table.Check_Table;
import java.io.*;

public class Update_Entry {

    String database, table;

    public Update_Entry(String database_name, String table_name) {
        database = database_name;
        table = table_name;
    }

    /*public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println("Enter the content:");
        //String sf = br.readLine();
        Update_Entry a = new Update_Entry("Narula", "CSE");
        a.updation("update CSE set Name=Benazir,Password=ECE where ID = 4");
    }*/
    public void updation(String s1) throws IOException {
        int g1 = Check_Table.check(database, table);//Proportional to number of tables something like c1
        if (g1 == 1) {
            String s3[] = new String[100];
            s3 = s1.split(" ");//splitting the query
            String columns[] = new String[100];
            String abc[][] = new String[10000][3];
            columns = s3[3].split(",");
            int count = 0, t, index = 0, i, flag = 0, k = 0, t1 = 0, t2 = 0;
            int index1[] = new int[100];
            String s = "E:/Database/" + database + "/" + table + ".qsv";
            String newfilename = "E:/Database/" + database + "/newfile.qsv";
            //BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            String data[] = new String[100000];
            int c = Read_Entry.selection(data, database, table, s1);
            try {
                FileWriter writer;
                try (FileReader reader = new FileReader(s)) {
                    BufferedReader br = new BufferedReader(reader);
                    writer = new FileWriter(newfilename, true);
                    BufferedWriter bw = new BufferedWriter(writer);
                    String line, line1, line2, line3, line4;
                    line1 = br.readLine();
                    writer.write(line1 + "\r\n");
                    line2 = br.readLine();
                    writer.write(line2 + "\r\n");
                    line3 = br.readLine();
                    writer.write(line3 + "\r\n");
                    line4 = br.readLine();
                    writer.write(line4 + "\r\n");
                    String str[] = new String[100];
                    String s4[] = new String[100];
                    String data1[] = new String[100];
                    str = line1.split(":");//splitting the name of the columns
                    for (t = 0; t < str.length; t++) {
                        if (str[t].equals(data[c])) {//stores the index of the column which contains the primary key
                            index = t;
                        }
                    }
                    for (t1 = 0; t1 < columns.length; t1++) {
                        abc[t1] = columns[t1].split("=");
                        for (t2 = 0; t2 < str.length; t2++) {
                            if (abc[t1][0].equalsIgnoreCase(str[t2])) {
                                index1[k++] = t2;
                            }
                        }
                    }

                    while ((line = br.readLine()) != null) {
                        flag = 0;
                        s4 = line.split(":");//splitting the enteries
                        for (i = 0; i < c; i++) {
                            data1 = data[i].split(":");
                            if (s4[index].equals(data1[index])) {
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 1) {
                            String stg = ":";
                            for (i = 0; i < columns.length; i++) {
                                s4[index1[i]] = abc[i][1];
                            }
                            for (i = 1; i < s4.length; i++) {
                                stg = stg + s4[i] + ":";
                            }
                            line = stg;
                            count++;
                        }
                        writer.write(line + "\r\n");
                    }
                    reader.close();
                    br.close();
                    bw.flush();
                    bw.close();
                }
                writer.close();
                System.out.println("Query OK " + count + " rows Affected.");
            } catch (IOException|ArrayIndexOutOfBoundsException e) {
                System.out.println("Syntax Error");
            }
            File f = new File(s);
            f.setWritable(true);
            System.gc();
            do {
                System.gc();
                f.delete();
            } while (f.exists());
           
                File newfile = new File(newfilename);
                newfile.renameTo(f);
            

        } else {
            System.out.println("No such table is present.");
        }
    }
}
