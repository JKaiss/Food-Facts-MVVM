
package com.jaafoura.foodfacts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Languages {

    @SerializedName("en:french")
    @Expose
    private Long enFrench;

    public Long getEnFrench() {
        return enFrench;
    }

    public void setEnFrench(Long enFrench) {
        this.enFrench = enFrench;
    }

}
