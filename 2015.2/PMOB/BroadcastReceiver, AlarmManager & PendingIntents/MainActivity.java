package br.com.dhiegoabrantes.wheresmypack;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.dhiegoabrantes.wheresmypack.adapter.PackAdapter;
import br.com.dhiegoabrantes.wheresmypack.domain.Pack;
import br.com.dhiegoabrantes.wheresmypack.domain.PackEvent;
import br.com.dhiegoabrantes.wheresmypack.facade.PackFacade;
import br.com.dhiegoabrantes.wheresmypack.service.receiver.ReceiverConstants;
import br.com.dhiegoabrantes.wheresmypack.view.PackActivity;
import br.com.dhiegoabrantes.wheresmypack.view.PackEventActivity;

public class MainActivity extends AppCompatActivity {

    private PackFacade packFacade;
    private ListView listViewPacks;
    private Pack selectedPack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupAlarm();

    }


    public void setupAlarm(){
        //Criamos uma intent para indicar o tipo de broadcast que será 'disparado'
        Intent intentTrackPackReceiver = new Intent(ReceiverConstants.TRACKPACK_RECEIVER);

        //Verificamos se já existe um broadcast registrado com a intent 'intentTrackPackReceiver' e configuramos, por meio do 'PendingIntent.FLAG_NO_CREATE',
        //para não criar a PendingIntent. Ou seja, se não existir, não irá criar. Iremos utilizar esse passo apenas para verificar se existe!
        PendingIntent pendingIntentTrackPackReceiver = PendingIntent.getBroadcast(this, 0, intentTrackPackReceiver, PendingIntent.FLAG_NO_CREATE);
        
        //Se 'pendingIntentTrackPackReceiver' != null, já existe broadcast criado!
        boolean alreadyActive = (pendingIntentTrackPackReceiver != null);

        //Se não existe broadcast criado, criaremos neste momento!
        if( !alreadyActive ){
            Log.i("wmp", "Registrando alarme -> MainActivity!");
            //Instanciamos o PendingIntent
            pendingIntentTrackPackReceiver = PendingIntent.getBroadcast(this, 0, intentTrackPackReceiver, 0);

            //Acessamos o alarm manager
            AlarmManager alarme = (AlarmManager) this.getSystemService(this.ALARM_SERVICE);

            // Configuramos o alarme para executar mesmo que o dispositivo esteja em repouso (AlarmManager.RTC_WAKEUP), 
            // a partir do horário atual (System.currentTimeMillis()),
            // a cada 60000 milisegundos (1 minuto)
            // executando a pendingIntentTrackPackReceiver
            alarme.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 60000, pendingIntentTrackPackReceiver);
        }
    }

}
