package model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import model.User;



public class EmployeeAdd {


	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	ArrayList<User>employeedata=new ArrayList<User>();

	User User;
	User user=new User();


	public ArrayList<User> getEmployeedata() {
		return employeedata;
	}
	public void setEmployeedata(ArrayList<User> employeedata) {
		this.employeedata = employeedata;
	}

	public EmployeeAdd() {

	}

	public void addemployee() throws IOException {


		User user=new User();

		user.adduser();
		employeedata.add(user);
		System.out.println("employee added sucessfully");
	}
	public boolean userlogin() throws IOException
	{
		System.out.println("enter user name");
		String uname=br.readLine();
		System.out.println("enter password");
		String pass=br.readLine();
		int v=0;

		for(int i=0;i<employeedata.size();i++)
		{
			if(employeedata.get(i).getUsername().equals(uname)&& employeedata.get(i).getPassword().equals(pass))
			{
				v=1;
			}
		}
		if(v==1)
			return true;
		else
			return false;
	}
}

