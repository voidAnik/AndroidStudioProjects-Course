package com.example.mid_problem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_name,et_sms,et_number;
    Button btn_prev_sms;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.et_name);
        et_sms = findViewById(R.id.et_sms);
        et_number = findViewById(R.id.et_number);
        btn_prev_sms = findViewById(R.id.btn_prev_sms);

        btn_prev_sms.setOnClickListener(new View.OnClickListener() {
            String name,number,sms;

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,com.example.mid_problem.prev_sms.class);
                name = et_name.getText().toString();
                number = et_number.getText().toString();
                sms = et_sms.getText().toString();
                if(et_name.getText().toString().isEmpty() || et_name.getText().toString().isEmpty() || et_name.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                }
              /*  }else{
                    intent.putExtra("name",et_name.getText().toString().trim());
                }
                if(et_name.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Type your massage!",Toast.LENGTH_SHORT).show();
                }else{
                    intent.putExtra("sms",et_sms.getText().toString().trim());
                }
                if(et_name.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Give the recipient's number please!",Toast.LENGTH_SHORT).show();
                }else{
                    intent.putExtra("name",et_number.getText().toString().trim());
                }

                if(!et_name.getText().toString().isEmpty() && !et_number.getText().toString().isEmpty() && !et_sms.getText().toString().isEmpty()){
                    startActivity(intent);
                }*/
              if(et_number.getText().toString().length() !=11)
              {
                  Toast.makeText(MainActivity.this, "Number must be 11 digit", Toast.LENGTH_SHORT).show();
              }
              else{
                    intent.putExtra("name",name);
                    intent.putExtra("number",number);
                    intent.putExtra("sms",sms);
                    startActivity(intent);

                    }


            }
        });
    }
}