package loadingdata.ashish.advocateapp.Database;

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
    public static  String Table_Name = "Clientrecords";
    public static String Table_Case="Caserecord";
    public static String KEY_CaseName="CaseName";
    public static String KEY_CaseNumber="CaseNumber";
    public static String KEY_Status="status";

    public static String Col1 = "Name";
    public static String Col2 = "Address";
    public static String Col3 = "Contact";
    public static String Col4 = "Email";
    public static String Col5="CaseType";

    public DbHelper(Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table "+Table_Name+" ( "+Col1 +" text,"+Col2+" text, "+Col3+" text, "+Col4+" text,"+Col5+" text );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if Exists"+Table_Name);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name, String address, String contact, String email, String casetype ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col1, name);
        contentValues.put(Col2, address);
        contentValues.put(Col3, contact);
        contentValues.put(Col4, email);
        contentValues.put(Col5, casetype);
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
