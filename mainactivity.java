package com.example.administrator.dicegame;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivityDice extends AppCompatActivity {

    private int userScore;
    private int computerScore;
    private int diceScore;
    private Random random = new Random();
    private int[] dice = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_dice);

        final TextView textView = (TextView) findViewById(R.id.TV);

        final Button button = (Button) findViewById(R.id.button);
        final Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        final ImageView ob = (ImageView) findViewById(R.id.imageView);


        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                            int diceValue = random.nextInt(6) + 1;
                            ob.setImageDrawable(getResources().getDrawable(dice[diceValue - 1]));
                            userScore += diceValue;

                            if (diceValue == 1) {
                                userScore = 0;
                                updateText(userScore);
                                callComputer();

                            } else
                                updateText(userScore);

                    }
                }

        );

       button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (userScore>=100)
                            finalScore(userScore,computerScore);

                        for (int i = 0; i < 3; i++) {

                                int compValue = random.nextInt(6) + 1;
                                ob.setImageDrawable(getResources().getDrawable(dice[compValue - 1]));
                                computerScore += compValue;

                                if (compValue == 1) {
                                    computerScore = 0;
                                    computerGame(computerScore);
                                } else
                                    computerGame(computerScore);

                                finalScore(userScore,computerScore);

                        }
                    }
                }
        );

        button3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        userScore = 0;
                        computerScore = 0;
                        resetGame(userScore, computerScore);
                    }
                }
        );
    }


    void callComputer() {
        TextView textView = (TextView) findViewById(R.id.TV);
        ImageView ob = (ImageView) findViewById(R.id.imageView);
        for (int i = 0; i < 3; i++) {

                int compValue = random.nextInt(6) + 1;
                ob.setImageDrawable(getResources().getDrawable(dice[compValue - 1]));
                computerScore += compValue;

                if (compValue == 1) {
                    userScore = 0;
                    computerGame(computerScore);
                } else
                    computerGame(computerScore);
            }
        }



    void updateText(int userScore) {
        TextView textView = (TextView) findViewById(R.id.TV);
        textView.setText(" Your Score:" + userScore + "       Computer score:" + computerScore);

    }

    void computerGame(int compterScore) {
        TextView textView = (TextView) findViewById(R.id.TV);
        textView.setText(" Your Score:" + userScore + "       Computer score:" + computerScore);
    }

    void finalScore(int userScore,int computerScore)
    {   TextView textView = (TextView) findViewById(R.id.TV);
        TextView text= (TextView) findViewById(R.id.text);
        int a,b;
        a=userScore;
        b=computerScore;
        textView.setText(" Your Score:" + userScore + "       Computer score:" + computerScore);

        if(b>a)
            text.setText("You lose!");
        else
            text.setText("You win!");
    }

   void resetGame(int userScore,int computerScore)
   {   TextView textView = (TextView) findViewById(R.id.TV);
       textView.setText(" Your Score:" + userScore + "       Computer score:" + computerScore);
   }
}
