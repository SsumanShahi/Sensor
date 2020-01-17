package com.suman.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AccelerometerActivity extends AppCompatActivity {

    private TextView tvShowAxis;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        setTitle("Accelerometer Sensor");

        tvShowAxis = findViewById(R.id.tvShowAxis);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener sel = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float[] values = event.values;
                String xAxis = "x :" + + values[0]+ "\n";
                String yAxis = "y :" + + values[1]+ "\n";
                String zAxis = "z :" + + values[2]+ "\n";

                tvShowAxis.setText(xAxis + "" + yAxis + "" + zAxis);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        if(sensor !=null)
        {
            sensorManager.registerListener(sel,sensor,SensorManager.SENSOR_DELAY_NORMAL);

        }
        else
        {
            Toast.makeText(this, "No sensor found", Toast.LENGTH_LONG).show();
        }
    }
}
