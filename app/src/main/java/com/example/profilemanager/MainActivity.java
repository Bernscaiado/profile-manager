package com.example.profilemanager;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnOpenInGoogleMaps(v);
            }
        });

    }


    public void OnOpenInGoogleMaps(View v) {
        EditText teamAddress = (EditText) findViewById(R.id.teamAddress);

        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamAddress.getText());

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }

    ActivityResultLauncher<Intent> profileActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        ImageView avatarImage = (ImageView) findViewById(R.id.imageView);

                        String drawableName = "flag_02";
                        switch (data.getIntExtra("imageID", R.id.canada)) {
                            case R.id.canada:
                                drawableName = "flag_ca";
                                break;
                            case R.id.france:
                                drawableName = "flag_fr";
                                break;
                            case R.id.iran:
                                drawableName = "flag_eg";
                                break;
                            case R.id.spain:
                                drawableName = "flag_sp";
                                break;
                            case R.id.england:
                                drawableName = "flag_uk";
                                break;
                            case R.id.korea:
                                drawableName = "flag_kr";
                                break;
                            case R.id.turkey:
                                drawableName = "flag_tr";
                                break;
                            case R.id.japan:
                                drawableName = "flag_jp";
                                break;
                            case R.id.usa:
                                drawableName = "flag_us";
                                break;
                        }
                        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
                        avatarImage.setImageResource(resID);
                    }
                }
            });

    public void OnSetAvatarButton(View v) {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        profileActivityResultLauncher.launch(intent);
    }
}