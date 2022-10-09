package com.tuhin.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            SQLiteDatabase db = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR, age INT(3));");
            db.delete("users", null, null);
            db.execSQL("INSERT INTO users(name, age) VALUES('sajjad', 24);");
            Cursor c = db.rawQuery("select * from users", null);
            int colIndex = c.getColumnIndex("name");
            c.moveToFirst();
            Log.i("data", String.valueOf(c.getCount()));
            while(c!=null){
                Log.i("data", c.getString(colIndex));
                c.moveToNext();
            }
        }
        catch(Exception e){
            Log.i("ERROR:", "hello");
            Log.i("end", "hello");
        }
    }
}
