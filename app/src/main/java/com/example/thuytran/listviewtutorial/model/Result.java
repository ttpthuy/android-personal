package com.example.thuytran.listviewtutorial.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Result implements Serializable {
    private String id;
    private String name;
    private double maleRatio;
    private int jobMarket;
    private double score;

    public Result() {
    }
    public Result(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getString("id");
        this.name = jsonObject.getString("name");
        this.maleRatio = jsonObject.getDouble("maleRatio");
        this.jobMarket = jsonObject.getInt("jobMarket");
        this.score = jsonObject.getDouble("score");
    }

    public Result(String id, String name, double maleRatio, int jobMarket, double score) {
        this.id = id;
        this.name = name;
        this.maleRatio = maleRatio;
        this.jobMarket = jobMarket;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaleRatio() {
        return maleRatio;
    }

    public void setMaleRatio(double maleRatio) {
        this.maleRatio = maleRatio;
    }

    public int getJobMarket() {
        return jobMarket;
    }

    public void setJobMarket(int jobMarket) {
        this.jobMarket = jobMarket;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", maleRatio=" + maleRatio +
                ", jobMarket=" + jobMarket +
                ", score=" + score +
                '}';
    }
}
