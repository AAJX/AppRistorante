package com.adrianomari.googlemapapplication;

import android.Manifest;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button b = findViewById(R.id.bottone1);

        final EditText citta = findViewById(R.id.editText);



        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (citta.getText().toString().equals("milano")){



                LatLng mimmo = new LatLng(45.499345, 9.156686);
                LatLng lino = new LatLng(45.502788, 9.18146);
                LatLng ennio = new LatLng(45.492908, 9.184324);
                LatLng paolo = new LatLng(45.504051, 9.190858);

                mMap.addMarker(new MarkerOptions().position(mimmo).title("Ristorante Da Mimmo")
                        .snippet("Viale Dei Pioppi 38").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                mMap.addMarker(new MarkerOptions().position(lino).title("Ristorante Da Lino")
                        .snippet("Via Carlo Imbonati 52").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                mMap.addMarker(new MarkerOptions().position(ennio).title("Ristorante Da Ennio")
                        .snippet("Via Carlo Farini 63").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                mMap.addMarker(new MarkerOptions().position(paolo).title("Ristorante Da Paolo")
                        .snippet("Via Antonio Calderoni 2").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                CameraPosition cameraPosition = new CameraPosition.Builder().target(mimmo).zoom(13).build();

                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                } else

                if(citta.getText().toString().equals("torino")){
                    LatLng torino = new LatLng(45.072464 ,7.69383);
                    LatLng alfio = new LatLng(45.06819 , 7.686535);
                    LatLng luca = new LatLng(45.064674 , 7.686384);
                    LatLng enzo = new LatLng(45.060946 , 7.698293);
                    LatLng stefano = new LatLng(45.075373 , 7.699066);
                    mMap.addMarker(new MarkerOptions().position(torino).title("TORINO")
                            .snippet("").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                    mMap.addMarker(new MarkerOptions().position(alfio).title("Ristorante Da Alfio")
                            .snippet("Via Principe Amedeo 9").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                    mMap.addMarker(new MarkerOptions().position(luca).title("Ristorante Da Luca")
                            .snippet("Via S. Francesco da Paola 19").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                    mMap.addMarker(new MarkerOptions().position(enzo).title("Ristorante Da Enzo")
                            .snippet("Via Vittorio Amedeo Gioanetti 7").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                    mMap.addMarker(new MarkerOptions().position(stefano).title("Ristorante Da Stefano")
                            .snippet("Corso Verona 46").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(torino).zoom(13).build();

                    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                } else


                    if (citta.getText().toString().equals("venezia")) {
                    LatLng venezia = new LatLng(45.440847 , 12.315515);
                    LatLng betti = new LatLng(45.435548 , 12.320751);
                    LatLng veniceHotel = new LatLng(45.434463 , 12.325643);
                    LatLng lola = new LatLng(45.43615 , 12.343582);
                    LatLng gina = new LatLng(45.440968 , 12.342895);
                    mMap.addMarker(new MarkerOptions().position(venezia).title("VENEZIA")
                            .snippet("").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                    mMap.addMarker(new MarkerOptions().position(betti).title("Ristorante Da Betti")
                            .snippet("Fondamenta Cazziola 2482").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                    mMap.addMarker(new MarkerOptions().position(veniceHotel).title("Grand Hotel Venice")
                            .snippet("Sestiere Dorsoduro 3467").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                    mMap.addMarker(new MarkerOptions().position(lola).title("Ristorante Da Lola")
                            .snippet("Fondamenta S. Severo 5018").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                    mMap.addMarker(new MarkerOptions().position(gina).title("Ristorante Da Gina")
                            .snippet("Fondamenta Mendicanti 30122").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(venezia).zoom(13).build();

                    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                }
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng milano = new LatLng(45.500951, 9.174935);



        mMap.addMarker(new MarkerOptions().position(milano).title("MILANO")
                .snippet("").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));



        CameraPosition cameraPosition = new CameraPosition.Builder().target(milano).zoom(12).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));



        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

    }


}
