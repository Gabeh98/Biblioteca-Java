package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoAdmin;


@WebServlet("/LoginAdmin")
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DaoAdmin daoAdmin = new DaoAdmin();
	
    public LoginAdmin() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			//BeanJsp  beanJsp = new BeanJsp();
			
			String login  = request.getParameter("login");
			String password = request.getParameter("senha");
			
			if(daoAdmin.validarLogin(login, password)){
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin-page.jsp");
				dispatcher.forward(request, response);	
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin-login.jsp");
				dispatcher.forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
