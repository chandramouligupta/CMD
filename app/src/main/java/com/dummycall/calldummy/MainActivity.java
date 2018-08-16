package com.dummycall.calldummy;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private Context context;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS)
                == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG)
                == PackageManager.PERMISSION_GRANTED) {
            //all permissions are already granted
        } else {
            reqPermission();
        }

        Button callLogs = (Button) findViewById(R.id.call_logs);
        Button contactList = (Button) findViewById(R.id.contact_list);

        context = this;

        contactList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context ,ContactList.class);
                startActivity(intent);
            }
        });

        callLogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , CallLogsList.class);
                startActivity(intent);
            }
        });
        // Example of a call to a native method
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    //Permissions

    final String[] NECESSARY_PERMISSIONS = new String[] {Manifest.permission.READ_CALL_LOG ,
                                            Manifest.permission.READ_CONTACTS};


    public static final int REQUEST_READ_CONTACTS = 79;
    public  static final int REQUEST_READ_CALL_LOGS = 85;

    protected void reqPermission() {
        if(ActivityCompat.checkSelfPermission(this , Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED){
            //contact read permission already granted
        }else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.READ_CONTACTS)) {
                // show UI part if you want here to show some rationale !!!
                Toast.makeText(this, "This app require contact permission", Toast.LENGTH_LONG);

            }

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_CONTACTS},
                    REQUEST_READ_CONTACTS);

            ActivityCompat.requestPermissions(this , new String[]{ android.Manifest.permission.READ_CONTACTS} , REQUEST_READ_CONTACTS);
        }
        if(ActivityCompat.checkSelfPermission(this , android.Manifest.permission.READ_CALL_LOG) == PackageManager.PERMISSION_GRANTED){
            //call logs read permission already granted
        }else{
            if(ActivityCompat.shouldShowRequestPermissionRationale(this , Manifest.permission.READ_CALL_LOG)){
                //show UI part if you want here to show some rationale !!!
                                Toast.makeText(this , "This app require call logs permission" , Toast.LENGTH_LONG);
            }
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CALL_LOG},
                    REQUEST_READ_CALL_LOGS);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_READ_CONTACTS: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {



                } else {

                    // permission denied,Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            case REQUEST_READ_CALL_LOGS:{

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {



                } else {

                    // permission denied,Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

        }
    }
}
