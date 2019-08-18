package com.example.thuytran.listviewtutorial.model;

public class Answer extends Object {
    private String idQs;
    private int ans;
//    private String idGroup;

    public Answer(String idQs,  int ans) {
        this.idQs = idQs;
        this.ans = ans;
    }

    public Answer() {
    }

    public Answer(QuestionAnswer questionAnswer){
        this.idQs = questionAnswer.getIdQs();
        this.ans = questionAnswer.getAnswer();
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


    @Override
    public String toString() {
        return "Answer{" +
                "idQs='" + idQs + '\'' +
                ", ans=" + ans +
                '}';
    }
}
