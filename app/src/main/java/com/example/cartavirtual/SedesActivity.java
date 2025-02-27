package com.example.cartavirtual;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.cartavirtual.databinding.ActivitySedesBinding;

import java.util.ArrayList;
import java.util.List;

public class SedesActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivitySedesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySedesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private List<MarkerOptions> markerList = new ArrayList<>();

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Sede La 70 (Medellín)
        LatLng SedeLa70 = new LatLng(6.246519124928239, -75.58927732771186);
        markerList.add(new MarkerOptions()
                .position(SedeLa70)
                .title("Restaurante Arteson La 70")
                .snippet("Dirección: Cra. 70 #C3-43, Medellín\nHorario: 8:00 AM - 10:00 PM\nTeléfono: +57 310 000 00000"));

        // Sede El Poblado (Medellín)
        LatLng SedeElPoblado = new LatLng(6.209789765385485, -75.56772124301362);
        markerList.add(new MarkerOptions()
                .position(SedeElPoblado)
                .title("Restaurante Arteson Poblado")
                .snippet("Dirección: Cra. 43A #6S-15, Medellín\nHorario: 8:00 AM - 10:00 PM\nTeléfono: +57 31000000000"));

        // Sede Miami (Nueva ubicación)
        LatLng SedeMiami = new LatLng(25.7617, -80.1918); // Nueva ubicación en Miami
        markerList.add(new MarkerOptions()
                .position(SedeMiami)
                .title("Restaurante Arteson Miami")
                .snippet("Dirección: 1234 Ocean Dr, Miami, FL\nHorario: 9:00 AM - 9:00 PM\nTeléfono: +1 305 555 4235"));

        // Añadir marcadores al mapa
        for (MarkerOptions marker : markerList) {
            mMap.addMarker(marker);
        }

        // Zoom inicial a Medellín
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SedeLa70, 12));

        // Mostrar InfoWindows automáticamente al cargar el mapa
        mMap.setOnMapLoadedCallback(() -> {
            for (MarkerOptions marker : markerList) {
                mMap.addMarker(marker).showInfoWindow();
            }
        });

        // Mostrar InfoWindow al hacer clic en un marcador
        mMap.setOnMarkerClickListener(marker -> {
            marker.showInfoWindow();
            return false; // Devolver false para que también haga zoom si es necesario
        });
    }
}