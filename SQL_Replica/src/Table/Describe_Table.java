/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import java.io.*;
import Miscellaneous.*;

public class Describe_Table {

    /*public static void main(String args[])throws IOException
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter the query:");
String s = br.readLine();
String q[] = new String[10];
q=s.split(" ");
describe_table a = new describe_table();
a.describe("harshit",q[1]);
}*/
  public  void describe(String database, String table) throws IOException {
        String s = "E:/Database/" + database + "/" + table + ".qsv";
        FileReader reader = new FileReader(s);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line, line1, line2, line3, line4;
        line1 = bufferedReader.readLine();
        Prints.pr(line1);
        line2 = bufferedReader.readLine();
        Prints.pr(line2);
        line3 = bufferedReader.readLine();
        Prints.pr(line3);
        line4 = bufferedReader.readLine();
        Prints.pr(line4);
        
        
        reader.close();
        bufferedReader.close();
    }
}
