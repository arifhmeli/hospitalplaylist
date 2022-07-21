package com.myapplication.findhospital;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.myapplication.findhospital.databinding.ActivityMapsBinding;

public class Maps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
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

        enableMyLocation();

        // Add a marker in Sydney and move the camera
        LatLng clinic1 = new LatLng(6.4409, 100.1914);
        LatLng clinic2 = new LatLng(6.4026, 100.1390);
        LatLng clinic3 = new LatLng(6.4332, 100.1865);
        LatLng clinic4 = new LatLng(6.3960, 100.1331);
        LatLng clinic5 = new LatLng(6.3975, 100.1342);
        LatLng clinic6 = new LatLng(6.4219, 100.1975);
        LatLng clinic7 = new LatLng(6.4231, 100.1973);
        LatLng clinic8 = new LatLng(6.4362, 100.1883);
        LatLng clinic9 = new LatLng(6.4370, 100.1905);
        LatLng clinic10 = new LatLng(6.4385, 100.1944);
        LatLng clinic11 = new LatLng(6.4394, 100.1961);
        LatLng clinic12 = new LatLng(6.4397, 100.1905);
        LatLng clinic13 = new LatLng(6.4368, 100.1943);
        LatLng clinic14 = new LatLng(6.4368, 100.1939);
        LatLng clinic15 = new LatLng(6.4363, 100.1939);


        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);

        mMap.addMarker(new MarkerOptions().position(clinic1).title("Hospital Tuanku Fauziah").snippet("04-973 8000"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(clinic1));
        mMap.addMarker(new MarkerOptions().position(clinic2).title("Poliklinik Penawar").snippet("04-985 2372"));;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(clinic2));
        mMap.addMarker(new MarkerOptions().position(clinic3).title("KPJ Perlis Special").snippet("04-985 2372"));;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(clinic3));
        mMap.addMarker(new MarkerOptions().position(clinic4).title("Klinik Megah").snippet("04-997 4257"));;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(clinic4));
        mMap.addMarker(new MarkerOptions().position(clinic5).title("Klinik Kesihatan Kuala Perlis").snippet("04-985 4259"));;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(clinic5));
        mMap.addMarker(new MarkerOptions().position(clinic6).title("Annura Clinic").snippet("04-976 7878"));;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(clinic6));
        mMap.addMarker(new MarkerOptions().position(clinic7).title("Poliklinik Dr. Azhar dan Rakan-rakan").snippet("04-970 4146"));;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(clinic7));
        mMap.addMarker(new MarkerOptions().position(clinic8).title("Remedic Clinic Kangar").snippet("04-977 3118"));;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(clinic8));
        mMap.addMarker(new MarkerOptions().position(clinic9).title("Klinik Ehsan").snippet("04-976 4408"));;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(clinic9));
        mMap.addMarker(new MarkerOptions().position(clinic10).title("Klinik Tan & Lee").snippet("04-976 8389"));;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(clinic10));
        mMap.addMarker(new MarkerOptions().position(clinic11).title("Klinik Faizah Kangar").snippet("04-976 7366"));;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(clinic11));
        mMap.addMarker(new MarkerOptions().position(clinic12).title("Klinik Kesihatana Kangar").snippet("04-977 9043"));;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(clinic12));
        mMap.addMarker(new MarkerOptions().position(clinic13).title("Qualitas Health Clinic").snippet("04-976 1457"));;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(clinic13));
        mMap.addMarker(new MarkerOptions().position(clinic14).title("Poliklinik Chong").snippet("04-977 9668"));;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(clinic14));
        mMap.addMarker(new MarkerOptions().position(clinic15).title("Klinik Dr. Haji Othman").snippet("04-976 4622"));;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(clinic15));

        mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
            }
        } else {
            String perms[] = {"android.permission.ACCESS_FINE_LOCATION"};
            // Permission to access the location is missing. Show rationale and request permission
            ActivityCompat.requestPermissions(this, perms,200);
        }
    }
}