package com.example.thuytran.listviewtutorial.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Job implements Serializable {
    private String idJob;
    private String jobName;
    private String jobGroup;

    public Job(String idJob, String jobName, String jobGroup) {
        this.idJob = idJob;
        this.jobName = jobName;
        this.jobGroup = jobGroup;
    }

    public Job() {
    }
    public Job(JSONObject jsonObject) throws JSONException {
        this.idJob = jsonObject.getString("id");
        this.jobName = jsonObject.getString("name");
        this.jobGroup = jsonObject.getString("group");
    }

    public String getIdJob() {
        return idJob;
    }

    public void setIdJob(String idJob) {
        this.idJob = idJob;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    @Override
    public String toString() {
        return "Job{" +
                "idJob='" + idJob + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                '}' + "\n";
    }
}
