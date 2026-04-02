package com.example.myapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button bntAvancar, bntVoltar;
    ImageView imageView;
    Integer imagens[] = new Integer[]{
            R.drawable.cachorro,
            R.drawable.gardem,
            R.drawable.patinho,
            R.drawable.happy,
            R.drawable.porquinho
    };

    int posicao=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bntVoltar=findViewById(R.id.buttonVoltar);
        bntAvancar=findViewById(R.id.buttonAvancar);
        imageView=findViewById(R.id.imageView);
        imageView.setImageResource((imagens[posicao]));

        bntAvancar.setOnClickListener(v -> {

            if(posicao == imagens.length-1) {
                posicao = 0;
            } else{
                posicao++;
            }
            imageView.setImageResource(imagens[posicao]);
        });
        bntVoltar.setOnClickListener(v -> {

            posicao--;

            if(posicao < 0 ) {
                posicao = imagens.length-1;
            }
            imageView.setImageResource(imagens[posicao]);
        });
    }
}