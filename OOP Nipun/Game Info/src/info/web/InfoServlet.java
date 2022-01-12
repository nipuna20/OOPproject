package info.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.dao.InfoDAO;
import info.model.Info;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InfoDAO infoDAO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
    	this.infoDAO = new InfoDAO();
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
			insertInfo(request, response);
			break;
		case "/delete":
			deleteInfo(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			updateInfo(request, response);
			break;
		default:
			//handle list
			listInfo(request, response);
			break;
		}
		
		
	}
	
	
	private void listInfo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			List<Info> listInfo = infoDAO.selectAllInfo();
			request.setAttribute("listInfo", listInfo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("info-list.jsp");
			dispatcher.forward(request, response);
		}
	
	
	private void updateInfo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String game = request.getParameter("game");
		String origin = request.getParameter("origin");
		String size = request.getParameter("size");
		String purpose = request.getParameter("purpose");
		String sales = request.getParameter("sales");
		
		Info info = new Info(id, game, origin, size, purpose, sales);
		try {
			infoDAO.updateInfo(info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
	
	private void deleteInfo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			infoDAO.deleteInfo(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Info existingInfo = infoDAO.selectInfo(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("info-form.jsp");
		request.setAttribute("info", existingInfo);
		dispatcher.forward(request, response);
	}
	
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("info-form.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void insertInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String game = request.getParameter("game");
		String origin = request.getParameter("origin");
		String size = request.getParameter("size");
		String purpose = request.getParameter("purpose");
		String sales = request.getParameter("sales");
		
		Info newInfo = new Info(game, origin, size, purpose, sales);
		try {
			infoDAO.insertInfo(newInfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}

	

}
