package com.example.hw04_group22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class DisplayListYearActivity extends AppCompatActivity {

    TextView tv_movieTitle, tv_genreYear, tv_ratingYear, tv_movieYear, tv_imdbYear;
    EditText et_descYear;
    Button button_finish;
    ImageButton previousButton, nextButton, firstButton, lastButton;

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


    }
}
