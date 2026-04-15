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

public class ActivityB extends AppCompatActivity {
    Button botaoFinish;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        tv.findViewById(R.id.tvActivityB);
        Intent i=getIntent();
        Bundle b=i.getExtras();
        String msg = b.getString("msg");
        tv.setText(msg);

        botaoFinish=findViewById(R.id.btnFechar);
        botaoFinish.setOnClickListener(v -> {
            finish();
        });

    }
}