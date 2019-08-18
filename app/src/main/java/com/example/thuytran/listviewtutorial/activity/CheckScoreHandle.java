package com.example.thuytran.listviewtutorial.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.thuytran.listviewtutorial.R;
import com.example.thuytran.listviewtutorial.adapter.*;
import com.example.thuytran.listviewtutorial.jsonconvert.PostToServer;
import com.example.thuytran.listviewtutorial.model.*;
import com.example.thuytran.listviewtutorial.sqllite.ScoreSqlLiteHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class CheckScoreHandle extends AppCompatActivity {
    TextView txtViewLevel;
    ListView scoreLV10, scoreLV11, scoreLV12, scoreLVDH;
    Button btnSendScore;
    ArrayList<String> subjects ;
    int idButton ;
    byte sex;
    private LinearLayout[] rowsOfLevel;
    Level10ScoreAdapter scoreAdapter;
    Level11ScoreAdapter scoreAdapter2;
    Level12ScoreAdapter scoreAdapter3;
    LevelDaiHocScoreAdapter scoreAdapter4;
    ScoreSqlLiteHandler scoreSqlLiteHandler;
    Job job;
    private ArrayList<QuestionAnswer> questionModels;
    public ArrayList<EditModel> editModelArrayList, editModelArrayList2, editModelArrayList3, editModelArrayList4;
    private RecyclerView lop10View, lop11View, lop12View, daihocView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_score);

        initElement();

