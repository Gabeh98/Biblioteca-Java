package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.BeanLivros;
import beans.BeanUsuario;
import connection.SingleConnection;

public class DaoLivros {
	private Connection connection;
	public DaoLivros(){
		connection = SingleConnection.getConnection();
	}
	public void salvar(BeanLivros livro){

		try {
			String sql = "insert into livro (nome,autor,status,id) values (?,?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1,livro.getNome());
			insert.setString(2,livro.getAutor());
			insert.setString(3,livro.getStatus());
			insert.setString(4, livro.getId());
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
	public void status(BeanLivros livro){
		try {
			String sql = "UPDATE livro SET status = ?";
	        sql += " WHERE nome = ?";
	        
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1,livro.getStatus());
			insert.setString(2,livro.getNome());
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
	public ArrayList<BeanLivros> getlistaLivro()throws Exception{

        ArrayList<BeanLivros> listaLivro = new ArrayList<>();
        String sql = "SELECT * FROM livro";
        SingleConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            BeanLivros beanLivro = new BeanLivros();
            beanLivro.setNome(resultSet.getString("nome"));
            beanLivro.setStatus(resultSet.getString("status"));
            beanLivro.setId(resultSet.getString("id"));
            
            listaLivro.add(beanLivro);
        }
        return listaLivro;
    }
	
	public void Emprestar(BeanLivros emprestimo){
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
	
}
