package com.example.thuytran.listviewtutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Question> questionList ;
    ViewHolder viewHolder;



    public MyAdapter(Context context, int layout, List<Question> questionList) {
        this.context = context;
        this.layout = layout;
        this.questionList = questionList;
    }

    public MyAdapter() {
        this.questionList = new ArrayList<>();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            int layoutResourse = 0;
            int viewType=getItemViewType(position);
            switch (viewType) {
                case 0:
                    layoutResourse=R.layout.even_row;
                    break;

                case 1:
                    layoutResourse=R.layout.odd_row;
                    break;
            }

            convertView = layoutInflater.inflate(layoutResourse, null);
             viewHolder = new ViewHolder();
            viewHolder.textQuestion = (TextView) convertView.findViewById(R.id.textView);
            viewHolder.textQuestion = (TextView) convertView.findViewById(R.id.number);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String name = questionList.get(position).getQus();
        viewHolder.textQuestion.setText(name);
//        viewHolder.textNumber.setText("Câu " + position + 1);
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
        TextView textNumber;

    }
}
