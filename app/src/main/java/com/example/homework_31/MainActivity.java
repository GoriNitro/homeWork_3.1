package com.example.homework_31;

import static android.content.Intent.EXTRA_EMAIL;
import static android.content.Intent.EXTRA_SUBJECT;
import static android.content.Intent.EXTRA_TEXT;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    TextInputEditText editTextEmail;
    TextInputEditText editTextTheme;
    TextInputEditText editText;
    Button button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextEmail = findViewById(R.id.txt);
        editTextTheme = findViewById(R.id.txt1);
        editText = findViewById(R.id.txt2);
        button = findViewById(R.id.button);
        initListener();
    }
    private void initListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(EXTRA_EMAIL, (Objects.requireNonNull(editTextEmail.getText())).toString());
                intent.putExtra(EXTRA_SUBJECT,(Objects.requireNonNull(editTextTheme.getText())).toString());
                intent.putExtra(EXTRA_TEXT, (Objects.requireNonNull(editText.getText())).toString());
                startActivity(Intent.createChooser(intent, "Send to"));
            }
        });
    }
}