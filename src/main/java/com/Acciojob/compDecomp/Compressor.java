package com.Acciojob.compDecomp;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compressor {
    public static void method(File file) {
        try {
            // Get the parent directory of the input file
            String fileDirectory = file.getParent();

            // Create a FileInputStream to read from the input file
            FileInputStream fis = new FileInputStream(file);

            // Create a FileOutputStream to write to the output file (compressed with GZIP)
            FileOutputStream fos = new FileOutputStream(fileDirectory+"/CompressedFile_ByRavi.gz");

            // Create a GZIPOutputStream to compress the output data
            GZIPOutputStream gzip = new GZIPOutputStream(fos);

            // Create a buffer to hold the data being read from the input file
            byte[] buffer = new byte[1024];
            int len;

            // Read data from the input file into the buffer, then write the buffer to the GZIPOutputStream
            while ((len = fis.read(buffer)) != -1){
                gzip.write(buffer, 0, len);
            }

            // Close the GZIPOutputStream, FileOutputStream, and FileInputStream
            gzip.close();
            fos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            // Handle the case where the input file is not found
            JOptionPane.showMessageDialog(null,"File not found: " + e.getMessage());
        } catch (IOException e) {
            // Handle any other IOExceptions that may occur while reading or writing data
            JOptionPane.showMessageDialog(null,"Error reading/writing file: " + e.getMessage());
        } catch (Exception e) {
            // Handle any other exceptions that may occur
            JOptionPane.showMessageDialog(null,"An error occurred: " + e.getMessage());
        }
    }
}