//        scoreSqlLiteHandler = new ScoreSqlLiteHandler(CheckScoreHandle.this);

    }
    private ArrayList<EditModel> populateList(int size){

        ArrayList<EditModel> list = new ArrayList<>();
        if(size > 8){
            size = 8;
        }
        for(int i = 0; i < size; i++){
            EditModel editModel = new EditModel();
            editModel.setEditTextValue(String.valueOf(i));
            list.add(editModel);
        }

        return list;
    }
    public void getData(){
        Intent intent = getIntent();
        idButton = intent.getIntExtra("level", 2131165277 );
        sex = intent.getByteExtra("sex", Byte.MIN_VALUE);
        subjects = (ArrayList<String>) intent.getSerializableExtra("subjects");
        job = (Job) intent.getSerializableExtra("job");
        Log.i("sex", sex + "");
        Log.i("jobSelectedDSMH", subjects + "");

    }
    public void initElement() {
        rowsOfLevel = new LinearLayout[4];
        rowsOfLevel[0] = (LinearLayout) findViewById(R.id.firstLayout);
        rowsOfLevel[1] = (LinearLayout) findViewById(R.id.secondLayout);
        rowsOfLevel[2] = (LinearLayout) findViewById(R.id.thirdLayout);
        rowsOfLevel[3] = (LinearLayout) findViewById(R.id.fourthLayout);
        btnSendScore = (Button) findViewById(R.id.btnSendScore);
        subjects = new ArrayList<>();
        btnSendScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                try {
                    sendScore();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        getData();

        //set number of layout depend on user choice
        for (LinearLayout horizontalLinearLayout : rowsOfLevel) {
            horizontalLinearLayout.setVisibility(View.GONE);
        }

        for (int row = 0; row < idButton; row++) {
            rowsOfLevel[row].setVisibility(View.VISIBLE);
        }

        //set adapter for listview
        scoreLV10 = (ListView) findViewById(R.id.scoreLV10);
        scoreLV11 = (ListView) findViewById(R.id.scoreLV11);
        scoreLV12 = (ListView) findViewById(R.id.scoreLV12);
        scoreLVDH = (ListView) findViewById(R.id.scoreLVDH);
        editModelArrayList = populateList(subjects.size());
        editModelArrayList2 = populateList(subjects.size());
        editModelArrayList3 = populateList(subjects.size());
        editModelArrayList4 = populateList(subjects.size());
        scoreAdapter = new Level10ScoreAdapter(CheckScoreHandle.this, editModelArrayList, subjects);
        scoreAdapter2 = new Level11ScoreAdapter(CheckScoreHandle.this, editModelArrayList2, subjects);
        scoreAdapter3 = new Level12ScoreAdapter(CheckScoreHandle.this, editModelArrayList3, subjects);
        scoreAdapter4 = new LevelDaiHocScoreAdapter(CheckScoreHandle.this, editModelArrayList3, subjects);
        configAdapter();

    }

    private void configAdapter() {
        scoreLV10.setAdapter(scoreAdapter);
        scoreLV11.setAdapter(scoreAdapter2);
        scoreLV12.setAdapter(scoreAdapter3);
        scoreLVDH.setAdapter(scoreAdapter);

    }

    public void sendScore() throws ExecutionException, InterruptedException, JSONException {
        SchoolScore lop10, lop11, lop12, lop13;
        Intent intent = new Intent(this, MainActivity.class);
        ArrayList<SchoolScore> schoolScores = new ArrayList<>();
        questionModels = new ArrayList<>();
        if( Level10ScoreAdapter.editModelArrayList.size() > 1){
             lop10 = new SchoolScore("lop10", Level10ScoreAdapter.editModelArrayList, job.getGroup() );
             schoolScores.add(lop10);
            Log.i("lop10", lop10 + "");
        }
        if(idButton > 1 && Level11ScoreAdapter.editModelArrayList.size() > 1){
            lop11 = new SchoolScore("lop11", Level11ScoreAdapter.editModelArrayList, job.getGroup() );
            schoolScores.add(lop11);
            Log.i("lop11", lop11 + "");
        }
        if(idButton > 2 && Level12ScoreAdapter.editModelArrayList.size() > 1){
            lop12 = new SchoolScore("lop12", Level12ScoreAdapter.editModelArrayList, job.getGroup() );
            schoolScores.add(lop12);
            Log.i("lop12", lop12 + "");
        }
        if( idButton > 3 && LevelDaiHocScoreAdapter.editModelArrayList.size() > 1){
            lop13 = new SchoolScore("daihoc", LevelDaiHocScoreAdapter.editModelArrayList, job.getGroup() );
            schoolScores.add(lop13);
            Log.i("lop13", lop13 + "");
        }
        //SQLLite saving
//      scoreSqlLiteHandler.addSchoolScore(new SchoolScore("lop10",1,1,1,1,1));
//      scoreSqlLiteHandler.addSchoolScore(new SchoolScore("lop11",2,2,2,2,2));
//      scoreSqlLiteHandler.addSchoolScore(new SchoolScore("lop12",3,3,3,3,3));
//      Log.i("allll", scoreSqlLiteHandler.getAllSchoolScore() + "");

        //Send to server

        JSONObject jsonObject = new JSONObject();
        Gson gsonBuilder = new GsonBuilder().create();
        jsonObject.put("score", schoolScores );
        jsonObject.put("sex", this.sex);
        Log.i("sexeee", this.sex + "");

        String url = "";
        if(job.getGroup() != null && !job.getGroup().isEmpty()  ){
            url = "http://10.0.3.2:8080/Grquestion2_step2";
            jsonObject.put("jobOfG", job);
        }else{
            url = "http://10.0.3.2:8080/Grquestion1_step1";
        }
        String s = gsonBuilder.toJson(jsonObject);
        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("s", s)
                .setType(MultipartBody.FORM)
                .build();
        PostToServer postToServer = new PostToServer(url, requestBody);

        postToServer.execute();
        String dataJSON = postToServer.get();
        Log.i("miningques", dataJSON);

        JSONArray JHListQuestion = new JSONArray(dataJSON);
        for (int i = 0 ; i < JHListQuestion.length(); i++){
            JSONObject object = JHListQuestion.getJSONObject(i);
//            questionList.add(new Question(object));
            questionModels.add(new QuestionAnswer(new Question(object)));
        }
        intent.putExtra("schoolscore", schoolScores);
        intent.putExtra("JHListQuestion", questionModels);
        startActivity(intent);

    }
}
