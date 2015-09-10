package main;

import java.sql.SQLException;
import java.util.List;

import br.edu.nassau.pweb.dao.DaoUsuario;
import br.edu.nassau.pweb.dao.DaoUsuarioFile;
import br.edu.nassau.pweb.dao.DaoUsuarioImpl;
import br.edu.nassau.pweb.model.Usuario;

public class Main {

	public static void main(String[] args) {
		DaoUsuario daoFile = new DaoUsuarioFile();
		DaoUsuario daoDB = new DaoUsuarioImpl();
		try {
			for(int i = 0; i < 5; i++){
				Usuario u = new Usuario();
				u.setNome("Usuario"+i);
				u.setLogin("LoginUsuario"+i);
				u.setSenha("SenhaUsuario"+i);
				
				daoDB.save(u);
			}
			List<Usuario> usuarios = daoDB.list();
			
			for (Usuario usuario : usuarios) {
				System.out.println("nome: " + usuario.getNome());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
