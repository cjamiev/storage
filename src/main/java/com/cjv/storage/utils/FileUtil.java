package com.cjv.storage.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
    public static int backupDB(String type, String contents) {
        try {
            String timestamp = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss").format(new Date());
            FileWriter writer = new FileWriter("./backup/"+type+"-"+timestamp+".json"); // Creates or overwrites
            writer.write(contents);
            writer.close(); // Important to close the writer
            System.out.println("Successfully wrote to the file.");
            return 1;
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
            return 0;
        }
    }
}