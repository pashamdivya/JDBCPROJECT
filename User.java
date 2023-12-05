package jdbc_2.dto;

public class User {
	private int id;
	private String name;
	private long phone;
	private double amount;
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", amount=" + amount + "]";
	}
	public User(int id, String name, long phone, double amount) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.amount = amount;
	}
	public User() {
		super();
	}
	
}
