package fr.jee.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DoRegister
 */
public class DoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		// Testing the existence of the user
		boolean isValid = false;
		String mail = req.getParameter("mail");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");
		
		if(!password.equals(confirmPassword)){
			req.getRequestDispatcher("/register?status=differentPasswords&mail="+mail).forward(request, response);
		}else{
			// TODO Call the User factory to register a new user in the database
			// Get in return the user id to store it into session
			session.setAttribute("isAuthentified", true);
			response.sendRedirect(req.getContextPath()+"/auth");
			//req.getRequestDispatcher("/auth").forward(request, response);
		}
	}

}
