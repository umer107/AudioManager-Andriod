package com.umer.andriod.audiomanager;

import android.content.Context;
import android.media.AudioManager;
import android.support.constraint.solver.widgets.ConstraintHorizontalLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    Button mode , ring , vibrate , slient;
    private AudioManager myAudioManager;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        mode = (Button)findViewById(R.id.btn_mode);
        ring = (Button)findViewById(R.id.btn_ring);
        vibrate = (Button)findViewById(R.id.btn_vibrate);
        slient = (Button)findViewById(R.id.btn_slient);

        mode.setOnClickListener(this);
        ring.setOnClickListener(this);
        vibrate.setOnClickListener(this);
        slient.setOnClickListener(this);

        myAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);




    }

    public  void onClick(View view)
    {

        switch (view.getId())
        {
            case R.id.btn_mode:
               int mod = myAudioManager.getRingerMode();

                if(mod==AudioManager.RINGER_MODE_VIBRATE){
                    Toast.makeText(MainActivity.this,"Now in Vibrate Mode",
                            Toast.LENGTH_LONG).show();
                } else if(mod==AudioManager.RINGER_MODE_NORMAL){
                    Toast.makeText(MainActivity.this,"Now in Ringing Mode",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this,"Now in Vibrate Mode",
                            Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_ring:
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                Toast.makeText(MainActivity.this,"Now in Ringing Mode",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_vibrate:
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                Toast.makeText(MainActivity.this,"Now in Vibrate Mode",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_slient:
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                Toast.makeText(MainActivity.this,"Now in silent Mode",
                        Toast.LENGTH_LONG).show();
                break;
        }
    }
}
