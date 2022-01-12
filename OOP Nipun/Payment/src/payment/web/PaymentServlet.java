package payment.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import payment.dao.PaymentDAO;
import payment.model.Payment;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PaymentDAO paymentDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
    	this.paymentDAO = new PaymentDAO();
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
			insertPayment(request, response);
			break;
		case "/delete":
			deletePayment(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			updatePayment(request, response);
			break;
		default:
			//handle list
			listPayment(request, response);
			break;
		}
		
	}
	
	
	private void listPayment(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			List<Payment> listPayment = paymentDAO.selectAllPayment();
			request.setAttribute("listPayment", listPayment);
			RequestDispatcher dispatcher = request.getRequestDispatcher("payment-list.jsp");
			dispatcher.forward(request, response);
		}
	
	
	private void updatePayment(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String game = request.getParameter("game");
		String name = request.getParameter("name");
		String card = request.getParameter("card");
		String cvv = request.getParameter("cvv");
		String expire = request.getParameter("expire");
		String amount = request.getParameter("amount");
		
		Payment payment = new Payment(id, game, name, card, cvv, expire, amount);
		try {
			paymentDAO.updatePayment(payment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
	
	private void deletePayment(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			paymentDAO.deletePayment(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Payment existingPayment = paymentDAO.selectPayment(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("payment-form.jsp");
		request.setAttribute("payment", existingPayment);
		dispatcher.forward(request, response);
	}
	
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("payment-form.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void insertPayment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String game = request.getParameter("game");
		String name = request.getParameter("name");
		String card = request.getParameter("card");
		String cvv = request.getParameter("cvv");
		String expire = request.getParameter("expire");
		String amount = request.getParameter("amount");
		
		Payment newPayment = new Payment(game, name, card, cvv, expire, amount);
		try {
			paymentDAO.insertPayment(newPayment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}


	

}
