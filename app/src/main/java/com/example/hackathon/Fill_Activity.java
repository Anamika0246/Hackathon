package com.example.hackathon;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.BitSet;

public class Fill_Activity extends AppCompatActivity {

    EditText location, discription;
    Button upload,map, submit, cam;
    ImageView upload_image;

    private final int GALLERY_REQ_CODE = 1000;
    private final int CAMERA_REQ_CODE = 100;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        location = findViewById(R.id.location);
        discription = findViewById(R.id.disc);
        map = findViewById(R.id.map);
        upload = findViewById(R.id.upload);
        upload_image = findViewById(R.id.upload_image);
        submit = findViewById(R.id.submit);
        cam = findViewById(R.id.upload_cam);

        String loc = location.getText().toString();

        String disc = discription.getText().toString();


        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQ_CODE);
            }
        });



        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGallery = new Intent(Intent.ACTION_PICK);

                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(iGallery, GALLERY_REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK){
            if (requestCode==GALLERY_REQ_CODE){

                upload_image.setImageURI((data.getData()));
            } else if (requestCode==CAMERA_REQ_CODE) {

                Bitmap img = (Bitmap)( data.getExtras().get("data"));
                upload_image.setImageBitmap(img);
            }

        }
    }
}