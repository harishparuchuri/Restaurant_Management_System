package dao;
import java.util.*;
import dao.*;
public class OrderFood {
	Scanner sc=new Scanner(System.in);
	
	ArrayList<Food>OrderFood=new ArrayList<>();
	public int totalBill;
		
	public void setOrderFood(Food Food) {
		OrderFood.add(Food);
	}
	
	public void setBilltotal(int totalBill) {
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
	
	//update price method
	public int EditPrice()
	{
		System.out.println("Enter Updated Price of Item");
		return sc.nextInt();
	}
	public void UpdateFood()
	{
		String itemname;
		int flag=0;
		System.out.println("Enter the Item Name Do you Want To Update");
		itemname=sc.nextLine();
		System.out.println(" you enter the name is "+itemname+" size of array "+Itemlist.size());
		
		for(int i=0;i<Itemlist.size();i++)
		{
			System.out.println("inside loop ");
			//debuing
			System.out.println(Itemlist.get(i).getFname());
			System.out.println(itemname);
			
			
			
			
			//end code
			
			
			if(Itemlist.get(i).getFname().equals(itemname));
			flag++;
			Itemlist.get(i).setPrice(EditPrice());
			break;
		}
		if(flag==0)
		{
			System.out.println("No item exist with name "+itemname);
		}
	}
	
	//Delete food Item from List
	public void DeleteFood()
	{
		String Deleteitem;
		int flag=0;
		System.out.println("Enter Item NAme Do You Want To Delete");
		Deleteitem=sc.nextLine();
		for(int i=0;i<Itemlist.size();i++)
		{
			if(Itemlist.get(i).getFname().equals(Deleteitem))
			flag++;
			Itemlist.remove(i);
			System.out.println("Food Item "+Deleteitem +"is Removed from Items List");
			break;
			
		}
		if(flag==0)
		{
			System.out.println("There is no Item With name "+ Deleteitem +" Present in Menu");
		}
	}
	
	

}
