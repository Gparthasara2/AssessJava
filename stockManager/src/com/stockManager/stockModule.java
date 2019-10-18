package com.stockManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class stockModule {
	private List<itemModule> items = new ArrayList<itemModule>(10);

	public stockModule() {
		this.items.add(new itemModule("Potato", 50, "111", 100));
		this.items.add(new itemModule("Tomato", 100, "222", 100));
		this.items.add(new itemModule("Wheat", 150, "333", 100));
		this.items.add(new itemModule("Oil", 100, "444", 100));
		this.items.add(new itemModule("Soap", 250, "555", 100));
		this.items.add(new itemModule("Detergent", 350, "666", 100));
		this.items.add(new itemModule("Table", 150, "777", 100));
		this.items.add(new itemModule("Rice", 150, "888", 100));
		this.items.add(new itemModule("Barley", 100, "999", 100));
		this.items.add(new itemModule("Corn", 150, "765", 100));
	}

	public void checkcode(String code) throws codeException {
		int c = Integer.parseInt(code);
		int count = 0;
		while (c != 0) {

			c /= 10;
			++count;
		}
		if (count != 3) {
			throw new codeException("The Code must be three digits. Try Again.");
		}

	}

	public void createItem(String name, float price, String code, int quantity) {
		int f = 0;
		do {
			try {
				f = 1;
				this.checkcode(code);
			} catch (codeException n) {
				System.err.println(n.getMsg());
			}
		} while (f == 0);

		itemModule i = new itemModule(name, price, code, quantity);
		this.items.add(i);

	}

	public boolean checkItemAvailability(String item_name) {
		for (itemModule item : this.items) {
			if (item.getItem_name().equals(item_name)) {
				return true;
			}
		}

		return false;
	}

	public boolean checkItemQuantity(int item_quantity) {
		for (itemModule item : this.items) {
			if (item.getItem_quantity() >= item_quantity) {
				return true;
			}
		}

		return false;
	}

	public double priceOfPurchase(String item_name, int item_quantity) {
		double price = 0.0;
		itemModule curr = new itemModule();
		for (itemModule item : this.items) {
			if (item.getItem_name().equals(item_name)) {
				curr = item;
			}
		}

		price = curr.getItem_price() * item_quantity;
		curr.setItem_quantity(curr.getItem_quantity() - item_quantity);

		return price;
	}

	public List<itemModule> getItems() {
		return items;
	}

	public void setItems(List<itemModule> items) {
		this.items = items;
	}

	public void printStockHeader() {
		System.out.println(
				"--------------------------------------------------------------------AVAILABLE STOCKS-----------------------------------------------------------");
		System.out.println(
				String.format("%30s %25s %10s %25s %10s %25s %10s", "ITEM", "|", "PRICE", "|", "CODE", "|", "QUANTITY"));
		System.out.println(String.format("%s",
				"---------------------------------------------------------------------------------------------------------------------------------------------------"));
	}

	public void customerStockHeader() {
		System.out.println(
				"--------------------------------------------------------------------AVAILABLE ITEMS-----------------------------------------------------------");
		System.out.println(
				String.format("%30s %25s %10s %25s  %10s", "ITEM", "|", "PRICE", "|",  "QUANTITY"));
		System.out.println(String.format("%s",
				"---------------------------------------------------------------------------------------------------------------------------------------------------"));
	}
	
	public void cusViewStock() {
		this.customerStockHeader();
		for(itemModule i: this.items) {
			i.CusprintItem();
		}
//		System.out.println("The Available Stock:");
//		System.out.println("\t Name \t Code \t Quantity \t Cost");
//		for (itemModule i : this.getItems()) {
//			System.out.println("\t " + i.getItem_name() + "\t " + i.getItem_code() + "\t\t " + i.getItem_quantity()
//					+ "\t\t " + i.getItem_price());
//		}
	}
	
	public void viewStock() {
		this.printStockHeader();
		for(itemModule i: this.items) {
			i.printItem();
		}
//		System.out.println("The Available Stock:");
//		System.out.println("\t Name \t Code \t Quantity \t Cost");
//		for (itemModule i : this.getItems()) {
//			System.out.println("\t " + i.getItem_name() + "\t " + i.getItem_code() + "\t\t " + i.getItem_quantity()
//					+ "\t\t " + i.getItem_price());
//		}
	}
	
	public void removeTheItem(String name) {
		itemModule temp = new itemModule();
		for(itemModule i:this.items) {
			if(i.getItem_name().equals(name)) {
				temp = i;
			}
		}
		
		this.items.remove(temp);
	}
	
	public void modifyTheItem(String name) {
		Scanner reader = new Scanner(System.in);
		itemModule temp1 = new itemModule();
		for(itemModule i:this.items) {
			if(i.getItem_name().equals(name)) {
				temp1 = i;
			}
		}
		System.out.println("Enter new Item Name, Item Price, Item Quantity and Item Code in order: ");
		String nameNew = reader.nextLine();
		double priceNew = Double.parseDouble(reader.nextLine());
		int qNew = Integer.parseInt(reader.nextLine());
		String newCode = reader.nextLine();
		
		temp1 = new itemModule(nameNew,(float)priceNew,newCode,qNew);
		
		
	}

}