package com.example.android.santa_monica3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class CreateNotice extends AppCompatActivity {

    private Button btnStore, btnGetall;
    private EditText etname, ethobby;
    private DatabaseHelper databaseHelper;
    private Boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_notice);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        status = getIntent().getExtras().getBoolean("status");

        databaseHelper = new DatabaseHelper(this);

        btnStore = (Button) findViewById(R.id.btnstore);
        btnGetall = (Button) findViewById(R.id.btnget);
        etname = (EditText) findViewById(R.id.etname);
        ethobby = (EditText) findViewById(R.id.ethobby);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addUserDetail(etname.getText().toString(), ethobby.getText().toString());
                etname.setText("");
                ethobby.setText("");
                Toast.makeText(getApplicationContext(), "Stored Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        btnGetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),GetAllUsersActivity.class);
                intent.putExtra("status",status);
                startActivity(intent);
                overridePendingTransition(R.animator.slide_in, R.animator.slide_out);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            //startActivity(new Intent(this, CreateNotice.class));
            overridePendingTransition(R.animator.slide_in, R.animator.slide_out);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
        //startActivity(new Intent(this, CreateNotice.class));
        overridePendingTransition(R.animator.slide_in, R.animator.slide_out);
    }
}
