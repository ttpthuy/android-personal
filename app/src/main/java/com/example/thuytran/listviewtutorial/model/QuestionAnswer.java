package com.example.thuytran.listviewtutorial.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionAnswer implements Serializable {
    private String question;
    private int seleectedAnswerPosition;
    private boolean op1Sel,op2Sel,op3Sel, op4Sel, op5Sel;
    private String idQs;
    private String idGrQs;
    private String qus;
    private int answer;
    public QuestionAnswer(String idQs, String idGrQs, String qus) {
        this.idQs = idQs;
        this.idGrQs = idGrQs;
        this.qus = qus;
        this.answer = 0;
    }
    public QuestionAnswer(Question question){
        this.question = question.getQus();
        this.idGrQs = question.getIdGrQs();
        this.idQs = question.getIdQs();
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getIdQs() {
        return idQs;
    }

    public void setIdQs(String idQs) {
        this.idQs = idQs;
    }

    public String getIdGrQs() {
        return idGrQs;
    }

    public void setIdGrQs(String idGrQs) {
        this.idGrQs = idGrQs;
    }

    public String getQus() {
        return qus;
    }

    public void setQus(String qus) {
        this.qus = qus;
    }

    public QuestionAnswer() {
    }

    public QuestionAnswer(ResultSet resultSet) throws SQLException {
        this.idQs = resultSet.getString("Id_Question");
        this.idGrQs = resultSet.getString("Id_GroupQS");
        this.qus = resultSet.getString("text_QS");
    }

    public QuestionAnswer(JSONObject jsonObject) throws JSONException {
        this.idQs = jsonObject.getString("idQs");
        this.idGrQs = jsonObject.getString("idGrQs");
        this.qus = jsonObject.getString("qus");
    }

    public boolean isOp1Sel() {
        return op1Sel;
    }

    public void setOp1Sel(boolean op1Sel) {
        this.op1Sel = op1Sel;
        if(op1Sel){ // To make sure only one option is selected at a time
            setOp2Sel(false);
            setOp3Sel(false);
            setOp4Sel(false);
            setOp5Sel(false);
        }
    }

    public boolean isOp2Sel() {
        return op2Sel;
    }

    public void setOp2Sel(boolean op2Sel) {
        this.op2Sel = op2Sel;
        if(op2Sel){
            setOp1Sel(false);
            setOp3Sel(false);
            setOp4Sel(false);
            setOp5Sel(false);
        }
    }

    public boolean isOp3Sel() {
        return op3Sel;
    }

    public void setOp3Sel(boolean op3Sel) {
        this.op3Sel = op3Sel;
        if(op3Sel){
            setOp2Sel(false);
            setOp1Sel(false);
            setOp5Sel(false);
            setOp4Sel(false);
        }
    }

    public boolean isOp4Sel() {
        return op4Sel;
    }

    public void setOp4Sel(boolean op4Sel) {
        this.op4Sel = op4Sel;
        if(op4Sel){
            setOp1Sel(false);
            setOp2Sel(false);
            setOp3Sel(false);
            setOp5Sel(false);
        }
    }

    public boolean isOp5Sel() {
        return op5Sel;
    }

    public void setOp5Sel(boolean op5Sel) {
        this.op5Sel = op5Sel;
        if(op5Sel){
            setOp2Sel(false);
            setOp1Sel(false);
            setOp3Sel(false);
            setOp4Sel(false);
        }
    }


    public int getSeleectedAnswerPosition() {
        return seleectedAnswerPosition;
    }

    public void setSeleectedAnswerPosition(int seleectedAnswerPosition) {
        this.seleectedAnswerPosition = seleectedAnswerPosition;
    }

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }

}
