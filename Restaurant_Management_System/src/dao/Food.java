package dao;
import java.util.*;
public class Food {
	public String Fname;
	public float price;
	Scanner sc=new Scanner(System.in);
	Food(String Fname,Float price)
	{
		this.Fname=Fname;
		this.price=price;
	}
		public void addfood()
		{
			System.out.println("Enter Food Item Name");
			Fname=sc.nextLine();
			System.out.println("Enter Price of "+ Fname);
			price=sc.nextFloat();
			
			
		}
	
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	

}
