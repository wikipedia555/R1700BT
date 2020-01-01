package com.example.r1700bt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.ConsumerIrManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton volumePlus;
    ImageButton volumeMinus;
    ImageButton bluetooth;
    ImageButton linein;
    ImageButton  mute;
    boolean state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        volumePlus = (ImageButton) findViewById(R.id.plus);
        volumeMinus = (ImageButton) findViewById(R.id.minus);
        bluetooth = (ImageButton) findViewById(R.id.bluetooth);
        linein = (ImageButton) findViewById(R.id.linein);
        mute = (ImageButton) findViewById(R.id.mute);
        final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        final String errIr = "The device is not equipped with an IR port";
        final ConsumerIrManager consumerIrManager = (ConsumerIrManager) this.getSystemService(Context.CONSUMER_IR_SERVICE);
        final int frequency = 36000;
        final int vibratemilsec = 50;
        final int[] vplus = new int[]{334,168,19,19,19,19,19,19,19,19,19,63,19,19,19,19,19,19,19,63,19,63,19,63,19,19,19,19,19,63,19,63,19,63,19,63,19,63,19,19,19,63,19,19,19,63,19,19,19,19,19,19,19,19,19,63,19,19,19,63,19,19,19,63,19,63,19,1546};
        final int[] vminus = new int[]{334,168,19,19,19,19,19,19,19,19,19,63,19,19,19,19,19,19,19,63,19,63,19,63,19,19,19,19,19,63,19,63,19,63,19,19,19,19,19,63,19,63,19,63,19,63,19,19,19,19,19,63,19,63,19,19,19,19,19,19,19,19,19,63,19,63,19,1546};
        final int[] mutecode = new int[]{334,168,19,19,19,19,19,19,19,19,19,63,19,19,19,19,19,19,19,63,19,63,19,63,19,19,19,19,19,63,19,63,19,63,19,19,19,63,19,19,19,63,19,63,19,19,19,19,19,19,19,63,19,19,19,63,19,19,19,19,19,63,19,63,19,63,19,1547};
        final int[] bluetoothcode = new int[]{334,168,20,20,20,20,20,20,20,20,20,63,20,20,20,20,20,20,20,63,20,63,20,63,20,20,20,20,20,63,20,63,20,63,20,63,20,20,20,63,20,63,20,20,20,20,20,63,20,20,20,20,20,63,20,20,20,20,20,63,20,63,20,20,20,63,20,1547};
        final int[] lineincode = new int[]{334,168,20,20,20,20,20,20,20,20,20,63,20,20,20,20,20,20,20,63,20,63,20,63,20,20,20,20,20,63,20,63,20,63,20,20,20,63,20,63,20,63,20,63,20,20,20,63,20,20,20,63,20,20,20,20,20,20,20,20,20,63,20,20,20,63,20,1547};
        SwitchCompat onOffSwitch = (SwitchCompat)  findViewById(R.id.on_off_switch);
        onOffSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.v("Switch State=", ""+isChecked);
                state = isChecked;
            }

        });
        volumePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, vplus);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        volumeMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, vminus);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, bluetoothcode);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        linein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, lineincode);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, mutecode);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
