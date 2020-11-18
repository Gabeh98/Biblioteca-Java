package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanLivros;
import dao.DaoLivros;

@WebServlet("/AtualizarLivro")
public class AtualizarLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoLivros daoLivros = new DaoLivros();  
    public AtualizarLivro() {
        super();   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String status = request.getParameter("status");
		BeanLivros livro = new BeanLivros();
		livro.setNome(nome);
		livro.setStatus(status);
		daoLivros.status(livro);
		RequestDispatcher view = request.getRequestDispatcher("/book-status.jsp");
		view.forward(request, response);
	}
}
