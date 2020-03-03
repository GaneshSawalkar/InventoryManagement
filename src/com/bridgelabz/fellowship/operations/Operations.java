package com.bridgelabz.fellowship.operations;

import java.util.List;

import com.bridgelabz.fellowship.control.Control;
import com.bridgelabz.fellowship.inventory.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Operations {

	static ObjectMapper mapper = new ObjectMapper();

	public static void removeInventory() {
		List<Product> lists = Control.readInventory(); // read all inventory
		System.out.println("enter product name: ");
		String inputname = Inputvalidation.isString();
		try {
			for (Product product : lists) {
				if (product.name.equals(inputname)) { // if found then
					lists.remove(product); // remove inventory
				}
			}
		} catch (Exception e) {
		}
		Control.writeInventory(lists); // re-write updated inventory
	}

	public static void updateInventory() {
		List<Product> list = Control.readInventory(); // read all ininventory
		System.out.println("enter product name: ");
		String inputname = Inputvalidation.isString();
		for (Product product : list) {
			if (product.name.equals(inputname)) {
				System.out.println("1. Product Name\n" + "2. Price\n" + "3. Weight");
				int choice = Inputvalidation.isvalidInteger();
				switch (choice) {
				case 1:
					System.out.println("new name");
					product.setName(Inputvalidation.isString()); // set new product name
					break;
				case 2:
					System.out.println("new price");
					product.setPrice(Inputvalidation.isvalidInteger()); // set new product price
					break;
				case 3:
					System.out.println("change weight");
					product.setWeight(Inputvalidation.isvalidInteger()); // set new product weight
					break;
				default:
					break;
				}
			}

		}
		Control.writeInventory(list); // re-write updated inventory
	}

	public static void addInventory() {
		List<Product> array = Control.readInventory(); // read all inventory
		System.out.println("enter the product"); // main product name
		String product = Inputvalidation.isString();
		System.out.print("enter product sub types: "); // product sub types amount
		int productsubtypes = Inputvalidation.isvalidInteger();
		for (int i = 0; i < productsubtypes; i++) {
			Product Newproduct = new Product();
			newproduct.setType(product); // set product type
			System.out.println("enter the sub type" + (i + 1) + " product name");
			newproduct.setName(Inputvalidation.isString()); // set product name
			System.out.println("enter the Weight: ");
			newproduct.setWeight(Inputvalidation.isvalidInteger()); // set product weight

			System.out.println("enter the price per Kg: ");
			newproduct.setPrice(Inputvalidation.isvalidInteger()); // set product price

			array.add(newproduct); // add new product in list
		}
		Control.writeInventory(array); // re-write inventory list

	}

	public static void searchInventory() {
		List<Product> list = Control.readInventory(); // read all inventory
		System.out.println("enter the product");
		String input = Inputvalidation.isString();
		for (Product product : list) {
			if (product.name.equals(input)) { // if product found then show details
				System.out.print("the total price is: ");
				System.out.println(product.price * product.weight + " for " + product.weight + " kg");
			}
		}
	}

}
