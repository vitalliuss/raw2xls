package com.github.vitalliuss.core;

import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

/**
 * Created by Vitali_Shulha on 15-Jun-16.
 */
public class MetadataParser {

    public static final String N_A = "N/A";
    private Metadata metadata;

    public MetadataParser(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getAperture() {
        return getParamenter("[Exif SubIFD] F-Number - ");
    }

    public String getExposureTime() {
        return getParamenter("[Exif SubIFD] Shutter Speed Value - ");
    }

    public String getFocalLength() {
        return getParamenter("[Exif SubIFD] Focal Length - ");
    }

    public String getISO() {
        return getParamenter("[Exif SubIFD] ISO Speed Ratings - ");
    }

    private String getParamenter(String containsString){
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                if (tag.toString().trim().contains(containsString)) {
                    String parameter = tag.toString();
                    return parameter.replace(containsString, "");
                }
            }

            if (directory.hasErrors()) {
                for (String error : directory.getErrors()) {
                    System.err.println("ERROR: " + error);
                }
            }
        }

        return N_A;
    }

    public String getAllMetadata(){
        StringBuffer stringBuffer = new StringBuffer();
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                stringBuffer.append(tag.toString()).append("\n");
            }

            if (directory.hasErrors()) {
                for (String error : directory.getErrors()) {
                    System.err.println("ERROR: " + error);
                }
            }
        }

        return stringBuffer.toString();
    }

}
