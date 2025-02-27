package com.example.cartavirtual;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Vincular el ListView
        ListView lv = findViewById(R.id.listamenu);
        String[] Categorias = new String[]{"Entrada", "Platos Fuertes", "Bebidas", "Postres", "Licores"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Categorias);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i;

        switch (position) {
            case 0:
                i = new Intent(this, EntradasActivity.class);
                startActivity(i);
                break;
            case 1:
                i = new Intent(this, PlatosActivity.class);
                startActivity(i);
                break;
            case 2:
                i = new Intent(this, BebidasActivity.class);
                startActivity(i);
                break;
            case 3:
                i = new Intent(this, PostresActivity.class);
                startActivity(i);
                break;
            case 4:
                i = new Intent(this, LicoresActivity.class);
                startActivity(i);
                break;
        }
    }
}