
package jdbc_2.controller;

import java.sql.SQLException;
import java.util.Scanner;

import jdbc_2.dao.ToyCrud;
import jdbc_2.dao.UserCrud;
import jdbc_2.dto.Toy;
import jdbc_2.dto.User;

public class Toy_main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		ToyCrud crud=new ToyCrud();
		UserCrud crud1=new UserCrud();
		boolean check=true;
		do {
			System.out.println("welcome to toy shop......");
			System.out.println("enter the choice \n 1.toy 2.user 3.exit");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:{
				boolean check2=true;
				do {
					System.out.println("choose options \n 1.save \n 2.update \n 3.delete \n 4.exit");
					int choicebook=sc.nextInt();
					switch(choicebook) {
					case 1:{
						System.out.println("enter the id");
						int id=sc.nextInt();
						System.out.println("enter the toy name");
						String name=sc.next();
						System.out.println("enter the color");
						String color=sc.next();
						System.out.println("enter the brand");
						String brand=sc.next();
						System.out.println("enter the price");
						double price=sc.nextDouble();
						Toy toy=new Toy(id,name,color,brand,price);
						crud.saveToy(toy);
						break;
					}
					case 2:{
						System.out.println("enter the id");
						int id=sc.nextInt();
						System.out.println("enter the price");
						double price=sc.nextDouble();
						crud.updateToy(price, id);
						break;
					}
					case 3:{
						System.out.println("enter the id");
						int id=sc.nextInt();
						crud.delete(id);
						break;
					}
					case 4:{
						check2=false;
						break;
					}
					}
				}while(check2);
			}
			case 2:{
				boolean check3=true;
				do {
					System.out.println("enter thechoice \n 1.new user \n 2.old user \n 3.exit");
					int choiceuser=sc.nextInt();
					switch(choiceuser) {
					case 1:{
						System.out.println("enter the id");
						int id=sc.nextInt();
						System.out.println("enter the name");
						String name=sc.next();
						System.out.println("enter the phone");
						long phone=sc.nextLong();
						System.out.println("enter the amount");
						double amount=sc.nextDouble();
						User user=new User(id,name,phone,amount);
						crud1.saveUser(user);
						break;
					}
					case 2:{
						System.out.println("enter your id");
						int id=sc.nextInt();
						User user=new User();
						user.setId(id);					
						System.out.println("enter the user details");
						crud1.fetch(user);
						System.out.println();
						System.out.println("toys avaliable");
						crud.fetch(null);
						System.out.println("select the toy_id which you want to purchase");
						int t_id=sc.nextInt();
						Toy toy=new Toy();
						toy.setId(t_id);
						crud.receipt(toy,user);
						break;
					}
					case 3:{
						check3=false;
					}
					}
				}while(check3);
			}
			case 3:{
				check=false;
			}
			}
		}while(check);
		System.out.println("thanks visit again.......");

	}

}
