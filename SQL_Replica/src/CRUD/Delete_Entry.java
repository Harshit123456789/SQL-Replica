/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import Table.Check_Table;
import java.io.*;

public class Delete_Entry {

    String database, table;
    int i;

    /*public static void main(String args[])throws IOException
	{
	BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter the query:");
	String query = br1.readLine();
	delete a = new delete("Narula","CSE");
	a.deletion(query);
	//delete from CSE where Name = Harshit
	}*/
    public Delete_Entry(String database_name, String table_name) {
        database = database_name;
        table = table_name;
    }

    public void deletion(String s1) throws IOException {
        int count = 0, t, index = 0, flag = 0;
        String s = "E:/Database/" + database + "/" + table + ".qsv";
        String newfilename = "E:/Database/" + database + "/newfile.qsv";
        int g1 = Check_Table.check(database, table);
        if (g1 == 1) {
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
                    String s3[] = new String[100];
                    String s4[] = new String[100];
                    String data1[] = new String[100];
                    str = line1.split(":");//splitting the name of the columns
                    s3 = s1.split(" ");//splitting the query
                    for (i = 0; i < str.length; i++) {
                        if (str[i].equals(data[c])) {
                            index = i;
                        }
                    }
                    while ((line = br.readLine()) != null) {
                        flag = 0;
                        s4 = line.split(":");//splitting the enteries
                        for (i = 0; i < c; i++) {
                            data1 = data[i].split(":");
                            //System.out.println("Number of retrived data: " + i);
                            if (s4[index].equals(data1[index])) {
                                flag = 1;
                                break;
                            }
                        }
                        if (flag != 1) {
                            writer.write(line + "\r\n");
                        } else {
                            count++;
                        }
                    }
                    reader.close();
                    br.close();
                    bw.flush();
                    bw.close();
                }
                writer.close();
                try {
                    File file = new File(s);
                    file.setWritable(true);
                    do {
                        System.gc();
                        file.delete();
                    } while (file.exists());
                    System.gc();
                        //System.out.println(file.getName() + " is deleted!");
                        File file2 = new File(newfilename);
                        file2.renameTo(file);
                    
                } catch (Exception e) {
                }
            } catch (IOException e) {
            }
            System.out.println("Query OK " + count + " row Affected");
        } else {
            System.out.println("No such table is present.");
        }
    }
}
