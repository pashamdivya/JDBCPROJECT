package jdbc_2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jdbc_2.dto.Toy;
import jdbc_2.dto.User;

public class ToyCrud {
	public void createTable() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_shop?createDatabaseIfNotExist=true", "root", "root");
		Statement sta = con.createStatement();
		sta.execute("create table IF NOT EXISTS toy(id int primary key,name varchar(45) not null,color varchar(45),brand varchar(45),price double)");
		sta.close();
		con.close();
		System.out.println("created.....!!!!!!");
	}
	public void saveToy(Toy toy) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_shop?createDatabaseIfNotExist=true", "root", "root");
		PreparedStatement ps = con.prepareStatement("insert into toy values(?,?,?,?,?)");
		ps.setInt(1, toy.getId());
		ps.setString(2, toy.getName());
		ps.setString(3, toy.getColor());
		ps.setString(4, toy.getBrand());
		ps.setDouble(5, toy.getPrice());
		ps.execute();
		con.close();
		ps.close();
		System.out.println("inserted....!!!!!");
	}
	public void updateToy(double price,int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_shop?createDatabaseIfNotExist=true", "root", "root");
		PreparedStatement ps = con.prepareStatement("update toy set price=? where id=?");
		ps.setDouble(1, price);
		ps.setInt(2, id);
		ps.execute();
		con.close();
		ps.close();
	}
	public void delete(int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_shop?createDatabaseIfNotExist=true", "root", "root");
		PreparedStatement ps = con.prepareStatement("delete fron toy where id=?");
		ps.setInt(1,id);
		ps.execute();
		con.close();
		ps.close();
		System.out.println("deleted......!!!!!!!");
	}
	public void fetch(Toy toy) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_shop?createDatabaseIfNotExist=true", "root", "root");
		PreparedStatement ps = con.prepareStatement("select * from emp");
		ResultSet res = ps.executeQuery();
		while(res.next()) {
			System.out.println(res.getInt("id")+ " " +res.getString("name")+ " "+res.getString("color")+" "+res.getString("brand")+" "+res.getDouble("price"));
		}
		ps.close();
		con.close();
	}
	public void receipt(Toy toy , User user) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_shop?createDatabaseIfNotExist=true", "root", "root");
		PreparedStatement ps = con.prepareStatement("select * from toy store where id=?");
		ps.setInt(1, toy.getId());
		ResultSet res = ps.executeQuery();
		while(res.next()) {
			System.out.println("Toy price:" +res.getDouble("price"));
			System.out.println("Amount:"+UserCrud.receipt1(user));
			if(res.getDouble("price") > UserCrud.receipt1(user)) {
				System.out.println("insuffient balance to buy the toy");
			}else {
				double result=UserCrud.receipt1(user)-res.getDouble("price");
				System.out.println("bill:" +result);
				UserCrud.updateAmount(result,user.getId());
			}
		}
		ps.close();
		con.close();
		
		
	}
	
	

}
