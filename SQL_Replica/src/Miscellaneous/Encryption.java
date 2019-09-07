/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Miscellaneous;

/**
 *
 * @author HP
 */
public class Encryption {

    public static final String str = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String plaint, int key) {
        plaint = plaint.toLowerCase();
        String cipher = "";
        for (int i = 0; i < plaint.length(); i++) {
            int charpose = str.indexOf(plaint.charAt(i));
            int keyval = (charpose + key) % 26;
            char replaceval = str.charAt(keyval);
            cipher = cipher + replaceval;
        }
        return cipher;
    }

   /* public static void main(String args[]) throws IOException {
        String val = encrypt("toor", 3);
        System.out.println(val);
    }*/
}
