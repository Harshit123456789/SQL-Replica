/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Miscellaneous;

public class Prints {

    /*public static void main(String args[]) {
        pr(":1:Harshit:CSE:");
    }*/
    public static void pr(String entry) {
        int width = 20, i, j;
        String st[] = new String[100];
        st = entry.split(":");
        for (i = 1; i < st.length; i++) {
            System.out.print("|");
            System.out.print(st[i]);
            for (j = 0; j < (width - st[i].length()); j++) {
                System.out.print(" ");
            }
        }
        System.out.println("|");
    }
}
