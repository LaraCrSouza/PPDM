package com.example.myapp;

import java.util.ArrayList;

public class PlanetaDAO {

    ArrayList<Planeta> listaPlanetas;
    public PlanetaDAO() {
        listaPlanetas=new ArrayList<>();
        listaPlanetas.add(new Planeta("Mercurio" , R.drawable.mercury,"3,285x10^23kg"));
        listaPlanetas.add(new Planeta("Venus" ,R.drawable.venus, "4,867x10^24kg"));
        listaPlanetas.add(new Planeta("Terra" , R.drawable.earth,"5,972x10^24kg"));
        listaPlanetas.add(new Planeta("Marte" , R.drawable.mars, "6,39x10^23kg"));
        listaPlanetas.add(new Planeta("Jupiter" , R.drawable.jupter, "1,898x10^27kg"));
        listaPlanetas.add(new Planeta("Saturno" , R.drawable.saturn, "5,683x10^26kg"));
        listaPlanetas.add(new Planeta("Urano" , R.drawable.uranus, "8,681x10^25kg"));
        listaPlanetas.add(new Planeta("Netuno" , R.drawable.neptune, "1,024x10^26kg"));
    }
    public ArrayList<Planeta> getPlanetas(){
        return listaPlanetas;
    }
}
