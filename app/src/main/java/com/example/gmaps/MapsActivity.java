package com.example.gmaps;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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

        double LatStart = -0.9019480999999855;
        double LngStart = 119.91211878220886;
        double LatEnd = -0.8994417770929647;
        double LngEnd = 119.89867381758697;

        // Add a marker in Untad and move the camera
        LatLng DirgaHouse = new LatLng(LatStart, LngStart);
        LatLng BnsVeteran = new LatLng(LatEnd, LngEnd);

        mMap.addPolyline(new PolylineOptions().add(
            DirgaHouse,
                new LatLng(-0.9018368021152199, 119.91097482009103),
                new LatLng(-0.9021559454325041, 119.91092922252204),
                new LatLng(-0.9020553750620164, 119.90994887514029),
                new LatLng(-0.9021090125926692, 119.90960957571586),
                new LatLng(-0.9015176587706719, 119.90948485297623),
                new LatLng(-0.9017845055152373, 119.9082349435953),
                new LatLng(-0.9018622799421219, 119.9074101643095),
                new LatLng(-0.9017375726719291, 119.90714999003349),
                new LatLng(-0.9010496711981619, 119.90661354821846),
                new LatLng(-0.9004328393537729, 119.90604491988954),
                new LatLng(-0.8998079617725816, 119.90531938236403),
                new LatLng(-0.898886736479527, 119.90423174662581),
                new LatLng(-0.8986855955436853, 119.90397023121275),
                new LatLng(-0.8981478787555636, 119.90328090352202),
                new LatLng(-0.8983597472268784, 119.90245478314209),
                new LatLng(-0.8985085915241001, 119.90206049842256),
                new LatLng(-0.8989430637453396, 119.90106807997773),
                new LatLng(-0.8994606663296252, 119.89965455586302),
                new LatLng(-0.8995518423882789, 119.89941047591884),
                new LatLng(-0.8996108012831889, 119.89910741019143),
                new LatLng(-0.8996322987403695, 119.89899071019737),
                new LatLng(-0.8996443671928619, 119.89867555065298),
                new LatLng(-0.8994417770929647, 119.89867381758697),
                BnsVeteran).width(10).color(Color.BLUE)
        );

        mMap.addMarker(new MarkerOptions().position(DirgaHouse).title("Dirga House").snippet("Rumahku").icon(bitmapDescriptorFromImage(getApplicationContext(), R.mipmap.ic_launcher_round)));
        mMap.addMarker(new MarkerOptions().position(BnsVeteran).title("BNSMart").snippet("BNSMart Veteran").icon(bitmapDescriptorFromImage(getApplicationContext(), R.drawable.ic_baseline_store_24)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DirgaHouse, 13.5f));

        //Menghitung Jarak Antar Titik
        float[] results = new float[1];
        Location.distanceBetween(LatStart,LngStart,LatEnd,LngEnd, results);
        float distance = results[0];

        int kilometer = (int) (distance/1000);
        Toast.makeText(this, String.valueOf(kilometer)+"Km.", Toast.LENGTH_LONG).show();
    }

    private BitmapDescriptor bitmapDescriptorFromImage(Context context,int ImageResId)
    {
        Drawable imageDrawable = ContextCompat.getDrawable(context, ImageResId);
        imageDrawable.setBounds(0,0,imageDrawable.getIntrinsicWidth(),imageDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(imageDrawable.getIntrinsicWidth(),imageDrawable.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        imageDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }


    
}