package org.clinte.com.farazi.reza.tq.tqc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Questions_Acti extends AppCompatActivity {


    CountDownTimer timer;

    int a=0;

    int jvbd=0;


    int tjvb=0;
    int fjvb=0;

    RelativeLayout rlload,rlog;

    Button btn;

    TextView textView;
    RadioButton radioButton1,radioButton2,radioButton3,radioButton4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_);

        rlload=(RelativeLayout)findViewById(R.id.rlload);

        rlog=(RelativeLayout)findViewById(R.id.rlog);


        rlload.setVisibility(View.VISIBLE);





        btn=(Button)findViewById(R.id.button);



        timer=new CountDownTimer(100000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {


                a++;
                if(a==5)
                {
                    rlog.setVisibility(View.VISIBLE);
                    rlload.setVisibility(View.GONE);
                    btn.setVisibility(View.VISIBLE );
                }
            }

            @Override
            public void onFinish() {

            }
        }.start();

        pg();










        connnected_net_Work();

        try {
            Thread.sleep(1000);
        }catch (Exception e)
        {

        }
        filquestion();

        only();

    }




    public void pg()
    {
        textView=(TextView)findViewById(R.id.textView);
        radioButton1=(RadioButton)findViewById(R.id.radioButton);
        radioButton2=(RadioButton)findViewById(R.id.radioButton2);
        radioButton3=(RadioButton)findViewById(R.id.radioButton3);
        radioButton4=(RadioButton)findViewById(R.id.radioButton4);

    }






    int count=0;



    public void onclick_Main_btn(View v)
    {



        if(radioButton1.isChecked()==true&&jvbd==1)
        {
            tjvb++;
        }else if(radioButton2.isChecked()==true&&jvbd==2)
        {
            tjvb++;
        }else if(radioButton3.isChecked()==true&&jvbd==3)
        {
            tjvb++;
        }else if(radioButton4.isChecked()==true&&jvbd==4)
        {
            tjvb++;
        }else
        {
            fjvb++;
        }




        try
        {


            if(btn.getText().toString()=="پایان")
            {

                org.clinte.com.farazi.reza.tq.tqc.jvb.count=(count/6)+"";
                org.clinte.com.farazi.reza.tq.tqc.jvb.cntfls=fjvb+"";
                org.clinte.com.farazi.reza.tq.tqc.jvb.cnttru=tjvb+"";

                String s="تعداد کل سوالات   :   "+org.clinte.com.farazi.reza.tq.tqc.jvb.count;
                s+="\n";
                s+="تعداد سوالات پاسخ درست    :    "+org.clinte.com.farazi.reza.tq.tqc.jvb.cnttru;
                s+="\n";
                s+="تعداد سوالات اشتباه پاسخ   :    "+org.clinte.com.farazi.reza.tq.tqc.jvb.cntfls;
                s+="\n";
                s+="نام کاربری   :    "+ org.clinte.com.farazi.reza.tq.tqc.jvb.userName;


                dos.writeUTF(s);


                Intent n=new Intent(Questions_Acti.this,Natayeg.class);
                startActivity(n);


                return;
            }


            java.lang.String []questions=all_q_jvbs_jvb.split("-");




            textView.setText(questions[count]);
            radioButton1.setText(questions[count+1]);
            radioButton2.setText(questions[count+2]);
            radioButton3.setText(questions[count+3]);
            radioButton4.setText(questions[count+4]);
            jvbd=Integer.parseInt(questions[count+5].toString());
            count+=6;




            int ctn=count+=6;

            if(ctn==questions.length)
            {
                btn.setText("پایان");
            }



            clear();


        }
        catch (Exception e)
        {

            AlertDialog.Builder s=new AlertDialog.Builder(Questions_Acti.this);
            s.setMessage(e.getMessage());
            s.setNegativeButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            s.show();
        }



    }








    public void only()
    {

        try{



            java.lang.String []questions=all_q_jvbs_jvb.split("-");



                textView.setText(questions[count]);
                radioButton1.setText(questions[count+1]);
                radioButton2.setText(questions[count+2]);
                radioButton3.setText(questions[count+3]);
                radioButton4.setText(questions[count+4]);
                jvbd=Integer.parseInt(questions[count+5].toString());


            count+=6;


        }
        catch (Exception e)
        {
            Toast.makeText(Questions_Acti.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }



    String question[];







    public void filquestion()
    {


        try {


/*            for (int a = 0; a < questions.length; a++)
            {
                question[a] = questions[a].toString();
            }
*/

        }
        catch (Exception e)
        {
            AlertDialog.Builder s=new AlertDialog.Builder(Questions_Acti.this);
            s.setMessage(e.getMessage());
            s.setNegativeButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            s.show();
        }
    }







    public void clear()
    {
        radioButton1.setChecked(false);
        radioButton2.setChecked(false);
        radioButton3.setChecked(false);
        radioButton4.setChecked(false);

    }





    public Socket sock;
    public DataInputStream dis;
    public DataOutputStream dos;



    String all_q_jvbs_jvb;



    public void connnected_net_Work()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {


                try {


                    sock = new Socket(org.clinte.com.farazi.reza.tq.tqc.jvb.ip, 8085);
                    dis=new DataInputStream(sock.getInputStream());
                    dos=new DataOutputStream(sock.getOutputStream());



                    all_q_jvbs_jvb=dis.readUTF();

                    textView.setText(all_q_jvbs_jvb);



                }
                catch (Exception e)
                {
                    AlertDialog.Builder l=new AlertDialog.Builder(Questions_Acti.this);
                    l.setTitle("Error");
                    l.setMessage(e.getMessage());
                    l.setNegativeButton("باشه", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent in=new Intent(Intent.ACTION_MAIN);
                            in.addCategory(Intent.CATEGORY_HOME);
                            startActivity(in);

                        }
                    });
                    l.show();
                }

            }
        }).start();
    }













    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);

    }
}
