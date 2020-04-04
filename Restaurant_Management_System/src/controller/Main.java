/**
 * 
 */
package controller;

import java.io.*;
import model.*;

/**
 * @author haris
 *
 */




public class Main {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		FoodData Fooddata=new FoodData();

		User user=new User();
		EmployeeAdd employeeadd=new EmployeeAdd();
		int select;
		Boolean flag=false;
		Boolean eflag=false;

		do {
			Mainmenu();

			select=Integer.parseInt(br.readLine()); 
			switch(select)
			{
			case 1://admin menu display 
				do {
					if(flag!=true)
					{
						if(user.adminlogin())
						{
							flag=true;
							System.out.println("Login successfully\n\n");
						}
						else
						{
							System.out.println("Please Enter Correct username or password");
						}

					}	
					if(flag==true)
					{
						Adminmenu();
						select=Integer.parseInt(br.readLine()); 
						switch(select)
						{
						case 1:
							Fooddata.additem();
							break;
						case 2:
							Fooddata.UpdateFood();
							break;
						case 3:
							Fooddata.DeleteFood();
							break;
						case 4:
						Fooddata.getreport();
						break;

						case 5:System.out.println("Add Employee");
						employeeadd.addemployee();

						break;
						case 0:System.out.println("back menu");
						break;
						default: break;

						}


					}

				}
				while (select !=0);
				break;
			case 2:
				do {
					if(eflag!=true)
					{
						if(employeeadd.userlogin())
						{
							eflag=true;
							System.out.println("Login successfully\n\n");
						}
						else
						{
							System.out.println("Please Enter Correct username or password");
						}

					}	
					if(eflag==true)
					{

					usermenu();
					select=Integer.parseInt(br.readLine()); 
					switch(select)
					{
					case 1:
						Fooddata.displayfood();
						break;
					case 2:
						Fooddata.Bill();
						Fooddata.Generatepdf();
						//Fooddata.excel();
						break;
					case 0:System.out.println("Back to main menu");
					break;
					default:
						break;
					}

				}
				}

				while (select !=0);
				break;

			default:
				break;
			}
		}
		while (select !=3);
		System.out.println("Program Closed Thank You");



	}

	static void Mainmenu()
	{

		System.out.println("                              -----------> Welcom to Telugu Ruchulu <-----------");
		System.out.println("1. Admin");
		System.out.println("2. Employee");
		System.out.println("3. Exit");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("Select any option");
	}
	static void Adminmenu() {
		System.out.println("                                        *********** Admin Portal ************");
		System.out.println("1. Add Food Item");
		System.out.println("2. Update Food Item");
		System.out.println("3. Delete Fodd Item");
		System.out.println("4. Generate Report");
		System.out.println("5. Add Employee");
		System.out.println("0. BACK TO menu main");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("Select any option");
	}
	static void usermenu() {
		System.out.println("                                       ************** Employee Portal ********");
		System.out.println("1. Print Menu");
		System.out.println("2. Take Order");
		System.out.println("0. BACK TO MAIN MENU");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("Select any option");
	}


}
