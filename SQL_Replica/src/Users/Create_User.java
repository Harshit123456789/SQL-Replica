package Users;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import Miscellaneous.Encryption;
import Miscellaneous.Check_Uniqueness;

/**
 *
 * @author HP
 */
public class Create_User {

    int i, j, width = 20;

    /*public static void main(String args[])throws IOException
	{
	BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter the syntax:");
	String s = br1.readLine();
	String abc[] = new String[100];
	abc = s.split(" ");
	Create_User a = new Create_User();
	a.insertion(abc[4]);	
	}*/
    public void insertion(String s) throws IOException {
        int flag=0;
        String str[] = new String[50];
        str = s.split(",");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = null;

        Check_Uniqueness f = new Check_Uniqueness();
         flag = f.check_unique(s, "", "password");
        if (flag == 1) {
            System.out.println("User with this name already present");
        } else {
            String filename = "E:/Database/password.qsv";
            int x, index;
            try {
                bw = new BufferedWriter(new FileWriter(filename, true));
                bw.write(":");
                for (i = 0; i < str.length; i++) {
                    if (i == 1) {
                        str[i] = Encryption.encrypt(str[i], 3);
                    }
                    bw.write(str[i]);
                    bw.write(":");
                }
                bw.newLine();
                bw.flush();
                System.out.println("Query OK 1 row Affected");
            } catch (IOException e) {
            } finally {
                if (bw != null) {
                    bw.close();
                }

            }
        }

    }
}
