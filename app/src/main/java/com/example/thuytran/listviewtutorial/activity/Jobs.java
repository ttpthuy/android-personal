package com.example.thuytran.listviewtutorial.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.example.thuytran.listviewtutorial.R;
import com.example.thuytran.listviewtutorial.adapter.JobAdapter;
import com.example.thuytran.listviewtutorial.jsonconvert.DownloadJSON;
import com.example.thuytran.listviewtutorial.jsonconvert.PostToServer;
import com.example.thuytran.listviewtutorial.model.Job;
import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Jobs extends AppCompatActivity {
    private LinearLayout llContainer;
    private EditText etSearch;
    private ListView lvJobs;
    private ArrayList<Job> jobArrayList = new ArrayList<Job>();
    private JobAdapter adapter1;


    @Override
    protected void onResume() {
        super.onResume();
//        jobArrayList.add(new Job("1", "CNTT" ));
//        jobArrayList.add(new Job("2", "CNTT1" ));
//        jobArrayList.add(new Job("3", "CNTT2" ));
//        jobArrayList.add(new Job("4", "CNTT3" ));
//        jobArrayList.add(new Job("5", "CNTT4" ));
//        jobArrayList.add(new Job("6", "CNTT5" ));
//        jobArrayList.add(new Job("7", "CNTT6" ));
//        jobArrayList.add(new Job("8", "CNTT7" ));
//        jobArrayList.add(new Job("9", "CNTT8" ));
//        jobArrayList.add(new Job("10", "CNTT9" ));
//        jobArrayList.add(new Job("11", "CNTT10" ));
//        jobArrayList.add(new Job("12", "CNTT11" ));
//        jobArrayList.add(new Job("13", "CNTT12" ));
        DownloadJSON downloadJSON = new DownloadJSON("http://10.0.3.2:8080/Grquestion2_step1");
        downloadJSON.execute();
        try {
            String jobs = downloadJSON.get();
            JSONArray jobsarr = new JSONArray(jobs);
            for(int i = 0; i < jobsarr.length(); i++){
                JSONObject jsonObject = jobsarr.getJSONObject(i);
                jobArrayList.add(new Job(jsonObject));
            }
            adapter1 = new JobAdapter(Jobs.this, jobArrayList);
            lvJobs.setAdapter(adapter1);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e){
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);
        initialize();
        etSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Call back the Adapter with current character to Filter
                adapter1.getFilter().filter(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initialize() {
        etSearch = (EditText) findViewById(R.id.etSearch);
        lvJobs = (ListView)findViewById(R.id.lvJobs);
//        jobArrayList.add(new Job("1", "CNTT" ));
//        jobArrayList.add(new Job("2", "CNTT1" ));
//        jobArrayList.add(new Job("3", "CNTT2" ));
//        jobArrayList.add(new Job("4", "CNTT3" ));
//        jobArrayList.add(new Job("5", "CNTT4" ));
//        jobArrayList.add(new Job("6", "CNTT5" ));
//        jobArrayList.add(new Job("7", "CNTT6" ));
//        jobArrayList.add(new Job("8", "CNTT7" ));
//        jobArrayList.add(new Job("9", "CNTT8" ));
//        jobArrayList.add(new Job("10", "CNTT9" ));
//        jobArrayList.add(new Job("11", "CNTT10" ));
//        jobArrayList.add(new Job("12", "CNTT11" ));
//        jobArrayList.add(new Job("13", "CNTT12" ));
//        adapter1 = new JobAdapter(Jobs.this, jobArrayList);
//        lvJobs.setAdapter(adapter1);
    }
}
