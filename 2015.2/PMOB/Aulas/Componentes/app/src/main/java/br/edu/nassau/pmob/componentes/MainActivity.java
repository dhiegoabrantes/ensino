package br.edu.nassau.pmob.componentes;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import br.edu.nassau.pmob.componentes.view.ArrayAdapterActivity;
import br.edu.nassau.pmob.componentes.view.CustomAdapterActivity;
import br.edu.nassau.pmob.componentes.view.EditTextActivity;
import br.edu.nassau.pmob.componentes.view.MyActionBarActivity;
import br.edu.nassau.pmob.componentes.view.TextViewActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonTextView).setOnClickListener(this);
        findViewById(R.id.buttonEditText).setOnClickListener(this);
        findViewById(R.id.buttonArrayAdapter).setOnClickListener(this);
        findViewById(R.id.buttonCustomAdapter).setOnClickListener(this);
        findViewById(R.id.buttonActionBar).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonTextView:
                Intent buttonTextViewIntent = new Intent(this, TextViewActivity.class);
                startActivity(buttonTextViewIntent);
                break;
            case R.id.buttonEditText:
                Intent buttonEditTextIntent = new Intent(this, EditTextActivity.class);
                startActivity(buttonEditTextIntent);
                break;
            case R.id.buttonArrayAdapter:
                Intent buttonArrayAdapterIntent = new Intent(this, ArrayAdapterActivity.class);
                startActivity(buttonArrayAdapterIntent);
                break;
            case R.id.buttonCustomAdapter:
                Intent buttonCustomAdapterIntent = new Intent(this, CustomAdapterActivity.class);
                startActivity(buttonCustomAdapterIntent);
                break;
            case R.id.buttonActionBar:
                Intent buttonActionBarIntent = new Intent(this, MyActionBarActivity.class);
                startActivity(buttonActionBarIntent);
                break;
        }
    }
}
