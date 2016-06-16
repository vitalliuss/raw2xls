package com.github.vitalliuss;

import com.drew.metadata.Metadata;
import com.github.vitalliuss.core.ExifReader;
import com.github.vitalliuss.core.FileReader;
import com.github.vitalliuss.core.MetadataParser;
import com.github.vitalliuss.excel.ExcelWriter;
import com.github.vitalliuss.objects.Image;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main
{
    public static void main( String[] args ) throws URISyntaxException {
//        File image = new File(Main.class.getResource("/image.cr2").toURI());
//        MetadataParser metadataParser = new MetadataParser(exifReader.readMetadataFromFile(image));
//        System.out.println(metadataParser.getAperture());
//        System.out.println(metadataParser.getExposureTime());
//        System.out.println(metadataParser.getFocalLength());
//        System.out.println(metadataParser.getISO());
//        System.out.println(metadataParser.getAllMetadata());
        ExifReader exifReader = new ExifReader();

        try {
            FileReader fileReader = new FileReader();
            File baseDir = new File(".");
            System.out.println("Searching file in directory: [" + baseDir + "]");
            File[] fileList = fileReader.getAllFilesInDirectory(baseDir);

            List<Image> imageList = exifReader.getListOfImagesFromFileList(fileList);

            for(Image image : imageList){
                MetadataParser metadataParser = new MetadataParser(image.getMetadata());
                image.setAperture(metadataParser.getAperture());
                image.setExposureTime(metadataParser.getExposureTime());
                image.setFocalLength(metadataParser.getFocalLength());
                image.setISO(metadataParser.getISO());
//                System.out.println(metadataParser.getAllMetadata());
//                System.out.println(image.toString());
            }
            ExcelWriter excelWriter = new ExcelWriter();
            excelWriter.writeDataToExcel(imageList);

        } catch (IOException e) {
            e.printStackTrace();
        };
    }
}
