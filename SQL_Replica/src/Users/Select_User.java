/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import java.io.*;
import Miscellaneous.*;

public class Select_User {

    public void sel() {
        String s = "E:/Database/password.qsv";
        try {
            int count = 0;
            try (FileReader reader = new FileReader(s)) {
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line, line1, line2, line3, line4;
                line1 = bufferedReader.readLine();
                line2 = bufferedReader.readLine();
                line3 = bufferedReader.readLine();
                line4 = bufferedReader.readLine();
                Prints.pr(line1);
                String abc[] = new String[100];
                abc = line1.split(":");
                for (int u = 0; u < (20 * (abc.length - 1) + 8); u++) {
                    System.out.print("_");
                }
                System.out.println();
                while ((line = bufferedReader.readLine()) != null) {
                    Prints.pr(line);
                    count++;
                }
                //System.out.println("Total number of rows:" + count);
                reader.close();
                bufferedReader.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
