package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.Food;
import dao.OrderFood;

public class FoodData {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	ArrayList<Food> Itemlist = new ArrayList<>();//store menu
	ArrayList<String>selectedfood=new ArrayList<>();
	ArrayList<OrderFood>orderfood=new ArrayList<>();
	Food Food;
	
	public void setItemlist(ArrayList<Food> itemlist) {
		Itemlist = itemlist;
	}
	
	public OrderFood OrderFood;
	public int selectitem;
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
	
	
}
