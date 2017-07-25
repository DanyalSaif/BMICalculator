package com.techease.danyal.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class WeightActivity extends AppCompatActivity {
    ImageButton next3;
    EditText getWeight ;
    float age ;
    String gender ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        next3 = (ImageButton) findViewById(R.id.next3);
        getWeight = (EditText)findViewById(R.id.getweight);
        Intent mIntent = getIntent();
         age = mIntent.getIntExtra("age", 0);
        gender = mIntent.getStringExtra("gender");

        Toast.makeText(this, String.valueOf(age), Toast.LENGTH_SHORT).show();

        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validate()) {

                    return;
                }

                String value = getWeight.getText().toString();
                float weight =Integer.parseInt(value);
                Intent wIntent = new Intent(WeightActivity.this, HeightActivity.class);
                wIntent.putExtra("weight", weight);
                wIntent.putExtra("age", age);
                wIntent.putExtra("gender" , gender);
                startActivity(wIntent);
                finish();


            }
        });

    }

    public boolean validate() {
        boolean valid = true;
        String weight = getWeight.getText().toString();


        if (weight.isEmpty() ) {
            getWeight.setError("Enter your age ");
            valid = false;
        } else {
            getWeight.setError(null);
        }


        return valid;
    }

}
