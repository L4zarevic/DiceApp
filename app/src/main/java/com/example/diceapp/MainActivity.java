//Class for Dice app
package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Variable for image view witch contains ID of images what is declared in activity_main.xml
        final ImageView diceImage1 = findViewById(R.id.imgDice1);
        final ImageView diceImage2 = findViewById(R.id.imgDice2);

        //Create array witch index represent dice
        final int[] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        //Create button Roll witch contains ID of button what is declared in activity_main.xml
        Button btnRoll = findViewById(R.id.btnRollTheDice);

        //Create variable witch contains sound from res>>raw folder
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);

        //Create listener for button
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyDiceApp", "btnRoll is tapped now!");

                //Create object for random class
                Random rndObject = new Random();

                //Variable witch contains random number
                int myRandomNumber1 = rndObject.nextInt(6);
                int myRandomNumber2 = rndObject.nextInt(6);

                Log.i("MyDiceApp", "The first generated random number is " + myRandomNumber1);
                Log.i("MyDiceApp", "The second generated random number is " + myRandomNumber1);

                //Image view is change depending of generated random numbers
                diceImage1.setImageResource(diceImages[myRandomNumber1]);
                diceImage2.setImageResource(diceImages[myRandomNumber2]);

                //Animation for first dice
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(diceImage1);

                //Animation for second dice
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(diceImage2);

                //Play the sound when is clicked
                mp.start();
            }
        });


    }
}
