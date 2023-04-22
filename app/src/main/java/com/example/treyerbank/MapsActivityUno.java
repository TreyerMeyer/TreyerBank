package com.example.treyerbank;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.treyerbank.databinding.ActivityMapsUnoBinding;

public class MapsActivityUno extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsUnoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsUnoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Agregamos los marcadores de las sucursales y el movimiento de la camara
        LatLng sucursalUno = new LatLng(20.65, -103.40);
        mMap.addMarker(new MarkerOptions().position(sucursalUno).title("TreyerBank Plaza del Sol"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sucursalUno));
        mMap.setContentDescription("TreyerBank");

        LatLng sucursalDos = new LatLng(20.67, -103.34);
        mMap.addMarker(new MarkerOptions().position(sucursalDos).title("TreyerBank Centro"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sucursalDos));

        LatLng sucursalTres = new LatLng(20.59, -103.46);
        mMap.addMarker(new MarkerOptions().position(sucursalTres).title("TreyerBank Palomar"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sucursalTres));

        LatLng sucursalCuatro = new LatLng(20.62, -103.32);
        mMap.addMarker(new MarkerOptions().position(sucursalCuatro).title("TreyerBank Tlaquepaque"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sucursalCuatro));

        LatLng sucursalCinco = new LatLng(20.72, -103.39);
        mMap.addMarker(new MarkerOptions().position(sucursalCinco).title("TreyerBank Zapopan"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sucursalCinco));

        //Envio el mensaje de Bienvenida
        Toast.makeText(this, "Selecciona la sucursal TreyerBank de tu preferencia", Toast.LENGTH_LONG).show();
    }
}