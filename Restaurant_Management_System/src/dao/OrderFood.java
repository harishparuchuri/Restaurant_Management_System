package dao;
import java.util.*;
public class OrderFood {
	ArrayList<Food>OrderFood=new ArrayList<>();
	public float Billtotal;
		
	public void setOrderFood(Food Food) {
		OrderFood.add(Food);
	}
	
	public void setBilltotal(float billtotal) {
		Billtotal = billtotal;
	}
	
	public void BillPrint()
	{
		System.out.println("<-----Hotel Telugu Ruchulu----->");
		for(Food f:this.OrderFood)
		{
			System.out.println("Selected Food is "+ f.Fname);
			
		}
		System.out.println("Total Bill Amount "+this.Billtotal);
		System.out.println("<-----Thank You----->");
	}
	
	

}
