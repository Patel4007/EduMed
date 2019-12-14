package com.appspouch.edumed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView text_detail;
    TextView text_cause;
    private String details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        details = intent.getStringExtra("itemDetail");


        text_detail = findViewById(R.id.item_detail);
        text_detail.setText(details);

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent1 = getIntent();
        details = intent.getStringExtra("itemCause");

        text_cause = findViewById(R.id.item_detail);
        text_cause.setText((details));
    }
}
