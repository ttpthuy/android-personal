package com.example.thuytran.listviewtutorial.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.thuytran.listviewtutorial.model.Answer;
import com.example.thuytran.listviewtutorial.model.SchoolScore;

import java.util.ArrayList;
import java.util.List;

//import static com.example.thuytran.listviewtutorial.sqllite.ScoreSqlLiteHandler.DATABASE_NAME;
//import static com.example.thuytran.listviewtutorial.sqllite.ScoreSqlLiteHandler.DATABASE_VERSION;

public class AnswerSqlLiteHandle extends SQLiteOpenHelper {
    private static final String ANSWER_TABLE = "answer";

    private static final String COLUMN_ID_QS = "idQs";
    private static final String COLUMN_POSITION = "position";
    private static final String COLUMN_ANSWER = "answer";
    private static final String DATABASE_NAME = "newans";

    String CREATE_ANSWER_TABLE = "CREATE TABLE " + ANSWER_TABLE + "(" + COLUMN_ID_QS +
            " TEXT PRIMARY KEY, " + COLUMN_POSITION + " TEXT, " + COLUMN_ANSWER + " TEXT"
            + ")";


    public AnswerSqlLiteHandle(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ANSWER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ANSWER_TABLE);
        onCreate(db);
    }
    public void addAnswer(Answer answer){
        Log.i("aaaddd","adadadad");
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID_QS, answer.getIdQs());
//        values.put(COLUMN_POSITION, answer.getPosition());
        values.put(COLUMN_ANSWER, answer.getAns());
        database.insert(ANSWER_TABLE, null, values);
        database.close();
    }
    public List<Answer> getAllAnswer() {
        List<Answer> answers = new ArrayList<>();
        String selectAllQuery = "SELECT * FROM " + ANSWER_TABLE;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectAllQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Answer answer = new Answer();
                answer.setIdQs(cursor.getString(0));
//                answer.setPosition(cursor.getInt(1));
                answer.setAns(cursor.getInt(2));
                answers.add(answer);
            } while (cursor.moveToNext());
        }
        return answers;
    }
}
