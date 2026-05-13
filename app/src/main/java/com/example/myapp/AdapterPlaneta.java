package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterPlaneta extends ArrayAdapter<Planeta> {

    Context lcontext;

    public AdapterPlaneta(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);
        lcontext=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

//        inflar layout xml
        LayoutInflater inflater = LayoutInflater.from(lcontext);
        View itemView= inflater.inflate(R.layout.item_lista, parent, false);

//        Preencher o item da listagem na variavel view
        TextView tvNome = itemView.findViewById(R.id.textView);
        TextView tvMassa = itemView.findViewById(R.id.tvMassa);
        ImageView imageView = itemView.findViewById(R.id.imageView);
        Planeta p = getItem(position);
        tvNome.setText(p.nome);
        tvMassa.setText(p.massa);
        imageView.setImageResource(p.foto);

        return itemView;
    }
}
