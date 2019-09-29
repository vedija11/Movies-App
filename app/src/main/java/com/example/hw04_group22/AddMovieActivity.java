package com.example.hw04_group22;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class AddMovieActivity extends AppCompatActivity {

    EditText et_movieName, et_desc, et_year, et_imdb;
    TextView tv_seekval;
    Spinner dd_genrelist;
    SeekBar seekBar;
    Button addbutton;

    String[] genreList = {"Select", "Action", "Animation", "Comedy", "Documentary", "Family", "Horror", "Crime", "Others"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);
        setTitle("Add Movie");

        et_movieName = findViewById(R.id.et_movieName);
        et_desc = findViewById(R.id.et_desc);
        dd_genrelist = findViewById(R.id.tv_genrelist);
        et_year = findViewById(R.id.et_year);
        et_imdb = findViewById(R.id.et_imdb);
        tv_seekval = findViewById(R.id.tv_seekval);
        seekBar = findViewById(R.id.seekBar);
        addbutton = findViewById(R.id.addbutton);

        tv_seekval.setText("0");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genreList);
        dd_genrelist.setAdapter(adapter);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(et_movieName.getText()) || TextUtils.isEmpty(et_desc.getText()) || dd_genrelist.getSelectedItem().toString().equals("Select") || TextUtils.isEmpty(et_year.getText()) || TextUtils.isEmpty(et_imdb.getText())) {
                    if (TextUtils.isEmpty(et_movieName.getText()))
                        Toast.makeText(AddMovieActivity.this, "Enter Movie Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(et_desc.getText()))
                        Toast.makeText(AddMovieActivity.this, "Enter Description", Toast.LENGTH_SHORT).show();
                    else if (dd_genrelist.getSelectedItem().toString().equals("Select") )
                        Toast.makeText(AddMovieActivity.this, "Select Genre", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(et_year.getText()))
                        Toast.makeText(AddMovieActivity.this, "Enter Year", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(et_imdb.getText()))
                        Toast.makeText(AddMovieActivity.this, "Enter IMDB Link", Toast.LENGTH_SHORT).show();
                } else {
//                    Intent putMovie = new Intent(AddMovieActivity.this, MainActivity.class);
                    Movie movie = new Movie();
                    movie.setName(et_movieName.getText().toString());
                    movie.setDescription(et_desc.getText().toString());
                    movie.setGenre(dd_genrelist.getSelectedItem().toString());
                    movie.setRating(Integer.parseInt(tv_seekval.getText().toString()));
                    movie.setYear(Integer.parseInt(et_year.getText().toString()));
                    movie.setImdb(et_imdb.getText().toString());
                    Intent putMovie = new Intent();

                    putMovie.putExtra("Movie", movie);
                    Toast.makeText(AddMovieActivity.this, "Movie added", Toast.LENGTH_SHORT).show();
                    setResult(100,putMovie);
                    finish();
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_seekval.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
