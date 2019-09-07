/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

/**
 *
 * @author HP
 */
import java.io.*;

public class Delete_User {

    /*public static void main(String args[])throws IOException
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter the query:");
String s = br.readLine();
String str[] = new String[100];
str = s.split(" ");
delete_user a = new delete_user(str[5]);
a.deletion(s);
}*/
    String val;

    public Delete_User(String value) {
        val = value;
    }

    public void deletion(String s1) throws IOException {
        String str[] = new String[100];
        String s3[] = new String[100];
        String s4[] = new String[100];
        s3 = s1.split(" ");//splitting the query
        int count = 0, t, index = 0;
        String s = "E:/Database";
        String newfilename = s + "/newfile.qsv";
        s = s + "/password.qsv";
        try {
            FileWriter writer;
            try ( //delete user where Name = Harshit
                    FileReader reader = new FileReader(s)) {
                BufferedReader br = new BufferedReader(reader);
                writer = new FileWriter(newfilename, true);
                BufferedWriter bw = new BufferedWriter(writer);
                String line, line1;
                line1 = br.readLine();
                str = line1.split(":");//splitting the name of the columns
                writer.write(line1 + "\r\n");
                for (t = 0; t < str.length; t++) {
                    if (str[t].equals(s3[3])) {
                        index = t;
                    }
                }
                while ((line = br.readLine()) != null) {
                    s4 = line.split(":");//splitting the enteries
                    if (!(s4[index].equals(s3[5]))) {
                        writer.write(line + "\r\n");
                    } else {
                        count++;
                    }
                }
                reader.close();
                br.close();
            }
            writer.flush();
            writer.close();

        } catch (IOException e) {
        }
        File f = new File(s);
        f.setWritable(true);
         do {
                        System.gc();
                        f.delete();
                    } while (f.exists());
                    System.gc();
        File newfile = new File(newfilename);
        newfile.renameTo(f);
        System.out.println("Query OK " + count + " row Affected");
    }
}
