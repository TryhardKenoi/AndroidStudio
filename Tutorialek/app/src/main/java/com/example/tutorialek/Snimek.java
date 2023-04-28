package com.example.tutorialek;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.tutorialek.databinding.ContentMainBinding;
import com.example.tutorialek.databinding.SnimekBinding;

import java.net.Authenticator;
import java.util.function.Consumer;

public class Snimek extends AppCompatActivity {


    public static final int CAMERA_RERM_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snimek);

    }

    public void camera(View v){
        askCameraPermission();
    }

    private void askCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_RERM_CODE);
        }else{
            openCamera();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == CAMERA_RERM_CODE){
             if(grantResults.length < 0  && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                 openCamera();
             }else{
                 System.out.println("nene");
             }
        }
    }

    private void openCamera() {
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        
    }
}
