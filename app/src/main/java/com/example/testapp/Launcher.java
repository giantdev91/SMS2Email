package com.example.testapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Launcher extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("MyLauncher", "****************************************MyLauncher**************************************");
//        Intent i = new Intent();
//        i.setClassName("com.pkg", "com.pkg.yourStartActivity");
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(i);
    }
}
