/*
 * This program is used to rename a table.
 * 
 */
package Table;

import java.io.File;

/**
 *
 * @Harshit Gupta
 */
public class Rename_Table {

    /*public static void main(String args[]) {
        String oldname = "test";
        String newname = "testing";
        Rename_Table a = new Rename_Table();
        a.rename_table("Java1",oldname, newname);
    }*/
    public void rename_table(String database, String oldname, String newname) {
        //create source File object
        String oldname1 = "E:/Database/" + database + "/" + oldname + ".qsv";
        File oldName = new File(oldname1);

        //create destination File object
        String newname1 = "E:/Database/" + database + "/" + newname + ".qsv";
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
            System.out.println("Table Name changed");
        } else {
            System.out.println("Error renaming the table");
        }
    }
}
