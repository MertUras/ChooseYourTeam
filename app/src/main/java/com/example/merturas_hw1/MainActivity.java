package com.example.merturas_hw1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username=(TextView) findViewById(R.id.username);
        TextView password=(TextView) findViewById(R.id.password);
        MaterialButton loginbtn=(MaterialButton) findViewById(R.id.loginbtn);
        TextView signin=(TextView) findViewById(R.id.signin);

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000);
        anim.setStartOffset(200);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        signin.startAnimation(anim);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);



                if (username.getText().toString().equals("admin")&&password.getText().toString().equals("admin")){
                    Toast.makeText(MainActivity.this,"LOGIN SUCCESSFULL", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,MainActivity2.class);

                    startActivities(new Intent[]{intent});



                }
                else{
                    //Toast.makeText(MainActivity.this,"LOGIN FAILED", Toast.LENGTH_SHORT).show();
                    builder.setMessage("Try Again...");
                    builder.setCancelable(false);

                    builder.setPositiveButton("try again",new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.cancel();
                        }
                    });
                }
                AlertDialog alertDialog= builder.create();
                alertDialog.show();


            }
        });



    }
}