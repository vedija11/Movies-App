package com.example.hw04_group22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {
    EditText et_movieNameEdit, et_descEdit, et_yearEdit, et_imdbEdit;
    TextView tv_seekvalEdit,tv_genrelistEdit;
    SeekBar seekBarEdit;
    Button savebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        setTitle("Edit Movie");

        et_movieNameEdit = findViewById(R.id.et_movieNameEdit);
        et_descEdit = findViewById(R.id.et_descEdit);
        tv_genrelistEdit = findViewById(R.id.tv_genrelistEdit);
        et_yearEdit = findViewById(R.id.et_yearEdit);
        et_imdbEdit = findViewById(R.id.et_imdbEdit);
        tv_seekvalEdit = findViewById(R.id.tv_seekvalEdit);
        seekBarEdit = findViewById(R.id.seekBarEdit);
        savebutton = findViewById(R.id.savebutton);
    }
}
