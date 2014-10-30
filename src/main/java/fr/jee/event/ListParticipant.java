package fr.jee.event;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.jee.model.jpa.EventsEntity;
import fr.jee.model.jpa.ParticipantsEntity;
import fr.jee.models.ListEventReq;
import fr.jee.models.ListParticipantsReq;
import fr.jee.persistence.services.jpa.EventsPersistenceJPA;

/**
 * Servlet implementation class ListParticipant
 */
public class ListParticipant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListParticipant() {
        super();
    }

    private void process(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException{
  		getServletContext().getRequestDispatcher("/jsp/listParticipant.jsp").forward(request, response);
 	
  	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		if (id!=null){
			int idE = Integer.parseInt(id);
			EventsEntity event = new EventsPersistenceJPA().load(idE);
			
			if(event.getActif()==0)
				response.sendRedirect(request.getContextPath()+"PageErreur.html");	
			else{
				List<ParticipantsEntity> participants = new ListParticipantsReq().execute(id);
				if(participants.size() == 0)
					response.sendRedirect(request.getContextPath()+"PageErreur.html");
				else {
					request.setAttribute("event", event);
					request.setAttribute("participants", participants);
					process(request, response);
				}
			}
		}
		else {
			response.sendRedirect(request.getContextPath()+"PageErreur.html");	
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
