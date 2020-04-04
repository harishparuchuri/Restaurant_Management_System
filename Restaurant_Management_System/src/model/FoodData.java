package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import model.Food;
import dao.OrderFood;

public class FoodData {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int BillNo=1;
	public int selectitem;
	
	//Generate date
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		public String date = simpleDateFormat.format(new Date());
		String CustName;
		int foodprice;
		int totalBill;
	
	ArrayList<Food> Itemlist = new ArrayList<>();//store menu
	ArrayList<String>selectedfood=new ArrayList<>();//Store data in will
	ArrayList<OrderFood>orderfood=new ArrayList<>();//orderd items
	    
	
	
	

	Food Food;
	
	public void setItemlist(ArrayList<Food> itemlist) {
		Itemlist = itemlist;
	}
	
	
	
	public ArrayList<String> getSelectedfood() {
		return selectedfood;
	}
	public void setSelectedfood(ArrayList<String> selectedfood) {
		this.selectedfood = selectedfood;
	}
	
	public ArrayList<Food> getItemlist() {
		return Itemlist;
	}
	public ArrayList<OrderFood> getorderfood()
	{
		return orderfood;
	}
	

	
	public FoodData()
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
	//bill generation
	public void Bill() throws NumberFormatException, IOException
	{
		selectedfood.clear();
		foodprice=0;
		totalBill=0;
		int number;
		OrderFood order=new OrderFood();
		orderfood.add(order);
		
		System.out.println("Enter Customer Name");
		CustName=br.readLine();
		
		System.out.println("enter how many item's do you want");
		int ordercount=Integer.parseInt(br.readLine());
		for(int i=0;i<ordercount;i++)
		{
			System.out.println("Select Food Item"+(i+1));
			
			selectitem=Integer.parseInt(br.readLine());
			System.out.println("enter how many plates dou yo want");
			number=Integer.parseInt(br.readLine());
			Food food=Itemlist.get(selectitem-1);
			//updating item count
			int getitemcount=food.getIcount();
			int updateicount=getitemcount+number;
			food.setIcount(updateicount);
			//System.out.println("item icount value"+food.getIcount());
			//updating money of item
			int getitemmoney=food.getImoney();
			int costitem=food.getPrice()*number;
			int updateimoney=getitemmoney+costitem;
			food.setImoney(updateimoney);
			//System.out.println("earning from item "+food.getImoney());
			
			//System.out.println("print what is food"+food.getFname());
			
			order.setOrderFood(Food);
			foodprice=food.getPrice()*number;
			String itemdata=food.getFname()+"\t\t "+food.getPrice()+"R\t   "+number+"\t\t "+foodprice;
			selectedfood.add(itemdata);
			
			totalBill+=foodprice;
			
			
		}
		
		 String heading="ITEM NAME\tPRICE\tQUANTITY\tCOST";
		order.setBilltotal(totalBill);
		//print food items in bill
		System.out.println("\n\n   <-----Hotel Telugu Ruchulu----->");
		System.out.println("\n\t\t Receipt\t\t\t\n");
		System.out.println("*********************************************\n");
		System.out.println(heading);
		for(String sfood:selectedfood)
			System.out.println(sfood);
		System.out.println("\nTotal Bill Amount is  \t\t\t"+totalBill);
        System.out.println("\nCustomer Name      \t\t\t "+CustName);
        System.out.println("\nDate\t               \t\t\t"+date);
		System.out.println("\n\t<--Thank you visit again-->\n");
		
		
		
		
				
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
					System.out.println(itemname+" Price is updated");
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
					System.out.println("Food Item "+ Deleteitem +" is Removed from Items List");
					break;
					}
					
				}
				if(flag==0)
				{
					System.out.println("There is no Item With name "+ Deleteitem +" Present in Menu");
				}
			}
			
			
			public void Generatepdf()
			{
				String filename=BillNo+" "+date+CustName+".pdf";
				BillNo++;
				Document document = new Document();
			      try
			      {
			         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
			         document.open();
			         
			         document.add(new Paragraph("   <-----Hotel Telugu Ruchulu----->"));
			         document.add(new Paragraph("\n             Receipt            \n"));
			         document.add(new Paragraph("*******************************************************"));
			         document.add(new Paragraph("ITEM NAME    PRICE    QUANTITY    COST"));
			         for(String sfood:selectedfood)
			        	 document.add(new Paragraph(sfood));
			         document.add(new Paragraph("*******************************************************"));
			         document.add(new Paragraph("\nTotal Bill Amount is                          "+totalBill));
			         document.add(new Paragraph("\nCustomer Name                                 "+CustName));
			         document.add(new Paragraph("\nDate                                          "+date));
			         document.add(new Paragraph("\n    <--Thank you visit again-->\n"));
			         
			         
			         
			         document.close();
			         writer.close();
			      } catch (DocumentException e)
			      {
			         e.printStackTrace();
			      } catch (FileNotFoundException e)
			      {
			         e.printStackTrace();
			      }
			}
			
		
			//Generate day report
		public void getreport()
	{
		int totalmoney=0;
		
		
		@SuppressWarnings("rawtypes")
		Iterator itr=Itemlist.iterator(); 
		System.out.println("ITEM NAME\t ITEM PRICE \t TOTAL ORDERS \t  MONEY");
		while(itr.hasNext()){  
		    Food f=(Food)itr.next();  
		    if(f.getIcount()>0)
		    {
		    	
		    
		    System.out.println(f.getFname()+" \t"+f.getPrice()+"\t "+f.getIcount()+" \t"+f.getImoney());
		    totalmoney+=f.getImoney();
		    }
		
		
	
		}
		System.out.println("Total money\t\t\t\t"+ totalmoney);
	
	
}
}
