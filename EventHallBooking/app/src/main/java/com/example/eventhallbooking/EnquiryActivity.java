package com.example.eventhallbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class EnquiryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);

        EditText selectedHall = findViewById(R.id.editTextHallName);
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            selectedHall.setText(intent.getStringExtra("hallname"));
        }
    }
}