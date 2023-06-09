package com.ATMInterface;

import java.util.Scanner;

public class AtmInterface 
{

	public static int takeIntegerInput(int limit)
	{
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) {
					System.out.println("Choose the number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("Enter only integer value");
				flag = false;
			}
		};
		return input;
	}
	
	
	public static void main(String[] args) 
	{
		
		System.out.println("\nWELCOME TO NATIONAL BANK ATM MACHINE\n");
		System.out.println("1.Register");
		System.out.println("2.Exit \n");
		System.out.print("Enter Your Choice - ");
		int choice = takeIntegerInput(2);
		
		if ( choice == 1 ) 
		{
			Account a = new Account();
			a.register();
			while(true) 
			{
				System.out.println("1.Login");
				System.out.println("2.Exit \n");
				System.out.print("Enter Your Choice - ");
				int ch = takeIntegerInput(2);
				if ( ch == 1 ) 
				{
					if (a.login())
					{
						System.out.println("\n\nWELCOME BACK " + a.accholder + "\n");
						boolean isFinished = false;
						while (!isFinished) {
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.print("\nEnter Your Choice - ");
							int c = takeIntegerInput(6);
							switch(c) 
							{
								case 1:
								a.withdraw();
								break;
								case 2:
								a.deposit();
								break;
								case 3:
								a.transfer();
								break;
								case 4:
								a.checkBalance();
								break;
								case 5:
								a.transHistory();
								break;
								case 6:
								isFinished = true;
								break;
							}
						}
					}
				}
				else 
				{
					System.exit(0);
					//System.out.println("Successfully Exit...");
				}
			}
		}
		else 
		{
			//System.exit(0);
			System.out.println("Successfully Exit...\n");
			
		}
		
		
		
	}
}
