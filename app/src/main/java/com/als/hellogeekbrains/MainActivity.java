package com.als.hellogeekbrains;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textCounter;

    private TextView textCounter1;
    private Button button1, button3, button4;

    private String tv0Tag = "tv0Tag";
    private String tv1Tag = "tv1Tag";

    private String PARCEBLE_TAG = "PARCEBLE_TAG";

    private Counters counters = new Counters();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        textCounter = findViewById(R.id.textView1);
        textCounter1 = findViewById(R.id.textView2);
        button1 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        initOnClickListeners();
    }

    private void initOnClickListeners() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counters.setCounter1(counters.getCounter1() + 1);
                textCounter1.setText(String.valueOf(counters.getCounter1()));
            }
        });
        button3.setOnClickListener(this);
        button4.setOnClickListener(on4click);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putParcelable(PARCEBLE_TAG, counters);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        counters = instanceState.getParcelable(PARCEBLE_TAG);
        textCounter.setText(String.valueOf(counters.getCounter()));
        textCounter1.setText(String.valueOf(counters.getCounter1()));
    }

    private View.OnClickListener on4click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            makeToast();
        }
    };

    private void makeToast() {
        Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
    }

    public void button1_onClick(View v) {
        counters.setCounter(counters.getCounter() + 1);
        textCounter.setText(String.valueOf(counters.getCounter()));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button3) {
            Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
        }
    }
}
