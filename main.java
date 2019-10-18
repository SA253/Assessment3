package Localstore;
import java.util.*;

public class main {
	
	public static void main(String[] args) throws invalidname, codeException {
		int option = 0;

		itemmanager i = new itemmanager();
		
		do {
			Scanner s = new Scanner(System.in);
			System.out.println("\n Menu");
			System.out.println("1. enter the data of items");
			System.out.println("2. view the items");
			System.out.println("3. update");
			System.out.println("4. delete");
			System.out.println("5. total amount");
			System.out.println("6. exit");

			System.out.print("\n option");

			option = Integer.parseInt(s.nextLine());
			switch (option) {
			case 1:
		        i.add(i.newitem());
				break;
			case 2:
				System.out.printf("%70s\n","STOCK DATA");
				for(item k:i.items) {
					i.viewitem(k);
				}
					break;
			case 3:
				System.out.println("Enter the item to edit");
				int idForedit = Integer.parseInt(s.nextLine());
				i.edititem( idForedit);
				break;
			case 4:
				System.out.println("Enter the item to delete");
				int idForRemove = Integer.parseInt(s.nextLine());
				i.removeitem(idForRemove);
				break;
			case 5:
				System.out.println("Enter the total price");
				float f=0f;
				i.total(f);
				break;
			}
			}while (option != -1);
			
		}
	}
		
