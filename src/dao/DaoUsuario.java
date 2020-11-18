package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.BeanLivros;
import beans.BeanUsuario;
import connection.SingleConnection;

public class DaoUsuario {
	
	private Connection connection;
	
	public DaoUsuario(){
		connection = SingleConnection.getConnection();
	}
	public void salvar(BeanUsuario usuario){

		try {
			String sql = "insert into usuario (login,senha,id) values (?,?,?)";
			PreparedStatement insert;
			insert = connection.prepareStatement(sql);
			insert.setString(1, usuario.getLogin());
			insert.setString(2, usuario.getSenha());
			insert.setString(3, usuario.getId());
			insert.execute();
			
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	public ArrayList<BeanUsuario> getlistaUsuario()throws Exception{

        ArrayList<BeanUsuario> listarUsuario = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        SingleConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
        	BeanUsuario beanUsuario = new BeanUsuario();
            beanUsuario.setLogin(resultSet.getString("login"));
            beanUsuario.setId(resultSet.getString("id"));
            beanUsuario.setEmprestimo(resultSet.getString("emprestimo"));

            listarUsuario.add(beanUsuario);
        }
        return listarUsuario;
    }
}
