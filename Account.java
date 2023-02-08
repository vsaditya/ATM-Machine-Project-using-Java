package qsp;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
	Scanner input=new Scanner(System.in);
	DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");

	private int customerNumber;
	private int pinNumber;
	private double currentBalance=0;
	private double savingBalance=0;
	
	/* Set customer number*/
	
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber=customerNumber;
	}
	
	/* Get the customer number*/
	
	public int getCustomerNumber() {
		return customerNumber;
	}
	
	/*Get the pin number*/
	
	public int getPinNumber() {
		return pinNumber;
	}
	
	/*Set the Pin Number*/
	
	public void setPinNumber(int pinNumber) {
		this.pinNumber=pinNumber;
	}
	
	/*Get Account Current Balance*/
	
	public double getCurrentBalance() {
		return currentBalance;
	}
	
	/*Get Saving Account Balance*/
	
	public double getSavingBalance() {
		return savingBalance;
	}
	
	/*Calculate Saving Account WithDrawal*/
	
	public double calcSavingWithdraw(double amount) {
		savingBalance=(savingBalance-amount);
		return savingBalance;
	}
	
	/*Calculate Checking Account WithDrawal*/
	
	public double calcCurrentWithdraw(double amount) {
		currentBalance=(currentBalance-amount);
		return currentBalance;
	}
	
	/*Calculate Checking Account Deposit*/
	
	public double calcCurrentDeposit(double amount) {
		currentBalance=(currentBalance+amount);
		return currentBalance;
	}
	
	/*Calculate Saving Account Deposit */
	
	public double calcSavingDeposit(double amount) {
		savingBalance=(savingBalance+amount);
		return savingBalance;
	}
	
	/*Customer Checking account Withdraw input*/
	
	public void getCurrentWithdrawInput() {
		System.out.println("Current Account Balance:"+ moneyFormat.format(currentBalance));
		System.out.println("Amount you want to withdraw from Current Account:");
		double amount=input.nextDouble();
		
		if((currentBalance-amount)>=0) {
			calcCurrentWithdraw(amount);
			System.out.println("New Current Balance Amount:"+ moneyFormat.format(currentBalance));
		}else{
			System.out.println("Balance cannot be negetive.");
		}
	}
	
	/*Customer Saving Account Withdraw input*/
	

		public void getSavingWithdrawInput() {
			System.out.println("Saving Account Balance: "+moneyFormat.format(savingBalance));
			System.out.print("Amount to withdraw from savings account:");
			double amount=input.nextDouble();
			
			if((savingBalance-amount) >=0 ) {
				calcSavingWithdraw(amount);
				System.out.println("New Saving Account Balance:" + savingBalance +"/n");
			}else {
				System.out.println("Balance cannot be negetive");
			}
		}
		
		public void getCurrentDepositInput() {
			System.out.println("Current Account Balance: "+moneyFormat.format(currentBalance));
			System.out.print("Amount to be deposited to Current account:");
			double amount=input.nextDouble();
			
			if((currentBalance + amount) >=0 ) {
				calcCurrentDeposit(amount);
				System.out.println("New Current Account Balance:" + moneyFormat.format(currentBalance));
			}else {
				System.out.println("Balance cannot be negetive");
			}
		}
		
		public void getSavingDepositInput() {
			System.out.println("Saving Account Balance: "+moneyFormat.format(savingBalance));
			System.out.print("Amount to be deposited to Saving account:");
			double amount=input.nextDouble();
			
			if((currentBalance + amount) >=0 ) {
				calcSavingDeposit(amount);
				System.out.println("New Saving Account Balance:" + moneyFormat.format(savingBalance));
			}else {
				System.out.println("Balance cannot be negetive");
			}
		}
	}