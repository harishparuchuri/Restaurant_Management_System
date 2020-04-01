package dao;
import java.util.*;
public class Food {
	public String Fname;
	public int price;
	Scanner sc=new Scanner(System.in);
	Food()
	{
		
	}
	//entering food details
	Food(String Fname,int price)
	{
		this.Fname=Fname;
		this.price=price;
	}
	//getting food name and price
	public void addfood()
	{
		System.out.println("Enter Food Item Name");
		Fname=sc.nextLine();
		System.out.println("Enter Price of "+ Fname);
		price=sc.nextInt();


	}
	
	public String FoodData() {
		return Fname+" "+price;
	}

	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


}
