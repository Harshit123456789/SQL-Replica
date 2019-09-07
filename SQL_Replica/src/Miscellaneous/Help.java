/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Miscellaneous;

import java.io.*;

public class Help {

    public void helper() throws IOException {
        try {

            String s = "E:/Database/syntax.java";
            try (FileReader reader = new FileReader(s); BufferedReader bufferedReader = new BufferedReader(reader)) {

                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
                bufferedReader.close();
            }
        } catch (IOException e) {
        }
    }
}
