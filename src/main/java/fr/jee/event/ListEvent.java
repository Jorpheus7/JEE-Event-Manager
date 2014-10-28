package fr.jee.event;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.jee.model.jpa.EventsEntity;
import fr.jee.models.ListEventReq;
import fr.jee.persistence.services.jpa.EventsPersistenceJPA;



/**
 * Servlet implementation class ListEvent
 */
public class ListEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEvent() {
        super();
        
    }

    private void process(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException{
		getServletContext().getRequestDispatcher("/jsp/event.jsp").forward(request, response);
		
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int id = (int) session.getAttribute("id");
		List<EventsEntity> events = new ListEventReq().execute(id);
		process(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String publier = request.getParameter("publier");
		String id = request.getParameter("id");
		EventsPersistenceJPA jpaEvent = new EventsPersistenceJPA();
		EventsEntity event = new EventsEntity();
		if(publier != null){
			event=jpaEvent.load(Integer.parseInt(id));
			event.setActif(1);
			jpaEvent.save(event);

		}
		response.sendRedirect("listEvent");
		
	}

}
