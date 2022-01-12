package games.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import games.dao.GameDAO;
import games.model.Game;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GameDAO gameDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameServlet() {
        this.gameDAO = new GameDAO();
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
			insertGame(request, response);
			break;
		case "/delete":
			deleteGame(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			updateGame(request, response);
			break;
		default:
			//handle list
			listGame(request, response);
			break;
		}
		
	}
	
	
	private void listGame(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			List<Game> listGame = gameDAO.selectAllGame();
			request.setAttribute("listGame", listGame);
			RequestDispatcher dispatcher = request.getRequestDispatcher("game-list.jsp");
			dispatcher.forward(request, response);
		}
	
	
	private void updateGame(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String version = request.getParameter("version");
		String date = request.getParameter("date");
		String developer = request.getParameter("developer");
		String publisher = request.getParameter("publisher");
		
		Game game = new Game(id, name, version, date, developer, publisher);
		try {
			gameDAO.updateGame(game);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
	
	private void deleteGame(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			gameDAO.deleteGame(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Game existingGame = gameDAO.selectGame(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("game-form.jsp");
		request.setAttribute("game", existingGame);
		dispatcher.forward(request, response);
	}
	
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("game-form.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void insertGame(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String name = request.getParameter("name");
		String version = request.getParameter("version");
		String date = request.getParameter("date");
		String developer = request.getParameter("developer");
		String publisher = request.getParameter("publisher");
		
		Game newGame = new Game(name, version, date, developer, publisher);
		try {
			gameDAO.insertGame(newGame);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	

	

}
