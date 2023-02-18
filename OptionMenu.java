package qsp;


import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;


public class OptionMenu extends Account {
	Scanner menuInput=new Scanner(System.in);
	DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");
	
	int selection;
	
	HashMap<Integer,Integer> data=new HashMap<Integer,Integer>();
	
	
	/* Validate Customer account number and pin number*/
	
	public void getLogin() {
		int x=1;
		
         do {
			try {
				data.put(9876543,9876);
				data.put(8989898,1890);
				
				System.out.println("Welcome to the ATM Project");
				
				System.out.println("Enter your Account Number: ");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.println("Enter your PIN Number");
				setPinNumber(menuInput.nextInt());
			}catch(Exception e) {
				System.out.println("/n"+"Inavlid character(s). Only numbers."+"/n");
				x=2;
			}
			for(Entry<Integer, Integer> entry : data.entrySet()) {
				if(entry.getKey() == getCustomerNumber() && entry.getValue()== getPinNumber()) {
					getAccountType();
				}
			}
			System.out.println("Wrong customer number or pin number");
		}while(x==1);
	}
	
	/*Display account type with menu along with selection*/
	
	public void getAccountType() {
		System.out.println("Select the account that you want to access:");
		System.out.println("Type 1 : Current Acoount");
		System.out.println("Type 2 : Savings Account");
		System.out.println("Type 3 : Exit");
		System.out.println("Choice : ");
		
		selection=menuInput.nextInt();
		
		switch(selection) {
		case 1:
			getCurrent();
			break;
			
		case 2:
			getSaving();
			break;
			
		case 3:
			System.out.println("Thank you for using this ATM, bye.");
			break;
			
		default:
			System.out.println("Invalid Choice.");
			break;
		}
		
		
		}
	
	/*Display current account with selections*/
	
		public void getCurrent() {
			System.out.println("Current Account: ");
			System.out.println("Type 1- View Balance");
			System.out.println("Type 2- Withdraw Funds");
			System.out.println("Type 3- Deposit Funds");
			System.out.println("Type 4- Exit");
			System.out.println("Choice : ");
		
			selection=menuInput.nextInt();
		
		switch(selection) {
		case 1:
			System.out.println("Current Account Balance: " + moneyFormat.format(getCurrentBalance()));
			getAccountType();
			break;
			
		case 2:
			getCurrentWithdrawInput();
			getAccountType();
			break;
			
		case 3:
			getCurrentDepositInput();
			getAccountType();
			break;
			
		case 4:
			System.out.println("Thank you for using this ATM, bye.");
			break;
			
		default:
			System.out.println("Invalid choice.");
			break;
		}	
	}
		
		public void getSaving() {
			System.out.println("Savings Account: ");
			System.out.println("Type 1- View Balance");
			System.out.println("Type 2- Withdraw Funds");
			System.out.println("Type 3- Deposit Funds");
			System.out.println("Type 4- Exit");
			System.out.println("Choice : ");
			
			selection=menuInput.nextInt();
			
			switch(selection) {
			case 1:
				System.out.println("Saving Account Balance: "+ moneyFormat.format(getSavingBalance()));
				getAccountType();
				break;
				
			case 2:
				getSavingWithdrawInput();
				getAccountType();
				break;
				
			case 3:
				getSavingDepositInput();
				getAccountType();
				break;
				
			case 4:
				System.out.println("Thank you for using this ATM, bye.");
				break;
				
			default:
				System.out.println("Invalid choice.");
				break;
		}
	}
}
