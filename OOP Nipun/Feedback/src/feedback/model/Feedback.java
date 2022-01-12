package feedback.model;

public class Feedback {
	private int id;
	private String game;
	private String name;
	private String comment;
	private String rate;
	private String date;
	
	
	public Feedback(int id, String game, String name, String comment, String rate, String date) {
		super();
		this.id = id;
		this.game = game;
		this.name = name;
		this.comment = comment;
		this.rate = rate;
		this.date = date;
	}
	
	public Feedback(String game, String name, String comment, String rate, String date) {
		super();
		this.game = game;
		this.name = name;
		this.comment = comment;
		this.rate = rate;
		this.date = date;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
