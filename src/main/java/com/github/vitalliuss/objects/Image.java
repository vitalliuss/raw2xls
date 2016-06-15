package com.github.vitalliuss.objects;

import com.drew.metadata.Metadata;

import java.io.File;

/**
 * Created by Vitali_Shulha on 15-Jun-16.
 */
public class Image {

    private String path;
    private Metadata metadata;

    public Image(String path, Metadata metadata) {
        this.path = path;
        this.metadata = metadata;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "Image{" +
                "path='" + path.toString() + '\'' +
                ", metadata=" + metadata.toString() +
                '}';
    }
}
