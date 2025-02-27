package com.example.cartavirtual;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class EntradasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entradas);

        // Vincular el ListView
        ListView lv = findViewById(R.id.nose);

        // Obtener los datos del array de strings
        String[] entradas = getResources().getStringArray(R.array.listaentradas);

        // Configurar el adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, entradas);
        lv.setAdapter(adapter);
    }
}