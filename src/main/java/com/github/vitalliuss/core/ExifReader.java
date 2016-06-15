package com.github.vitalliuss.core;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.github.vitalliuss.objects.Image;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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

    public List<Image> getListOfImagesFromFileList(File[] fileList) throws IOException {
        List<Image> imageList = new LinkedList<>();

        for (File file : fileList) {
            Image image = new Image(file.getPath(), this.readMetadataFromFile(file));
            imageList.add(image);
        }

        return imageList;
    }
}
