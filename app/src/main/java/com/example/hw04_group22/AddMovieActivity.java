package com.example.hw04_group22;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class AddMovieActivity extends AppCompatActivity {

    EditText et_movieName, et_desc, et_year, et_imdb;
    TextView tv_seekval,tv_genrelist ;
    SeekBar seekBar;
    Button addbutton;

    String[] genreList = {"Action", "Animation", "Comedy", "Documentry", "Family", "Horror", "Crime", "Others"};

    //String movieName = "";
    //String description = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);
        setTitle("Add Movie");

        et_movieName = findViewById(R.id.et_movieName);
        et_desc = findViewById(R.id.et_desc);
        tv_genrelist = findViewById(R.id.tv_genrelist);
        et_year = findViewById(R.id.et_year);
        et_imdb = findViewById(R.id.et_imdb);
        tv_seekval = findViewById(R.id.tv_seekval);
        seekBar = findViewById(R.id.seekBar);
        addbutton = findViewById(R.id.addbutton);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //movieName = et_movieName.getText().toString();
                //description = et_desc.getText().toString();

                Toast.makeText(AddMovieActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
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

        tv_genrelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AddMovieActivity.this);
                builder.setTitle("Select a Genre:");

                builder.setItems(genreList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tv_genrelist.setText(genreList[which]);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
