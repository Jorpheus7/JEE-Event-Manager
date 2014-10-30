package fr.jee.login;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.jee.model.jpa.UsersEntity;

/**
 * Servlet implementation class DoLogin
 */
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
		String mail = req.getParameter("mail");
		String password = req.getParameter("password");

		// TODO check into the database if the mail exist
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit1");
		EntityManager em = emf.createEntityManager() ;
		
		Query query = em.createQuery(REQUEST);
		query.setParameter("mail", mail);
		query.setParameter("passwd", password);
		
		UsersEntity user = (UsersEntity) query.getSingleResult();
		// if exist, get the corresponding user
		// Check if the password matches
		em.close();
		
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
