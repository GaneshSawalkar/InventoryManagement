package com.bridgelabz.felloship.operations;

import java.util.List;

import com.bridgelabz.felloship.control.control;
import com.bridgelabz.felloship.inventory.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

public class operations {

	static ObjectMapper mapper = new ObjectMapper();

	public static void removeInventory() {
		List<Product> lists = control.readInventory(); // read all inventory
		System.out.println("enter product name: ");
		String inputname = inputvalidation.isString();
		try {
			for (Product product : lists) {
				if (product.name.equals(inputname)) { // if found then
					lists.remove(product); // remove inventory
				}
			}
		} catch (Exception e) {
		}
		control.writeInventory(lists); // re-write updated inventory
	}

	public static void updateInventory() {
		List<Product> list = control.readInventory(); // read all ininventory
		System.out.println("enter product name: ");
		String inputname = inputvalidation.isString();
		for (Product product : list) {
			if (product.name.equals(inputname)) {
				System.out.println("1. Product Name\n" + "2. Price\n" + "3. Weight");
				int choice = inputvalidation.isvalidInteger();
				switch (choice) {
				case 1:
					System.out.println("new name");
					product.setName(inputvalidation.isString()); // set new product name
					break;
				case 2:
					System.out.println("new price");
					product.setPrice(inputvalidation.isvalidInteger()); // set new product price
					break;
				case 3:
					System.out.println("change weight");
					product.setWeight(inputvalidation.isvalidInteger()); // set new product weight
					break;
				default:
					break;
				}
			}

		}
		control.writeInventory(list); // re-write updated inventory
	}

	public static void addInventory() {
		List<Product> array = control.readInventory(); // read all inventory
		System.out.println("enter the product"); // main product name
		String product = inputvalidation.isString();
		System.out.print("enter product sub types: "); // product sub types amount
		int productsubtypes = inputvalidation.isvalidInteger();
		for (int i = 0; i < productsubtypes; i++) {
			Product newproduct = new Product();
			newproduct.setType(product); // set product type
			System.out.println("enter the sub type" + (i + 1) + " product name");
			newproduct.setName(inputvalidation.isString()); // set product name
			System.out.println("enter the Weight: ");
			newproduct.setWeight(inputvalidation.isvalidInteger()); // set product weight

			System.out.println("enter the price per Kg: ");
			newproduct.setPrice(inputvalidation.isvalidInteger()); // set product price

			array.add(newproduct); // add new product in list
		}
		control.writeInventory(array); // re-write inventory list

	}

	public static void searchInventory() {
		List<Product> list = control.readInventory(); // read all inventory
		System.out.println("enter the product");
		String input = inputvalidation.isString();
		for (Product product : list) {
			if (product.name.equals(input)) { // if product found then show details
				System.out.print("the total price is: ");
				System.out.println(product.price * product.weight + " for " + product.weight + " kg");
			}
		}
	}

}
