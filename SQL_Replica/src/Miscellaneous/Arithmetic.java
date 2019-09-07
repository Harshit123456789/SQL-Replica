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
public class Arithmetic {

    public static void check(String s) {
        int i, x, y, j;
        String a = "", b = "";
        if (s.contains("+")) {
            i = 0;
            while (s.charAt(i) != '+') {
                a = a + s.charAt(i);
                i++;
            }
            x = Integer.parseInt(a);
            for (j = i + 1; j < s.length(); j++) {
                b = b + s.charAt(j);
            }
            y = Integer.parseInt(b);
            System.out.println(x + y);
        } else if (s.contains("-")) {
            i = 0;
            while (s.charAt(i) != '-') {
                a = a + s.charAt(i);
                i++;
            }
            x = Integer.parseInt(a);
            for (j = i + 1; j < s.length(); j++) {
                b = b + s.charAt(j);
            }
            y = Integer.parseInt(b);
            System.out.println(x - y);
        } else if (s.contains("*")) {
            i = 0;
            while (s.charAt(i) != '*') {
                a = a + s.charAt(i);
                i++;
            }
            x = Integer.parseInt(a);
            for (j = i + 1; j < s.length(); j++) {
                b = b + s.charAt(j);
            }
            y = Integer.parseInt(b);
            System.out.println(x * y);
        } else if (s.contains("/")) {
            i = 0;
            while (s.charAt(i) != '/') {
                a = a + s.charAt(i);
                i++;
            }
            x = Integer.parseInt(a);
            for (j = i + 1; j < s.length(); j++) {
                b = b + s.charAt(j);
            }
            y = Integer.parseInt(b);
            double z = x/y;
            System.out.println(z);
        } else if (s.contains("%")) {
            i = 0;
            while (s.charAt(i) != '%') {
                a = a + s.charAt(i);
                i++;
            }
            x = Integer.parseInt(a);
            for (j = i + 1; j < s.length(); j++) {
                b = b + s.charAt(j);
            }
            y = Integer.parseInt(b);
            System.out.println(x % y);
        }
    }

    /*public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = new String[100];
        s = br.readLine().split(" ");
        check(s[1]);
    }*/
}
