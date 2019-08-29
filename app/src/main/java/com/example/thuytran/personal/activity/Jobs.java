package com.example.thuytran.personal.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.example.thuytran.personal.R;
import com.example.thuytran.personal.adapter.JobAdapter;
import com.example.thuytran.personal.jsonconvert.DownloadJSON;
import com.example.thuytran.personal.model.Job;
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
        DownloadJSON downloadJSON = new DownloadJSON("http://10.0.3.2:8080/Grquestion2_step1");
        downloadJSON.execute();
        try {
            String jobs = downloadJSON.get();
            JSONArray jobsarr = new JSONArray(jobs);
            for(int i = 0; i < jobsarr.length(); i++){
                JSONObject jsonObject = jobsarr.getJSONObject(i);
                jobArrayList.add(new Job(jsonObject));
            }
            Log.i("jobs", jobArrayList + "");
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
}
