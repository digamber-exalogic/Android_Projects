package com.example.android.santa_monica3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    private Button myButton, myServiceButton, myAboutUsButton, myEventsButton,yourbuttonname;
    int clickcount=0;
    boolean status=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        myButton =findViewById(R.id.myButton);
        myServiceButton = findViewById(R.id.myServiceButton);
        myAboutUsButton = findViewById(R.id.myAUButton);
        myEventsButton = findViewById(R.id.myEventButton);
        yourbuttonname = findViewById(R.id.yourbuttonname);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status==true) {
                    Intent intent = new Intent(getApplicationContext(), GetAllUsersActivity.class);
                    intent.putExtra("status", status);
                    startActivity(intent);
                }else {
                    Intent mainIntent = new Intent(getApplicationContext(), CreateNotice.class);
                    mainIntent.putExtra("status", status);
                    startActivity(mainIntent);
                }

            }
        });{
    }

        myServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent(Dashboard.this, Service.class);
                startActivity(mainIntent);
            }
        });

        myEventsButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent mainIntent = new Intent(Dashboard.this, Events.class);
                startActivity(mainIntent);

            }
        });

        myAboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent(Dashboard.this, AboutUs.class);
                startActivity(mainIntent);

            }
        });


        yourbuttonname.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {




                if(clickcount == 0)
                {
                    yourbuttonname.setBackgroundColor(Color.RED);
                    status = true;
                    // Intent intent=new Intent(getApplicationContext(),GetAllUsersActivity.class);
                     //intent.putExtra("status",status);
                     //startActivity(intent);
                    clickcount = clickcount + 1;

                }
                else if(clickcount == 1)
                {
                    yourbuttonname.setBackgroundColor(Color.BLUE);
                    status=false;
                    clickcount = clickcount - 1;
                }


        }
        });
}
}
