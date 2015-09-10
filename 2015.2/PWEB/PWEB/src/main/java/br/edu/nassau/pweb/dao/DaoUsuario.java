package br.edu.nassau.pweb.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.nassau.pweb.model.Usuario;

public interface DaoUsuario {

	public void save(Usuario usuario) throws SQLException;
	
	public void update(Usuario usuario) throws SQLException;
	
	public void remove(Usuario usuario) throws SQLException;
	
	public Usuario get(int id);
	
	public List<Usuario> list() throws SQLException;
	
}
