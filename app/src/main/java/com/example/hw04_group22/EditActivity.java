package com.example.hw04_group22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class EditActivity extends AppCompatActivity {
    EditText et_movieNameEdit, et_descEdit, et_yearEdit, et_imdbEdit;
    TextView tv_seekvalEdit;
    Spinner dd_genrelistEdit;
    SeekBar seekBarEdit;
    Button savebutton;

    String[] genreList = {"Select", "Action", "Animation", "Comedy", "Documentary", "Family", "Horror", "Crime", "Others"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        setTitle("Edit Movie");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genreList);
        et_movieNameEdit = findViewById(R.id.et_movieNameEdit);
        et_descEdit = findViewById(R.id.et_descEdit);
        dd_genrelistEdit = findViewById(R.id.dd_genrelistEdit);
        et_yearEdit = findViewById(R.id.et_yearEdit);
        et_imdbEdit = findViewById(R.id.et_imdbEdit);
        tv_seekvalEdit = findViewById(R.id.tv_seekvalEdit);
        seekBarEdit = findViewById(R.id.seekBarEdit);
        savebutton = findViewById(R.id.savebutton);
        dd_genrelistEdit.setAdapter(adapter);

        final Intent editMovie = getIntent();
        Movie temp = (Movie) editMovie.getSerializableExtra("Movie");
        et_movieNameEdit.setText(temp.getName());
        et_descEdit.setText(temp.getDescription());
        dd_genrelistEdit.setSelection(adapter.getPosition(temp.getGenre()));
        et_yearEdit.setText(String.valueOf(temp.getYear()));
        et_imdbEdit.setText(temp.getImdb());
        tv_seekvalEdit.setText(String.valueOf(temp.getRating()));
        seekBarEdit.setProgress(temp.getRating());
        seekBarEdit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_seekvalEdit.setText(String.valueOf(seekBarEdit.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(et_movieNameEdit.getText()) || TextUtils.isEmpty(et_descEdit.getText()) || dd_genrelistEdit.getSelectedItem().toString().equals("Select") || TextUtils.isEmpty(et_yearEdit.getText()) || TextUtils.isEmpty(et_imdbEdit.getText())) {
                    if (TextUtils.isEmpty(et_movieNameEdit.getText()))
                        Toast.makeText(EditActivity.this, "Enter Movie Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(et_descEdit.getText()))
                        Toast.makeText(EditActivity.this, "Enter Description", Toast.LENGTH_SHORT).show();
                    else if (dd_genrelistEdit.getSelectedItem().toString().equals("Select"))
                        Toast.makeText(EditActivity.this, "Select Genre", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(et_yearEdit.getText()))
                        Toast.makeText(EditActivity.this, "Enter Year", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(et_imdbEdit.getText()))
                        Toast.makeText(EditActivity.this, "Enter IMDB Link", Toast.LENGTH_SHORT).show();
                } else if (et_yearEdit.getText().length() == 4 && Integer.parseInt(et_yearEdit.getText().toString()) > Calendar.getInstance().get(Calendar.YEAR)) {
                    Toast.makeText(EditActivity.this, "Year cannot be more than 2019", Toast.LENGTH_SHORT).show();
                } else if (et_yearEdit.getText().length() < 4) {
                    Toast.makeText(EditActivity.this, "Year should contain atleast 4 digits", Toast.LENGTH_SHORT).show();
                } else {
                    Movie movie = new Movie();
                    movie.setName(et_movieNameEdit.getText().toString());
                    movie.setDescription(et_descEdit.getText().toString());
                    movie.setGenre(dd_genrelistEdit.getSelectedItem().toString());
                    movie.setRating(Integer.parseInt(tv_seekvalEdit.getText().toString()));
                    movie.setYear(Integer.parseInt(et_yearEdit.getText().toString()));
                    movie.setImdb(et_imdbEdit.getText().toString());

                    editMovie.putExtra("Movie", movie);
                    Toast.makeText(EditActivity.this, "Movie Edited", Toast.LENGTH_SHORT).show();
                    setResult(200, editMovie);
                    finish();
                }
            }

        });
    }
}
