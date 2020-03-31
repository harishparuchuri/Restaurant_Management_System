/**
 * 
 */
package controller;

/**
 * @author haris
 *
 */
import java.util.*;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int select;
		do {
			Mainmenu();
			select=sc.nextInt();
			switch(select)
			{
			case 1://admin menu display and functions
				do {
					Adminmenu();
					select=sc.nextInt();
					switch(select)
					{
					case 1:System.out.println("add food item");
					break;
					case 2:System.out.println("update food");
					break;
					case 3:System.out.println("delete food");
					break;
					case 4:System.out.println("Generate report");
					break;

					case 5:System.out.println("optional sort items ");
					break;
					case 0:System.out.println("back menu");
					break;
					default: break;

					}


				}
				while (select !=0);
				break;
			case 2:
				do {
					usermenu();
					select=sc.nextInt();
					switch(select)
					{
					case 1:System.out.println("print menu");
					break;
					case 2:System.out.println("take order");
					break;
					case 0:System.out.println("return main menu");
					break;
					default:
						break;
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
		System.out.println("5. Sort items");
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
