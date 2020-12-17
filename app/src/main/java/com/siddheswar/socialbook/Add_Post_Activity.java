package com.siddheswar.socialbook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URL;

public class Add_Post_Activity extends AppCompatActivity {
    ImageView imgAddpost;
    Button btnUploadPost;
    public static final int SELECT_IMAGE = 1;
    Uri ImageURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__post_);
        imgAddpost = findViewById(R.id.addPostNewPhoto);
        btnUploadPost = findViewById(R.id.uploadPostButton);
        imgAddpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,SELECT_IMAGE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==SELECT_IMAGE && resultCode==RESULT_OK && data !=null)
        {
            ImageURL = data.getData();
            imgAddpost.setImageURI(ImageURL);
        }
    }
}