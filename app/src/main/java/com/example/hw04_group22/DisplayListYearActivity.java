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

public class DisplayListYearActivity extends AppCompatActivity {

    TextView tv_movieTitle, tv_genreYear, tv_ratingYear, tv_movieYear, tv_imdbYear;
    EditText et_descYear;
    Button button_finish;
    ImageButton previousButton, nextButton, firstButton, lastButton;
    int current_Index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_year);
        setTitle("Movies By Year");

        tv_movieTitle = findViewById(R.id.tv_movieTitle);
        tv_genreYear = findViewById(R.id.tv_genreYear);
        tv_ratingYear = findViewById(R.id.tv_ratingYear);
        tv_movieYear = findViewById(R.id.tv_movieYear);
        tv_imdbYear = findViewById(R.id.tv_imdbYear);
        et_descYear = findViewById(R.id.et_descYear);
        button_finish = findViewById(R.id.button_finish);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);
        firstButton = findViewById(R.id.firstButton);
        lastButton = findViewById(R.id.lastButton);

        Intent ListByYear = getIntent();
        final ArrayList<Movie> MovieList = (ArrayList<Movie>) ListByYear.getSerializableExtra("Movie");
        Collections.sort(MovieList, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o2.year>o1.year?0:1;
            }
        });
        Log.d("onCreate: ", MovieList.toString());
        final Movie currentMovie = MovieList.get(current_Index);
        setDisplay(currentMovie);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_Index++;
                if (current_Index == MovieList.size())
                    current_Index = 0;
                setDisplay(MovieList.get(current_Index));
            }
        });
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_Index--;
                if(current_Index<0)
                    current_Index=MovieList.size()-1;
                setDisplay(MovieList.get(current_Index));
            }
        });
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_Index=0;
                setDisplay(MovieList.get(current_Index));
            }
        });
        lastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_Index=MovieList.size()-1;
                setDisplay(MovieList.get(current_Index));
            }
        });
    }

    void setDisplay(Movie currentMovie) {
        tv_movieTitle.setText(currentMovie.getName());
        tv_genreYear.setText(currentMovie.getGenre());
        tv_movieYear.setText(String.valueOf(currentMovie.getYear()));
        tv_ratingYear.setText(String.valueOf(currentMovie.getRating()));
        et_descYear.setText(currentMovie.getDescription());
        tv_imdbYear.setText(currentMovie.getImdb());
    }
}
