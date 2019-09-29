package com.example.hw04_group22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DisplayListRatingActivity extends AppCompatActivity {

    TextView tv_titleRating, tv_genreRating, tv_movieRating, tv_yearRating, tv_imdbRating;
    EditText et_descRating;
    Button finishButtonR;
    ImageButton previousButtonR, nextButtonR, firstButtonR, lastButtonR;

    int current_Index=0;
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

        Intent ListByYear = getIntent();
        final ArrayList<Movie> MovieList = (ArrayList<Movie>) ListByYear.getSerializableExtra("Movie");
        Collections.sort(MovieList, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.rating>o2.rating?0:1;
            }
        });
        Log.d("onCreate: ", MovieList.toString());
        final Movie currentMovie = MovieList.get(current_Index);
        setDisplay(currentMovie);

        nextButtonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_Index++;
                if (current_Index == MovieList.size())
                    current_Index = 0;
                setDisplay(MovieList.get(current_Index));
            }
        });
        previousButtonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_Index--;
                if(current_Index<0)
                    current_Index=MovieList.size()-1;
                setDisplay(MovieList.get(current_Index));
            }
        });
        firstButtonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_Index=0;
                setDisplay(MovieList.get(current_Index));
            }
        });
        lastButtonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_Index=MovieList.size()-1;
                setDisplay(MovieList.get(current_Index));
            }
        });
    }
    void setDisplay(Movie currentMovie) {
        tv_titleRating.setText(currentMovie.getName());
        tv_genreRating.setText(currentMovie.getGenre());
        tv_yearRating.setText(String.valueOf(currentMovie.getYear()));
        tv_movieRating.setText(String.valueOf(currentMovie.getRating()));
        et_descRating.setText(currentMovie.getDescription());
        tv_imdbRating.setText(currentMovie.getImdb());
    }
}
