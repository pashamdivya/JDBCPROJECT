package jdbc_2.dto;

public class Toy {
	private int id;
	private String name;
	private String color;
	private String brand;
	private double price;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Toy [id=" + id + ", name=" + name + ", color=" + color + ", brand=" + brand + ", price=" + price + "]";
	}
	public Toy(int id, String name, String color, String brand, double price) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.brand = brand;
		this.price = price;
	}
	public Toy() {
		super();
	}
	

}
