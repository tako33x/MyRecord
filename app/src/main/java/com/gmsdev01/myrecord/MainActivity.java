package com.gmsdev01.myrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mInfoLabel;
    private Button mStartRecBtn;
    private Button mStopRecBtn;
    private boolean isRec = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInfoLabel = findViewById(R.id.infoLabel);
        mStartRecBtn = findViewById(R.id.startRecBtn);
        mStopRecBtn = findViewById(R.id.stopRecBtn);

        mStartRecBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent=new Intent(getBaseContext(), RecService.class);
                startService(startIntent);

            }
        });

        mStopRecBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stopIntent=new Intent(getBaseContext(), RecService.class);
                stopService(stopIntent);

            }
        });

        if(isRec){
            mInfoLabel.setText("Doing the job...");
        } else {
            mInfoLabel.setText("Ready");
        }

    }




}
