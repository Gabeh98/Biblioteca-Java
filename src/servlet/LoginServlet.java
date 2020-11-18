package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanUsuario;
import dao.DaoLogin;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DaoLogin daoLogin = new DaoLogin();
	
    public LoginServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			//BeanJsp  beanJsp = new BeanJsp();
			BeanUsuario beanUsuario = new BeanUsuario();
			
			String login  = request.getParameter("login");
			String password = request.getParameter("senha");
			
			request.getSession().setAttribute("login", login);
			
			if(daoLogin.validarLogin(login, password)){
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("user-page.jsp");
				dispatcher.forward(request, response);	
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}