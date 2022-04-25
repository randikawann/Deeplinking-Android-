package com.rancreation.deeplinkingsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnOpenReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpenReceiver = findViewById(R.id.btnOpenReceiver);

//        https://qa-id.uaepass.ae/trustedx-authservicer/oauth/man-as?redirect_url=https://stage.services.govenment.net.ae/business&client_id=sandbox_stage&state&response_type=code&scode=urn:uaeLdigitalIsd.profile&acr_values=urn:safelayentws.policies.authentication.eveblow&url_locales=en%27

        Uri uri = getIntent().getData();

        if(uri!=null){
            String path = uri.toString();
            String authcode = uri.getQueryParameter("authcode");
            Toast.makeText(this, "back data "+authcode, Toast.LENGTH_SHORT).show();

        }

        btnOpenReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.rancreation.deeplinkingreceiver");
                if (intent != null) {
                    Intent dfv = new Intent(Intent.ACTION_VIEW, Uri.parse("uaepassstg://authorisation?clientId=user1"));
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

    }
}