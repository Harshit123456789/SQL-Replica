/*
 * This program is used to rename a database.
 * This program has been checked.
 */
package Database;

/**
 *
 * @Harshit Gupta
 */
import java.io.*;

public class Rename_Database {

    /*public static void main(String args[]) {
        String oldname = "Java";
        String newname = "Java1";
        Rename_Database a = new Rename_Database();
        a.rename_database(oldname, newname);
    }*/
    public void rename_database(String oldname, String newname) {
        //create source File object
        String oldname1 = "E:/Database/" + oldname;
        File oldName = new File(oldname1);

        //create destination File object
        String newname1 = "E:/Database/" + newname;
        File newName = new File(newname1);

        /*
     * To rename a file or directory, use
     * boolean renameTo(File destination) method of Java File class.
     *
     * This method returns true if the file was renamed successfully, false
     * otherwise.
         */
        boolean isFileRenamed = oldName.renameTo(newName);

        if (isFileRenamed) {
            System.out.println("Database Name changed");
        } else {
            System.out.println("Error renaming the database");
        }
    }
}
