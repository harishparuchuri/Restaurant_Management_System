package dao;
import java.util.*;




public class AddFood {
	Scanner sc=new Scanner(System.in);
	ArrayList<Food> Itemlist = new ArrayList<>();
	ArrayList<OrderFood>orderfood=new ArrayList<>();
	Food Food;
	public OrderFood OrderFood;
	public int selectitem;
	public AddFood()
	{
		
	}
	//adding food items
	public void additem()
	{
		System.out.println("How Many Food Items Do You Want To Add?");
		int n=sc.nextInt();
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
	//generate bill
	public void Bill()
	{
		int foodprice=0;
		int totalBill=0;
		int number;
		OrderFood order=new OrderFood();
		orderfood.add(order);
		System.out.println("enter how many item's do you want");
		int ordercount=sc.nextInt();
		for(int i=0;i<ordercount;i++)
		{
			System.out.println("Select Food Item "+(i+1));
			
			selectitem=sc.nextInt();
			System.out.println("enter how many plates dou yo want");
			number=sc.nextInt();
			Food food=Itemlist.get(selectitem-1);
			order.setOrderFood(Food);
			foodprice=food.price*number;
			totalBill+=foodprice;
			//System.out.println("cost for item "+(i+1)+"is "+foodprice);
			
		}
		
		order.setBilltotal(totalBill);
		System.out.println("Total Bill Amount is"+totalBill);
		System.out.println("<--Thank you visit again-->");
				
	}
	//print order bill
	public void printorder()
	{
		for(int i=0;i<orderfood.size();i++)
		{
			orderfood.get(i).BillPrint();
		}
	}
	
}
