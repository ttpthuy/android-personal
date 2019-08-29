package com.example.thuytran.personal.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import com.example.thuytran.personal.R;
import com.example.thuytran.personal.model.OnOptionSelected;
import com.example.thuytran.personal.model.Question;
import com.example.thuytran.personal.model.QuestionAnswer;

import java.util.List;

public class RecylerAdapter extends  RecyclerView.Adapter<RecylerAdapter.ViewHolder> {
    List<Question> questions;
    private List<QuestionAnswer> questionModels;
    Context context;

    public RecylerAdapter(List<QuestionAnswer> questions, Context context) {
        this.questionModels = questions;
        this.context = context;
    }

    public void setOnOptionSelected(OnOptionSelected onOptionSelected) {
        this.onOptionSelected = onOptionSelected;
    }

    private OnOptionSelected onOptionSelected;


    public List<QuestionAnswer> getQuestionModels() {
        return questionModels;
    }

    public void setQuestionModels(List<QuestionAnswer> questionModels) {
        this.questionModels = questionModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.even_row, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        String question = questionModels.get(position).getQuestion();
        question = Character.toUpperCase(question.charAt(0)) + question.substring(1);
        viewHolder.questionTxt.setText("Câu " + ++position + ": "+ question);
        --position;
        viewHolder.an1.setChecked(questionModels.get(position).isOp1Sel());
        viewHolder.an2.setChecked(questionModels.get(position).isOp2Sel());
        viewHolder.an3.setChecked(questionModels.get(position).isOp3Sel());
        viewHolder.an4.setChecked(questionModels.get(position).isOp4Sel());
        viewHolder.an5.setChecked(questionModels.get(position).isOp5Sel());
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        if (questionModels != null) {
            return questionModels.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView questionTxt;
        RadioButton an1, an2, an3, an4, an5;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            questionTxt = (TextView) itemView.findViewById(R.id.textView);
            an1 = (RadioButton) itemView.findViewById(R.id.ans1);
            an2 = (RadioButton)itemView.findViewById(R.id.ans2);
            an3 = (RadioButton)itemView.findViewById(R.id.ans3);
            an4 = (RadioButton)itemView.findViewById(R.id.ans4);
            an5 = (RadioButton)itemView.findViewById(R.id.ans5);
            an1.setOnClickListener(this);
            an2.setOnClickListener(this);
            an3.setOnClickListener(this);
            an4.setOnClickListener(this);
            an5.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ans1:
                    onOptionSelected.onOptionSelected(getAdapterPosition(), 1);
                    break;

                case R.id.ans2:
                    onOptionSelected.onOptionSelected(getAdapterPosition(), 2);
                    break;

                case R.id.ans3:
                    onOptionSelected.onOptionSelected(getAdapterPosition(), 3);
                    break;
                case R.id.ans4:
                    onOptionSelected.onOptionSelected(getAdapterPosition(), 4);
                    break;
                case R.id.ans5:
                    onOptionSelected.onOptionSelected(getAdapterPosition(), 5);
                    break;
            }
        }
    }
}
