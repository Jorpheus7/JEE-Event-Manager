package fr.jee.login;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.jee.model.jpa.EventsEntity;
import fr.jee.model.jpa.UsersEntity;
import fr.jee.persistence.services.jpa.EventsPersistenceJPA;
import fr.jee.persistence.services.jpa.UsersPersistenceJPA;
import fr.jee.validate.ValidateUser;

/**
 * Servlet implementation class DoRegister
 */
public class DoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private	static final String MAIL = "mail";
	private static final String PASSWORD = "password";
	private static final String CONFIRM_PASSWORD = "confirmPassword";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoRegister() {
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
		
		String mail = request.getParameter(MAIL);
		String password = request.getParameter(PASSWORD);
		String confirmPassword = request.getParameter(CONFIRM_PASSWORD);
		
		if(!password.equals(confirmPassword)){
			req.getRequestDispatcher("/register?status=differentPasswords&mail="+mail).forward(request, response);
		}else{
			ValidateUser v = new ValidateUser();
			UsersPersistenceJPA jpaUser = new UsersPersistenceJPA();
			UsersEntity user = v.validationUser(mail, password);
			
			//Si il y a une erreur
			if(user != null){
				jpaUser.insert(user);
				// Get in return the user id to store it into session
				session.setAttribute("isAuthentified", true);
				session.setAttribute("userID", user.getId());
				response.sendRedirect(req.getContextPath()+"/auth/ListEvent");
			}
			else{
				response.sendRedirect("ListEvent");
			}
		}
			
	}

}
