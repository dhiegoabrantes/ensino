package br.edu.nassau.pmob.componentes.view;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.nassau.pmob.componentes.R;


public class EditTextActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    private EditText mEdtNome;
    private EditText mEdtEmail;
    private EditText mEdtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        mEdtNome  = (EditText)findViewById(R.id.edtNome);
        mEdtEmail = (EditText)findViewById(R.id.edtEmail);
        mEdtSenha = (EditText)findViewById(R.id.edtSenha);
        mEdtSenha.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (v == mEdtSenha &&
                EditorInfo.IME_ACTION_DONE == actionId) {
            String nome = mEdtNome.getText().toString();
            String email = mEdtEmail.getText().toString();
            String senha = mEdtSenha.getText().toString();
            boolean validated = true;
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                mEdtEmail.setError(getString(R.string.msg_erro_email));
                validated = false;
            }
            if (!senha.equals("123")) {
                mEdtSenha.setError(
                        getString(R.string.msg_erro_senha));
                validated = false;
            }
            if (validated) {
                Toast.makeText(this,
                        getString(R.string.msg_sucesso, nome, email),
                        Toast.LENGTH_SHORT).show();
            }
            return false;
        }
        return false;
    }
}
