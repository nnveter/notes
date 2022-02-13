package ru.exe.secret;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Add extends AppCompatActivity {

    Button mButton;
    EditText mEdit;
    EditText mEdit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        mButton = findViewById(R.id.button);
        mEdit = findViewById(R.id.editText);
        mEdit2 = findViewById(R.id.editTextTextMultiLine);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.title.add(mEdit.getText().toString());
                MainActivity.soder.add(mEdit2.getText().toString());
                MainActivity.dataAdapter.notifyDataSetChanged();
                try {
                    FileOutputStream fos = Add.this.openFileOutput("title.txt", Context.MODE_PRIVATE);
                    ObjectOutputStream os = new ObjectOutputStream(fos);
                    os.writeObject(MainActivity.title);
                    os.close();
                    fos.close();
                    FileOutputStream fos2 = Add.this.openFileOutput("body.txt", Context.MODE_PRIVATE);
                    ObjectOutputStream os2 = new ObjectOutputStream(fos2);
                    os2.writeObject(MainActivity.soder);
                    os2.close();
                    fos2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(Add.this, MainActivity.class));
            }
        });
    }
}