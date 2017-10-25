
package com.jaafoura.foodfacts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sizes {

    @SerializedName("400")
    @Expose
    private com.jaafoura.foodfacts.model._400 _400;
    @SerializedName("full")
    @Expose
    private Full full;
    @SerializedName("100")
    @Expose
    private com.jaafoura.foodfacts.model._100 _100;
    @SerializedName("200")
    @Expose
    private com.jaafoura.foodfacts.model._200 _200;

    public com.jaafoura.foodfacts.model._400 get400() {
        return _400;
    }

    public void set400(com.jaafoura.foodfacts.model._400 _400) {
        this._400 = _400;
    }

    public Full getFull() {
        return full;
    }

    public void setFull(Full full) {
        this.full = full;
    }

    public com.jaafoura.foodfacts.model._100 get100() {
        return _100;
    }

    public void set100(com.jaafoura.foodfacts.model._100 _100) {
        this._100 = _100;
    }

    public com.jaafoura.foodfacts.model._200 get200() {
        return _200;
    }

    public void set200(com.jaafoura.foodfacts.model._200 _200) {
        this._200 = _200;
    }

}
