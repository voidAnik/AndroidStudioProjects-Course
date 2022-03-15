package com.example.mid_problem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class prev_sms extends AppCompatActivity {
    String name,sms,number;
    TextView tv_from,tv_to,tv_operator,tv_sms;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prev_sms);
        tv_from = findViewById(R.id.tv_from);
        tv_to = findViewById(R.id.tv_to);
        tv_operator = findViewById(R.id.tv_operator);
        tv_sms = findViewById(R.id.tv_sms);
        btn_send = findViewById(R.id.btn_send);

        name = getIntent().getStringExtra("name");
        sms = getIntent().getStringExtra("sms");
        number = getIntent().getStringExtra("number");

        tv_from.setText("From: "+ name);
        tv_to.setText("To: "+ number);
        /*tv_operator.setVisibility(View.INVISIBLE);*/
        tv_sms.setText(sms);
        String operator =number.substring(0,3);
       switch (operator) {
            case "019":
                tv_operator.setText("Operator:" + "Banglalink");
                break;
            case "017":
                tv_operator.setText("Operator:" + "GP");
                break;
            case "018":
                tv_operator.setText("Operator:" + "Robi");
                break;
            case "016":
                tv_operator.setText("Operator:" + "Airtel");
                break;
            default:
                break;
        }

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(prev_sms.this,com.example.mid_problem.MainActivity.class);
                startActivity(intent2);
            }
        });

    }
}