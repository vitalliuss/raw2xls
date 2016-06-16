package com.github.vitalliuss.core;

import com.drew.metadata.Metadata;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vitali_Shulha on 15-Jun-16.
 */
public class FileReader {

    public FileReader() {
    }

    public File[] getAllFilesInDirectory(File path){
        final String[] acceptedExtensions = new String[] { ".jpg", ".jpeg", ".cr2" };
        printAccetedExtentions(acceptedExtensions);
        final File[] files = path.listFiles(new FileFilter()
        {
            public boolean accept(final File file)
            {
                if (file.isDirectory())
                    return false;
                for (String extension : acceptedExtensions) {
                    if (file.getName().toLowerCase().endsWith(extension)) {
                        System.out.println("Found image: [" + file.getName() + "]");
                        return true;
                    }
                }
                return false;
            }
        });

        if(null == files){
            System.out.println("No files found in directory: " + path.toString());
        }
        else{
            System.out.println("Found [" + files.length + "] images");
        }

        return files;
    }

    private void printAccetedExtentions(String[] acceptedExtensions) {
        System.out.println("Accepted extentions for images: ");
        for (String extension : acceptedExtensions) {
            System.out.println("    [" + extension + "]");
        }
    }
}
