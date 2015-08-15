package br.com.dhiegoabrantes.copypaste;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button copiar = (Button) findViewById(R.id.btnCopiar);
        final TextView destino = (TextView) findViewById(R.id.destino);
        final EditText origem = (EditText) findViewById(R.id.origem);

        copiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destino.setText( origem.getText() );
            }
        });

    }
}
