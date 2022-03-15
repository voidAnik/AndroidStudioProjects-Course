package com.example.temperatureconverter;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Double temp,result;
    Button btn_convert;
    ImageView iv;
    EditText et_temp;
    TextView tv_result,tv_s,tv_histo;
    ArrayList<String> results;
    DecimalFormat df = new DecimalFormat("#.###");
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        results = new ArrayList<String>();

        //Title show in middle
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        //Show icon in action bar
        /*ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);*/

        btn_convert = findViewById(R.id.btn_convert);
        iv = findViewById(R.id.iv_th);
        et_temp = findViewById(R.id.et_temp);
        tv_result = findViewById(R.id.tv_result);
        tv_s = findViewById(R.id.tv_s);
        tv_histo = findViewById(R.id.tv_histo);

        loadHistory();

        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    temp = Double.parseDouble(et_temp.getText().toString());

                    result = (temp-32) / (9f /5);
                    result = Double.parseDouble(df.format(result));
                    Toast.makeText(MainActivity.this,"Result calculated",Toast.LENGTH_SHORT).show();
                    tv_result.setText("The Temperature in Celsius is " + result + "°C.");
                    results.add(+temp+"°F = " + result +"°C");
                    tv_histo.setText(getString(R.string.history_n));
                    for(int i = 0; i < results.size(); i++){
                        tv_histo.append((i+1) + ". "+results.get(i) + "\n");
                    }
                    tv_histo.setMovementMethod(new ScrollingMovementMethod());

                    if(result <=20)
                    {
                        iv.setImageResource(R.drawable.th_2);
                        tv_s.setTextColor(getResources().getColor(R.color.th2));
                        et_temp.setTextColor(getResources().getColor(R.color.th2));
                        /*btn_convert.setTextColor(getResources().getColor(R.color.th2));*/
                        btn_convert.setBackgroundColor(getResources().getColor(R.color.th2));
                        tv_result.setTextColor(getResources().getColor(R.color.th2));

                    }
                    else if(result > 20 && result <=30)
                    {
                        iv.setImageResource(R.drawable.th_3);
                        tv_s.setTextColor(getResources().getColor(R.color.th3));
                        et_temp.setTextColor(getResources().getColor(R.color.th3));
                        /*btn_convert.setTextColor(getResources().getColor(R.color.th3));*/
                        btn_convert.setBackgroundColor(getResources().getColor(R.color.th3));
                        tv_result.setTextColor(getResources().getColor(R.color.th3));
                    }
                    if(result > 30 && result <=40)
                    {
                        iv.setImageResource(R.drawable.th_4);
                        tv_s.setTextColor(getResources().getColor(R.color.th4));
                        et_temp.setTextColor(getResources().getColor(R.color.th4));
                        /*btn_convert.setTextColor(getResources().getColor(R.color.th4));*/
                        btn_convert.setBackgroundColor(getResources().getColor(R.color.th4));
                        tv_result.setTextColor(getResources().getColor(R.color.th4));
                    }
                    if(result > 40 && result <=50)
                    {
                        iv.setImageResource(R.drawable.th_5);
                        tv_s.setTextColor(getResources().getColor(R.color.th5));
                        et_temp.setTextColor(getResources().getColor(R.color.th5));
                        /*btn_convert.setTextColor(getResources().getColor(R.color.th5));*/
                        btn_convert.setBackgroundColor(getResources().getColor(R.color.th5));
                        tv_result.setTextColor(getResources().getColor(R.color.th5));
                    }
                    if(result > 50 && result <=70)
                    {
                        iv.setImageResource(R.drawable.th_7);
                        tv_s.setTextColor(getResources().getColor(R.color.th7));
                        et_temp.setTextColor(getResources().getColor(R.color.th7));
                        /*btn_convert.setTextColor(getResources().getColor(R.color.th7));*/
                        btn_convert.setBackgroundColor(getResources().getColor(R.color.th7));
                        btn_convert.setBackgroundColor(getResources().getColor(R.color.th7));
                        tv_result.setTextColor(getResources().getColor(R.color.th7));
                    }
                    if(result > 70 && result <=80)
                    {
                        iv.setImageResource(R.drawable.th_8);
                        tv_s.setTextColor(getResources().getColor(R.color.th8));
                        et_temp.setTextColor(getResources().getColor(R.color.th8));
                        /*btn_convert.setTextColor(getResources().getColor(R.color.th8));*/
                        btn_convert.setBackgroundColor(getResources().getColor(R.color.th8));
                        tv_result.setTextColor(getResources().getColor(R.color.th8));
                    }
                    if(result > 80 && result <=90)
                    {
                        iv.setImageResource(R.drawable.th_9);
                        tv_s.setTextColor(getResources().getColor(R.color.th9));
                        et_temp.setTextColor(getResources().getColor(R.color.th9));
                        /*btn_convert.setTextColor(getResources().getColor(R.color.th9));*/
                        btn_convert.setBackgroundColor(getResources().getColor(R.color.th9));
                        tv_result.setTextColor(getResources().getColor(R.color.th9));
                    }
                    if(result > 90)
                    {
                        iv.setImageResource(R.drawable.th_10);
                        tv_s.setTextColor(getResources().getColor(R.color.th10));
                        et_temp.setTextColor(getResources().getColor(R.color.th10));
                        /*btn_convert.setTextColor(getResources().getColor(R.color.th10));*/
                        btn_convert.setBackgroundColor(getResources().getColor(R.color.th10));
                        tv_result.setTextColor(getResources().getColor(R.color.th10));
                    }
                    }catch (Exception e){
                        Toast.makeText(MainActivity.this,"Give a temperature input.",Toast.LENGTH_SHORT).show();
                    }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.clear){
            try{
                FileOutputStream file = openFileOutput("history.txt",MODE_PRIVATE);
                OutputStreamWriter outputFile = new OutputStreamWriter(file);
                outputFile.write("");
                outputFile.flush();
                outputFile.close();
                results.clear();
                tv_histo.setText(getString(R.string.history_n));
            }catch (Exception e){
                Log.e("Exception","File write failed");
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadHistory() {
        results.clear();
        File file = getApplicationContext().getFileStreamPath("history.txt");
        String lineFromline;
        if(file.exists()){
            tv_histo.setText(getString(R.string.history_n));
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput("history.txt")));
                while((lineFromline = reader.readLine()) != null){
                    results.add(lineFromline);
                }
                reader.close();
                for(int i = 0; i < results.size(); i++){
                    tv_histo.append((i+1) + ". "+results.get(i)+ "\n");
                }
            }catch (Exception e){
                Log.e("Exception","File read failed");
            }
        }


    }

    @Override
    protected void onDestroy() {
        saveHistory();
        super.onDestroy();
    }

    private void saveHistory() {
        try{
            FileOutputStream file = openFileOutput("history.txt",MODE_PRIVATE);
            OutputStreamWriter outputFile = new OutputStreamWriter(file);
            for(int i = 0; i < results.size(); i++){
                outputFile.write(results.get(i));
                //tv_histo.append((i+1) + ". "+results.get(i));
            }
            outputFile.flush();
            outputFile.close();
        }catch (Exception e){
            Log.e("Exception","File write failed");
        }
    }
}