package com.techease.danyal.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class HeightActivity extends AppCompatActivity {
    ImageButton next4;
    EditText getHeight ;
    float age , weight ;
    String gender ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height);
        next4 = (ImageButton) findViewById(R.id.next4);
        getHeight = (EditText)findViewById(R.id.getHeight);


        Intent wIntent = getIntent();
        age = wIntent.getIntExtra("age", 0);
        weight = wIntent.getFloatExtra("weight", weight);
        gender =  wIntent.getStringExtra("gender") ;

        next4.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validate()) {

                    return;
                }

                String value= getHeight.getText().toString();
                float height =Integer.parseInt(value);
                Intent hIntent = new Intent(HeightActivity.this, FourthActivity.class);
                hIntent.putExtra("height", height);
                hIntent.putExtra("age", age) ;
                hIntent.putExtra("weight", weight);
                hIntent.putExtra("gender", gender);
                startActivity(hIntent);
                finish();

            }
        });;
    }

    public boolean validate() {
        boolean valid = true;
        String height = getHeight.getText().toString();


        if (height.isEmpty() ) {
            getHeight.setError("Enter your age ");
            valid = false;
        } else {
            getHeight.setError(null);
        }


        return valid;
    }

}
