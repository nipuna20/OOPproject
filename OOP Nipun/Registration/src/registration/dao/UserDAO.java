package registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import registration.model.User;

//This DAO class provides CRUD database operations for the table registered data in the database
public class UserDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/gaming_system?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_USER_SQL = "INSERT INTO user" + " (name, password, gender, age, address, phone) VALUES " + " (?, ?, ?, ?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select id, name, password, gender, age, address, phone from user where id = ?";
	private static final String SELECT_ALL_USER = "select * from user";
	private static final String DELETE_USER_SQL = "delete from user where id = ?;";
	private static final String UPDATE_USER_SQL = "update user set name = ?, password = ?, gender = ?, age = ?, address = ?, phone = ? where id = ?;";
	
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
	
			//insert user
			public void insertUser(User user) throws SQLException {
				System.out.println(INSERT_USER_SQL);
				try(Connection connection = getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);){
					preparedStatement.setString(1, user.getName());
					preparedStatement.setString(2, user.getPassword());
					preparedStatement.setString(3, user.getGender());
					preparedStatement.setString(4, user.getAge());
					preparedStatement.setString(5, user.getAddress());
					preparedStatement.setString(6, user.getPhone());
					System.out.println(preparedStatement);
					preparedStatement.executeUpdate();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
	
			
			//update user
			public boolean updateUser(User user) throws SQLException {
				boolean rowUpdated;
				try (Connection connection = getConnection();
						PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL);){
					statement.setString(1, user.getName());
					statement.setString(2, user.getPassword());
					statement.setString(3, user.getGender());
					statement.setString(4, user.getAge());
					statement.setString(5, user.getAddress());
					statement.setString(6, user.getPhone());
					statement.setInt(7, user.getId());
						
					rowUpdated = statement.executeUpdate() > 0;
				}
				return rowUpdated;
			}
			
			//select user by id
			public User selectUser(int id) {
				User user = null;
					
				try (Connection connection = getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);){
					preparedStatement.setInt(1, id);
					System.out.println(preparedStatement);
						
					ResultSet rs = preparedStatement.executeQuery();
						
					while (rs.next()) {
						String name = rs.getString("name");
						String password = rs.getString("password");
						String gender = rs.getString("gender");
						String age = rs.getString("age");
						String address = rs.getString("address");
						String phone = rs.getString("phone");
						user = new User(id, name, password, gender, age, address, phone);
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
				return user;
			}
			
			
			//select user
			public List<User> selectAllUser() {
				List<User> user = new ArrayList<>();
					
				try (Connection connection = getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);){
					System.out.println(preparedStatement);
						
					ResultSet rs = preparedStatement.executeQuery();
						
					while (rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String password = rs.getString("password");
						String gender = rs.getString("gender");
						String age = rs.getString("age");
						String address = rs.getString("address");
						String phone = rs.getString("phone");
						user.add(new User(id, name, password, gender, age, address, phone));
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
				return user;
			}
			
			
			//delete user
			public boolean deleteUser(int id) throws SQLException {
				boolean rowDeleted;
				try (Connection connection = getConnection();
						PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);){
					statement.setInt(1, id);
					rowDeleted = statement.executeUpdate() > 0;
				}
				return rowDeleted;
			}

}
