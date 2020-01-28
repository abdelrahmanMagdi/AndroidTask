package com.informatique.informatiquetask.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by abdelrahman on 28/01/20.
 */
public class HumanPartnerObjectPOJO {

    @SerializedName("nameAr")
    @Expose
    private String nameAr;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("nIN")
    @Expose
    private String nIN;
    @SerializedName("percentage")
    @Expose
    private String percentage;

    /**
     * No args constructor for use in serialization
     */
    public HumanPartnerObjectPOJO() {
    }

    /**
     * @param nIN
     * @param nameAr
     * @param nationality
     * @param percentage
     */
    public HumanPartnerObjectPOJO(String nameAr, String nationality, String nIN, String percentage) {
        super();
        this.nameAr = nameAr;
        this.nationality = nationality;
        this.nIN = nIN;
        this.percentage = percentage;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNIN() {
        return nIN;
    }

    public void setNIN(String nIN) {
        this.nIN = nIN;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }


}
