package com.conductiveresistance.favscripture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class FavoriteScripture extends AppCompatActivity {

    public static final String TAG = "FavoriteScripture";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scripture);

        Intent fav = getIntent();

        String iBook = fav.getStringExtra(MainActivity.BOOK);
        String iChapter = fav.getStringExtra(MainActivity.CHAPTER);
        String iVerse = fav.getStringExtra(MainActivity.VERSE);

        String scriptureReference = iBook + " " + iChapter + ":" + iVerse;
        Log.d(TAG,"Received " + scriptureReference);

        TextView scriptureOutput = findViewById(R.id.scriptureOutputText);
        scriptureOutput.setText(scriptureReference);


    }
}
