package org.clinte.com.farazi.reza.tq.tqc;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Start_Ac extends AppCompatActivity {


    ImageView img_Main;

    CountDownTimer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_);
        ani();

    }

    float y;

    public void ani()
    {
        img_Main=(ImageView)findViewById(R.id.imageView);

        y=img_Main.getY();



        timer=new CountDownTimer(100000,1) {
            @Override
            public void onTick(long millisUntilFinished)
            {

                img_Main.setY(y);
                y++;
                if(y==250)
                {
                    Intent intent=new Intent(Start_Ac.this,Sabt.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFinish() {

            }
        }.start();


    }






}
