package com.rancreation.deeplinkingreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvText;
    Button btnbacksend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnbacksend= findViewById(R.id.btnbacksend);

        btnbacksend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dfv = new Intent(Intent.ACTION_VIEW, Uri.parse("duapp://authorisation?authcode=abcdef"));
                startActivity(dfv);
            }
        });

        tvText = findViewById(R.id.tvText);
        Uri uri = getIntent().getData();

        if(uri!=null){
            String path = uri.toString();
            String mapname = uri.getQueryParameter("clientId");
            tvText.setText(mapname);

        }
    }
}