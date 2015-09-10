package br.edu.nassau.pweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.nassau.pweb.model.Usuario;

public class DaoUsuarioImpl extends GenericDao implements DaoUsuario{

	public void save(Usuario usuario) throws SQLException{
		String sql = "INSERT INTO usuarios (nome, login, senha) VALUES (?,?,?)";	
		Connection conn = null;
		PreparedStatement st = null;
		try {
			
			conn = getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, usuario.getNome());
			st.setString(2, usuario.getLogin());
			st.setString(3, usuario.getSenha());
			
			st.execute();
			
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			st.close();
			conn.close();
		}	
	}
	
	public void update(Usuario usuario) throws SQLException{
		String sql = "UPDATE usuarios SET nome=?, login=?, senha=? WHERE id=?";
		Connection conn= null;
		PreparedStatement st =null;
		
		conn = getConnection();
		st = conn.prepareStatement(sql);
		try {
			st.setString(1, usuario.getNome());
			st.setString(2, usuario.getLogin());
			st.setString(3, usuario.getSenha());
			st.setInt(4, usuario.getId());
			
			st.execute();
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			st.close();
			conn.close();
		}	
	}
	
	public void remove(Usuario usuario) throws SQLException{
		String  sql = "DELETE from usuarios WHERE id = ?";
		Connection conn = null;
		PreparedStatement st = null;
		
		conn = getConnection();
		st = conn.prepareStatement(sql);
		
		try {
			st.setInt(1, usuario.getId());
			st.execute();
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			st.close();
			conn.close();
		}
		
	}
	
	public Usuario get(int id){
		String sql = "SELECT * FROM usuarios WHERE id=?";
		
		try {
			Connection conn = getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet resultSet = st.executeQuery();
			
			if( resultSet.next() ){
				int idRs = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String login = resultSet.getString("login");
				String senha = resultSet.getString("senha");
				
				Usuario u = new Usuario();
				u.setId(idRs);
				u.setNome(nome);
				u.setLogin(login);
				u.setSenha(senha);
				
				st.close();
				conn.close();
				
				return u;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Usuario> list() throws SQLException{
		String sql = "SELECT * FROM usuarios";
		
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = getConnection();
			st = conn.prepareStatement(sql);
			ResultSet resultSet = st.executeQuery();
			
			
			List<Usuario> usuarios = new ArrayList<Usuario>();
			while( resultSet.next() ){
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String login = resultSet.getString("login");
				String senha = resultSet.getString("senha");
				
				Usuario u = new Usuario();
				u.setId(id);
				u.setNome(nome);
				u.setLogin(login);
				u.setSenha(senha);
				usuarios.add(u);
			}
			
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			st.close();
			conn.close();
		}
	}
	
	
	public static void main(String[] args) {
		
		DaoUsuario dao = new DaoUsuarioFile();
	
		
		try {
			
			for(int i = 0; i < 5; i++){
				Usuario u = new Usuario();
				u.setNome("Usuario"+i);
				u.setLogin("LoginUsuario"+i);
				u.setSenha("SenhaUsuario"+i);
				
				dao.save(u);
			}
			
			
			List<Usuario> usuarios = dao.list();
			
			for (Usuario usuario : usuarios) {
				System.out.println("nome: " + usuario.getNome());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
				
		
		
		
		
		
		
		
	}

}
