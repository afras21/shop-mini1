package com.example.afrasali.fb1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class newpro extends AppCompatActivity {
    String userName, pname, pprice;
    EditText ename, eprice;
    Button toastBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpro);

        toastBtn = (Button)findViewById(R.id.toastBtn);
        toastBtn.setVisibility(View.GONE);
        userName = getIntent().getStringExtra("name");



    }

    public void Lgout(View view) {
        Intent i = new Intent(newpro.this, ProAdd.class);
        i.putExtra("name",userName);
        startActivity(i);
        finish();
    }

    public void addClick(View view) {
        toastBtn.setVisibility(View.VISIBLE);
        ename = (EditText)findViewById(R.id.getProId);
        eprice = (EditText)findViewById(R.id.getPriceId);
        pname = ename.getText().toString();
        pprice = eprice.getText().toString();

        SaveUser saveUser = new SaveUser(this);
        ContentValues c = new ContentValues();
        c.put("pname",pname);
        c.put("pprice",pprice);

        SQLiteDatabase db = saveUser.getWritableDatabase();
        long row = db.insert(userName, null, c);
        Intent i = new Intent(newpro.this,ProAdd.class);
        i.putExtra("name",userName);
        startActivity(i);


    }
}

