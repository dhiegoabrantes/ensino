package br.com.dhiegoabrantes.helloworld;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivityD extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_d);
        Log.i("helloWorld", "onCreate");

        Button b = (Button) findViewById(R.id.botao);
        b.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("helloWorld", "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("helloWorld", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("helloWorld", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("helloWorld", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("helloWorld", "onDestroy");
    }

    @Override
    public void onClick(View v) {
        Log.i("helloWorld", "clicou!");
    }
}
