package com.example.thuytran.listviewtutorial.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.thuytran.listviewtutorial.model.Answer;
import com.example.thuytran.listviewtutorial.model.Question;
import com.example.thuytran.listviewtutorial.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAdapter extends ArrayAdapter<Question> {
    private Context context;
    private int layout;
    private List<Question> questionList ;
    Answer answer;
    ViewHolder viewHolder;

    Answer[] data ;
    int pos = 0;

    public MyAdapter(@NonNull Context context, int resource, List<Question> questionList) {
        super(context, resource);
        this.context = context;
        this.layout = layout;
        this.questionList = questionList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
    //    public MyAdapter(Context context, int layout, List<Question> questionList) {
//        this.context = context;
//        this.layout = layout;
//        this.questionList = questionList;
//    }
//
//    public MyAdapter() {
//        this.questionList = new ArrayList<>();
//    }


    //    @Override
//    public View getView( int position, View convertView, ViewGroup parent) {
//        if (convertView == null){
//            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            int layoutResourse = 0;
////            int viewType = getItemViewType(position);
//            int viewType = 0;
//            switch (viewType) {
//                case 0:
//                    layoutResourse= R.layout.even_row;
//                    break;
//
//                case 1:
//                    layoutResourse=R.layout.odd_row;
//                    break;
//            }
////            this.pos = position;
//
//
//            convertView = layoutInflater.inflate(layoutResourse, null);
//             viewHolder = new ViewHolder();
//            this.pos = ((ListView)parent).getPositionForView(convertView);
//            Log.i("thisPosition", pos +"");
//            viewHolder.textQuestion = (TextView) convertView.findViewById(R.id.textView);
//            viewHolder.radioGroup = (RadioGroup) convertView.findViewById(R.id.checkScroreRadio);
//            data = new Answer[questionList.size()];
//
//            viewHolder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(RadioGroup group, int checkedId) {
//                     answer = new Answer();
//                    switch(checkedId) {
//                        case R.id.ans1:
//                            answer.setPosition(pos);
//                            answer.setAns(1);
//                            answer.setIdQs(questionList.get(pos).getIdQs());
//                            data[pos] = answer;
//                            Log.i("checkedPosition", pos + "");
//                                Log.i("checked", 1 + "");
//                            break;
//                        case R.id.ans2:
//                            answer.setPosition(pos);
//                            answer.setAns(2);
//                            answer.setIdQs(questionList.get(pos).getIdQs());
//                            data[pos] = answer;
//                            Log.i("checkedPosition", pos  + "");
//                                Log.i("checked", 2 + "");
//                            break;
//                        case R.id.ans3:
//                            answer.setPosition(pos);
//                            answer.setAns(3);
//                            answer.setIdQs(questionList.get(pos).getIdQs());
//                            data[pos] = answer;
//                            Log.i("checkedPosition", pos + "");
//                                Log.i("checked", 3 + "");
//                            break;
//                        case R.id.ans4:
//                            answer.setPosition(pos);
//                            answer.setAns(4);
//                            answer.setIdQs(questionList.get(pos).getIdQs());
//                            data[pos] = answer;
//                            Log.i("checkedPosition", pos + "");
//                                Log.i("checked", 4 + "");
//                            break;
//                        case R.id.ans5:
//                            answer.setPosition(pos);
//                            answer.setAns(5);
//                            answer.setIdQs(questionList.get(pos).getIdQs());
//                            data[pos] = answer;
//                            Log.i("checkedPosition", pos + "");
//                                Log.i("checked", 5 + "");
//                            break;
//                    }
//
//
//                }
//            });
//
//            convertView.setTag(viewHolder);
//        }else{
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//        String name = questionList.get(position).getQus();
//        viewHolder.textQuestion.setText(name);
//        return convertView;
//    }

//    @Override
//    public int getCount() {
//        return questionList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return questionList.get(position);
//    }
//
//    public Answer[] getAns(){
//        return data;
//
//    }
//    @Override
//    public int getItemViewType(int position) {
//        return position % 2;
//    }
//
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
    static class ViewHolder{
        TextView textQuestion;
        RadioGroup radioGroup;
    }
}
