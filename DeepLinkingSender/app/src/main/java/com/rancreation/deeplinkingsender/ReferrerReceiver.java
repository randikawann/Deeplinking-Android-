package com.rancreation.deeplinkingsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by Randika Wanninayaka on 2022-04-25.
 */
public class ReferrerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (!intent.getAction().equals("com.android.vending.INSTALL_REFERRER")) {
            return;
        }

        String referrer = intent.getStringExtra("referrer");
        try {
            // This is your data from th URL, you can do any kind of
            //    manipulation using this.
            referrer = URLDecoder.decode(referrer, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }
    }
}