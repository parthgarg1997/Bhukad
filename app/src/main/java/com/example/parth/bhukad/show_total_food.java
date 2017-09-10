package com.example.parth.bhukad;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class show_total_food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_total_food);
        TextView txt=(TextView)findViewById(R.id.display_food);
       String str= MainActivity.database_handler.final_show();
        txt.setText(str);
    }
}
