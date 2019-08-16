package com.example.thuytran.listviewtutorial.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.thuytran.listviewtutorial.R;
import com.example.thuytran.listviewtutorial.adapter.RecylerAdapter;
import com.example.thuytran.listviewtutorial.jsonconvert.DownloadJSON;
import com.example.thuytran.listviewtutorial.jsonconvert.PostToServer;
import com.example.thuytran.listviewtutorial.model.*;
import com.example.thuytran.listviewtutorial.sqllite.AnswerSqlLiteHandle;
import com.example.thuytran.listviewtutorial.sqllite.ScoreSqlLiteHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements OnOptionSelected {
    ListView listView;
    List<Question> questionList ;
    Button getAns;
    AnswerSqlLiteHandle answerSqlLiteHandle;
    ArrayList<SchoolScore> schoolScores;
    private RecyclerView mRecyclerView;
    private List<QuestionAnswer> questionModels;
    private RecylerAdapter recylerAdapter;
    int[] answer ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initElement();

        try {
            try {
                getData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //get school score

        answerSqlLiteHandle = new AnswerSqlLiteHandle(MainActivity.this);



        recylerAdapter.setQuestionModels(questionModels);


    }
    private void initElement(){
        listView = (ListView) findViewById(R.id.list_item);
        questionList = new ArrayList<>();
        getAns = (Button) findViewById(R.id.getAns);
        getAns.setOnClickListener(getAnsListener);
        getAns.setText("DONE");
        schoolScores = new ArrayList<>();
        mRecyclerView =(RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        //get School Score
        Intent intent = getIntent();
        schoolScores = (ArrayList<SchoolScore>) intent.getSerializableExtra("schoolscore");

        //config for view adapter,...
        congifForView();
    }
    private void congifForView(){
        //config for recyler adapter
        recylerAdapter =new RecylerAdapter(questionModels, MainActivity.this);
        mRecyclerView.setAdapter(recylerAdapter);
        recylerAdapter.setOnOptionSelected(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private View.OnClickListener getAnsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this,"DONE", Toast.LENGTH_SHORT).show();
            recylerAdapter.getQuestionModels();
            Log.i("last", Arrays.toString(answer) + "");
            List<Answer> answers = new ArrayList<>();
            for(int i = 0; i < recylerAdapter.getQuestionModels().size() ; i ++ ){
                Answer answer = new Answer(recylerAdapter.getQuestionModels().get(i));
                answers.add(answer);
                Log.i("total", answers.get(i).getIdQs() + "    " +  answers.get(i).getAns());
            }
            Log.i("last", answers + "");
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("answer",answers);
                jsonObject.put("score",schoolScores );
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.i("json", jsonObject + "");
            Gson gsonBuilder = new GsonBuilder().create();
            String s = gsonBuilder.toJson(jsonObject);
            Log.i("jsonAns", s);
            RequestBody requestBody = new MultipartBody.Builder()
                    .addFormDataPart("s",s)
                    .setType(MultipartBody.FORM)
                    .build();
            PostToServer postToServer = new PostToServer("http://10.0.3.2:8080/answer", requestBody);
            postToServer.execute();
        }

    };



    private void getData() throws ExecutionException, InterruptedException, JSONException, IOException {
//        String url = "http://10.0.3.2:8080/hello";
//        DownloadJSON downloadJSON = new DownloadJSON(url);
//        Log.i("question2",  "hihih");
//        downloadJSON.execute();
//        String dataJSON = downloadJSON.get();
//        JSONArray jsonArrayDanhSachSanPham = new JSONArray(dataJSON);
//        for (int i = 0 ; i < jsonArrayDanhSachSanPham.length(); i++){
//            JSONObject object = jsonArrayDanhSachSanPham.getJSONObject(i);
//            questionList.add(new Question(object));
//        }
//        Log.i("questionListing", questionList + "");
//        Collections.shuffle(questionList);

        questionModels=new ArrayList<QuestionAnswer>();
        for (int i = 0; i < 20; i++) {
            QuestionAnswer questionModel = new QuestionAnswer();
            questionModel.setQuestion("Question " + (i + 1));
            questionModels.add(questionModel);
        }

        answer = new int[questionModels.size()];

    }


    @Override
    public void onOptionSelected(int position, int itemSelected) {
        questionModels.get(position).setSeleectedAnswerPosition(itemSelected);

        switch (itemSelected){
            case 1:
                questionModels.get(position).setOp1Sel(true);
                questionModels.get(position).setAnswer(1);
                Log.i("qus", position + "   " + 1);
                answer[position] = 1;
                break;

            case 2:
                questionModels.get(position).setOp2Sel(true);
                questionModels.get(position).setAnswer(2);
                Log.i("qus", position + "   " + 2);
                answer[position] = 2;
                break;
            case 3:
                questionModels.get(position).setOp3Sel(true);
                questionModels.get(position).setAnswer(3);
                Log.i("qus", position + "   " + 3);
                answer[position] = 3;
                break;
            case 4:
                questionModels.get(position).setOp4Sel(true);
                questionModels.get(position).setAnswer(4);
                Log.i("qus", position + "   " + 4);
                answer[position] = 4;
                break;
            case 5:
                questionModels.get(position).setOp5Sel(true);
                questionModels.get(position).setAnswer(5);
                Log.i("qus", position + "   " + 5);
                answer[position] = 5;
                break;
        }
        recylerAdapter.setQuestionModels(questionModels);
        recylerAdapter.notifyDataSetChanged();
    }
}
