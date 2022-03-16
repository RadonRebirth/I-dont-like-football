package com.example.idontlovefootbal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Integer BrazilCounter = 0;
    Integer SpainCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onClickBrazil(View view){
        BrazilCounter++;
        TextView counterBrazilView = findViewById(R.id.txt_BrazilCounter);
        counterBrazilView.setText(BrazilCounter.toString());
    }
    public void onClickSpain(View view){
        SpainCounter++;
        TextView counterSpainView = findViewById(R.id.txt_SpainCounter);
        counterSpainView.setText(SpainCounter.toString());
    }
    public void onClickReset(View view){
        BrazilCounter = 0;
        SpainCounter = 0;
        TextView counterBrazilView = findViewById(R.id.txt_BrazilCounter);
        TextView counterSpainView = findViewById(R.id.txt_SpainCounter);
        counterBrazilView.setText(BrazilCounter.toString());
        counterSpainView.setText(SpainCounter.toString());
    }
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("BrazilCount")) {
            BrazilCounter = savedInstanceState.getInt("BrazilCount");
        }
        if (savedInstanceState != null && savedInstanceState.containsKey("SpainCount")) {
            SpainCounter = savedInstanceState.getInt("SpainCount");
        }
    }
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("BrazilCount", BrazilCounter);
        outState.putInt("SpainCount", SpainCounter);
    }
    public void resetUI() {
        ((TextView) findViewById(R.id.txt_BrazilCounter)).setText(BrazilCounter.toString());
        ((TextView) findViewById(R.id.txt_SpainCounter)).setText(SpainCounter.toString());
    }
    public void onResume() {
        super.onResume();
        resetUI();
    }
}