package com.github.vitalliuss.runner;

import com.github.vitalliuss.core.ExifReader;
import com.github.vitalliuss.core.FileReader;
import com.github.vitalliuss.core.MetadataParser;
import com.github.vitalliuss.excel.ExcelWriter;
import com.github.vitalliuss.objects.Image;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Vitali_Shulha on 16-Jun-16.
 */
public class Runner {

    public void run(String dirToRead, String fileToWrite){
        ExifReader exifReader = new ExifReader();

        try {
            FileReader fileReader = new FileReader();
            File baseDir = new File(dirToRead);
            System.out.println("Searching file in directory: [" + baseDir + "]");
            File[] fileList = fileReader.getAllFilesInDirectory(baseDir);

            List<Image> imageList = exifReader.getListOfImagesFromFileList(fileList);

            for(Image image : imageList){
                MetadataParser metadataParser = new MetadataParser(image.getMetadata());
                image.setAperture(metadataParser.getAperture());
                image.setExposureTime(metadataParser.getExposureTime());
                image.setFocalLength(metadataParser.getFocalLength());
                image.setISO(metadataParser.getISO());
            }
            ExcelWriter excelWriter = new ExcelWriter();
            excelWriter.writeDataToExcel(imageList, fileToWrite);

        } catch (IOException e) {
            e.printStackTrace();
        };
    }
}
