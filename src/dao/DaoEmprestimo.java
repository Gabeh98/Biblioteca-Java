package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.BeanLivros;
import beans.BeanUsuario;
import connection.SingleConnection;

public class DaoEmprestimo {
	private Connection connection;
	
	public DaoEmprestimo() {
		connection = SingleConnection.getConnection();
	}

	public void Emprestar(BeanUsuario emprestimo){
		try {
			String sql = "UPDATE usuario SET emprestimo = ?";
	        sql += " WHERE id = ?";
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1,emprestimo.getEmprestimo());
			insert.setString(2,emprestimo.getId());

			insert.execute();
			
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try{
				connection.rollback();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}	
	}
	public void livroEmprestar(BeanLivros emprestimo){
		try {
			String sql = "UPDATE livro SET emprestimo = ?";
	        sql += " WHERE id = ?";
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1,emprestimo.getEmprestimo());
			insert.setString(2,emprestimo.getId());

			insert.execute();
			
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try{
				connection.rollback();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}	
	}
	public ArrayList<BeanUsuario> getUsuario(String usuario) throws Exception{
		
		ArrayList<BeanUsuario> listaUser = new ArrayList<>();
		String sql = "SELECT * FROM usuario ";
		sql+= "WHERE login = ?";
		SingleConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, usuario);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()){
			BeanUsuario beanUsuario = new BeanUsuario();
			beanUsuario.setLogin(resultSet.getString("login"));
			beanUsuario.setEmprestimo(resultSet.getString("emprestimo"));
			listaUser.add(beanUsuario);
		}
		return listaUser;
	}
}
