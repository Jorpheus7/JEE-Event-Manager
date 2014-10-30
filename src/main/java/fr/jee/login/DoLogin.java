package fr.jee.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.jee.model.jpa.UsersEntity;
import fr.jee.persistence.services.jpa.UsersPersistenceJPA;
import fr.jee.validate.ValidateUserLogin;

/**
 * Servlet implementation class DoLogin
 */
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MAIL = "mail";
	private static final String PASSWORD = "password";
	
	private final String REQUEST = "SELECT u FROM UsersEntity u WHERE u.mail = :mail AND u.passwd = :passwd";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		req.getRequestDispatcher("/login?redirected=true").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		// Testing the existence of the user
		String mail = req.getParameter(MAIL);
		String password = req.getParameter(PASSWORD);
		
		ValidateUserLogin v = new ValidateUserLogin();
		UsersEntity user = v.validationUserLogin(mail, password);
		
		if(user != null){
			session.setAttribute("isAuthentified", true);
			session.setAttribute("userID", user.getId());
			response.sendRedirect(req.getContextPath()+"/auth");
			//req.getRequestDispatcher("/auth").forward(request, response);
		}else{
			req.getRequestDispatcher("/login?status=invalid").forward(request, response);
		}

	}

}
