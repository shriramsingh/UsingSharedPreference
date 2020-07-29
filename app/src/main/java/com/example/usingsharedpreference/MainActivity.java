package com.example.usingsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    private int counter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.txtDisplay);

        loadData();
    }

    public void btn_action(View view) {
        counter++;
        textView.setText(String.valueOf(counter));
    }

    public void saveData(){
        SharedPreferences sharedPreferences=getSharedPreferences("saveconnter",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("counter",counter);
        editor.apply();

    }

    public void loadData(){
        SharedPreferences sharedPreferences=getSharedPreferences("saveconnter",MODE_PRIVATE);
        counter=sharedPreferences.getInt("counter",MODE_PRIVATE);
        textView.setText(String.valueOf(counter));


    }

    @Override
    protected void onPause() {
        super.onPause();

        saveData();
    }


}