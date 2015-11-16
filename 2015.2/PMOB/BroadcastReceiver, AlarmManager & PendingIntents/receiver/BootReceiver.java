package br.com.dhiegoabrantes.wheresmypack.service.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by dhiego on 11/11/15.
 */
public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intentTrackPackReceiver = new Intent(ReceiverConstants.TRACKPACK_RECEIVER);
        PendingIntent pendingIntentTrackPackReceiver = PendingIntent.getBroadcast(context, 0, intentTrackPackReceiver, PendingIntent.FLAG_NO_CREATE);
        boolean alreadyActive = (pendingIntentTrackPackReceiver != null);

        if( !alreadyActive ){
            Log.i("wmp", "Registrando alarme -> BootReceiver!");
            pendingIntentTrackPackReceiver = PendingIntent.getBroadcast(context, 0, intent, 0);
            AlarmManager alarm = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
            alarm.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000, pendingIntentTrackPackReceiver);
        }

    }
}
