package br.com.dhiegoabrantes.cadastro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.dhiegoabrantes.cadastro.adapter.AlunoAdapter;
import br.com.dhiegoabrantes.cadastro.domain.Aluno;

/**
 * Created by dhiego on 09/08/15.
 */
public class ListaAlunosActivity extends AppCompatActivity {

//    List<String> listaItems = new ArrayList<String>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista_alunos, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setupMenu(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem_alunos);
        setupLista();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fillLista();
    }

    private void setupLista(){
        ListView lista = (ListView) findViewById(R.id.lista);
        //Associamos um comportamento ao evento de click simples dos itens da lista
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Recuperamos o objeto clicado
                Aluno obj = (Aluno) parent.getItemAtPosition(position);
                Toast.makeText(ListaAlunosActivity.this, "Posição: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        //Associamos um comportamento ao evento de click longo dos itens da lista
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Recuperamos o objeto clicado
                Aluno obj = (Aluno) parent.getItemAtPosition(position);
                Toast.makeText(ListaAlunosActivity.this, "Item: " + obj.getNome(), Toast.LENGTH_SHORT).show();

                //
                return true;
            }
        });
    }

    private void fillLista(){
        List<Aluno> alunos = BD.Alunos.getAll();
        final ListView lista = (ListView) findViewById(R.id.lista);

        AlunoAdapter ad = new AlunoAdapter(ListaAlunosActivity.this, alunos);
        //Associando o adapter à lista
        lista.setAdapter(ad);
    }

    private void setupMenu(MenuItem item){
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()){
            case R.id.menuOpNovo:
                Intent intent = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                startActivity(intent);
                break;
        }
    }
}
