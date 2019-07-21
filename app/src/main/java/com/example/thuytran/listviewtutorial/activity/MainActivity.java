package com.example.thuytran.listviewtutorial.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.thuytran.listviewtutorial.R;
import com.example.thuytran.listviewtutorial.adapter.MyAdapter;
import com.example.thuytran.listviewtutorial.jsonconvert.DownloadJSON;
import com.example.thuytran.listviewtutorial.jsonconvert.PostToServer;
import com.example.thuytran.listviewtutorial.model.Answer;
import com.example.thuytran.listviewtutorial.model.Question;
import com.example.thuytran.listviewtutorial.model.SchoolScore;
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

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<Question> questionList ;
    MyAdapter myAdapter;
    RadioGroup radioGroup;
    Button getAns;
    AnswerSqlLiteHandle answerSqlLiteHandle;
    ArrayList<SchoolScore> schoolScores;

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
        answerSqlLiteHandle = new AnswerSqlLiteHandle(MainActivity.this);
        myAdapter = new MyAdapter(this, R.layout.activity_row_list_view, questionList);
        listView.setAdapter(myAdapter);
        Intent intent = getIntent();
         schoolScores = (ArrayList<SchoolScore>) intent.getSerializableExtra("schoolscore");
        answerSqlLiteHandle = new AnswerSqlLiteHandle(MainActivity.this);


    }
    private void initElement(){
        radioGroup = (RadioGroup) findViewById(R.id.checkScroreRadio);
        listView = (ListView) findViewById(R.id.list_item);
        questionList = new ArrayList<>();
        listView.setOnItemClickListener(onItemClickListener);
        getAns = (Button) findViewById(R.id.getAns);
        getAns.setOnClickListener(getAnsClickItem);
        schoolScores = new ArrayList<>();

    }
    private View.OnClickListener getAnsClickItem = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i("ans", Arrays.toString(myAdapter.getAns()));

            Answer[] answers = myAdapter.getAns();
            for(int i = 0; i < answers.length; i++){
                answerSqlLiteHandle.addAnswer(answers[i]);
            }
            Log.i("answesInSQLLite", answerSqlLiteHandle.getAllAnswer()+"");
            Log.i("schoolscoreSQLLITE", schoolScores + "");
//            Map<String, List<>> map = new HashMap<>();
//            map.put("s", answerSqlLiteHandle.getAllAnswer());
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("answer",answerSqlLiteHandle.getAllAnswer() );
                jsonObject.put("score",schoolScores );
            } catch (JSONException e) {
                e.printStackTrace();
            }

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

        questionList.add(new Question("01","01", "Like ME"));
        questionList.add(new Question("02","01", "Like Him"));
        questionList.add(new Question("03","01", "Like ME"));
        questionList.add(new Question("04","01", "Like ME"));
        questionList.add(new Question("05","01", "Like ME"));
        questionList.add(new Question("06","01", "Like ME"));
        questionList.add(new Question("07","01", "Like ME"));

    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
       Map<Integer, Integer> map = new HashMap<>();
       Log.i("parent", view.getParent().getParent().getParent() + "");
        switch(view.getId()) {
            case R.id.ans1:
                if (checked)
                    Log.i("checked", 1 + "");
//                    map.put(listView.getCheckedItemPosition(), 1);
                    break;
            case R.id.ans2:
                if (checked)
                    Log.i("checked", 2 + "");
                    break;
            case R.id.ans3:
                if (checked)
                    Log.i("checked", 3 + "");
                    break;
            case R.id.ans4:
                if (checked)
                    Log.i("checked", 4 + "");
                    break;
            case R.id.ans5:
                if (checked)
                    Log.i("checked", 5 + "");
                    break;
        }

    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                long arg3) {
            // TODO Auto-generated method stub
            //do your job here, position is the item position in ListView
        }
    };

}
