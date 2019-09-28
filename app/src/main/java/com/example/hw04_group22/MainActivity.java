package com.example.hw04_group22;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button_add;
    Button button_edit;
    Button button_delete;
    Button button_listYear;
    Button button_listRate;

    ArrayList<Object> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Favorite Movies");

        button_add = findViewById(R.id.button_add);
        button_edit = findViewById(R.id.button_edit);
        button_delete = findViewById(R.id.button_delete);
        button_listYear = findViewById(R.id.button_listYear);
        button_listRate = findViewById(R.id.button_listRate);


        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addMovie = new Intent(MainActivity.this, AddMovieActivity.class);
                //addMovie.putExtra("MovieList", movieList);
                startActivity(addMovie);
                finish();
            }
        });

        button_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent edit = new Intent(MainActivity.this, EditActivity.class);
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Pick a Movie");

                builder.setItems(movieList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int name) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();*/
                //edit.putExtra("MovieList", movieList);
                startActivity(edit);
                finish();
            }
        });

        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent deleteMovie = new Intent(MainActivity.this, DeleteMovieActivity.class);
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Pick a Movie");

                builder.setItems(movieList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int name) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();*/
                startActivity(deleteMovie);
                finish();
            }
        });

        button_listYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listYear = new Intent(MainActivity.this, DisplayListYearActivity.class);
                //listYear.putExtra("MovieList", movieList);
                startActivity(listYear);
                finish();
            }
        });

        button_listRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listRating = new Intent(MainActivity.this, DisplayListRatingActivity.class);
                //listRating.putExtra("MovieList", movieList);
                startActivity(listRating);
                finish();
            }
        });
    }
}
