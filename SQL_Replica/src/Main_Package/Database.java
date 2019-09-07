/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Package;

import java.io.*;
import CRUD.*;
import Database.*;
import Miscellaneous.*;
import Table.*;
import Temporary_Table.Create_Temporary_Table;
import Users.*;

class Database {

    public static void main(String args[]) throws IOException {
        String s, database_name;
        database_name = " ";
        String primary_key = " ";
        int flag1 = 0;
        String str[] = new String[20];
        String data[] = new String[100000];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String username, password;
        System.out.print("Enter username:");
        username = br.readLine();
        System.out.print("Enter Password:");
        password = br.readLine();
        Read_Password d = new Read_Password();
        int flag = d.reads_password(username, password);
        if (flag == 1) {
            while (true) {
                s = Input.input();
                //s = br.readLine();
                str = s.split(" ");
                switch (str[0]) {
                    case "quit": {
                        System.out.println("Good Bye");
                        System.exit(0);
                    }
                    case "exit": {
                        System.out.println("Good Bye");
                        System.exit(0);
                    }
                    case "create": {
                        if (str[1].equals("database")) {
                            Create_Database a = new Create_Database(str[2]);
                            a.creation_database();
                        }
                        if (str[1].equals("user")) {
                            Create_User a = new Create_User();
                            a.insertion(str[4]);
                        }
                        if (str[1].equals("table")) {
                            if (database_name.equals(" ")) {
                                System.out.println("Database not selected.");
                            } else {
                                Create_Table a = new Create_Table(database_name);
                                a.tables(s);
                            }

                        }
                        if (str[1].equals("temporary_table")) {
                            if (database_name.equals(" ")) {
                                System.out.println("Database not selected.");
                            } else {
                                Create_Temporary_Table a = new Create_Temporary_Table(database_name);
                                a.tables(s);
                            }

                        }
                        break;
                    }
                    case "update": {
                        if (str[1].equals("user")) {
                            Update_User a = new Update_User();
                            a.updation(s);
                        } else if (database_name.equals(" ")) {
                            System.out.println("Database not selected.");
                        } else {
                            flag1 = Check_Table.check(database_name, str[1]);
                            if (flag1 == 1) {
                                Update_Entry a = new Update_Entry(database_name, str[1]);
                                a.updation(s);
                            } else {
                                System.out.println("No such table present.");
                            }
                        }
                        break;
                    }
                    case "delete": {
                        if (str[1].equals("user")) {
                            Delete_User a = new Delete_User(str[5]);
                            a.deletion(s);
                        } else if (database_name.equals(" ")) {
                            System.out.println("Database not selected.");
                        } else {
                            flag1 = Check_Table.check(database_name, str[2]);
                            if (flag1 == 1) {
                                Delete_Entry a = new Delete_Entry(database_name, str[2]);
                                a.deletion(s);
                            } else {
                                System.out.println("No such table present.");
                            }
                        }
                        break;
                    }
                    case "select": {
                        if (str[1].contains("+") || str[1].contains("-") || str[1].contains("*") || str[1].contains("/") || str[1].contains("%")) {
                            Arithmetic.check(str[1]);
                        } else if (database_name.equals(" ")) {
                            if (str.length == 2) {
                                System.out.println("Database not selected.");
                            }

                            if (s.equals("select all from user")) {
                                System.out.println("Access Denied");
                                /*Select_User t = new Select_User();
                                t.sel();*/
                            } else if (str.length >= 4 && database_name.equals(" ")) {
                                System.out.println("Database not selected");
                            }
                          
                        } else if (str[1].equals("database")) {
                            System.out.println(database_name);
                        } else {
                            if (!(str[1].equals("distinct"))) {
                                flag1 = Check_Table.check(database_name, str[3]);
                            } else {
                                flag1 = Check_Table.check(database_name, str[4]);
                            }
                            if (flag1 == 1) {
                                switch (str[1]) {
                                    case "distinct": {
                                        Distinct_Entry a = new Distinct_Entry();
                                        a.display(database_name, s);
                                        break;
                                    }
                                    case "count": {
                                        Count_Rows a = new Count_Rows();
                                        a.counts(database_name, str[3]);
                                        break;
                                    }
                                    default:
                                        int c = Read_Entry.selection(data, database_name, str[3], s);
                                        if (c != 0) {
                                            if (str[1].equals("all")) {
                                                for (int i = 0; i < c; i++) {
                                                    Prints.pr(data[i]);
                                                }
                                            } else {
                                                String col = select.select(data, database_name, str[3], str[1], c);
                                                Prints.pr(col);
                                                String col1[] = new String[100];
                                                col1 = col.split(":");
                                                for (int u = 0; u < (20 * (col1.length - 1) + 8); u++) {
                                                    System.out.print("_");
                                                }
                                                System.out.println();
                                                for (int i = 0; i < c; i++) {
                                                    Prints.pr(data[i]);
                                                }
                                            }
                                        }

                                        break;
                                }
                            } else {
                                System.out.println("No such table present.");
                            }
                        }
                        break;
                    }
                    case "insert": {
                        if (database_name.equals(" ")) {
                            System.out.println("Database not selected.");
                        } else if (str[3].equals("values")) {
                            Create_Entry a = new Create_Entry(database_name, str[2], s, str[5]);
                            a.insertion();
                        } else {
                            str[5] = str[5].replace("(", "");
                            str[5] = str[5].replace(")", "");
                            Create_Entry a = new Create_Entry(database_name, str[2], s, str[5]);
                            a.insertion();
                        }
                        break;
                    }
                    case "use": {
                        flag1 = Check_Database.check_data(str[1]);
                        if (flag1 == 1) {
                            database_name = str[1];
                            System.out.println("Database Selected");
                        } else {
                            System.out.println("No such database present.");
                        }
                        break;
                    }
                    case "drop": {
                        if (str[1].equals("database")) {
                            Drop_Database a = new Drop_Database(str[2]);
                            System.out.println("Query OK database deleted.");
                        }
                        if (str[1].equals("table")) {
                            Drop_Table a = new Drop_Table(database_name, str[2]);
                            System.out.println("Query OK table deleted.");
                        }
                        break;
                    }
                    case "help": {
                        Help a = new Help();
                        a.helper();
                        break;
                    }
                    case "describe": {
                        if (database_name.equals(" ")) {
                            System.out.println("Database not selected.");
                        } else {
                            Describe_Table a = new Describe_Table();
                            a.describe(database_name, str[1]);
                        }
                        break;
                    }
                    case "show": {
                        if (str[1].equals("databases")) {
                            Show_Databases a = new Show_Databases();
                            a.show_database();
                        } else if (database_name.equals(" ")) {
                            System.out.println("Database not selected.");
                        } else if (str[1].equals("tables")) {
                            Show_Tables a = new Show_Tables(database_name);
                            a.show_tables();
                        }
                        break;
                    }
                    case "rename": {
                        if (str[1].equals("database")) {
                            //syntax:_rename database oldname to newname
                            Rename_Database a = new Rename_Database();
                            a.rename_database(str[2], str[4]);
                        } else if (database_name.equals(" ")) {
                            System.out.println("Database not selected.");
                        } else if (str[1].equals("table")) {
                            Rename_Table a = new Rename_Table();
                            a.rename_table(database_name, str[2], str[4]);
                        }
                        break;
                    }
                    case "truncate": {
                        if (database_name.equals(" ")) {
                            System.out.println("Database not selected.");
                        } else {
                            //truncate table table_name
                            Truncate_Table a = new Truncate_Table(database_name, str[2]);
                            a.truncate();
                        }
                        break;
                    }
                    default: {
                        System.out.println("Syntax Error.");
                    }
                }
            }
        } else {
            System.out.println("Wrong username or password.");
        }
    }
}
