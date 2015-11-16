package br.com.dhiegoabrantes.wheresmypack.service.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import br.com.dhiegoabrantes.wheresmypack.facade.PackFacade;

/**
 * Created by dhiego on 10/11/15.
 */
public class TrackPackReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("wmp", "TrackPackReceiver recebido!");
    }
}

