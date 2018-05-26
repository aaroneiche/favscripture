package com.conductiveresistance.favscripture;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String preference = "com.conductiveresistance.favscripture.DATA";

    public static final String BOOK = "3 Nephi";
    public static final String CHAPTER = "11";
    public static final String VERSE = "10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendScripture(View view){

        //TODO: Error checking for blank edit boxes.

        EditText bookText       =  (EditText)findViewById(R.id.bookText);
        EditText chapterText    =  (EditText)findViewById(R.id.chapterText);
        EditText verseText      =  (EditText)findViewById(R.id.verseText);

        String book     = bookText.getText().toString();
        String chapter  = chapterText.getText().toString();
        String verse    = verseText.getText().toString();

        Log.d(TAG, "Creating intent with " + book+ " " + chapter + ":" + verse);
        Intent favIntent = new Intent(this, FavoriteScripture.class);

        favIntent.putExtra(BOOK, book);
        favIntent.putExtra(CHAPTER, chapter);
        favIntent.putExtra(VERSE, verse);


        startActivity(favIntent);

    }

    public void loadScripture(View view){
        SharedPreferences data = getApplicationContext().getSharedPreferences(preference,Context.MODE_PRIVATE);

        EditText bookText       =  (EditText)findViewById(R.id.bookText);
        EditText chapterText    =  (EditText)findViewById(R.id.chapterText);
        EditText verseText      =  (EditText)findViewById(R.id.verseText);

        bookText.setText(data.getString("bookText","--"));
        chapterText.setText(data.getString("chapterText","--"));
        verseText.setText(data.getString("verseText","--"));

    }
}
