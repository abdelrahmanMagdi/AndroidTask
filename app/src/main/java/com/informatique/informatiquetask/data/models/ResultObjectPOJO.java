package com.informatique.informatiquetask.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by abdelrahman on 28/01/20.
 */
public class ResultObjectPOJO {
    @SerializedName("humanPartners")
    @Expose
    private ArrayList<HumanPartnerObjectPOJO> humanPartners = null;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("companyCapital")
    @Expose
    private String companyCapital;
    @SerializedName("creationDate")
    @Expose
    private String creationDate;
    @SerializedName("expiryDate")
    @Expose
    private String expiryDate;
    @SerializedName("arabicCommercialName")
    @Expose
    private String arabicCommercialName;
    @SerializedName("companyStartDate")
    @Expose
    private String companyStartDate;
    @SerializedName("branchesCount")
    @Expose
    private String branchesCount;
    @SerializedName("commercialRegistrationEntityType")
    @Expose
    private String commercialRegistrationEntityType;
    @SerializedName("commercialRegistrationCode")
    @Expose
    private String commercialRegistrationCode;

    /**
     * No args constructor for use in serialization
     */
    public ResultObjectPOJO() {
    }

    /**
     * @param commercialRegistrationCode
     * @param companyStartDate
     * @param creationDate
     * @param commercialRegistrationEntityType
     * @param expiryDate
     * @param humanPartners
     * @param companyCapital
     * @param location
     * @param branchesCount
     * @param arabicCommercialName
     */
    public ResultObjectPOJO(ArrayList<HumanPartnerObjectPOJO> humanPartners, String location, String creationDate, String expiryDate, String arabicCommercialName, String companyStartDate, String branchesCount, String commercialRegistrationEntityType, String companyCapital, String commercialRegistrationCode) {
        super();
        this.humanPartners = humanPartners;

        this.location = location;
        this.creationDate = creationDate;
        this.expiryDate = expiryDate;
        this.arabicCommercialName = arabicCommercialName;
        this.companyStartDate = companyStartDate;
        this.branchesCount = branchesCount;
        this.commercialRegistrationEntityType = commercialRegistrationEntityType;
        this.companyCapital = companyCapital;
        this.commercialRegistrationCode = commercialRegistrationCode;
    }

    public ArrayList<HumanPartnerObjectPOJO> getHumanPartners() {
        return humanPartners;
    }

    public void setHumanPartners(ArrayList<HumanPartnerObjectPOJO> humanPartners) {
        this.humanPartners = humanPartners;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getArabicCommercialName() {
        return arabicCommercialName;
    }

    public void setArabicCommercialName(String arabicCommercialName) {
        this.arabicCommercialName = arabicCommercialName;
    }

    public String getCompanyStartDate() {
        return companyStartDate;
    }

    public void setCompanyStartDate(String companyStartDate) {
        this.companyStartDate = companyStartDate;
    }

    public String getBranchesCount() {
        return branchesCount;
    }

    public void setBranchesCount(String branchesCount) {
        this.branchesCount = branchesCount;
    }

    public String getCommercialRegistrationEntityType() {
        return commercialRegistrationEntityType;
    }

    public void setCommercialRegistrationEntityType(String commercialRegistrationEntityType) {
        this.commercialRegistrationEntityType = commercialRegistrationEntityType;
    }

    public String getCompanyCapital() {
        return companyCapital;
    }

    public void setCompanyCapital(String companyCapital) {
        this.companyCapital = companyCapital;
    }

    public String getCommercialRegistrationCode() {
        return commercialRegistrationCode;
    }

    public void setCommercialRegistrationCode(String commercialRegistrationCode) {
        this.commercialRegistrationCode = commercialRegistrationCode;
    }
}
