package com.example.headphone4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnStart;
    CheckBox cbRemember;
    TextView tvForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnStart = findViewById(R.id.btnStart);
        cbRemember = findViewById(R.id.cbRemember);
        tvForgot = findViewById(R.id.tvForgot);

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateButton();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        etEmail.addTextChangedListener(watcher);
        etPassword.addTextChangedListener(watcher);

        btnStart.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this,
                    "Email: " + etEmail.getText() +
                            "\nПароль: " + etPassword.getText(),
                    Toast.LENGTH_SHORT).show();
        });

        tvForgot.setOnClickListener(v ->
                Toast.makeText(MainActivity.this,
                        "Функция восстановления пароля",
                        Toast.LENGTH_SHORT).show()
        );

        updateButton();
    }

    private void updateButton() {
        boolean ready =
                !etEmail.getText().toString().isEmpty() &&
                        !etPassword.getText().toString().isEmpty();

        btnStart.setEnabled(ready);

        if (ready) {
            btnStart.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
            btnStart.setTextColor(getResources().getColor(android.R.color.white));
        } else {
            btnStart.setBackgroundColor(0xFFCCCCCC);
            btnStart.setTextColor(0xFF666666);
        }
    }
}