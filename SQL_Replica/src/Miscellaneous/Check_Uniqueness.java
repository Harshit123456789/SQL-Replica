/*
 * This program checks for the primary key.
 * This program has been checked and works properly.
 */
package Miscellaneous;

/* 
 *@Harshit Gupta 
 */
import java.io.*;

public class Check_Uniqueness {

    /*public static void main(String args[]) throws IOException {
        Check_Uniqueness a = new Check_Uniqueness();
        int flag = a.check_unique("5:Gourav:secret4", "Java1", "testing");
        if (flag == 1) {
            System.out.println("Primary key should be unique.");
        }
        else{
            System.out.println("Query ok 1 row affected");
        }
    }*/
    public int check_unique(String new_entry, String database, String table) {
        int flag = 0, k = 0;
        try {
            String s="";
            String s1[] = new String[100];
            String str[] = new String[100];
            String abc[] = new String[100];
            String entry[] = new String[100];
            int index[] = new int[100];
            entry = new_entry.split(",");
            if(!(database.equals("")))
            {
                s = "E:/Database/" + database + "/" + table + ".qsv";
            }
            else
            {
                s = "E:/Database/"  + table + ".qsv";
            }
            try (
                    FileReader reader = new FileReader(s)) {
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line, line1, line2, line3, line4;
                line1 = bufferedReader.readLine();
                line2 = bufferedReader.readLine();
                line3 = bufferedReader.readLine();
                line4 = bufferedReader.readLine();
                abc = line4.split(":");
                for (int i = 0; i < abc.length; i++) {
                    if ((abc[i].trim()).equals("Yes")) {
                        index[k++] = i;
                    }
                }
                str = line1.split(":");
                while ((line = bufferedReader.readLine()) != null) {
                    s1 = line.split(":");
                    for (int i = 0; i < k; i++) {
                        if ((s1[index[i]].trim()).equals(entry[index[i] - 1])) {
                            flag = 1;
                            break;
                        }
                    }
                }
                reader.close();
                bufferedReader.close();
            }
            return flag;
        } catch (IOException e) {
            System.out.println(e);
        }
        return flag;
    }
}
