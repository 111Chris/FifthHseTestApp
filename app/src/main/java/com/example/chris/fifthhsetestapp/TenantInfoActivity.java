package com.example.chris.fifthhsetestapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TenantInfoActivity extends AppCompatActivity {


    private DatabaseHandler database;
    private String tenantname, add, city, state, mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        database = DatabaseHandler.getmInstance(getApplicationContext());



        final EditText tenantName = (EditText) findViewById((R.id.txtTenantName));
        final EditText tenantAdd = (EditText) findViewById((R.id.txtTenantAdd));
        final EditText tenantCity = (EditText) findViewById((R.id.txtTenantCity));
        final EditText tenantState = (EditText) findViewById((R.id.txtTenantState));
        final EditText tenantMobile = (EditText) findViewById((R.id.txtTenantMobile));



        Button btnSave = (Button) findViewById(R.id.btnSubmit);
        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){

                tenantname = tenantName.getText().toString();
                add = tenantAdd.getText().toString();
                city = tenantCity.getText().toString();
                state = tenantState.getText().toString();
                mobile = tenantMobile.getText().toString();


                long id = database.insertIntoTenantInfo(tenantname, add, city, state, mobile);
                 if (id>0){
                     Toast.makeText(getApplicationContext(), "Tenant Information Saved Successfuly.", Toast.LENGTH_LONG).show();
                 }else{
                     Toast.makeText(getApplicationContext(), "Sorry, no record Saved.", Toast.LENGTH_LONG).show();
                 }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tenant_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
