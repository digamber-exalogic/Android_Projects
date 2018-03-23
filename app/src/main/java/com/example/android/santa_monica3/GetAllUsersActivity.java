package com.example.android.santa_monica3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;


public class GetAllUsersActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<UserModel> userModelArrayList;
    private CustomAdapter customAdapter;
    private DatabaseHelper databaseHelper;
    private Boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_users);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.lv);

        databaseHelper = new DatabaseHelper(this);

        Intent intent = getIntent();

        status = getIntent().getExtras().getBoolean("status");


        userModelArrayList = databaseHelper.getAllUsers();

        customAdapter = new CustomAdapter(this,userModelArrayList);
        listView.setAdapter(customAdapter);
        Log.e("status","===="+status);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(status.equals(true)) {
                    listView.setClickable(false);
                }else {
                    listView.setClickable(true);
                    Intent intent = new Intent(GetAllUsersActivity.this, UpdateDeleteActivity.class);
                    intent.putExtra("user", userModelArrayList.get(position));
                    intent.putExtra("status", status);
                    startActivity(intent);
                    overridePendingTransition(R.animator.slide_in, R.animator.slide_out);
                }
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
