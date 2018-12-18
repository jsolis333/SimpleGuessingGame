package com.example.solis.simpleguessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //member variable
    int randomAnswer;

    public void makeToast(String string) {

        Toast.makeText(getApplicationContext(), string, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating our View Variables.
        final Button mGuessButton = findViewById(R.id.button);
        final EditText mUserGuess = findViewById(R.id.editText);

        //creating a random object
        Random mRandom = new Random();

        //creating a random variable for our random answer
        randomAnswer = mRandom.nextInt(20) +1;



        //Sets a listener for the button.
        mGuessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int mGuess = Integer.parseInt(mUserGuess.getText().toString());

                //Logic for less than
                if (mGuess < randomAnswer)   {
                    makeToast("Greater");

                 //Logic for greater than
                } else if (mGuess > randomAnswer) {
                  makeToast("Less");

                 //Logic for Correct Answer
                } else {
                    makeToast("Congratulations you guessed the number! Try again!");

                    Random mRandom = new Random();
                    randomAnswer = mRandom.nextInt(20) +1;
                }
            }
        });
    }
}
