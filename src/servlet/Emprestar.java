package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanLivros;
import beans.BeanUsuario;
import dao.DaoEmprestimo;


@WebServlet("/Emprestar")
public class Emprestar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DaoEmprestimo daoEmprestimo = new DaoEmprestimo();
	
    public Emprestar() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuarioid = request.getParameter("usuarioid");
		String livroid = request.getParameter("livroid");
		BeanUsuario emprestimo = new BeanUsuario(); 
		BeanLivros lEmprestar = new BeanLivros();
		emprestimo.setId(usuarioid);
		emprestimo.setEmprestimo(livroid);
		
		lEmprestar.setId(usuarioid);
		lEmprestar.setEmprestimo(livroid);
		daoEmprestimo.Emprestar(emprestimo);
		//continuar aki
		daoEmprestimo.livroEmprestar(lEmprestar);
		RequestDispatcher view = request.getRequestDispatcher("/user-list.jsp");
		view.forward(request, response);
	}

}
