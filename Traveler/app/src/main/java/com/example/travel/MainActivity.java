package com.example.travel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN=5000;

//Variables
    Animation Top, Bottom;
    ImageView image;
    TextView logo,slogan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
//Animation
        Top=AnimationUtils.loadAnimation(this,R.anim.top_animation);
        Bottom=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
  //Hooks
        image=findViewById(R.id.imageView);
        logo=findViewById(R.id.textView);
        slogan=findViewById(R.id.textView2);

        //Animation Implementation
        image.setAnimation(Top);
        logo.setAnimation(Bottom);
        slogan.setAnimation(Bottom);


//new activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this, Authentication.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);



    }
}