package qz3282.egci428.com.quiz;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

import java.util.List;

public class Mapsnewroute extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    SensorManager sensorManager;
    Sensor sensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapsnewroute);

        Button b = (Button) findViewById(R.id.back);
        assert b != null;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mapsnewroute.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ImageButton flag = (ImageButton) findViewById(R.id.imageButton);
        assert flag != null;
        flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mapsnewroute.this, MainActivity.class);
                startActivity(intent);
            }
        });
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);



    }


    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(13.7934,100.3225);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Thailand"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void onResume() { super.onResume();
        sensorManager.registerListener(accelListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void onStop() { super.onStop();
        sensorManager.unregisterListener(accelListener); }
    SensorEventListener accelListener = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int acc) {
        }

        public void onSensorChanged(SensorEvent event) {


        }
    };

}
