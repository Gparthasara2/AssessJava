package com.stockManager;

import java.util.List;

public class purchase_item {
	private String item_name;
	private int item_quantity;
	private double individual_cost;
	private double item_cost;

	public purchase_item(String item_name, int item_quantity, float individual_cost, double item_cost) {
		super();
		this.item_name = item_name;
		this.item_quantity = item_quantity;
		this.individual_cost = individual_cost;
		this.item_cost = item_cost;
	}

	public purchase_item() {
		// TODO Auto-generated constructor stub
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}

	public double getIndividual_cost() {
		return individual_cost;
	}

	public void setIndividual_cost(double individual_cost) {
		this.individual_cost = individual_cost;
	}

	public double getItem_cost() {
		return item_cost;
	}

	public void setItem_cost(double item_cost) {
		this.item_cost = item_cost;
	}

	public void printInvoiceHeader() {
		System.out.println(
				"--------------------------------------------------------------------INVOICE------------------------------------------------------------------------");
		System.out.println(
				String.format("%30s %25s %10s %25s %10s %25s %10s", "Item", "|", "Price($)", "|", "Qty", "|", "Cost"));
		System.out.println(String.format("%s",
				"---------------------------------------------------------------------------------------------------------------------------------------------------"));
	}

	public void printInvoice() {
		System.out.println(String.format("%30s %25s %10.2f %25s %10s %25s %10.2f", this.getItem_name(), "|",
				this.getIndividual_cost(), "|", this.getItem_quantity(), "|",
				this.getItem_quantity() * this.getIndividual_cost()));
	}

	public void buildInvoice(List<purchase_item> purchaseditems) {
		this.printInvoiceHeader();
		for (purchase_item p : purchaseditems) {
			p.printInvoice();
		}
	}
}
