package com.Acciojob.compDecomp;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Decompressor {
    public static void method(File file) {
        try {
            // Get the directory of the file
            String fileDirectory = file.getParent();

            // Create a FileInputStream object to read the file
            FileInputStream fis = new FileInputStream(file);

            // Create a GZIPInputStream object to decompress the data
            GZIPInputStream gzip = new GZIPInputStream(fis);

            // Create a FileOutputStream object to write the decompressed data to a file
            FileOutputStream fos = new FileOutputStream(fileDirectory + "/De_CompressedFile_ByRavi.gz");

            // Create a buffer to read the data
            byte[] buffer = new byte[1024];
            int len = 0;

            // Read the data from the GZIPInputStream and write it to the FileOutputStream
            while ((len = gzip.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            // Close the streams
            gzip.close();
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"File not found: " + e.getMessage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Error reading/writing file: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"An error occurred: " + e.getMessage());
        }
    }
}
