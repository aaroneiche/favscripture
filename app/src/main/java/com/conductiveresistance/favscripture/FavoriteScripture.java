package com.conductiveresistance.favscripture;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FavoriteScripture extends AppCompatActivity {

    public static final String TAG = "FavoriteScripture";
    private static final String preference = "com.conductiveresistance.favscripture.DATA";

    private String book = "";
    private String chapter = "";
    private String verse = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scripture);

        Intent fav = getIntent();

        book = fav.getStringExtra(MainActivity.BOOK);
        chapter = fav.getStringExtra(MainActivity.CHAPTER);
        verse = fav.getStringExtra(MainActivity.VERSE);

        String scriptureReference = book + " " + chapter + ":" + verse;
        Log.d(TAG,"Received " + scriptureReference);

        TextView scriptureOutput = findViewById(R.id.scriptureOutputText);
        scriptureOutput.setText(scriptureReference);
    }


    public void saveScripture(View view){

        Context context = getApplicationContext();
        SharedPreferences data = context.getSharedPreferences(preference, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = data.edit();

        editor.putString("bookText",book);
        editor.putString("chapterText",chapter);
        editor.putString("verseText",verse);

        editor.apply();

        Toast.makeText(getApplicationContext(), "Scripture saved!", Toast.LENGTH_SHORT).show();

    }

}
