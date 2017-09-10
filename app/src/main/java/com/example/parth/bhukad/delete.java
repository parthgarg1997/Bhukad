package com.example.parth.bhukad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class delete extends AppCompatActivity {
EditText edt;
    Button button;
    food_item food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        edt=(EditText)findViewById(R.id.delete_d_product);
        button=(Button)findViewById(R.id.delete_button);
    }
    public void deleter_function(View view)
    {
        String str=edt.getText().toString();
        food=new food_item(str,0);
        MainActivity.database_handler.delete_product(food);

        finish();
    }
}
