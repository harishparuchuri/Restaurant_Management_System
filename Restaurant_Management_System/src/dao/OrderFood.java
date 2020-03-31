package dao;
import java.util.*;
public class OrderFood {
	ArrayList<Food>OrderFood=new ArrayList<>();
	public float totalBill;
		
	public void setOrderFood(Food Food) {
		OrderFood.add(Food);
	}
	
	public void setBilltotal(float totalBill) {
		this.totalBill = totalBill;
	}
	//generate bill
	public void BillPrint()
	{
		System.out.println("<-----Hotel Telugu Ruchulu----->");
		for(Food f:this.OrderFood)
		{
			System.out.println("Selected Food is "+ f.Fname);
			
		}
		System.out.println("Total Bill Amount "+this.totalBill);
		System.out.println("<-----Thank You----->");
	}
	
	

}
