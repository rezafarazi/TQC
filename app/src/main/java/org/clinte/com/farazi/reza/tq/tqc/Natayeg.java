package org.clinte.com.farazi.reza.tq.tqc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Natayeg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_natayeg);

        TextView t=(TextView)findViewById(R.id.jvbtextView);

        String s="تعداد کل سوالات   :   "+jvb.count;
        s+="\n";
        s+="تعداد سوالات پاسخ درست    :    "+jvb.cnttru;
        s+="\n";
        s+="تعداد سوالات اشتباه پاسخ   :    "+jvb.cntfls;
        s+="\n";
        t.setText(s);




        this.setTitle("نتیجه");


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);


    }


    public void click_btn(View v)
    {
        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}
