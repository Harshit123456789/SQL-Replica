/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import java.io.*;

public class Update_User {

    /*public static void main(String args[])throws IOException
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter the content:");
	String s = br.readLine();
	update_user a = new update_user();
	a.updation(s);
	}*/
    public void updation(String s1) throws IOException {
        String s3[] = new String[100];
        s3 = s1.split(" ");//splitting the query
        int count = 0, t, index = 0, index1 = 0, width = 20, i, j;
        String table = s3[1];
        String old = s3[9];
        String newval = s3[5];
        String s = "E:/Database";
        String newfilename = s + "/newfile.qsv";
        s = s + "/password.qsv";
        try {
            FileWriter writer;
            try (FileReader reader = new FileReader(s)) {
                BufferedReader br = new BufferedReader(reader);
                writer = new FileWriter(newfilename, true);
                BufferedWriter bw = new BufferedWriter(writer);
                String line, line1;
                line1 = br.readLine();
                writer.write(line1 + "\r\n");
                String str[] = new String[100];
                String s4[] = new String[100];
                str = line1.split(":");//splitting the name of the columns
                for (t = 0; t < str.length; t++) {
                    if (str[t].equals(s3[7])) {
                        index = t;
                    }
                    if (str[t].equals(s3[3])) {
                        index1 = t;
                    }
                }
                while ((line = br.readLine()) != null) {
                    s4 = line.split(":");//splitting the enteries
                    String stg = ":";
                    if ((s4[index].trim()).equals(s3[9])) {
                        s4[index1] = s3[5];
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
            System.out.println("Query OK " + count + " rows Affected");
        } catch (IOException e) {
        }
        File f = new File(s);
        f.setWritable(true);
        System.gc();
         do {
                        System.gc();
                        f.delete();
                    } while (f.exists());
                    System.gc();
        File newfile = new File(newfilename);
        newfile.renameTo(f);
    }
}
