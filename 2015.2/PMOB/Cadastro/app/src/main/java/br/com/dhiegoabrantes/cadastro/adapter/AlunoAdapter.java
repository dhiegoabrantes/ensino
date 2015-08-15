package br.com.dhiegoabrantes.cadastro.adapter;

import android.content.Context;
import android.widget.TextView;

import java.util.List;

import br.com.dhiegoabrantes.cadastro.domain.Aluno;

/**
 * Created by dhiego on 15/08/15.
 */
public class AlunoAdapter extends GenericListAdapter<Aluno> {

    public AlunoAdapter(Context context, List<Aluno> objects) {
        super(context, objects);
    }

    @Override
    public void drawText(TextView textView, Aluno object) {
        textView.setText( object.getNome() );
    }
}
