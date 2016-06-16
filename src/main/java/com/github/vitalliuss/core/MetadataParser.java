package com.github.vitalliuss.core;

import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

/**
 * Created by Vitali_Shulha on 15-Jun-16.
 */
public class MetadataParser {

    private final String N_A = "N/A";
    private Metadata metadata;

    public MetadataParser(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getAperture() {
        return getParameter("[Exif SubIFD] F-Number - ");
    }

    public String getExposureTime() {
        return getParameter("[Exif SubIFD] Shutter Speed Value - ");
    }

    public String getFocalLength() {
        return getParameter("[Exif SubIFD] Focal Length - ");
    }

    public String getISO() {
        return getParameter("[Exif SubIFD] ISO Speed Ratings - ");
    }

    private String getParameter(String containsString){
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
}
