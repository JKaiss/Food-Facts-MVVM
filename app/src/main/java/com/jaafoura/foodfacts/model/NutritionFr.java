
package com.jaafoura.foodfacts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NutritionFr {

    @SerializedName("x1")
    @Expose
    private String x1;
    @SerializedName("imgid")
    @Expose
    private String imgid;
    @SerializedName("normalize")
    @Expose
    private String normalize;
    @SerializedName("white_magic")
    @Expose
    private String whiteMagic;
    @SerializedName("y2")
    @Expose
    private String y2;
    @SerializedName("geometry")
    @Expose
    private String geometry;
    @SerializedName("rev")
    @Expose
    private String rev;
    @SerializedName("angle")
    @Expose
    private String angle;
    @SerializedName("x2")
    @Expose
    private String x2;
    @SerializedName("sizes")
    @Expose
    private Sizes sizes;
    @SerializedName("y1")
    @Expose
    private String y1;

    public String getX1() {
        return x1;
    }

    public void setX1(String x1) {
        this.x1 = x1;
    }

    public String getImgid() {
        return imgid;
    }

    public void setImgid(String imgid) {
        this.imgid = imgid;
    }

    public String getNormalize() {
        return normalize;
    }

    public void setNormalize(String normalize) {
        this.normalize = normalize;
    }

    public String getWhiteMagic() {
        return whiteMagic;
    }

    public void setWhiteMagic(String whiteMagic) {
        this.whiteMagic = whiteMagic;
    }

    public String getY2() {
        return y2;
    }

    public void setY2(String y2) {
        this.y2 = y2;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    public String getRev() {
        return rev;
    }

    public void setRev(String rev) {
        this.rev = rev;
    }

    public String getAngle() {
        return angle;
    }

    public void setAngle(String angle) {
        this.angle = angle;
    }

    public String getX2() {
        return x2;
    }

    public void setX2(String x2) {
        this.x2 = x2;
    }

    public Sizes getSizes() {
        return sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    public String getY1() {
        return y1;
    }

    public void setY1(String y1) {
        this.y1 = y1;
    }

}
