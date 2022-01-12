package games.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import games.model.Game;


//This DAO class provides CRUD database operations for the table games in the database
public class GameDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/gaming_system?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_GAME_SQL = "INSERT INTO game" + " (name, version, date, developer, publisher) VALUES " + " (?, ?, ?, ?, ?);";
	private static final String SELECT_GAME_BY_ID = "select id, name, version, date, developer, publisher from game where id = ?";
	private static final String SELECT_ALL_GAME = "select * from game";
	private static final String DELETE_GAME_SQL = "delete from game where id = ?;";
	private static final String UPDATE_GAME_SQL = "update game set name = ?, version = ?, date = ?, developer = ?, publisher = ? where id = ?;";
	
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
	
	
	//insert game
	public void insertGame(Game game) throws SQLException {
		System.out.println(INSERT_GAME_SQL);
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GAME_SQL);){
			preparedStatement.setString(1, game.getName());
			preparedStatement.setString(2, game.getVersion());
			preparedStatement.setString(3, game.getDate());
			preparedStatement.setString(4, game.getDeveloper());
			preparedStatement.setString(5, game.getPublisher());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//update game
	public boolean updateGame(Game game) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_GAME_SQL);){
			statement.setString(1, game.getName());
			statement.setString(2, game.getVersion());
			statement.setString(3, game.getDate());
			statement.setString(4, game.getDeveloper());
			statement.setString(5, game.getPublisher());
			statement.setInt(6, game.getId());
				
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	
	//select game by id
	public Game selectGame(int id) {
		Game game = null;
			
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GAME_BY_ID);){
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
				
			ResultSet rs = preparedStatement.executeQuery();
				
			while (rs.next()) {
				String name = rs.getString("name");
				String version = rs.getString("version");
				String date = rs.getString("date");
				String developer = rs.getString("developer");
				String publisher = rs.getString("publisher");
				game = new Game(id, name, version, date, developer, publisher);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return game;
	}
	
	
	//select game
	public List<Game> selectAllGame() {
		List<Game> game = new ArrayList<>();
			
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_GAME);){
			System.out.println(preparedStatement);
				
			ResultSet rs = preparedStatement.executeQuery();
				
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String version = rs.getString("version");
				String date = rs.getString("date");
				String developer = rs.getString("developer");
				String publisher = rs.getString("publisher");
				game.add(new Game(id, name, version, date, developer, publisher));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return game;
	}
	
	
	//delete game
	public boolean deleteGame(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_GAME_SQL);){
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	

}
