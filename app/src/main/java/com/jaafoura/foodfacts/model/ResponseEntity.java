
package com.jaafoura.foodfacts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseEntity {

    @SerializedName("status_verbose")
    @Expose
    private String statusVerbose;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("product")
    @Expose
    private Product product;
    @SerializedName("status")
    @Expose
    private Long status;

    public String getStatusVerbose() {
        return statusVerbose;
    }

    public void setStatusVerbose(String statusVerbose) {
        this.statusVerbose = statusVerbose;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

}
