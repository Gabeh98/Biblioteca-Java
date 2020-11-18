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


@WebServlet("/SalvarLivro")
public class SalvarLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DaoLivros daoLivros = new DaoLivros();
    public SalvarLivro() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String autor = request.getParameter("autor");
		String status = request.getParameter("status");
		String id = request.getParameter("id");
		
		BeanLivros livro = new BeanLivros();
		livro.setAutor(autor);
		livro.setNome(nome);
		livro.setStatus(status);
		livro.setId(id);
		
		daoLivros.salvar(livro);
		
		RequestDispatcher view = request.getRequestDispatcher("/cadastro-livro.jsp");
		view.forward(request, response);
	}
}
