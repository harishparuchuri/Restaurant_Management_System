package dao;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;


public class AddFood {
	
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	
	ArrayList<Food> Itemlist = new ArrayList<>();
	ArrayList<String>selectedfood=new ArrayList<>();
	ArrayList<OrderFood>orderfood=new ArrayList<>();
	Food Food;
	int BillNo=1;
	
	public void setItemlist(ArrayList<Food> itemlist) {
		Itemlist = itemlist;
	}
	public OrderFood OrderFood;
	public int selectitem;
	public AddFood()
	{
		
	}
	//adding food items
	public void additem() throws NumberFormatException, IOException
	{
		System.out.println("How Many Food Items Do You Want To Add?");
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++)
		{
			Food food=new Food();
			food.addfood();
			Itemlist.add(food);
			
		}
	}
	//print food items
	public void displayfood()
	{
		for (int i = 0; i < Itemlist.size(); i++) {
			System.out.println((i+1)+"."+Itemlist.get(i).FoodData());
		}
	}
	
	//Generate date
	String pattern = "dd-MM-yyyy";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

	String date = simpleDateFormat.format(new Date());
	
	
	//generate bill
	public void Bill() throws NumberFormatException, IOException
	{
		String CustName;
		int foodprice=0;
		int totalBill=0;
		int number;
		OrderFood order=new OrderFood();
		orderfood.add(order);
		
		System.out.println("Enter Customer Name");
		CustName=br.readLine();
		
		System.out.println("enter how many item's do you want");
		int ordercount=Integer.parseInt(br.readLine());
		for(int i=0;i<ordercount;i++)
		{
			System.out.println("Select Food Item "+(i+1));
			
			selectitem=Integer.parseInt(br.readLine());
			System.out.println("enter how many plates dou yo want");
			number=Integer.parseInt(br.readLine());
			Food food=Itemlist.get(selectitem-1);
			///
			
			
			order.setOrderFood(Food);
			foodprice=food.price*number;
			
			String itemdata=food.Fname+"\t\t "+food.price+"R\t   "+number+"\t\t "+foodprice;
			selectedfood.add(itemdata);
			//System.out.println(itemdata);
			totalBill+=foodprice;
			
			
		}
		
		String heading="ITEM NAME\tPRICE\tQUANTITY\tCOST";
		order.setBilltotal(totalBill);
		//print food items in bill
		System.out.println("   <-----Hotel Telugu Ruchulu----->");
		System.out.println("\n\t\t Receipt\t\t\t\n");
		System.out.println("*********************************************");
		System.out.println(heading);
		for(String sfood:selectedfood)
			System.out.println(sfood);
		System.out.println("\nTotal Bill Amount is  \t\t\t"+totalBill);
        System.out.println("\nCustomer Name         "+CustName);
        System.out.println("\nDate\t               \t\t"+date);
		System.out.println("\n\t<--Thank you visit again-->\n");
		
		
		
		
				
	}
	
	//Generate receipt
	public void Receipt() throws IOException 
	{
		String fileName=BillNo+"_"+date;
		BillNo++;
		
		File file = new File("E:\\Receipt\\fileName.txt");
		PrintWriter out = new PrintWriter("fileName.txt");
		out.println("harish paruchuri");
		System.out.println("receipt generated");
		out.close();
	}
	
	
	
	
	
	//update price method
		public int EditPrice() throws NumberFormatException, IOException
		{
			System.out.println("Enter Updated Price of Item");
			return Integer.parseInt(br.readLine());
		}
		public void UpdateFood() throws IOException
		{
			String itemname;
			int flag=0;
			System.out.println("Enter the Item Name Do you Want To Update");
			
			itemname=br.readLine();
			System.out.println("after \n"+itemname);
			
			for(int i=0;i<Itemlist.size();i++)
			{
				
				if(Itemlist.get(i).getFname().equals(itemname))
				{
				flag++;
				System.out.println("Loop\n"+itemname);
				Itemlist.get(i).setPrice(EditPrice());
				break;
				}
			}
			if(flag==0)
			{
				System.out.println("No item exist with name "+itemname);
			}
		}
		
		
		//Delete food Item from List
		public void DeleteFood() throws IOException
		{
			String Deleteitem;
			int flag=0;
			System.out.println("Enter Item Name Do You Want To Delete");
			Deleteitem=br.readLine();
			for(int i=0;i<Itemlist.size();i++)
			{
				if(Itemlist.get(i).getFname().equals(Deleteitem))
				{
				flag++;
				Itemlist.remove(i);
				System.out.println("Food Item "+ Deleteitem +"is Removed from Items List");
				break;
				}
				
			}
			if(flag==0)
			{
				System.out.println("There is no Item With name "+ Deleteitem +" Present in Menu");
			}
		}
		

	
}
