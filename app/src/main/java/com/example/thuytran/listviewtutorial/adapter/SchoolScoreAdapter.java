package com.example.thuytran.listviewtutorial.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.thuytran.listviewtutorial.R;
import com.example.thuytran.listviewtutorial.model.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolScoreAdapter extends BaseAdapter {
    private Context context;
    private String[] subjectList = {"Toán", "Lý","Hóa","Văn","Anh"};
    ViewHolder viewHold;
    LayoutInflater layoutInflater;
    Map<String,String> score;
    public SchoolScoreAdapter(@NonNull Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        score =  new HashMap<>();
    }

    @Override
    public int getCount() {
        return subjectList.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.score_row, null);
        viewHold = new ViewHolder();
            viewHold.textSubject = (TextView) convertView.findViewById(R.id.textSubject);
            viewHold.editTextScore = (EditText) convertView.findViewById(R.id.scoreET);
        Log.i("edittext", viewHold.editTextScore.getText().toString() + "");
        viewHold.editTextScore.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("edittext", viewHold.editTextScore.getText().toString() + "");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        convertView.setTag(viewHold);
        viewHold.textSubject.setText(subjectList[position]);


        return  convertView;
    }
    public Map<String,String> getScore (){
        Log.i("edittext", viewHold.editTextScore.getText().toString() + "");
        return score;
    }
}
 class ViewHolder{
    TextView textSubject;
    EditText editTextScore;

}
