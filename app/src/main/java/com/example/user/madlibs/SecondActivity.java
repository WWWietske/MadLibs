/**
 * 	Wietske Dotinga
 * 	User inputs words. Using story.java these words are filled in in the story.
 * 	Text gets passed to the third activity.
 */
package com.example.user.madlibs;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class SecondActivity extends AppCompatActivity {

    // Use the methods in story by calling story right here
    Story newStory;
    Button nextButton;
    EditText enterWordText;
    TextView wordsLeft;
    int inputWords = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize the edittext, textview
        enterWordText = (EditText) findViewById(R.id.enterWordText);
        wordsLeft = (TextView) findViewById(R.id.wordsLeft);

        // Initialize the button for next word and set OnclickListener
        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(next);

        // Initialize textview for amount of words left
        wordsLeft = (TextView) findViewById(R.id.numberText);
        //TODO error, want ding nog niet gezet ofzo
        //wordsLeft.setText(inputWords);

        // TODO dan hier die classes uit story gebruiken om alles te doen, heuj

        // Opening the story file and reading it
        AssetManager am = getAssets();
        InputStream inputText = null;

        // Check for IOException
        try {
            inputText = am.open("madlib0_simple.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        newStory = new Story(inputText);
    }

    View.OnClickListener next = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Save word into placeholder
            newStory.fillInPlaceholder(enterWordText.getText().toString());
            enterWordText.setText("");

            // If all words are filled in use intent to send story to third activity
            if (newStory.isFilledIn()){
                String story = newStory.toString();
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("storyFinished", story);
                startActivity(intent);
            }
        }
    };


}
