package com.example.thuytran.listviewtutorial.model;

import java.io.Serializable;

public class Job implements Serializable {
    private String idJob;
    private String jobName;

    public Job(String idJob, String jobName) {
        this.idJob = idJob;
        this.jobName = jobName;
    }

    public Job() {
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
}
