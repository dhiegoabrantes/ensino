package br.edu.nassau.pweb.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.nassau.pweb.model.Usuario;

public class DaoUsuarioFile implements DaoUsuario {

	@Override
	public void save(Usuario usuario) throws SQLException {
		System.out.println("Salvando em arquivo");
	}

	@Override
	public void update(Usuario usuario) throws SQLException {
		System.out.println("Atualizando em arquivo");
	}

	@Override
	public void remove(Usuario usuario) throws SQLException {
		System.out.println("Removendo em arquivo");
	}

	@Override
	public Usuario get(int id) {
		System.out.println("Recuperando registro do arquivo");
		return null;
	}

	@Override
	public List<Usuario> list() throws SQLException {
		System.out.println("Recuperando todos os registros do arquivo");
		return null;
	}

}
