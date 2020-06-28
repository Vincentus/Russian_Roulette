package com.example.russianroulette;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;


public class MainActivity extends Activity {
    private SoundPool sounds;
    private int soundShot;
    private int soundMiss;
    private int soundRound;
    private ImageView bloodImage;
    private int onShot=3;
    private int maxCount= 6;
    private int random =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNewSoundpool();
        loadSounds();
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected void createNewSoundpool() {

        AudioAttributes attributes = new AudioAttributes.Builder()
             .setUsage(AudioAttributes.USAGE_GAME)
             .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
          .build();
        sounds = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
    }


    private void loadSounds(){
        soundShot= sounds.load(this, R.raw.soundshot, 1 );
        soundMiss= sounds.load(this,R.raw.soundmiss,2);
        soundRound=sounds.load(this,R.raw.soundround,3);




    }


    public void onShot(View view) {


        if (random==onShot){


        sounds.play(soundShot,1.0f,1.0f,1,0,1);
        bloodImage.setVisibility(View.VISIBLE);}
        else{
        sounds.play(soundMiss,1.0f,1.0f,1,0,1);


    }}

    public void onMiss(View view) {

    }

    public void onRound(View view) {
        sounds.play(soundRound,1.0f,1.0f,1,0,1);
        bloodImage.setVisibility(View.GONE);
        random= new Random().nextInt(maxCount);



}


private void init(){

    bloodImage = findViewById(R.id.bloodImage);


}

}