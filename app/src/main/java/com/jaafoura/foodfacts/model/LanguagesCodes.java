
package com.jaafoura.foodfacts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LanguagesCodes {

    @SerializedName("fr")
    @Expose
    private Long fr;

    public Long getFr() {
        return fr;
    }

    public void setFr(Long fr) {
        this.fr = fr;
    }

}
