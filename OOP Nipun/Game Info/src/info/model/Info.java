package info.model;

public class Info {
	private int id;
	private String game;
	private String origin;
	private String size;
	private String purpose;
	private String sales;
	
	
	public Info(int id, String game, String origin, String size, String purpose, String sales) {
		super();
		this.id = id;
		this.game = game;
		this.origin = origin;
		this.size = size;
		this.purpose = purpose;
		this.sales = sales;
	}
	
	
	public Info(String game, String origin, String size, String purpose, String sales) {
		super();
		this.game = game;
		this.origin = origin;
		this.size = size;
		this.purpose = purpose;
		this.sales = sales;
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
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	
	
	
	

}
