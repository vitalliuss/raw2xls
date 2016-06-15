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
        return getParamenter("F-Number");
    }

    public String getExposureTime() {
        return getParamenter("Shutter Speed Value");
    }

    public String getFocalLength() {
        return getParamenter("Focal Length");
    }

    public String getISO() {
        return getParamenter("ISO Speed Ratings");
    }

    public String getDateTime() {
        return getParamenter("//Date/Time");
    }

    private String getParamenter(String containsString){
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                if (tag.getTagName().trim().contains(containsString)) {
                    return tag.toString();
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
