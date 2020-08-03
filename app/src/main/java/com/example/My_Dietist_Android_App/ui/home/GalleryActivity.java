package com.example.My_Dietist_Android_App.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.My_Dietist_Android_App.R;

public class GalleryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

    }

//just a simple intent and a switch adding data (redId) in the selected image which will be used to identify the selected image that will be passed in the fullscreen activity
    public void imageClicked(View v){
        Intent FsIntent = new Intent(this, FullScreenActivity.class);
        switch (v.getId()){
            case R.id.fitnessImageView:
                FsIntent.putExtra("resId",R.drawable.fitness2);
                break;
            case R.id.fitnessImageView2:
                FsIntent.putExtra("resId",R.drawable.fitness3);
                break;
            case R.id.fitnessImageView3:
                FsIntent.putExtra("resId",R.drawable.fitness4);
                break;
            case R.id.fitnessImageView4:
                FsIntent.putExtra("resId",R.drawable.avatar2);
                break;
        }

        startActivity(FsIntent);
    }

}
