package com.example.eventhallbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eventhallbooking.R;

public class ClickedItemActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked_item);

        imageView = findViewById(R.id.imageViewClicked);
        textView = findViewById(R.id.tvNameClicked);

        //set Value
        Intent intent = getIntent();
        if(intent.getExtras() != null) {
            String selectedName = intent.getStringExtra("name");
            int selectedImage = intent.getIntExtra("image",0);

            textView.setText(selectedName);
            imageView.setImageResource(selectedImage);

            Button enquiryButton = findViewById(R.id.buttonEnquiry);
            enquiryButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String hallName = textView.getText().toString();
                    startActivity(new Intent(v.getContext(), EnquiryActivity.class).putExtra(
                            "hallname",hallName));
                }
            });
        }
    }
}