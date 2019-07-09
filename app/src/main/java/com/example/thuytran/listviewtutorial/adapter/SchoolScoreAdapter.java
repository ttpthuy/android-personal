package com.example.thuytran.listviewtutorial.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.thuytran.listviewtutorial.R;
import com.example.thuytran.listviewtutorial.model.Question;

import java.util.List;

public class SchoolScoreAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<String> subjects ;
    ViewHolder viewHolder;
    public SchoolScoreAdapter(@NonNull Context context, @NonNull List<String> subjects) {
        this.context = context;
        this.layout = R.layout.score_row;
        this.subjects = subjects;
    }

    @Override
    public int getCount() {
        return 100;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.i("schoolAdapter", "schooladaper");
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        TextView textSubject = (TextView) convertView.findViewById(R.id.textSubject);
        EditText editTextScore = (EditText) convertView.findViewById(R.id.scoreET);
        String subject = subjects.get(position);
        textSubject.setText(subject);
        return convertView;
    }
}
 class ViewHolder{
    TextView textSubject;
    EditText editTextScore;

}
