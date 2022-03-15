package com.example.ct_01class;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class resultActivity extends AppCompatActivity {
    TextView c1, c2, c3;
    TextView tv_gpa, tv_cred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        tv_gpa = findViewById(R.id.tv_gpa);
        tv_cred = findViewById(R.id.tv_cred);

        String course1 =  getIntent().getStringExtra("course1");
        String course2 =  getIntent().getStringExtra("course2");
        String course3 =  getIntent().getStringExtra("course3");
        Integer total_cred = getIntent().getIntExtra("total_cred",0);
        Float gpa = getIntent().getFloatExtra("gpa",0);
//        Toast.makeText(resultActivity.this, course1 + course2 + course3, Toast.LENGTH_SHORT).show();

        c1.setText(course1);
        c2.setText(course2);
        c3.setText(course3);
        tv_cred.setText(total_cred.toString());
        tv_gpa.setText(gpa.toString());
    }
}