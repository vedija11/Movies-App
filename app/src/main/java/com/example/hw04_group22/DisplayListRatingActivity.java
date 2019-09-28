package com.example.hw04_group22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class DisplayListRatingActivity extends AppCompatActivity {

    TextView tv_titleRating, tv_genreRating, tv_movieRating, tv_yearRating, tv_imdbRating;
    EditText et_descRating;
    Button finishButtonR;
    ImageButton previousButtonR, nextButtonR, firstButtonR, lastButtonR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_rating);
        setTitle("Movies By Rating");

        tv_titleRating = findViewById(R.id.tv_titleRating);
        tv_genreRating = findViewById(R.id.tv_genreRating);
        tv_movieRating = findViewById(R.id.tv_movieRating);
        tv_yearRating = findViewById(R.id.tv_yearRating);
        tv_imdbRating = findViewById(R.id.tv_imdbRating);
        et_descRating = findViewById(R.id.et_descRating);
        finishButtonR = findViewById(R.id.finishButtonR);
        previousButtonR = findViewById(R.id.previousButtonR);
        nextButtonR = findViewById(R.id.nextButtonR);
        firstButtonR = findViewById(R.id.firstButtonR);
        lastButtonR = findViewById(R.id.lastButtonR);
    }
}
