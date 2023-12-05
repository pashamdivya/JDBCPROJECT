package jdbc_2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc_2.dto.User;

public class UserCrud {
	public void createTable() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?createDatabaseIfNotExist=true", "root", "root");
		Statement sta = con.createStatement();
		sta.execute("create table IF NOT EXISTS user(id int primary key,name varchar(45),phone long,amount double");
		sta.close();
		con.close();
		}
	public void saveUser(User user) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_shop?createDatabaseIfNotExist=true", "root", "root");
		PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?)");
		ps.setInt(1, user.getId());
		ps.setString(2, user.getName());
		ps.setLong(3, user.getPhone());
		ps.setDouble(4, user.getAmount());
		//ps.execute();
		ps.close();
		con.close();
		}
	public void fetch(User user) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_shop?createDatabaseIfNotExist=true", "root", "root");
		PreparedStatement ps = con.prepareStatement("select *from user where id=?");
		ps.setInt(1,user.getId());
		ResultSet res = ps.executeQuery();
		while(res.next()) {
			System.out.println(res.getInt("id")+ " "+res.getString("name")+" "+res.getLong("phone")+" "+res.getDouble("amount"));
			}
		ps.close();
		con.close();
	}
	

	public static double receipt1(User user) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_shop?createDatabaseIfNotExist=true", "root", "root");
		PreparedStatement ps = con.prepareStatement("select amount from user where id=?");
		ps.setInt(1,user.getId());
		ResultSet res = ps.executeQuery();
		double result=0;
		while(res.next()) {
			result=res.getDouble("amount");
		}
		ps.close();
		con.close();
		return result;
	}
	public static void updateAmount(double amount,int id) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_shop?createDatabaseIfNotExist=true", "root", "root");
		PreparedStatement ps = con.prepareStatement("update user set amount=? where id=?");
		ps.setDouble(1, amount);
		ps.setInt(2, id);
		ps.execute();
		ps.close();
		con.close();
		
	}

}
