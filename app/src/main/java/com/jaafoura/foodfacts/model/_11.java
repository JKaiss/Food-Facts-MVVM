
package com.jaafoura.foodfacts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class _11 {

    @SerializedName("uploader")
    @Expose
    private String uploader;
    @SerializedName("sizes")
    @Expose
    private Sizes sizes;
    @SerializedName("uploaded_t")
    @Expose
    private String uploadedT;

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public Sizes getSizes() {
        return sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    public String getUploadedT() {
        return uploadedT;
    }

    public void setUploadedT(String uploadedT) {
        this.uploadedT = uploadedT;
    }

}
