
package com.jaafoura.foodfacts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class _100 {

    @SerializedName("w")
    @Expose
    private Long w;
    @SerializedName("h")
    @Expose
    private Long h;

    public Long getW() {
        return w;
    }

    public void setW(Long w) {
        this.w = w;
    }

    public Long getH() {
        return h;
    }

    public void setH(Long h) {
        this.h = h;
    }

}
