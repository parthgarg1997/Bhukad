package com.example.parth.bhukad;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class adders extends AppCompatActivity {
    EditText food_edit_text;
    Button button;
    food_item food;
    SQLiteDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adders);
         food_edit_text=(EditText)findViewById(R.id.new_item_name);
         button=(Button)findViewById(R.id.new_item_bitton);


    }
    public void adderfunction(View view)
    {
        String str=food_edit_text.getText().toString();
        food=new food_item(str,0);
        MainActivity.database_handler.add_products(food);

        finish();
    }
}
