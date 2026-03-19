package com.example.myapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button b ;
    EditText edMin, edMax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.tv);
        b = findViewById(R.id.button);
        edMin=findViewById(R.id.edMin);
        edMax=findViewById(R.id.edMax);

        b.setOnClickListener(v -> {
            String minStr = edMin.getText().toString();
            String maxStr = edMax.getText().toString();
            if(minStr.isEmpty()){
                edMin.setError("Informe o valor minimo");
                return;
            }
            if (maxStr.isEmpty()){
                edMax.setError("Informe o valor máximo");
                return;
            }

            int min= Integer.parseInt(minStr);
            int max= Integer.parseInt(maxStr);

            Random random = new Random();
            int r = random.nextInt(min,max);
            tv.setText(Integer.toString(r));
        });
    }
}