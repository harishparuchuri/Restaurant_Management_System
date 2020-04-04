package model;
import java.io.*;

public class Food {
	private String Fname;
	private int price;
	private int icount=0;
	private int imoney=0;
	
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	Food()
	{
		
	}
	//entering food details
	Food(String Fname,int price,int icount,int imoney)
	{
		this.Fname=Fname;
		this.price=price;
		this.icount=icount;
		this.imoney=imoney;
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
	public int getIcount() {
		return icount;
	}
	public void setIcount(int icount) {
		this.icount = icount;
	}
	public int getImoney() {
		return imoney;
	}
	public void setImoney(int imoney) {
		this.imoney = imoney;
	}
	

}
