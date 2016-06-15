package com.github.vitalliuss.core;

import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

/**
 * Created by Vitali_Shulha on 15-Jun-16.
 */
public class MetadataParser {

    private Metadata metadata;

    public MetadataParser(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getAperture() {
        // Iterate over the data and print to System.out
        //
        // A Metadata object contains multiple Directory objects
        //
        for (Directory directory : metadata.getDirectories()) {

            //
            // Each Directory stores values in Tag objects
            //
            for (Tag tag : directory.getTags()) {
                if (tag.getTagName().trim().contains("F-Number")) {
                    return tag.toString();
                }
            }

            if (directory.hasErrors()) {
                for (String error : directory.getErrors()) {
                    System.err.println("ERROR: " + error);
                }
            }
        }

        return "";
    }

}
