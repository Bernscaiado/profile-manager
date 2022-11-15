package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void SetTeamIcon(View v) {
        Intent returnIntent = new Intent();

        ImageView selectedImage = (ImageView) v;

        returnIntent.putExtra("imageID", selectedImage.getId());

        setResult(RESULT_OK, returnIntent);

        finish();
    }
}