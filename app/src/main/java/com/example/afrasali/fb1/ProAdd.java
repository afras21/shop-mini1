package com.example.afrasali.fb1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProAdd extends AppCompatActivity {
    String userName;
    ArrayList names, cost;
    String[] mStringArray;
    public int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_add);
        userName = getIntent().getStringExtra("name");
        TextView user = (TextView) findViewById(R.id.userId);
        String temp = ""+userName.charAt(0);
        String temp1 = userName;
        temp = temp.toUpperCase();
        temp = temp+temp1.replace(temp1.charAt(0),'\0');
        user.setText(temp);
        ListView ls = (ListView) findViewById(R.id.productList);
        ls.setDivider(null);

        names = new ArrayList<String>();
        cost = new ArrayList<String>();

        SaveUser s = new SaveUser(this);
        SQLiteDatabase db;
        db = s.getReadableDatabase();
        String[] columns = {"pname", "pprice"};
        Cursor cr = db.query(userName, columns, null, null, null, null, null);
        while (cr.moveToNext()) {
            names.add(cr.getString(cr.getColumnIndex("pname")));
            cost.add(cr.getString(cr.getColumnIndex("pprice")));

        }

        count = names.size();
        CustomAdapter myAdapter = new CustomAdapter();
        ls.setAdapter(myAdapter);


    }

    public void Lgout(View view) {
        Intent i = new Intent(ProAdd.this, LoginScreen.class);
        startActivity(i);
        Toast.makeText(this, "Signed Out Successfully", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void addClick(View view) {
        Intent i = new Intent(ProAdd.this, newpro.class);
        i.putExtra("name", userName);
        startActivity(i);

    }


    class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return count;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlist, null);
            TextView prod = (TextView) view.findViewById(R.id.proId);
            TextView pri = (TextView) view.findViewById(R.id.rateId);
            pri.setText(""+names.get(position));
            prod.setText("Rs "+cost.get(position));
            return view;
        }
    }
}