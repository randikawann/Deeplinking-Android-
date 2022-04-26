package com.rancreation.deeplinkingsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DataBackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_back);

        Button btnOpenReceiver = findViewById(R.id.btnOpenReceiver);
        Uri uri = getIntent().getData();

        if(uri!=null){
            String path = uri.toString();
            String authcode = uri.getQueryParameter("authcode222");
            Toast.makeText(this, "DataBackActivity=====back data "+authcode, Toast.LENGTH_SHORT).show();

        }

        btnOpenReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.rancreation.deeplinkingreceiver");
                if (intent != null) {
                    Intent dfv = new Intent(Intent.ACTION_VIEW, Uri.parse("uaepassstg://authorisation?clientId=user1"));
                    startActivity(dfv);



                } else {
                    Toast.makeText(getApplicationContext(), "Application not available", Toast.LENGTH_SHORT).show();
//            // Bring user to the market or let them choose an app?
//            intent = new Intent(Intent.ACTION_VIEW);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            intent.setData(Uri.parse("market://details?id=" + "ae.uaepass.mainapp.stg"));
//            startActivity(intent);
                }
            }
        });

    }
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        //LOAD THIS APP BACK
//        this.onBackPressed();
//    }
}