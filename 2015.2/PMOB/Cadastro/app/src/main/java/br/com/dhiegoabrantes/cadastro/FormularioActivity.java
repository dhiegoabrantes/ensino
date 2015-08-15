package br.com.dhiegoabrantes.cadastro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import br.com.dhiegoabrantes.cadastro.domain.Aluno;

/**
 * Created by dhiego on 13/08/15.
 */
public class FormularioActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.formulario);


        findViewById(R.id.botaoSalvar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nomeEditText = (EditText) findViewById(R.id.editTextNome);
                EditText siteEditText = (EditText) findViewById(R.id.editTextSite);
                EditText enderecoEditText = (EditText) findViewById(R.id.editTextEndereco);
                EditText telefoneEditText = (EditText) findViewById(R.id.editTextTelefone);
                RatingBar ratingBarEditText = (RatingBar) findViewById(R.id.ratingBarNota);

                String nome = nomeEditText.getText().toString();
                String site = siteEditText.getText().toString();
                String endereco = enderecoEditText.getText().toString();
                String telefone = telefoneEditText.getText().toString();
                float nota = ratingBarEditText.getRating();

                Aluno aluno = new Aluno(nome, site, endereco, telefone, nota);
                BD.Alunos.add(aluno);

                clearFields();
                Toast.makeText(FormularioActivity.this, "Aluno " + aluno.getNome() + " inserido com sucesso!", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void clearFields(){
        ((EditText)findViewById(R.id.editTextNome)).setText("");
        ((EditText)findViewById(R.id.editTextSite)).setText("");
        ((EditText)findViewById(R.id.editTextEndereco)).setText("");
        ((EditText)findViewById(R.id.editTextTelefone)).setText("");
        ((RatingBar)findViewById(R.id.ratingBarNota)).setRating(0);
    }
}
