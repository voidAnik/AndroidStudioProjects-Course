package com.example.class03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etID;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);

        tvResult.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etID.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please enter your id",Toast.LENGTH_SHORT).show();
                }
                else {
                    String idNumber = etID.getText().toString().trim();
                    //Toast.makeText(MainActivity.this, idNumber, Toast.LENGTH_SHORT).show();
                    String tempdept = idNumber.substring(0, 3);
                    String tempSemester = idNumber.substring(3,6);
                    String dept = "";
                    String semester = "";
                    if(tempdept.matches("011"))
                        dept = "CSE";
                    else if(tempdept.matches("111"))
                        dept = "BBA";
                    else
                        dept = "unknown";

                    if(tempSemester.matches("171"))
                        semester = "Spring 2017";
                    else if(tempSemester.matches("172"))
                        semester = "Summer 2017";
                    else
                        semester = "unknown";

                    String text = "You are from "+dept+" Department and enrolled in "+ semester;
                    tvResult.setText(text);
                    tvResult.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}