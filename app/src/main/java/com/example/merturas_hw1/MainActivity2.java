package com.example.merturas_hw1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText mYearEt=(EditText) findViewById(R.id.yearEditText);
        Button mCalBtn=(Button) findViewById(R.id.calculate_btn);
        TextView mAgeTv=(TextView) findViewById(R.id.ageTextView);


        mCalBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity2.this);

                String userDDB=mYearEt.getText().toString().trim();
                int year= Calendar.getInstance().get(Calendar.YEAR);
                if(userDDB.isEmpty()){
                    Toast.makeText(MainActivity2.this,"Please enter a year",Toast.LENGTH_SHORT).show();

                }else if(userDDB.compareTo(String.valueOf(year))>0){
                    Toast.makeText(MainActivity2.this,"Year Should be less than year",Toast.LENGTH_SHORT).show();

                }else{
                    int myAge=year - Integer.parseInt(userDDB);
                  //  mAgeTv.setText("Your age is "+myAge+" years");
                    builder.setMessage("Your age is "+myAge+" years");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK",new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.cancel();
                        }
                    });
                    Intent intent=new Intent(MainActivity2.this,MainActivity3.class);

                    startActivities(new Intent[]{intent});
                }
                AlertDialog alertDialog= builder.create();
                alertDialog.show();

            }
        });
    }

}