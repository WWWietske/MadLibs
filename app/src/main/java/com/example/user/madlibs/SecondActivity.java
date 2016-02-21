/**
 * 	Wietske Dotinga
 * 	User inputs words. Using story.java these words are filled in in the story.
 * 	Text gets passed to the third activity.
 */
package com.example.user.madlibs;

import android.content.Context;
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
    int inputWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize the edittext for entering the words
        enterWordText = (EditText) findViewById(R.id.enterWordText);

        // Initialize the button for next word and setOnclickListener
        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(next);

        // TODO dan hier die classes uit story gebruiken om alles te doen, heuj

        // Opening the story file and reading it
        Context context = getApplicationContext();
        AssetManager am = context.getAssets();
        InputStream inputText = null;

        // IOException must be caught
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
            // TODO hier dan ervoor zorgen dat als je op de button klikt het woord doorgestuurd wordt en alles update en edittext leeg
            // bij laatste woord dan naar 3e activity sturen
        }
    };
}
