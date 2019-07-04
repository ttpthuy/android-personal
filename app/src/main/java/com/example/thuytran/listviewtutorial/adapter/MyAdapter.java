package com.example.thuytran.listviewtutorial.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.thuytran.listviewtutorial.model.Answer;
import com.example.thuytran.listviewtutorial.model.Question;
import com.example.thuytran.listviewtutorial.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Question> questionList ;
    Answer answer;
    ViewHolder viewHolder;

    Answer[] data ;


    public MyAdapter(Context context, int layout, List<Question> questionList) {
        this.context = context;
        this.layout = layout;
        this.questionList = questionList;
    }

    public MyAdapter() {
        this.questionList = new ArrayList<>();
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            int layoutResourse = 0;
            int viewType = getItemViewType(position);
            switch (viewType) {
                case 0:
                    layoutResourse= R.layout.even_row;
                    break;

                case 1:
                    layoutResourse=R.layout.odd_row;
                    break;
            }

            convertView = layoutInflater.inflate(layoutResourse, null);
             viewHolder = new ViewHolder();
            viewHolder.textQuestion = (TextView) convertView.findViewById(R.id.textView);
            viewHolder.radioGroup = (RadioGroup) convertView.findViewById(R.id.checkScroreRadio);
            data = new Answer[questionList.size()];
            viewHolder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                     answer = new Answer();
                    switch(checkedId) {
                        case R.id.ans1:
                            answer.setPosition(position);
                            answer.setAns(1);
                            answer.setIdQs(questionList.get(position).getIdQs());
                            data[position] = answer;
                            Log.i("checkedPosition", position + "");
                                Log.i("checked", 1 + "");
                            break;
                        case R.id.ans2:
                            answer.setPosition(position);
                            answer.setAns(2);
                            answer.setIdQs(questionList.get(position).getIdQs());
                            data[position] = answer;
                            Log.i("checkedPosition", position  + "");
                                Log.i("checked", 2 + "");
                            break;
                        case R.id.ans3:
                            answer.setPosition(position);
                            answer.setAns(3);
                            answer.setIdQs(questionList.get(position).getIdQs());
                            Log.i("checkedPosition", position + "");
                                Log.i("checked", 3 + "");
                            break;
                        case R.id.ans4:
                            answer.setPosition(position);
                            answer.setAns(4);
                            answer.setIdQs(questionList.get(position).getIdQs());
                            data[position] = answer;
                            Log.i("checkedPosition", position + "");
                                Log.i("checked", 4 + "");
                            break;
                        case R.id.ans5:
                            answer.setPosition(position);
                            answer.setAns(5);
                            answer.setIdQs(questionList.get(position).getIdQs());
                            data[position] = answer;
                            Log.i("checkedPosition", position + "");
                                Log.i("checked", 5 + "");
                            break;
                    }


                }
            });

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String name = questionList.get(position).getQus();
        viewHolder.textQuestion.setText(name);
        return convertView;
    }

    @Override
    public int getCount() {
        return questionList.size();
    }

    @Override
    public Object getItem(int position) {
        return questionList.get(position);
    }

    public Answer[] getAns(){
        return data;

    }
    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }
    static class ViewHolder{
        TextView textQuestion;
        RadioGroup radioGroup;

    }
}
