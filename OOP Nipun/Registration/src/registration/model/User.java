package registration.model;

public class User {
	private int id;
	private String name;
	private String password;
	private String gender;
	private String age;
	private String address;
	private String phone;
	
	public User(int id, String name, String password, String gender, String age, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.phone = phone;
	}
	
	public User(String name, String password, String gender, String age, String address, String phone) {
		super();
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.phone = phone;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
