package br.edu.nassau.pmob.componentes.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import br.edu.nassau.pmob.componentes.R;
import br.edu.nassau.pmob.componentes.adapter.MyCustomAdapter;
import br.edu.nassau.pmob.componentes.model.Pack;


public class CustomAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);

        List<Pack> packs = new LinkedList<Pack>();
        packs.add(new Pack("Pack1", "TrackNumber1"));
        packs.add(new Pack("Pack2", "TrackNumber2"));
        packs.add(new Pack("Pack3", "TrackNumber3"));

        MyCustomAdapter adapter = new MyCustomAdapter(this, packs);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pack pack = (Pack) parent.getItemAtPosition(position);
                Toast.makeText(CustomAdapterActivity.this, "Name: " + pack.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
