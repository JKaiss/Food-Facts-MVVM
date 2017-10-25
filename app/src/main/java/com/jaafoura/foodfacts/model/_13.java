
package com.jaafoura.foodfacts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class _13 {

    @SerializedName("sizes")
    @Expose
    private Sizes sizes;
    @SerializedName("uploaded_t")
    @Expose
    private String uploadedT;
    @SerializedName("uploader")
    @Expose
    private String uploader;

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

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

}
