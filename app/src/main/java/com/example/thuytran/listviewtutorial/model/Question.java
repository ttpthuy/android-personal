package com.example.thuytran.listviewtutorial.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Question extends Object {
    private String idQs;
    private String idGrQs;
    private String qus;

    public Question(String idQs, String idGrQs, String qus) {
        this.idQs = idQs;
        this.idGrQs = idGrQs;
        this.qus = qus;
    }

    public Question(ResultSet resultSet) throws SQLException {
        this.idQs = resultSet.getString("Id_Question");
        this.idGrQs = resultSet.getString("Id_GroupQS");
        this.qus = resultSet.getString("text_QS");
    }

    public Question(JSONObject jsonObject) throws JSONException {
        this.idQs = jsonObject.getString("idQs");
        this.idGrQs = jsonObject.getString("idGrQs");
        this.qus = jsonObject.getString("qus");
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

    @Override
    public String toString() {
        return "Question{" +
                "idQs='" + idQs + '\'' +
                ", idGrQs='" + idGrQs + '\'' +
                ", qus='" + qus + '\'' +
                '}' + "\n";
    }
}
