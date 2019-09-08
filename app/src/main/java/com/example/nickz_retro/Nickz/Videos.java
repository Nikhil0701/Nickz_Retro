
package com.example.nickz_retro.Nickz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Videos {

    @SerializedName("large")
    @Expose
    private Large large;
    @SerializedName("small")
    @Expose
    private Small small;
    @SerializedName("medium")
    @Expose
    private Medium medium;
    @SerializedName("tiny")
    @Expose
    private Tiny tiny;

    public Large getLarge() {
        return large;
    }

    public void setLarge(Large large) {
        this.large = large;
    }

    public Small getSmall() {
        return small;
    }

    public void setSmall(Small small) {
        this.small = small;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public Tiny getTiny() {
        return tiny;
    }

    public void setTiny(Tiny tiny) {
        this.tiny = tiny;
    }

}
