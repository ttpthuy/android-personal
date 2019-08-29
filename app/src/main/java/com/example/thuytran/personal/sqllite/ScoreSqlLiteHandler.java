package com.example.thuytran.personal.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.thuytran.personal.model.SchoolScore;

import java.util.ArrayList;
import java.util.List;

public class ScoreSqlLiteHandler extends SQLiteOpenHelper {
    // Database Version
    public static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "information.db";

    private static final String SCHOOL_SCORE_COMPUTER = "school";

    // Computer Table Columns
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_Toan = "toan";
    private static final String COLUMN_Ly = "ly";
    private static final String COLUMN_Hoa = "hoa";
    private static final String COLUMN_Van = "van";
    private static final String COLUMN_Anh = "anh";

    String CREATE_SCHOOL_SCORE_TABLE = "CREATE TABLE " + SCHOOL_SCORE_COMPUTER + "(" + COLUMN_ID +
            " TEXT PRIMARY KEY, " + COLUMN_Toan + " TEXT, " + COLUMN_Ly + " TEXT," +
            COLUMN_Hoa + " TEXT," + COLUMN_Van + " TEXT," +COLUMN_Anh + " TEXT"
            + ")";

    public ScoreSqlLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("oncreateeeeeeeee", "oncreate");
        db.execSQL(CREATE_SCHOOL_SCORE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SCHOOL_SCORE_COMPUTER);
        onCreate(db);
    }
    public void addSchoolScore(SchoolScore schoolScore){
        Log.i("aaaddd","adadadad");
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, schoolScore.getIdLevel());
        values.put(COLUMN_Toan, schoolScore.getToan());
        values.put(COLUMN_Ly, schoolScore.getLy());
        values.put(COLUMN_Hoa, schoolScore.getHoa());
        values.put(COLUMN_Van, schoolScore.getVan());
        values.put(COLUMN_Anh, schoolScore.getAnh());
        database.insert(SCHOOL_SCORE_COMPUTER, null, values);
        database.close();

    }
    // Getting all Computer Objects
    public List<SchoolScore> getAllSchoolScore() {

        List<SchoolScore> schoolScores = new ArrayList<>();

        String selectAllQuery = "SELECT * FROM " + SCHOOL_SCORE_COMPUTER;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectAllQuery, null);


        if (cursor.moveToFirst()) {

            do {

                SchoolScore schoolScore = new SchoolScore();
                schoolScore.setIdLevel(cursor.getString(0));
                schoolScore.setToan(cursor.getDouble(1));
                schoolScore.setLy(cursor.getDouble(2));
                schoolScore.setHoa(cursor.getDouble(2));
                schoolScore.setVan(cursor.getDouble(2));
                schoolScore.setAnh(cursor.getDouble(2));


                schoolScores.add(schoolScore);

            } while (cursor.moveToNext());
        }
        return schoolScores;
    }

}
