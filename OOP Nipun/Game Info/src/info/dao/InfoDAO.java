package info.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import info.model.Info;

//This DAO class provides CRUD database operations for the table infomation in the database
public class InfoDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/gaming_system?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_INFO_SQL = "INSERT INTO info" + " (game, origin, size, purpose, sales) VALUES " + " (?, ?, ?, ?, ?);";
	private static final String SELECT_INFO_BY_ID = "select id, game, origin, size, purpose, sales from info where id = ?";
	private static final String SELECT_ALL_INFO = "select * from info";
	private static final String DELETE_INFO_SQL = "delete from info where id = ?;";
	private static final String UPDATE_INFO_SQL = "update info set game = ?, origin = ?, size = ?, purpose = ?, sales = ? where id = ?;";
	
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
	
			//insert info
			public void insertInfo(Info info) throws SQLException {
				System.out.println(INSERT_INFO_SQL);
				try(Connection connection = getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INFO_SQL);){
					preparedStatement.setString(1, info.getGame());
					preparedStatement.setString(2, info.getOrigin());
					preparedStatement.setString(3, info.getSize());
					preparedStatement.setString(4, info.getPurpose());
					preparedStatement.setString(5, info.getSales());
					System.out.println(preparedStatement);
					preparedStatement.executeUpdate();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			//update info
			public boolean updateInfo(Info info) throws SQLException {
				boolean rowUpdated;
				try (Connection connection = getConnection();
						PreparedStatement statement = connection.prepareStatement(UPDATE_INFO_SQL);){
					statement.setString(1, info.getGame());
					statement.setString(2, info.getOrigin());
					statement.setString(3, info.getSize());
					statement.setString(4, info.getPurpose());
					statement.setString(5, info.getSales());
					statement.setInt(6, info.getId());
						
					rowUpdated = statement.executeUpdate() > 0;
				}
				return rowUpdated;
			}
			
			
			//select info by id
			public Info selectInfo(int id) {
				Info info = null;
					
				try (Connection connection = getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(SELECT_INFO_BY_ID);){
					preparedStatement.setInt(1, id);
					System.out.println(preparedStatement);
						
					ResultSet rs = preparedStatement.executeQuery();
						
					while (rs.next()) {
						String game = rs.getString("game");
						String origin = rs.getString("origin");
						String size = rs.getString("size");
						String purpose = rs.getString("purpose");
						String sales = rs.getString("sales");
						info = new Info(id, game, origin, size, purpose, sales);
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
				return info;
			}
			
			

			//select info
			public List<Info> selectAllInfo() {
				List<Info> info = new ArrayList<>();
					
				try (Connection connection = getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_INFO);){
					System.out.println(preparedStatement);
						
					ResultSet rs = preparedStatement.executeQuery();
						
					while (rs.next()) {
						int id = rs.getInt("id");
						String game = rs.getString("game");
						String origin = rs.getString("origin");
						String size = rs.getString("size");
						String purpose = rs.getString("purpose");
						String sales = rs.getString("sales");
						info.add(new Info(id, game, origin, size, purpose, sales));
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
				return info;
			}
			
			
			//delete info
					public boolean deleteInfo(int id) throws SQLException {
						boolean rowDeleted;
						try (Connection connection = getConnection();
								PreparedStatement statement = connection.prepareStatement(DELETE_INFO_SQL);){
							statement.setInt(1, id);
							rowDeleted = statement.executeUpdate() > 0;
						}
						return rowDeleted;
					}

	
	

}
