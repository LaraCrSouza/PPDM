package com.example.myapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    EditText peso, altura;

    Button btnCalcular;

    double imc;

    TextView imcFinal, resultado;

    ImageView imageView;

    Integer imagens[] = new Integer[]{
            R.drawable.abaixopeso,
            R.drawable.normal,
            R.drawable.obesidade1,
            R.drawable.obesidade2,
            R.drawable.obesidade3,
            R.drawable.perfil,
            R.drawable.sobrepeso
    };

    int posicao=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular=findViewById(R.id.button);
        peso=findViewById(R.id.ptPeso);
        altura=findViewById(R.id.ptAltura);
        imcFinal=findViewById(R.id.imc);
        resultado=findViewById(R.id.resultado);
        imageView=findViewById(R.id.imageView);
        imageView.setImageResource((imagens[posicao]));

        btnCalcular.setOnClickListener(v -> {
                String srtPeso = peso.getText().toString();
                String srtAltura = altura.getText().toString();

                double peso = Double.parseDouble(srtPeso);
                double altura = Double.parseDouble(srtAltura);

                imc = peso/(altura*altura);

                DecimalFormat dc = new DecimalFormat("##.##");

                imcFinal.setText(Double.toString(imc));

        });


        String srtPeso = peso.getText().toString();
        String srtAltura = altura.getText().toString();



        Double pesoF = Double.parseDouble(srtPeso);
        Double alturaF = Double.parseDouble(srtAltura);


        if(imc<18.5){

            resultado.setText("Você está abaixo do peso");


        }

    }
}