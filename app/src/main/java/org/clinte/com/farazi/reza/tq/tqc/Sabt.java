package org.clinte.com.farazi.reza.tq.tqc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Sabt extends AppCompatActivity {


    EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabt);

        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent in=new Intent(Intent.ACTION_MAIN);
        in.addCategory(Intent.CATEGORY_HOME);
        startActivity(in);

    }



    public void dbt_btn(View v)
    {
        jvb.userName=ed1.getText().toString();
        jvb.ip=ed2.getText().toString();

        Intent in=new Intent(Sabt.this,Questions_Acti.class);

        startActivity(in);

    }



}
