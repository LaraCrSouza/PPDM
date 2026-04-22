package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Intent;
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

    Button bntCalcularImc;
    ImageView imageView;

    EditText peso, altura;

    TextView imcFinal, imcClassificacao;

    Double imc, pesoF, alturaF;



    Integer imagens[] = new Integer[]{
            R.drawable.perfil,
            R.drawable.abaixopeso,
            R.drawable.normal,
            R.drawable.sobrepeso,
            R.drawable.obesidade1,
            R.drawable.obesidade2,
            R.drawable.obesidade3,
    };


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bntCalcularImc=findViewById(R.id.buttonCalcular);
        peso=findViewById(R.id.ptPeso);
        altura=findViewById(R.id.ptAltura);
        imcFinal=findViewById(R.id.imc);
        imcClassificacao=findViewById(R.id.resultado);
        imageView=findViewById(R.id.imageView);

        imageView.setImageResource(imagens[0]);

        bntCalcularImc.setOnClickListener(v -> {


            String alturaS = altura.getText().toString();
            String pesoS = peso.getText().toString();

            if(alturaS.isEmpty()){
                altura.setError("Informe um valor Minimo");
                altura.requestFocus();
                return;
            }

            if (pesoS.isEmpty()){
                peso.setError("Informe um valor Minimo");
                peso.requestFocus();
                return;
            }
            Intent intent= new Intent(getApplicationContext(), MainActivity2.class);
            String msg=pesoF.getText().toString();

            alturaF = Double.parseDouble(alturaS);
            pesoF = Double.parseDouble(pesoS);

            imc = (pesoF/(alturaF*alturaF));
            DecimalFormat dc = new DecimalFormat("##.##");

            if(imc < 18.5){
                imageView.setImageResource(imagens[1]);
                imcFinal.setText("IMC = " + dc.format(imc));
                imcClassificacao.setText("Classificação = Abaixo do Peso");
            } else if(imc >= 18.5 && imc < 24.9){
                imageView.setImageResource(imagens[2]);
                imcFinal.setText("IMC = " + dc.format(imc));
                imcClassificacao.setText("Classificação = Normal");
            } else if(imc >= 25 && imc < 29.9){
                imageView.setImageResource(imagens[3]);
                imcFinal.setText("IMC = " + dc.format(imc));
                imcClassificacao.setText("Classificação = Sobrepeso");
            } else if(imc >= 30 && imc < 34.9){
                imageView.setImageResource(imagens[4]);
                imcFinal.setText("IMC = " + dc.format(imc));
                imcClassificacao.setText("Classificação = Obesidade grau 1");
            } else if(imc >= 35 && imc < 39.9){
                imageView.setImageResource(imagens[5]);
                imcFinal.setText("IMC = " + dc.format(imc));
                imcClassificacao.setText("Classificação = Obesidade grau 2");
            } else if(imc >= 40){
                imageView.setImageResource(imagens[6]);
                imcFinal.setText("IMC = " + dc.format(imc));
                imcClassificacao.setText("Classificação = Obesidade grau 3");
            }

        });

    }
}