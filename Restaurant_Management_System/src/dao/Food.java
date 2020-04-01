package dao;
import java.io.*;
import java.util.*;
public class Food {
	public String Fname;
	public int price;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
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
	public void addfood() throws IOException
	{
		System.out.println("Enter Food Item Name");
		Fname=br.readLine();
		System.out.println("Enter Price of "+ Fname);
		price=Integer.parseInt(br.readLine());


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
