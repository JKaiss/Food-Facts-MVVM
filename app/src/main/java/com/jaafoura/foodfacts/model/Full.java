
package com.jaafoura.foodfacts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Full {

    @SerializedName("h")
    @Expose
    private Long h;
    @SerializedName("w")
    @Expose
    private Long w;

    public Long getH() {
        return h;
    }

    public void setH(Long h) {
        this.h = h;
    }

    public Long getW() {
        return w;
    }

    public void setW(Long w) {
        this.w = w;
    }

}
