package com.example.assignment_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity2 extends AppCompatActivity {
    ImageButton ib_smile,ib_sad,ib_neutral;
    EditText et_name,et_phone,et_web,et_address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ib_smile = findViewById(R.id.ib_smile);
        ib_sad = findViewById(R.id.ib_sad);
        ib_neutral = findViewById(R.id.ib_neutral);
        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        et_web = findViewById(R.id.et_web);
        et_address = findViewById(R.id.et_address);

        ib_smile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createInfo(1);
            }
        });
        ib_sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createInfo(2);
            }
        });
        ib_neutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createInfo(3);
            }
        });
    }

    private void createInfo(int emoId) {
        if(et_name.getText().toString().isEmpty()){
            et_name.setError("Can't be blank. Type your name please!");
            return;
        }
        if(et_phone.getText().toString().isEmpty()){
            et_phone.setError("Can't be blank. Type your phone number please!");
            return;
        }
        if(et_web.getText().toString().isEmpty()){
            et_web.setError("Can't be blank. Type your web address please!");
            return;
        }
        if(et_address.getText().toString().isEmpty()){
            et_address.setError("Can't be blank. Type your Home address please!");
            return;
        }
        Intent intent = new Intent(MainActivity2.this,com.example.assignment_intent.MainActivity3.class);
        intent.putExtra("name",et_name.getText().toString());
        intent.putExtra("phone",et_phone.getText().toString());
        intent.putExtra("web",et_web.getText().toString());
        intent.putExtra("address",et_address.getText().toString());
        intent.putExtra("emo",emoId);
        startActivity(intent);

    }
}