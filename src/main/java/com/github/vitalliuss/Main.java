package com.github.vitalliuss;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.github.vitalliuss.core.ExifReader;
import com.github.vitalliuss.core.MetadataParser;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main
{
    public static void main( String[] args ) throws URISyntaxException {
        File image;
        image = new File(Main.class.getResource("/image.cr2").toURI());

        ExifReader exifReader = new ExifReader();
        MetadataParser metadataParser = new MetadataParser(exifReader.readMetadataFromFile(image));
        System.out.print(metadataParser.getAperture());
    }
}
