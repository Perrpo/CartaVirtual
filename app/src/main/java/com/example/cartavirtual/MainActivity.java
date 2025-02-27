package com.example.cartavirtual;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void consultarSedes(View v) {
        Intent i = new Intent(this, SedesActivity.class);
        startActivity(i);
    }

    public void verMenu(View v) {
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }

    public void realizarReserva(View v) {
        // Número de teléfono y mensaje predefinido
        String phone = "+573113873691"; // Reemplaza con el número de WhatsApp del restaurante
        String message = "Hola, deseo hacer una reserva con ustedes.";

        // Crear el intent para abrir WhatsApp usando wa.me
        String url = "https://wa.me/" + phone + "?text=" + Uri.encode(message);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        // Verificar si hay una aplicación que pueda manejar el intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // Si no hay una aplicación que pueda manejar el intent, mostrar un mensaje al usuario
            Toast.makeText(this, "No se puede abrir WhatsApp.", Toast.LENGTH_SHORT).show();
        }
    }
}