package com.appspouch.edumed.model;

public class Category {

    private String diseaseName;
    private String diseaseFacts;
    private String diseaseCauses;


    public Category() {
    }

    public Category(String diseaseName, String diseaseFacts, String diseaseCauses) {
        this.diseaseName = diseaseName;
        this.diseaseFacts = diseaseFacts;
        this.diseaseCauses = diseaseCauses;
    }

    public String getdiseaseName() {
        return diseaseName;
    }

    public void setdiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getdiseaseFacts() {
        return diseaseFacts;
    }

    public void setdiseaseFacts(String diseaseFacts) {
        this.diseaseFacts = diseaseFacts;
    }

    public String getDiseaseCauses() {
        return diseaseCauses;
    }

    public void setDiseaseCauses(String diseaseCauses) {
        this.diseaseCauses = diseaseCauses;
    }
}
