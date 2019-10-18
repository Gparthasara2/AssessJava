package com.stockManager;

public class itemModule {
	private String item_name;
	private float item_price;
	private String item_code;
	private int item_quantity;

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public float getItem_price() {
		return item_price;
	}

	public void setItem_price(float item_price) {
		this.item_price = item_price;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public int getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}

	public itemModule(String item_name, float item_price, String item_code, int item_quantity) {
		super();
		this.item_name = item_name;
		this.item_price = item_price;
		this.item_code = item_code;
		this.item_quantity = item_quantity;
	}

	public itemModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void printItem() {
		System.out.println(String.format("%30s %25s %10.2f %25s %10s %25s %10s", this.getItem_name(), "|",
				this.getItem_price(), "|", (this.getItem_code()), "|",
				this.getItem_quantity()));
	}
	
	public void CusprintItem() {
		System.out.println(String.format("%30s %25s %10.2f %25s %10s", this.getItem_name(), "|",
				this.getItem_price(), "|", 
				this.getItem_quantity()));
	}

}
