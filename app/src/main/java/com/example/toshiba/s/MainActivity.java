package com.example.toshiba.s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView xTEXT , yTEXT , zTEXT;
    private Sensor S;
    private SensorManager SM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SM =(SensorManager)getSystemService(SENSOR_SERVICE);

        S= SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SM.registerListener(this,S,SensorManager.SENSOR_DELAY_NORMAL);

        xTEXT= (TextView)findViewById(R.id.xTEXT);
        yTEXT= (TextView)findViewById(R.id.yTEXT);
        zTEXT= (TextView)findViewById(R.id.zTEXT);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xTEXT.setText("X: "+ event.values[0]);
        yTEXT.setText("Y: "+ event.values[1]);
        zTEXT.setText("Z: "+ event.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
