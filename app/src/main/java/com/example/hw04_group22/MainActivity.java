/*
Group No: 22
Group Members: Neeraj Auti
               Vedija Jagtap
 */

package com.example.hw04_group22;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button_add;
    Button button_edit;
    Button button_delete;
    Button button_listYear;
    Button button_listRate;

    ArrayList<Movie> movieList = new ArrayList<>();
    List<CharSequence> movieNameList = new ArrayList<>();
    final int REQ_CODE_ADD_MOVIE = 100;
    final int REQ_CODE_EDIT_MOVIE = 200;
    int position=0;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (REQ_CODE_ADD_MOVIE): {
                if (AddMovieActivity.RESULT_OK == -1) {
                    if(data !=null) {
                        movieList.add((Movie) data.getSerializableExtra("Movie"));
                        movieNameList.add(movieList.get(movieList.size() - 1).name);
                    }
                }
                break;
            }
            case REQ_CODE_EDIT_MOVIE:
                if (EditActivity.RESULT_OK == -1) {
                    if(data !=null) {
                        movieList.add(position,(Movie) data.getSerializableExtra("Movie"));
                        movieNameList.add(position,movieList.get(movieList.size() - 1).name);
                    }
                }
                break;
        }
    }

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
                startActivityForResult(addMovie, REQ_CODE_ADD_MOVIE);
            }
        });

        button_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (movieList.size() == 0)
                    Toast.makeText(getApplicationContext(), "No Movies to edit", Toast.LENGTH_LONG).show();
                else {
                    final Intent edit = new Intent(MainActivity.this, EditActivity.class);
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Pick a Movie");

                    builder.setItems(movieNameList.toArray(new CharSequence[movieNameList.size()]), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Movie temp = movieList.get(which);
                            edit.putExtra("Movie", temp);
                            position=which;
                            movieList.remove(which);
                            movieNameList.remove(which);
                            startActivityForResult(edit, REQ_CODE_EDIT_MOVIE);
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (movieList.size() == 0)
                    Toast.makeText(getApplicationContext(), "No Movies to delete", Toast.LENGTH_LONG).show();
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Pick a Movie");
                    builder.setItems(movieNameList.toArray(new CharSequence[movieNameList.size()]), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String movieTitle = movieNameList.get(which).toString();
                            movieList.remove(which);
                            movieNameList.remove(which);
                            Toast.makeText(MainActivity.this, "Movie '" + movieTitle + "' Deleted!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

        button_listYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (movieList.size() == 0)
                    Toast.makeText(getApplicationContext(), "No Movies to display", Toast.LENGTH_LONG).show();
                else {
                    Intent listYear = new Intent("com.example.hw04_group22.intent.action.VIEW1");
                    listYear.addCategory(Intent.CATEGORY_DEFAULT);
                    listYear.putExtra("Movie", movieList);
                    Intent chooser = Intent.createChooser(listYear, "Choose Page");
                    if (listYear.resolveActivity(getPackageManager()) != null) {
                        startActivity(chooser);
                    }
                }
            }
        });

        button_listRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (movieList.size() == 0)
                    Toast.makeText(getApplicationContext(), "No Movies to display", Toast.LENGTH_LONG).show();
                else {
                    Intent listRating = new Intent("com.example.hw04_group22.intent.action.VIEW");
                    listRating.addCategory(Intent.CATEGORY_DEFAULT);
                    listRating.putExtra("Movie", movieList);
                    Intent chooser = Intent.createChooser(listRating, "Choose Page");
                    if (listRating.resolveActivity(getPackageManager()) != null) {
                        startActivity(chooser);
                    }
                }
            }
        });
    }

}
