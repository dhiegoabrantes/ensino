package br.edu.nassau.pweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.edu.nassau.pweb.model.Usuario;

public class DaoUsuarioImpl extends GenericDao implements DaoUsuario{

	public void save(Usuario usuario) throws SQLException{
		String sql = "INSERT INTO usuarios (nome, login, senha) VALUES (?,?,?)";	
		Connection conn = null;
		PreparedStatement st = null;
		try {
			
			openConn();
			st = conn.prepareStatement(sql);
			st.setString(1, usuario.getNome());
			st.setString(2, usuario.getLogin());
			st.setString(3, usuario.getSenha());
			
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			st.close();
			closeConn();
		}	
	}
	
	public void update(Usuario usuario) throws SQLException{
		String sql = "UPDATE usuarios SET nome=?, login=?, senha=? WHERE id=?";
		//Implemente a lógica do código aqui!
	}
	
	public void remove(Usuario usuario) throws SQLException{
		String  sql = "DELETE from usuarios WHERE id = ?";
		//Implemente a lógica do código aqui!
	}
	
	public Usuario get(int id){
		String sql = "SELECT * FROM usuarios WHERE id=?";
		//Implemente a lógica do código aqui!
		return null;
	}
	
	public List<Usuario> list() throws SQLException{
		String sql = "SELECT * FROM usuarios";
		//Implemente a lógica do código aqui!
		return null;
	}
	
}
