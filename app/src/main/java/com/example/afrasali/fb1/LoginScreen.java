package com.example.afrasali.fb1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);


        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                1);
    }
    public void LClick(View view){
        SaveUser s=new SaveUser(this);
        EditText user=(EditText)findViewById(R.id.GetUser);

        EditText pwd=(EditText)findViewById(R.id.GetPwd);

        String luser=user.getText().toString().toLowerCase().trim();
        String lpwd=pwd.getText().toString().toLowerCase().trim();
        if(luser.equals("minu") || luser.equals("admin")){
            if(lpwd.equals("admin")){
                Intent i=new Intent(LoginScreen.this,ProAdd.class);
                  i.putExtra("name",luser);
                  i.putExtra("password",lpwd);
                  startActivity(i);
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
                finish();
            }
            else {
                pwd.setError("wrong password");
            }
        }
        else {
            user.setError(" Wrong Username");
        }



    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
