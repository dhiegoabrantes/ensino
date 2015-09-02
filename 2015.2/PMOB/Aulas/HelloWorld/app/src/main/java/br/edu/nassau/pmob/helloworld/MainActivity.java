package br.edu.nassau.pmob.helloworld;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button botaoSomar = (Button) findViewById(R.id.botaoSomar);
        botaoSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText valor1EditText = (EditText) findViewById(R.id.editTextValor1);
                EditText valor2EditText = (EditText) findViewById(R.id.editTextValor2);

                Integer valor1 = Integer.valueOf(valor1EditText.getText().toString());
                Integer valor2 = Integer.valueOf(valor2EditText.getText().toString());

                Integer resultado = valor1 + valor2;

//                Toast.makeText(MainActivity.this, "Resultado: " + resultado, Toast.LENGTH_LONG).show();


                Intent it = new Intent(MainActivity.this, SegundaTelaActivity.class);
                it.putExtra("resultado", resultado);
                startActivity(it);
            }
        });


    }

}
