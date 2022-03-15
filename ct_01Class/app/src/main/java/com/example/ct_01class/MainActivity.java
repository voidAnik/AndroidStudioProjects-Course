package com.example.ct_01class;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_name1, et_name2, et_name3;
    EditText et_cr1, et_cr2, et_cr3;
    Spinner s_grade1, s_grade2, s_grade3;
    Button calculateBtn;
    String course1, course2, course3;
    Integer total_credit;
    float grade1, grade2, grade3;
    float gpa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final float[] grade = {4, (float) 3.67, (float) 3.33, 3, (float) 2.67, (float) 2.33, 2, (float) 1.67, (float) 1.33, 1};
        //ID bindings
        et_name1 = findViewById(R.id.et_name1);
        et_name2 = findViewById(R.id.et_name2);
        et_name3 = findViewById(R.id.et_name3);
        et_cr1 = findViewById(R.id.et_cr1);
        et_cr2 = findViewById(R.id.et_cr2);
        et_cr3 = findViewById(R.id.et_cr3);
        s_grade1 = findViewById(R.id.s_grade1);
        s_grade2 = findViewById(R.id.s_grade2);
        s_grade3 = findViewById(R.id.s_grade3);
        calculateBtn = findViewById(R.id.calculateBtn);

        //Getting spinner value
        s_grade1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                grade1 = grade[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        s_grade2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                grade2 = grade[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        s_grade3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                grade3 = grade[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    checkEmpty();
                    total_credit = Integer.parseInt(et_cr1.getText().toString()) + Integer.parseInt(et_cr2.getText().toString()) + Integer.parseInt(et_cr3.getText().toString());
                    float total_grade = (grade1 * Integer.parseInt(et_cr1.getText().toString())) + (grade2 * Integer.parseInt(et_cr1.getText().toString())) + (grade3 * Integer.parseInt(et_cr1.getText().toString()));
                    gpa = total_grade / total_credit;

//                    Toast.makeText(MainActivity.this, String.valueOf(gpa), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this,com.example.ct_01class.resultActivity.class);
                    intent.putExtra("course1", et_name1.getText().toString());
                    intent.putExtra("course2", et_name2.getText().toString());
                    intent.putExtra("course3", et_name2.getText().toString());
                    intent.putExtra("total_cred",total_credit);
                    intent.putExtra("gpa",gpa);
                    startActivity(intent);
            }
        });

    }

    private void checkEmpty() {
        if(et_cr1.getText().toString().isEmpty()){
            et_cr1.setError("fill this please");
        }
        if(et_cr2.getText().toString().isEmpty()){
            et_cr2.setError("fill this please");
        }
        if(et_cr3.getText().toString().isEmpty()){
            et_cr3.setError("fill this please");
        }
        if(et_name1.getText().toString().isEmpty()){
            et_name1.setError("fill this please");
        }
        if(et_name2.getText().toString().isEmpty()){
            et_name2.setError("fill this please");
        }
        if(et_name3.getText().toString().isEmpty()){
            et_name3.setError("fill this please");
        }
    }

}