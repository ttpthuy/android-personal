package com.example.thuytran.listviewtutorial.model;

public class Answer extends Object {
    private String idQs;
    private int ans;
    private String idGroup;

    public Answer(String idQs,  int ans, String idGroup) {
        this.idQs = idQs;
        this.ans = ans;
        this.idGroup = idGroup;
    }

    public Answer() {
    }

    public Answer(QuestionAnswer questionAnswer){
        this.idQs = questionAnswer.getIdQs();
        this.ans = questionAnswer.getAnswer();
        this.idGroup = questionAnswer.getIdGrQs();
    }

    public String getIdQs() {
        return idQs;
    }

    public void setIdQs(String idQs) {
        this.idQs = idQs;
    }



    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "idQs='" + idQs + '\'' +
                ", ans=" + ans +
                ", idGroup='" + idGroup + '\'' +
                '}' + "\n";
    }
}
