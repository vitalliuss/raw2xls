package com.github.vitalliuss.core;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;

import java.io.File;
import java.io.IOException;

/**
 * Created by Vitali_Shulha on 15-Jun-16.
 */
public class ExifReader {

    public ExifReader() {
    }

    public Metadata readMetadataFromFile(File file){
        Metadata metadata = new Metadata();
        try {
            metadata = ImageMetadataReader.readMetadata(file);
        } catch (ImageProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return metadata;
    }

}
