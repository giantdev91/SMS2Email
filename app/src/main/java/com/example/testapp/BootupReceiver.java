package com.example.testapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.tuenti.smsradar.Sms;
import com.tuenti.smsradar.SmsListener;
import com.tuenti.smsradar.SmsRadar;
import com.tuenti.smsradar.SmsRadarService;

public class BootupReceiver extends BroadcastReceiver {

    Context context;
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("BBB", "********************************Bootup Receiver********************************************");
        this.context = context;
//        SmsRadar.initializeSmsRadarService(context, new SmsListener() {
//            @Override
//            public void onSmsSent(Sms sms) {
//                showSmsToast(sms);
//            }
//
//            @Override
//            public void onSmsReceived(Sms sms) {
//                showSmsToast(sms);
//            }
//        });
//        Intent i = new Intent(context, SmsRadarService.class);
//        context.startService(i);
    }

    private void showSmsToast(Sms sms) {
        System.out.println("********************************Bootup Receiver********************************************");
        Log.d("AAA", "********************************Bootup Receiver********************************************");
        Toast.makeText(this.context, sms.toString(), Toast.LENGTH_LONG).show();
    }
}