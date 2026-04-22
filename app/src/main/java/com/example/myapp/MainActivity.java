package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapp.R;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);

        Button button=findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Intent intent= new Intent(getApplicationContext(), com.example.myapp.ActivityB.class);
            String msg=editText.getText().toString();

            intent.putExtra("msg", msg);
            startActivity(intent);
        });

    }
}