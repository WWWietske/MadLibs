/**
 * 	Wietske Dotinga
 * 	Third activity displays the final story and a button to start over.
 */
package com.example.user.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView storyText;
    Button againButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Initialize textview and button and set onclicklistener
        storyText = (TextView) findViewById(R.id.storyText);
        againButton = (Button) findViewById(R.id.againButton);

        againButton.setOnClickListener(newStory);

        // Get intent from second activity and set textview to the story
        Bundle extras = getIntent().getExtras();
        String finishedStory = extras.getString("storyFinished");
        storyText.setText(finishedStory);
    }

    View.OnClickListener newStory = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent startGameAgain = new Intent(ThirdActivity.this, MainActivity.class);
            startActivity(startGameAgain);
        }
    };
}
