package feedback.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import feedback.model.Feedback;

//This DAO class provides CRUD database operations for the table feedbacks in the database
public class FeedbackDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/gaming_system?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_FEEDBACK_SQL = "INSERT INTO feedback" + " (game, name, rate, comment, date) VALUES " + " (?, ?, ?, ?, ?);";
	private static final String SELECT_FEEDBACK_BY_ID = "select id, game, name, rate, comment, date from feedback where id = ?";
	private static final String SELECT_ALL_FEEDBACK = "select * from feedback";
	private static final String DELETE_FEEDBACK_SQL = "delete from feedback where id = ?;";
	private static final String UPDATE_FEEDBACK_SQL = "update feedback set game = ?, name = ?, rate = ?, comment = ?, date = ? where id = ?;";
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
			//insert feedback
			public void insertFeedback(Feedback feedback) throws SQLException {
				System.out.println(INSERT_FEEDBACK_SQL);
				try(Connection connection = getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FEEDBACK_SQL);){
					preparedStatement.setString(1, feedback.getGame());
					preparedStatement.setString(2, feedback.getName());
					preparedStatement.setString(3, feedback.getRate());
					preparedStatement.setString(4, feedback.getComment());
					preparedStatement.setString(5, feedback.getDate());
					System.out.println(preparedStatement);
					preparedStatement.executeUpdate();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			//update feedback
			public boolean updateFeedback(Feedback feedback) throws SQLException {
				boolean rowUpdated;
				try (Connection connection = getConnection();
						PreparedStatement statement = connection.prepareStatement(UPDATE_FEEDBACK_SQL);){
					statement.setString(1, feedback.getGame());
					statement.setString(2, feedback.getName());
					statement.setString(3, feedback.getRate());
					statement.setString(4, feedback.getComment());
					statement.setString(5, feedback.getDate());
					statement.setInt(6, feedback.getId());
						
					rowUpdated = statement.executeUpdate() > 0;
				}
				return rowUpdated;
			}
			
			
			//select feedback by id
			public Feedback selectFeedback(int id) {
				Feedback feedback = null;
					
				try (Connection connection = getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FEEDBACK_BY_ID);){
					preparedStatement.setInt(1, id);
					System.out.println(preparedStatement);
						
					ResultSet rs = preparedStatement.executeQuery();
						
					while (rs.next()) {
						String game = rs.getString("game");
						String name = rs.getString("name");
						String rate = rs.getString("rate");
						String comment = rs.getString("comment");
						String date = rs.getString("date");
						feedback = new Feedback(id, game, name, rate, comment, date);
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
				return feedback;
			}
			
			
			//select feedback
			public List<Feedback> selectAllFeedback() {
				List<Feedback> feedback = new ArrayList<>();
					
				try (Connection connection = getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FEEDBACK);){
					System.out.println(preparedStatement);
						
					ResultSet rs = preparedStatement.executeQuery();
						
					while (rs.next()) {
						int id = rs.getInt("id");
						String game = rs.getString("game");
						String name = rs.getString("name");
						String rate = rs.getString("rate");
						String comment = rs.getString("comment");
						String date = rs.getString("date");
						feedback.add(new Feedback(id, game, name, rate, comment, date));
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
				return feedback;
			}
			
			

			//delete feedback
					public boolean deleteFeedback(int id) throws SQLException {
						boolean rowDeleted;
						try (Connection connection = getConnection();
								PreparedStatement statement = connection.prepareStatement(DELETE_FEEDBACK_SQL);){
							statement.setInt(1, id);
							rowDeleted = statement.executeUpdate() > 0;
						}
						return rowDeleted;
					}
	
	

}
