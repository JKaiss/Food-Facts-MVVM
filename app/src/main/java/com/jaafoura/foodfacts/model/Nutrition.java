
package com.jaafoura.foodfacts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nutrition {

    @SerializedName("display")
    @Expose
    private Display display;
    @SerializedName("small")
    @Expose
    private Small small;
    @SerializedName("thumb")
    @Expose
    private Thumb thumb;

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Small getSmall() {
        return small;
    }

    public void setSmall(Small small) {
        this.small = small;
    }

    public Thumb getThumb() {
        return thumb;
    }

    public void setThumb(Thumb thumb) {
        this.thumb = thumb;
    }

}
