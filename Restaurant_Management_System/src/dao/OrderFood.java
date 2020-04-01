package dao;
import java.util.*;
import java.io.*;
import dao.*;
public class OrderFood {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//delete array for testing
	ArrayList<Food> Itemlist = new ArrayList<>();
	
	ArrayList<Food>OrderFood=new ArrayList<>();
	public int totalBill;
		
	public void setOrderFood(Food Food) {
		OrderFood.add(Food);
	}
	
	public void setBilltotal(int totalBill) {
		this.totalBill = totalBill;
	}
	//generate bill
	
	
	
	
	//Delete food Item from List
	public void DeleteFood() throws IOException
	{
		String Deleteitem;
		int flag=0;
		System.out.println("Enter Item NAme Do You Want To Delete");
		Deleteitem=br.readLine();
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
