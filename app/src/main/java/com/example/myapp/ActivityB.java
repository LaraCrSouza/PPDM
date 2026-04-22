package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapp.R;

public class ActivityB extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_b);

        Button bfechar = findViewById(R.id.button_finish);
        textView=findViewById(R.id.tvMsg);

        String txt= getIntent().getExtras().getString("msg");
        textView.setText(txt);



        bfechar.setOnClickListener(v -> {
            finish();
        });
    }
}