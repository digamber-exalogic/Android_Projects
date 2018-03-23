package com.example.android.santa_monica3;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Login_page extends AppCompatActivity {
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }
    public void navToDashboard(View view) {
        Intent mainIntent = new Intent(Login_page.this, Dashboard.class);
        startActivity(mainIntent);
        Toast.makeText(getApplicationContext(), "Login Successful!",
                Toast.LENGTH_SHORT).show();
    }
}
