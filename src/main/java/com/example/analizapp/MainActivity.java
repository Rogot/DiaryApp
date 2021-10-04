package com.example.analizapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button openDir_button;
    private Button fillDir_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openDir_button = (Button) findViewById(R.id.openDir);
        fillDir_button = (Button) findViewById(R.id.fillDir);
    }

    public void openDiary(View view) {
        Intent diaryIntent = new Intent(MainActivity.this, OpenDiaryActivity.class);
        startActivity(diaryIntent);
    }

    public void openFillDiary(View view) {
        Intent fillIntent = new Intent(MainActivity.this, FillActivity.class);
        startActivity(fillIntent);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

}