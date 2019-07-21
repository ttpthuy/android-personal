package com.example.thuytran.listviewtutorial.model;

public class Answer extends Object {
    private String idQs;
    private int position;
    private int ans;

    public Answer(String idQs, int position, int ans) {
        this.idQs = idQs;
        this.position = position;
        this.ans = ans;
    }

    public Answer() {
    }

    public String getIdQs() {
        return idQs;
    }

    public void setIdQs(String idQs) {
        this.idQs = idQs;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "idQs='" + idQs + '\'' +
                ", position=" + position +
                ", ans=" + ans +
                '}' + "\n";
    }
}
