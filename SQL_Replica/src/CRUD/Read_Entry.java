/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.io.*;
import Miscellaneous.*;

public class Read_Entry {

    /*public static void main(String args[])throws IOException
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter the query:");
String s = br.readLine();
String st1[] = new String[100];
int c = selection(st1,"Narula","CSE",s);
for(int i=0;i<c;i++)
System.out.println(st1[i]);
}*/
    public static int selection(String st1[], String database, String table, String s) throws IOException {
        int count = 0, i = 0, count1 = 0, index = 0;
        //String database = "Narula";
        String st[] = new String[10000];
        String primary[] = new String[50];
        String abc[] = new String[10000];
        st = s.split(" ");
        String fi = "E:/Database/" + database + "/" + table + ".qsv";
        //System.out.println(fi);
        FileReader reader = new FileReader(fi);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line, line1, line2, line3, line4;
        line1 = bufferedReader.readLine();
        //System.out.println(line1);
        line2 = bufferedReader.readLine();
        //System.out.println(line2);
        line3 = bufferedReader.readLine();
        //System.out.println(line3);
        line4 = bufferedReader.readLine();
        abc = line4.split(":");
        for (i = 0; i < abc.length; i++) {
            if ((abc[i]).equals("Yes")) {
                index = i;
            }
        }
        primary = line1.split(":");
        //System.out.println(line4);
        while ((line = bufferedReader.readLine()) != null) {
            st1[count++] = line;
        }
        try{
          i = 0;
        while (i < st.length) {
            switch (st[i]) {
                case "where": {

                    //System.out.println("Inside Where.");
                    if (st[i + 2].equals("between")) {
                        count1 = between(st1, line1, st[i + 1], st[i + 3], st[i + 5], count);
                        i = i + 5;
                        count = count1;
                    } else {
                        count1 = where_clause(st1, line1, st[i + 1], st[i + 2], st[i + 3], count);
                        i = i + 3;
                        count = count1;
                    }
                    break;
                }
                case "and": {
                    count1 = where_clause(st1, line1, st[i + 1], st[i + 2], st[i + 3], count);
                    //System.out.println("Inside And.");
                    i = i + 3;
                    count = count1;
                    break;
                }
                case "order": {
                    //System.out.println("Inside Order.");
                    order_clause(st1, line1, st[i + 2], st[i + 3], count);
                    i = i + 2;
                    break;
                }
                case "limit": {
                    count = Integer.parseInt(st[i + 1]);
                    i = i + 1;
                }
                default: {
                    i++;
                }
            }
        } 
        if (count != 0) {
            if (st[0].equals("select")) {
                if (st[1].equals("all")) {
                    Prints.pr(line1);
                    for (int u = 0; u < (20 * (abc.length - 1) + 8); u++) {
                        System.out.print("_");
                    }
                    System.out.println();
                }
            }
        } else {
            System.out.println("Empty set.");
        }

        //for(i=0;i<count;i++)
        //System.out.println(st1[i]);
        st1[count] = primary[index];
        reader.close();
        bufferedReader.close();
        return count;
        }catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Syntax Error");
        }
        
