package games.model;

public class Game {
	private int id;
	private String name;
	private String version;
	private String date;
	private String developer;
	private String publisher;
	

	public Game(int id, String name, String version, String date, String developer, String publisher) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.date = date;
		this.developer = developer;
		this.publisher = publisher;
	}
	

	public Game(String name, String version, String date, String developer, String publisher) {
		super();
		this.name = name;
		this.version = version;
		this.date = date;
		this.developer = developer;
		this.publisher = publisher;
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
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	

}
