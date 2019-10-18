package Localstore;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

class invalidname extends Exception {
	private String message;

	public invalidname() {
	}

	public invalidname(String message) {
		super(message);
		this.message = message;
	}

}

class codeException extends Exception {
	public codeException(String message) {
		super(message);
	}
}
public class itemmanager extends item{
	
	
	List<item>items=new LinkedList<item>();
	int id=0;
	
	public item newitem() throws invalidname,codeException{
		
		Scanner s = new Scanner(System.in);
		int f1=0;
		do {
		System.out.print("\n enter the itemcode");
		String icode = "";
		if (s.hasNext())
			
			
			try {
				icode = s.next();
				f1=0;
				Pattern p = Pattern.compile("^\\d{3}$");
				if(p.matcher(icode).matches()) {
					
					break;}
				if (!(p.matcher(icode).matches())) {
					f1=1;
					throw new codeException("code should be of 3 digits");
				}
				else {break;}
				}
				catch(codeException e){
					System.err.println(e.getMessage());
					
				}
		}while(f1==1);
		
		
		int flag = 0;
		do {
			System.out.print("\n enter the itemname");
			String iname = "";
			
			if (s.hasNext())

				try {
					iname = s.next();
					flag = 0;

					if (checkName(iname) == false) {
						flag = 1;

						throw new invalidname("name must not contain number");
						// throws exception

					}
				} catch (invalidname ie) {
					System.err.println(ie.getMessage());
				}
		} while (flag == 1);
		
		System.out.print("\n enter the itempricee");
		float iprice = 0f;
		if (s.hasNext())
			iprice = s.nextFloat();
		++id;
		return new item(id,icode,iname,iprice);
	}
	
	public boolean checkName(String iname) {
		int f = 0;
		char[] chars = iname.toCharArray();
		for (char c : chars) {
			if (Character.isDigit(c)) {
				f = 1;
			}
		}
		if (f == 1) {
			return false;
		} else {
			this.iname = iname;
			return true;
		}
	}
	
	
	
	
	public void add(item i) {
		items.add(i);
		
	}
	
	public void viewitem(item i) {
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.printf("%70s\n","DETAILS OF Item");
		System.out.println("----------------------------------------------------------------------------------------------------");
		//System.out.printf("Patient ID : %-30s Patient Name : %-1s\n",String.valueOf(p.getId()),p.getName());
		System.out.printf(" item id : %-1s \n item code : %-1s \n item Name : %-1s \n item price :%-30f\n",i.getId(),i.getIcode(),i.getIname(),i.getIprice());
		
		System.out.println("----------------------------------------------------------------------------------------------------");
	}

	public boolean validatephone(String icode) {
		Pattern p = Pattern.compile("^\\d{3}$");
		try {
		if(p.matcher(icode).matches()) {return false;}
		if (!(p.matcher(icode).matches())) {
			throw new codeException("code should not exceed 3 digits");
		}
		else {return false;}
		}
		catch(codeException e){
			System.err.println(e.getMessage());
			return true;
		}
	}
		
	public void edititem(int id) {

		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the new code ");

		String newicode = reader.nextLine();
		System.out.println("Enter the new name ");

		String newiname = reader.nextLine();
		System.out.println("Enter the new price ");

		float newiprice = reader.nextFloat();
		

		for (item k : this.items) {
			if (k.getId() == id) {
				this.items.set(this.items.indexOf(k), new item(newicode,newiname,newiprice));}}
		System.out.println("data updated successfully");
	}
	
	public void removeitem(int id) {
		item temp = new item();
		for (item s : this.items) {
			if (s.getId() == id) {
				temp = s;
			}
		}
		this.items.remove(temp);
		
	}
	public void total(float iprice) {
		for(item s:this.items) {
			float temp=0;
			temp+=s.getIprice();
			
		}
	}
}

