package com.example.thuytran.listviewtutorial.model;

import java.io.Serializable;
import java.util.List;

public class SchoolScore implements Serializable {
    private String idLevel;
    private double toan;
    private double ly;
    private double hoa;
    private double van;
    private double anh;

    public SchoolScore(String idLevel, double toan, double ly, double hoa, double van, double anh) {
        this.idLevel = idLevel;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
        this.van = van;
        this.anh = anh;
    }
    public SchoolScore(String isLevel, List<EditModel> editModels){
        this.idLevel = isLevel;
        this.toan = Double.parseDouble(editModels.get(0).getEditTextValue());
        this.ly = Double.parseDouble(editModels.get(1).getEditTextValue());
        this.hoa = Double.parseDouble(editModels.get(2).getEditTextValue());
        this.van = Double.parseDouble(editModels.get(3).getEditTextValue());
        this.anh = Double.parseDouble(editModels.get(4).getEditTextValue());


    }

    public SchoolScore() {
    }

    public String getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(String idLevel) {
        this.idLevel = idLevel;
    }

    public double getToan() {
        return toan;
    }

    public void setToan(double toan) {
        this.toan = toan;
    }

    public double getLy() {
        return ly;
    }

    public void setLy(double ly) {
        this.ly = ly;
    }

    public double getHoa() {
        return hoa;
    }

    public void setHoa(double hoa) {
        this.hoa = hoa;
    }

    public double getVan() {
        return van;
    }

    public void setVan(double van) {
        this.van = van;
    }

    public double getAnh() {
        return anh;
    }

    public void setAnh(double anh) {
        this.anh = anh;
    }

    @Override
    public String toString() {
        return "SchoolScore{" +
                "idLevel='" + idLevel + '\'' +
                ", toan=" + toan +
                ", ly=" + ly +
                ", hoa=" + hoa +
                ", van=" + van +
                ", anh=" + anh +
                '}' + "\n";
    }
}
