package com.example.eventappdsc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEventPage extends AppCompatActivity {

    Button btnDone;
    EditText eventName, eventDesc;
    String name ="";
    String desc ="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event_page);


        btnDone = findViewById(R.id.buttondone);
        eventName = findViewById(R.id.editeventName);
        eventDesc = findViewById(R.id.editdesc);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = eventName.getText().toString().trim();
                desc = eventDesc.getText().toString().trim();
                final int check = 1;
                Intent intent = new Intent(AddEventPage.this, MainActivity.class);
                intent.putExtra("FormName",name);
                intent.putExtra("FormDesc", desc);
                intent.putExtra("Check", check);
                Toast.makeText(AddEventPage.this, name, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }
}