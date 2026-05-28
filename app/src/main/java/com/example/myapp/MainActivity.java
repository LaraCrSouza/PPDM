package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;
    ListView lv;

    EditText editText;

    ImageButton button;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        sqLiteDatabase = openOrCreateDatabase("notas", MODE_PRIVATE, null);

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, nota TEXT)");
        listagem();

        button = findViewById(R.id.button);
        editText = findViewById(R.id.ed);
        button.setOnClickListener(v -> {
            ContentValues contentValues = new ContentValues();
            contentValues.put("titulo", editText.getText().toString());
            contentValues.put("nota", editText.getText().toString());
            sqLiteDatabase.insert("notas", null, contentValues);
            listagem();
        });
    }

    public void listagem() {
        Cursor c = sqLiteDatabase.rawQuery("SELECT id, titulo, nota FROM notas", null);
        c.moveToFirst(); //movimenta o ponteiro do cursor para o primeiro registro recuperado
        ArrayList<Nota> listaNotas = new ArrayList<>();

        while (!c.isAfterLast()) {

            @SuppressLint("Range") int id = c.getInt(c.getColumnIndex("id"));
            @SuppressLint("Range") String titulo = c.getString(c.getColumnIndex("titulo"));
            @SuppressLint("Range") String nota = c.getString(c.getColumnIndex("nota"));
            Nota n = new Nota(id, titulo, nota);
            listaNotas.add(n);
            Log.d("SELECT", Integer.toString(id) + "," + titulo + "," + nota);

            c.moveToNext();
        }

        ListView lv = findViewById(R.id.listview);
        ArrayList<String> listaTitulos = new ArrayList<>();
        for (Nota nota : listaNotas) {
            listaTitulos.add(nota.titulo);
        }

//        exibindo no listview
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listaTitulos);
        lv.setAdapter(adapter);
    }
}