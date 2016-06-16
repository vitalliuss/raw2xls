package com.github.vitalliuss.objects;

import com.drew.metadata.Metadata;

/**
 * Created by Vitali_Shulha on 15-Jun-16.
 */
public class Image {

    private String path;
    private Metadata metadata;
    private String aperture;
    private String focalLength;
    private String exposureTime;
    private String ISO;

    public Image(String path, Metadata metadata) {
        this.path = path;
        this.metadata = metadata;
    }

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    public String getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(String focalLength) {
        this.focalLength = focalLength;
    }

    public String getExposureTime() {
        return exposureTime;
    }

    public void setExposureTime(String exposureTime) {
        this.exposureTime = exposureTime;
    }

    public String getISO() {
        return ISO;
    }

    public void setISO(String ISO) {
        this.ISO = ISO;
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
                "path='" + path + '\'' +
                ", metadata=" + metadata +
                ", aperture='" + aperture + '\'' +
                ", focalLength='" + focalLength + '\'' +
                ", exposureTime='" + exposureTime + '\'' +
                ", ISO='" + ISO + '\'' +
                '}';
    }
}
