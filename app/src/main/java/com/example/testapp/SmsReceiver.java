package com.example.testapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;

public class SmsReceiver extends BroadcastReceiver {

   @Override
   public void onReceive(Context context, Intent intent) {
      if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())) {
         Bundle bundle = intent.getExtras();
         if (bundle != null) {
            Object[] pdus = (Object[]) bundle.get("pdus");
            if (pdus != null && pdus.length > 0) {
               for (Object pdu : pdus) {
                  SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu);
                  String sender = smsMessage.getDisplayOriginatingAddress();
                  String messageBody = smsMessage.getMessageBody();

                  // Do something with the incoming SMS content
               }
            }
         }
      }
   }

   public void registerReceiver(Context context) {
      IntentFilter filter = new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
      context.registerReceiver(this, filter);
   }

   public void unregisterReceiver(Context context) {
      context.unregisterReceiver(this);
   }
}