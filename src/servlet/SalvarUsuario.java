package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanUsuario;
import dao.DaoUsuario;


@WebServlet("/SalvarUsuario")
public class SalvarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    DaoUsuario daoUsuario = new DaoUsuario();
  
    public SalvarUsuario() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String id = request.getParameter("id");
		
		BeanUsuario usuario = new BeanUsuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setId(id);
		daoUsuario.salvar(usuario);
		
		RequestDispatcher view = request.getRequestDispatcher("cadastro-usuario.jsp");
		view.forward(request, response);

		
	}
}
