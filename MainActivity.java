package com.nkcodelab.mypermission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Variable creating done
    private static final int REQUEST_PERMISSION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create function here
        requestPermission();
        appFunction();
    }

    private void appFunction() {
        Toast.makeText(this, "SUBSCRIBE OUR CHANNEL", Toast.LENGTH_SHORT).show();
    }

    private void requestPermission() {

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        permissionCheck=ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS);
        permissionCheck=ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE);
        permissionCheck=ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CALL_LOG);
        permissionCheck=ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION);

        if (permissionCheck == PackageManager.PERMISSION_GRANTED)
        {
            appFunction();

        }else
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_SMS,Manifest.permission.READ_CONTACTS,
                    Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.READ_CALL_LOG,
                    Manifest.permission.READ_EXTERNAL_STORAGE},REQUEST_PERMISSION);
        }
        appFunction();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION)
        {
            appFunction();
        }else
        {
            Toast.makeText(this, "Please allow Permission", Toast.LENGTH_SHORT).show();
        }
    }
}