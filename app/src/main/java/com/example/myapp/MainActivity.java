package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String nomes[] = new String[]{"Daniel", "Sophia", "Prancha", "Davi", "Iran", "Fernandinho", "Borracha"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this, //contexto
                android.R.layout.simple_list_item_1, //recurso do layout xml
                android.R.id.text1, //id do textView interno no layout
                nomes //Array de String DataSource
        );
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent= new Intent(getApplicationContext(), MainActivity2.class);
            //Acrecsentar o dado do nome na intenção

            intent.putExtra("nome", nomes[position]); // "nome", valor
            startActivity(intent);
        });
    }
}