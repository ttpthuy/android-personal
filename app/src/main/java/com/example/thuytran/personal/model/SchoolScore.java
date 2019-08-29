package com.example.thuytran.personal.model;

import java.io.Serializable;
import java.util.List;

public class SchoolScore implements Serializable {
    private String idLevel;
    private double toan;
    private double ly;
    private double hoa;
    private double van;
    private double anh;
    private double sinh;
    private double su;
    private double dia;

    public SchoolScore(String idLevel, double toan, double ly, double hoa, double van, double sinh, double su, double dia, double anh) {
        this.idLevel = idLevel;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
        this.van = van;
        this.anh = anh;
        this.sinh = sinh;
        this.su = su;
        this.dia = dia;
    }
    public SchoolScore(String isLevel, List<EditModel> editModels, String group){
        this.idLevel = isLevel;
        switch (group.toLowerCase()){
            case "tn":
                this.toan = Double.parseDouble(editModels.get(0).getEditTextValue());
                this.ly = Double.parseDouble(editModels.get(1).getEditTextValue());
                this.hoa = Double.parseDouble(editModels.get(2).getEditTextValue());
                this.sinh = Double.parseDouble(editModels.get(3).getEditTextValue());
                this.anh = Double.parseDouble(editModels.get(4).getEditTextValue());
                break;
            case "xh":
                this.toan = Double.parseDouble(editModels.get(0).getEditTextValue());
                this.van = Double.parseDouble(editModels.get(1).getEditTextValue());
                this.anh = Double.parseDouble(editModels.get(2).getEditTextValue());
                this.su = Double.parseDouble(editModels.get(3).getEditTextValue());
                this.dia = Double.parseDouble(editModels.get(4).getEditTextValue());
                break;
                default:
                    this.toan = Double.parseDouble(editModels.get(0).getEditTextValue());
                    this.ly = Double.parseDouble(editModels.get(1).getEditTextValue());
                    this.hoa = Double.parseDouble(editModels.get(2).getEditTextValue());
                    this.van = Double.parseDouble(editModels.get(3).getEditTextValue());
                    this.anh = Double.parseDouble(editModels.get(4).getEditTextValue());
                    this.sinh = Double.parseDouble(editModels.get(5).getEditTextValue());
                    this.su = Double.parseDouble(editModels.get(6).getEditTextValue());
                    this.dia = Double.parseDouble(editModels.get(7).getEditTextValue());
                    break;
        }


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

    public double getSinh() {
        return sinh;
    }

    public void setSinh(double sinh) {
        this.sinh = sinh;
    }

    public double getSu() {
        return su;
    }

    public void setSu(double su) {
        this.su = su;
    }

    public double getDia() {
        return dia;
    }

    public void setDia(double dia) {
        this.dia = dia;
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
                ", sinh=" + sinh +
                ", su=" + su +
                ", dia=" + dia +
                '}' + "\n";
    }
}
