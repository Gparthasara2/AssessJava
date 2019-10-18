package com.stockManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class menuDriver {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		System.out.println("Enter 1 if you are Clerk and 0 if you are Customer: ");
		int user = Integer.parseInt(reader.nextLine());
		if (user == 0) {
			stockModule stock = new stockModule();
			List<purchase_item> purchaseditems = new ArrayList<purchase_item>();
			int customer_check = 0;
			System.out.println("Welcome to the Store");
			do {

				System.out.println("Enter the item you wanted to buy: \n");
				
				stock.cusViewStock();
				String item_name = reader.nextLine();

				if (stock.checkItemAvailability(item_name)) {
					System.out.println("Enter the quantity: \n");
					int item_quantity = Integer.parseInt(reader.nextLine());
					if (stock.checkItemQuantity(item_quantity)) {
						double price = stock.priceOfPurchase(item_name, item_quantity);
						System.out.println("The cost of the item is Rs. " + price);
						purchaseditems
								.add(new purchase_item(item_name, item_quantity, (float) price / item_quantity, price));
						System.out.println("Type 1 if you wanted to purchase more or -1 to get your invoice: ");
						customer_check = Integer.parseInt(reader.nextLine());
						if (customer_check == -1) {
							break;
						}
					} else {
						System.out.println("Sorry, " + item_name + " is out of goods.");
					}
				} else {
					System.out.println("Sorry, the item is NOT AVAILABLE.");
				}

			} while (customer_check != -1);

			if (customer_check == -1) {
				double total = 0;
				purchase_item a = new purchase_item();
				a.buildInvoice(purchaseditems);
				for (purchase_item p : purchaseditems) {

					total += p.getItem_cost();
				}

				System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t TOTAL : Rs. " + total);
				System.out.println("----------------------------------------------------------THANK YOU FOR SHOPPING WITH US------------------------------------------------------");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------");
			}
		} else {
			System.out.println("Hello, Select a Valid Option: ");
			int wanted = 0;
			do {
				System.out.println("1. View the Stock");
				System.out.println("2. Add a new item to stock");
				System.out.println("3. Remove from the stock");
				System.out.println("4. Modify a stock");
				System.out.println("5. Exit");
				stockModule stock = new stockModule();
				wanted = Integer.parseInt(reader.nextLine());
				switch (wanted) {
				case 1:
					stock.viewStock();
					break;
				case 2:
					System.out.println("Enter the name of the item: ");
					String name = reader.nextLine();
					System.out.println("Enter the Price of the item: ");
					float price = Integer.parseInt(reader.nextLine());
					System.out.println("Enter the code of the item: ");
					String code = reader.nextLine();
					System.out.println("Enter the Quantity of items: ");
					int quantity = Integer.parseInt(reader.nextLine());
					stock.createItem(name, price, code, quantity);
					break;

				case 3:
					System.out.println("Enter the name of the item to remove: ");
					name = reader.nextLine();
					stock.removeTheItem(name);
					break;
				case 4:
					System.out.println("Enter the name of the item to modify: ");
					name = reader.nextLine();
					stock.modifyTheItem(name);
					break;
				case 5:
					wanted = -1;
					System.out.println("Thank you!!!");
					break;
					
				}

			} while (wanted != -1);

		}

	}

}
