package ru.exe.secret;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Viewl extends AppCompatActivity {

    TextView text;
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        text = findViewById(R.id.textView);
        text2 = findViewById(R.id.textView2);

        text.setText(MainActivity.ti);
        text2.setText(MainActivity.so);
    }
}