package com.example.thuytran.personal.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Job implements Serializable {
    private String id;
    private String name;
    private String group;

    public Job(String id, String name, String jobGroup) {
        this.id = id;
        this.name = name;
        this.group = jobGroup;
    }

    public Job() {
        this.id = "";
        this.name = "";
        this.group = "";
    }
    public Job(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getString("id");
        this.name = jsonObject.getString("name");
        this.group = jsonObject.getString("group");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                '}' + "\n";
    }
}
