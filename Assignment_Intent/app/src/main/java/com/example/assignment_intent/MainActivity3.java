package com.example.assignment_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    Button create_btn;
    ImageView emo;
    ImageButton dial_btn,web_btn,map_btn;
    TextView tv_feel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        create_btn = findViewById(R.id.create_btn);
        emo = findViewById(R.id.iv_selected);
        dial_btn = findViewById(R.id.dial_btn);
        web_btn = findViewById(R.id.web_btn);
        map_btn = findViewById(R.id.map_btn);
        tv_feel = findViewById(R.id.tv_feel);

        String name = getIntent().getStringExtra("name");
        final String phone = getIntent().getStringExtra("phone");
        final String web = getIntent().getStringExtra("web");
        final String map = getIntent().getStringExtra("address");
        int emoId = getIntent().getIntExtra("emo",0);

        switch (emoId){ //Setting feeling emo
            case 1:
               emo.setImageResource(R.drawable.smile);
                break;
            case 2:
                emo.setImageResource(R.drawable.sad);
                break;
            case 3:
                emo.setImageResource(R.drawable.neutral);
                break;
        }
        tv_feel.setText("Feelings of " + "'" + name + "'");

        //Dialing
        dial_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                startActivity(intent);
            }
        });
        //Opening web address
        web_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + web));
                startActivity(intent);
            }
        });
        //Opening map
        map_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0, 0?q=" + map));
                startActivity(intent);
            }
        });

        //Going to second activity to create contact again
        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this,com.example.assignment_intent.MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}