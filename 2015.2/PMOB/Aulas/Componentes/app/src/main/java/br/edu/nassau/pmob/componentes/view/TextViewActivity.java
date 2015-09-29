package br.edu.nassau.pmob.componentes.view;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import br.edu.nassau.pmob.componentes.R;


public class TextViewActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        Typeface typefaceGoodDog = Typeface.createFromAsset(getAssets(), "GoodDog.otf");
        TextView textViewFonte = (TextView) findViewById(R.id.textViewFonte);
        textViewFonte.setTypeface(typefaceGoodDog);

        TextView textViewSublinhado = (TextView) findViewById(R.id.textViewSublinhado);
        textViewSublinhado.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        TextView textViewRiscado = (TextView) findViewById(R.id.textViewRiscado);
        textViewRiscado.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }
}
