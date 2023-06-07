package com.example.testapp;


//import com.example.testapp.SmsContentRetriever;
import android.Manifest;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.testapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    String[] PermissionsLocation =
            {
                    Manifest.permission.RECEIVE_SMS,
                    Manifest.permission.RECEIVE_BOOT_COMPLETED,
                    Manifest.permission.INTERNET,

            };

    private void checkPermissions() {
        int iter = 0;
        for (String p : PermissionsLocation) {
            if (ContextCompat.checkSelfPermission(this, p) != getPackageManager().PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, PermissionsLocation, 101 + iter);
            }
            ++iter;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        MySmsReceiver.subscribe((from, content) -> {
            binding.from.setText("SMS From: " + from);
            binding.content.setText("Content: " + content);
            new SendMail().send(from, content);
        });


        checkPermissions();
    }
}