package feedback.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import feedback.dao.FeedbackDAO;
import feedback.model.Feedback;

/**
 * Servlet implementation class FeedbackServlet
 */
@WebServlet("/")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FeedbackDAO feedbackDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackServlet() {
    	this.feedbackDAO = new FeedbackDAO();
    }
    
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertFeedback(request, response);
			break;
		case "/delete":
			deleteFeedback(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			updateFeedback(request, response);
			break;
		default:
			//handle list
			listFeedback(request, response);
			break;
		}
		
		
	}
	
	
	private void listFeedback(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			List<Feedback> listFeedback = feedbackDAO.selectAllFeedback();
			request.setAttribute("listFeedback", listFeedback);
			RequestDispatcher dispatcher = request.getRequestDispatcher("feedback-list.jsp");
			dispatcher.forward(request, response);
		}
	
	
	private void updateFeedback(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String game = request.getParameter("game");
		String name = request.getParameter("name");
		String rate = request.getParameter("rate");
		String comment = request.getParameter("comment");
		String date = request.getParameter("date");
		
		Feedback feedback = new Feedback(id, game, name, rate, comment, date);
		try {
			feedbackDAO.updateFeedback(feedback);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
	
	private void deleteFeedback(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			feedbackDAO.deleteFeedback(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Feedback existingFeedback = feedbackDAO.selectFeedback(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("feedback-form.jsp");
		request.setAttribute("feedback", existingFeedback);
		dispatcher.forward(request, response);
	}
	
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("feedback-form.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void insertFeedback(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String game = request.getParameter("game");
		String name = request.getParameter("name");
		String rate = request.getParameter("rate");
		String comment = request.getParameter("comment");
		String date = request.getParameter("date");
		Feedback newFeedback = new Feedback(game, name, rate, comment, date);
		try {
			feedbackDAO.insertFeedback(newFeedback);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}

	

}
