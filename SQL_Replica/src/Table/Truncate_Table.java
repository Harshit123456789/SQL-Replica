/*
 * This program is used to truncate a table.
 * This program has been checked and works properly.
 */
package Table;

import java.io.*;

/**
 *
 * @Harshit Gupta
 */
public class Truncate_Table {

    String database, table;

    /*public static void main(String args[]) throws IOException {
        Truncate_Table a = new Truncate_Table("Java1", "testing");
        a.truncate();
    }*/

    public Truncate_Table(String database_name, String table_name) {
        database = database_name;
        table = table_name;
    }

    public void truncate() throws IOException {
        String s = "E:/Database/" + database + "/" + table + ".qsv";
        String newfilename = "E:/Database/" + database + "/newfile.qsv";
        try {
            FileWriter writer;
            try (FileReader reader = new FileReader(s)) {
                BufferedReader br = new BufferedReader(reader);
                writer = new FileWriter(newfilename, true);
                BufferedWriter bw = new BufferedWriter(writer);
                String line1, line2, line3, line4;
                line1 = br.readLine();
                writer.write(line1 + "\r\n");
                line2 = br.readLine();
                writer.write(line2 + "\r\n");
                line3 = br.readLine();
                writer.write(line3 + "\r\n");
                line4 = br.readLine();
                writer.write(line4 + "\r\n");
                /*
                 * Lines 39 to 46 is used to write the table structure to a new file  
                 */
                reader.close();
                br.close();
                bw.flush();
                bw.close();
            }
            writer.close();
            try {
                /*
                  This try block deletes the table and creates a new table with the same structure and renames this new table to the old one.
                 */
                File file = new File(s);
                file.setWritable(true);
                System.gc();
                if (file.delete()) {
                    //System.out.println(file.getName() + " is deleted!");
                    File file2 = new File(newfilename);
                    file2.renameTo(file);
                } else {
                    System.out.println("Delete operation failed.");
                }
            } catch (Exception e) {
            }
        } catch (IOException e) {
        }
        System.out.println("Query OK 1 row Affected");
    }
}