        //System.out.println("After execution of the where clause.");
        return 0;

    }

    static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    /*static String removeCharAt(String s, int pos, int pos1) {
      return s.substring(pos, pos1-1);
}*/
    static void order_clause(String st1[], String line1, String column, String type, int count) {
        String abc[] = new String[100];
        String x[] = new String[100];
        String y[] = new String[100];
        String line;
        int index = 0, i, j;
        abc = line1.split(":");
        for (i = 0; i < abc.length; i++) {
            if (abc[i].equals(column)) {
                index = i;
            }
        }
        if (type.equals("descending")) {
            for (i = 0; i < count; i++) {
                for (j = 1; j < count; j++) {
                    x = st1[j].split(":");
                    y = st1[j - 1].split(":");
                    if (x[index].compareTo(y[index]) > 0) {
                        line = st1[j - 1];
                        st1[j - 1] = st1[j];
                        st1[j] = line;
                    }
                }
            }
        } else if(type.equals("ascending")){
            for (i = 0; i < count; i++) {
                for (j = 1; j < count; j++) {
                    x = st1[j].split(":");
                    y = st1[j - 1].split(":");
                    if (x[index].compareTo(y[index]) < 0) {
                        line = st1[j - 1];
                        st1[j - 1] = st1[j];
                        st1[j] = line;
                    }
                }
            }
        }
    }

    static int between(String st1[], String line1, String column, String value1, String value2, int count) {
        String st2[] = new String[10000];
        String st3[] = new String[10000];
        String st4[] = new String[10000];
        String line;
        int i, k = 0, index = 0;
        st2 = line1.split(":");
        for (i = 0; i < st2.length; i++) {
            if (st2[i].equals(column)) {
                index = i;
            }
        }
        k = 0;
        for (i = 0; i < count; i++) {
            line = st1[i];
            st3 = line.split(":");
            if ((st3[index].compareTo(value1) > 0) && (st3[index].compareTo(value2) < 0)) {
                st4[k++] = st1[i];
            }
        }
        for (i = 0; i < k; i++) {
            st1[i] = st4[i];
        }
        return k;
    }

    static int where_clause(String st1[], String line1, String column, String likes, String val, int count) {
        String st2[] = new String[10000];
        String st3[] = new String[10000];
        String st4[] = new String[10000];
        String line;
        int i, k = 0, index = 0;
        st2 = line1.split(":");
        for (i = 0; i < st2.length; i++) {
            if (st2[i].equals(column)) {
                index = i;
            }
        }
        if (likes.equals("=")) {
            k = 0;
            for (i = 0; i < count; i++) {
                line = st1[i];
                st3 = line.split(":");
                if (st3[index].equals(val)) {
                    st4[k++] = st1[i];
                }
            }
            for (i = 0; i < k; i++) {
                st1[i] = st4[i];
            }
        } else if (likes.equals("!=") || likes.equals("<>")) {
            k = 0;
            for (i = 0; i < count; i++) {
                line = st1[i];
                st3 = line.split(":");
                if (!(st3[index].equals(val))) {
                    st4[k++] = st1[i];
                }
            }
            for (i = 0; i < k; i++) {
                st1[i] = st4[i];
            }
        } else if (likes.equals(">") || likes.equals("!<")) {
            k = 0;
            for (i = 0; i < count; i++) {
                line = st1[i];
                st3 = line.split(":");
                if (st3[index].compareTo(val) > 0) {
                    st4[k++] = st1[i];
                }
            }
            for (i = 0; i < k; i++) {
                st1[i] = st4[i];
            }
        } else if (likes.equals("<") || likes.equals("!>")) {
            k = 0;
            for (i = 0; i < count; i++) {
                line = st1[i];
                st3 = line.split(":");
                if (st3[index].compareTo(val) < 0) {
                    st4[k++] = st1[i];
                }
            }
            for (i = 0; i < k; i++) {
                st1[i] = st4[i];
            }
        } else if (likes.equals(">") || likes.equals("=")) {
            k = 0;
            for (i = 0; i < count; i++) {
                line = st1[i];
                st3 = line.split(":");
                if (st3[index].compareTo(val) > 0 || st3[index].equals(val)) {
                    st4[k++] = st1[i];
                }
            }
            for (i = 0; i < k; i++) {
                st1[i] = st4[i];
            }
        } else if (likes.equals("<") || likes.equals("=")) {
            k = 0;
            for (i = 0; i < count; i++) {
                line = st1[i];
                st3 = line.split(":");
                if (st3[index].compareTo(val) < 0 || st3[index].equals(val)) {
                    st4[k++] = st1[i];
                }
            }
            for (i = 0; i < k; i++) {
                st1[i] = st4[i];
            }
        } else if (likes.equals("like")) {
            int len = val.length();
            if ((val.startsWith("%")) && (val.endsWith("%"))) {
                //System.out.println(val);
                val = val.replaceAll("%", "");
                //System.out.println(val);
                k = 0;
                for (i = 0; i < count; i++) {
                    line = st1[i];
                    st3 = line.split(":");
                    if (st3[index].contains(val)) {
                        st4[k++] = st1[i];
                    }
                }
                for (i = 0; i < k; i++) {
                    st1[i] = st4[i];
                }
                //System.out.println("Starts and ends with");
            }
            if (val.startsWith("%")) {
                //System.out.println(val);
                val = removeCharAt(val, 0);
                //System.out.println(val);
                k = 0;
                for (i = 0; i < count; i++) {
                    line = st1[i];
                    st3 = line.split(":");
                    if (st3[index].endsWith(val)) {
                        //System.out.println(st3[index]);
                        st4[k++] = st1[i];
                    }
                }
                for (i = 0; i < k; i++) {
                    st1[i] = st4[i];
                }
                //System.out.println("Starts with");
            } else if (val.endsWith("%")) {
                val = removeCharAt(val, len - 1);
                k = 0;
                for (i = 0; i < count; i++) {
                    line = st1[i];
                    st3 = line.split(":");
                    if (st3[index].startsWith(val)) {
                        st4[k++] = st1[i];
                    }
                }
                for (i = 0; i < k; i++) {
                    st1[i] = st4[i];
                }
                //System.out.println(val);
                //System.out.println("Ends with");
            }
        }
        return k;
    }
}
