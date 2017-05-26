package loadingdata.ashish.advocateapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Aashish on 5/26/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    public static  String Database_Name = "Advocate.db";
    public static  String Table_Name = "Caserecord";
    public static String Col1 = "Caseno";
    public static String Col2 = "Name";
    public static String Col3 = "Contact";
    public static String Col4 = "CaseType";
    public static String Col5="Court";

    public DbHelper(Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table "+Table_Name+" ( "+Col1 +" text,"+Col2+" text, "+Col3+" text, "+Col4+" text,"+Col5+" text );");
        Log.d("Create query","Create table "+Table_Name+" ( "+Col1 +" text, "+Col2+" text, "+Col3+" text, "+Col4+" text,"+Col5+" text );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if Exists"+Table_Name);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String caseno, String name, String contact, String casetype, String court ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col1, caseno);
        contentValues.put(Col2, name);
        contentValues.put(Col3, contact);
        contentValues.put(Col4, casetype);
        contentValues.put(Col5, court);
        long result = db.insert(Table_Name, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getRecords()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from "+Table_Name,null);
        return cursor;
    }


}
