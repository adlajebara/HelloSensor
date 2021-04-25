package com.example.adlas_compass_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements SensorEventListener {

    private Button compassButton;
    private TextView xValue, yValue, zValue;
    private SensorManager sensorManager;
    private Sensor accelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(MainActivity2.this, accelerometer, sensorManager.SENSOR_DELAY_NORMAL);

        xValue = findViewById(R.id.x_view);
        yValue = findViewById(R.id.y_view);
        zValue = findViewById(R.id.z_view);

        compassButton = findViewById(R.id.compassButton);
        compassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCompass();
            }
        });
    }

    public void openCompass(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xValue.setText("X: " + Math.round(event.values[0]));
        yValue.setText("Y: " + Math.round(event.values[1]));
        zValue.setText("Z: " + Math.round(event.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}