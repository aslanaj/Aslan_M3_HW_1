package com.example.aslan_m3_hw_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnSend;

    private EditText etEmail;
    private EditText etSubject;
    private EditText etMassage;
    static  final String KEY_FOR_OPEN_EMAIL = "Send mail";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();

    }

    private void initListener() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEmail();
            }
        });
    }

    private void openEmail() {
        String email = etEmail.getText().toString();
        String subject = etSubject.getText().toString();
        String message = etMassage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{ email});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("email/*");
        intent.setPackage("com.google.android.gm");
        // Добавил пакет Gmail для принудительного открытия приложения Gmail.

        startActivity(Intent.createChooser(intent, KEY_FOR_OPEN_EMAIL));
    }

    private void initView() {
        btnSend = findViewById(R.id.btn_send);
        etEmail = findViewById(R.id.et_email);
        etSubject = findViewById(R.id.et_subject);
        etMassage = findViewById(R.id.et_massage);
    }


}