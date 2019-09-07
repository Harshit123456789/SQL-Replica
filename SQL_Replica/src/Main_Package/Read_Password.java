/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Package;

import java.io.*;
import Miscellaneous.Encryption;

class Read_Password {

    int reads_password(String user, String password) {
        int flag = 0;
        try {
            String s1[] = new String[100];
            String str[] = new String[100];
            String s = "E:/Database/password.qsv";
            FileReader reader = new FileReader(s);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line, line1, line2, line3, line4;
            line1 = bufferedReader.readLine();
            line2 = bufferedReader.readLine();
            line3 = bufferedReader.readLine();
            line4 = bufferedReader.readLine();
            password = Encryption.encrypt(password, 3);
            str = line1.split(":");//splitting the name of the columns
            while ((line = bufferedReader.readLine()) != null) {
                s1 = line.split(":");
                if ((user.equals(s1[1])) && (password.equals(s1[2]))) {
                    flag = 1;
                }
            }
            reader.close();
            bufferedReader.close();
            return flag;
        } catch (IOException e) {
            System.out.println(e);
        }
        return flag;
    }
}
