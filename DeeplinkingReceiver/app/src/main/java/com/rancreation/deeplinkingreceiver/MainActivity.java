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
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.rancreation.deeplinkingreceiver");
                if (intent != null) {
                    Intent dfv = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com?mapname=50"));
                    startActivity(dfv);



                } else {
                    Toast.makeText(MainActivity.this, "Application not available", Toast.LENGTH_SHORT).show();
//            // Bring user to the market or let them choose an app?
//            intent = new Intent(Intent.ACTION_VIEW);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            intent.setData(Uri.parse("market://details?id=" + "ae.uaepass.mainapp.stg"));
//            startActivity(intent);
                }
            }
        });

        tvText = findViewById(R.id.tvText);
        Uri uri = getIntent().getData();

        if(uri!=null){
            String path = uri.toString();
            String mapname = uri.getQueryParameter("mapname");
            tvText.setText(mapname);

        }
    }
}