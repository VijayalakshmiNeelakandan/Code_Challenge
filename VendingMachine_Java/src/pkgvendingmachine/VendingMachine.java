// Program for a Vending Machine that dispenses drinks based on coins added
// Handled basic test scenarios for user input

package pkgvendingmachine;

import java.util.*;

public class VendingMachine {
	static int drinkchoice;
	public static void main(String args[]) throws InputMismatchException {
		UserInput ip = new UserInput();
		welcomeuser wc = new welcomeuser();
		drinkchoice = wc.choosedrink();
		ip.selectProduct(drinkchoice);
	}
}

	class welcomeuser {
		static Scanner scw = new Scanner(System.in);
		int drinkchoice;
		int choosedrink()
		{
		do {
		    try {
				System.out.println("Hi, Welcome to Viji's Vending Machine");
				System.out.println("Select one of the Items:");
				System.out.println("Enter 1 for COKE (25 Cents)");
				System.out.println("Enter 2 for PEPSI (35 Cents)");
				System.out.println("Enter 3 for SODA (45 Cents)");
				System.out.println("Enter 4 for Supplier login");
				System.out.println("Enter 9 to Exit");
				drinkchoice = scw.nextInt();
		    } catch (InputMismatchException e) {
				System.out.println("Invalid option. Please enter from one of the given options");
		    }
		    scw.nextLine(); // clears the buffer
		} while (drinkchoice  <= 0);
		
		return drinkchoice;
	}
	}
	class UserInput {
		int totalAmount=0, PINinput=0;
		final int supplierPIN=1234;
		static Scanner sc = new Scanner(System.in);

		int input(int coins)	{
		switch(coins) {
			case 9:
				System.out.println("Transaction Cancelled. Please collect your Refund Amount: "+totalAmount +" Cents");
				System.exit(0);
			break;
			case 1:
				totalAmount = totalAmount +1;
			break;
			case 5:
				totalAmount = totalAmount + 5;
			break;
			case 10:
				totalAmount = totalAmount + 10;
			break;
			case 25:
				totalAmount = totalAmount + 25;
			break;
			default :
			System.out.println("Invalid Coin added. Accepted denominations: 1,5,10,25 Cents");
			break;
			}
			return 0;
		}
		
		int selectProduct(int userchoice) {
			switch(userchoice) {
				case 9:
					System.out.println("Transaction Cancelled. Thank you");
					System.exit(0);
				break;
				case 1:
					processdrink("Coke",25);
				break;
				case 2:
					processdrink("Pepsi",35);
				break;
				case 3:
					processdrink("Soda",45);
				break;
				case 4:
					supplierLogin();
				break;
				default:
				System.out.println("Invalid Choice. Please choose from the options 1,2,3 or 4");
			}
			return 0;
		}

// Validating Drink choice given by user		
		void processdrink(String drink, int cost) {
			int coins=01
					;
			System.out.println("You have selected "+drink);
			System.out.println("Please add "+cost+" cents. Accepted denominations: 1,5,10,25 Cents");
			
			validatecoininput(coins);

			while (totalAmount < cost) {			
			System.out.println("Insufficient funds. Add balance of "+ (cost - totalAmount)+ " cents. \n(Enter 9 to Cancel the Transaction and get a Refund)");
			validatecoininput(coins);
			}
			
			totalAmount = totalAmount - cost;
			System.out.println("Please Collect your "+drink);
			System.out.println("Please Collect your Remaining change: "+totalAmount);
		}

// Validating Coin Input		
		void validatecoininput(int coins) {
			do {
			    try {
					coins = sc.nextInt();
					input(coins);
			    } catch (InputMismatchException e) {
					System.out.println("Invalid coin. Accepted denominations: 1,5,10,25 Cents");
			    }
			    sc.nextLine(); // clears the buffer
			} while (coins <= 0);
		}
		
// Supplier Login method		
		void supplierLogin()	{
			System.out.println("Please enter the Supplier PIN");
			do {
			    try {
			    	PINinput = sc.nextInt();
			    } catch (InputMismatchException e) {
					System.out.println("Invalid PIN. Please enter only numbers");
			    }
			    sc.nextLine(); // clears the buffer
				} while (PINinput <= 0);
					if(PINinput == supplierPIN) 
					{
					//Calling Input method to reset Cash register
						cashReset();
						stockReset();
					}
					else
					System.out.println("Incorrect PIN. Closing Program");
		}
	//  Cash Update
		void cashReset() {
			int[] cashCoin= new	int[4];
	//		1 cent cashCoin(0) = 15
	//		5 cent cashCoin(1) = 50
	//		10 cent cashCoin(2) = 20
	//		25 cent cashCoin(3) = 10
			System.out.println("Please enter the number of coins added per denomination");
			System.out.println("Enter the number of coins added for 1 cent : ");
			cashCoin[0] = sc.nextInt();
			System.out.println("Enter the number of coins added for 5 cents : ");
			cashCoin[1] = sc.nextInt();
			System.out.println("Enter the number of coins added for 10 cents : ");
			cashCoin[2] = sc.nextInt();
			System.out.println("Enter the number of coins added for 25 cents : ");
			cashCoin[3] = sc.nextInt();
			System.out.println("You have added "+cashCoin[0]+" coins for 1 cent");
			System.out.println("You have added "+cashCoin[1]+" coins for 5 cents");
			System.out.println("You have added "+cashCoin[2]+" coins for 10 cents");
			System.out.println("You have added "+cashCoin[3]+" coins for 25 cents");
		}
	//  Stock Update
		void stockReset() {
			
			int[] productUnits= new	int[4];
	
	//		COKE productUnits(0) = 20
	//		PEPSI productUnits(1) = 10
	//		SODA productUnits(2) = 10
	
			System.out.println("Please enter the number of units added per product");
			System.out.println("Enter the number of units added for COKE : ");
			productUnits[0] = sc.nextInt();
			System.out.println("Enter the number of units added for PEPSI : ");		
			productUnits[1] = sc.nextInt();
			System.out.println("Enter the number of units added for SODA : ");
			productUnits[2] = sc.nextInt();
			System.out.println("You have added "+productUnits[0]+" units for COKE");
			System.out.println("You have added "+productUnits[1]+" units for PEPSI");
			System.out.println("You have added "+productUnits[2]+" units for SODA");
		}
	}
	