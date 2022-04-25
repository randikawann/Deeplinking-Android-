package com.rancreation.deeplinkingreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = findViewById(R.id.tvText);
        Uri uri = getIntent().getData();

        if(uri!=null){
            String path = uri.toString();
            String mapname = uri.getQueryParameter("mapname");
            tvText.setText(mapname);

        }
    }
}