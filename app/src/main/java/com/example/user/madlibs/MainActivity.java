/**
 * 	Wietske Dotinga
 * 	Main activity with a button to start the game.
 */

package com.example.user.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 	This class has a button that redirects to the second activity.
 */
public class MainActivity extends AppCompatActivity {

    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(start);
    }

    /**
     * 	OnClickListener that opens second activy when button is clicked.
     */
    View.OnClickListener start = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent startGame = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(startGame);
        }
    };
}