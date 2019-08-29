package com.example.thuytran.personal.adapter.score;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.example.thuytran.personal.R;
import com.example.thuytran.personal.model.EditModel;

import java.util.ArrayList;

public class Lv10RecyclerAdapter extends RecyclerView.Adapter<Lv10RecyclerAdapter.MyViewHolder>  {
    private LayoutInflater inflater;
    public static ArrayList<EditModel> editModelArrayList;
    ArrayList<String> subjects ;

    public Lv10RecyclerAdapter(Context ctx, ArrayList<EditModel> editModelArrayList , ArrayList<String> subjects) {
        inflater = LayoutInflater.from(ctx);
        this.editModelArrayList = editModelArrayList;
        this.subjects = subjects;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =  inflater.inflate(R.layout.score_row, null, true);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.textView.setText(this.subjects.get(position));
        myViewHolder.editText.setText(editModelArrayList.get(position).getEditTextValue());


    }

    @Override
    public int getItemCount() {
        return editModelArrayList.size();
    }

    public static  boolean isEditTextEmpty(){
        if( editModelArrayList == null || editModelArrayList.isEmpty() )
            return true;
        for (EditModel editModel: editModelArrayList ) {
            if(editModel.getEditTextValue().matches("")){
                return true;
            }

        }
        return false;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private EditText editText;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textSubject);
            editText = (EditText) itemView.findViewById(R.id.scoreET);
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    editModelArrayList.get(getAdapterPosition()).setEditTextValue(editText.getText().toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
    }
}
