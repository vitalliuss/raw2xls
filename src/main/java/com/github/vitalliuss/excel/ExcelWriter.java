package com.github.vitalliuss.excel;

import com.github.vitalliuss.objects.Image;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Vitali_Shulha on 16-Jun-16.
 */
public class ExcelWriter {

    private final String XLS_EXTENSION = ".xlsx";

    public void writeDataToExcel(List<Image> imageList, String fileToWrite) throws IOException {
        System.out.println("Writing data in Excel: " + fileToWrite + XLS_EXTENSION);
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        SXSSFSheet sheet = workbook.createSheet();
        createHeaderRow(sheet);
        for (int i = 0; i < imageList.size(); i++){
            SXSSFRow row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(imageList.get(i).getPath());
            row.createCell(1).setCellValue(imageList.get(i).getAperture());
            row.createCell(2).setCellValue(imageList.get(i).getFocalLength());
            row.createCell(3).setCellValue(imageList.get(i).getExposureTime());
            row.createCell(4).setCellValue(imageList.get(i).getISO());
        }
        FileOutputStream fileOutputStream = new FileOutputStream(fileToWrite + XLS_EXTENSION);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }

    private SXSSFRow createHeaderRow(SXSSFSheet sheet) {
        SXSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("IMAGE");
        headerRow.createCell(1).setCellValue("F-Number");
        headerRow.createCell(2).setCellValue("Focal Length");
        headerRow.createCell(3).setCellValue("Exposure Time");
        headerRow.createCell(4).setCellValue("ISO");
        return headerRow;
    }
}
