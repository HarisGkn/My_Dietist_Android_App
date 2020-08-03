package com.example.My_Dietist_Android_App.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.My_Dietist_Android_App.R;

public class FullScreenActivity extends AppCompatActivity {
//the image is passed from the gallery activity and replaces the placeholder image
    ImageView fsImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        fsImage = (ImageView) findViewById(R.id.placeHolderImageView);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            int resid = bundle.getInt("resId");
            fsImage.setImageResource(resid);
        }
    }
}
