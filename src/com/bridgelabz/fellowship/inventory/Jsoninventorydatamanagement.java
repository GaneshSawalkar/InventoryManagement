package com.bridgelabz.fellowship.inventory;

import com.bridgelabz.fellowship.operations.*;
import com.bridgelabz.fellowship.productmenu.*;

public class Jsoninventorydatamanagement {

	public static void main(String[] args) {
		try {
			menu();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// inventory show
	public static void menu() {
		Inventorymanager.priceMenu();
		System.out.println("******************Operations***************");

		int key;
		do {
			System.out.println("1: Add Inventory\n" + "2: Remove Inventory\n" + "3: Update Inventory\n"
					+ "4: Search Inventory\n5: Show all Inventory\n" + "6: Exit");
			key = Inputvalidation.isvalidInteger();
			switch (key) {
			case 1:
				Inventorymanager.priceMenu(); // show inventory
				Operations.addInventory(); // add new inventory
				Inventorymanager.priceMenu(); // show updated inventory
				break;
			case 2:
				Inventorymanager.priceMenu(); // show inventory
				Operations.removeInventory(); // remove inventory
				Inventorymanager.priceMenu(); // show updated inventory
				break;
			case 3:
				Inventorymanager.priceMenu(); // show inventory
				Operations.updateInventory(); // update inventory information
				Inventorymanager.priceMenu();// show updated inventory
				break;
			case 4:
				Operations.searchInventory(); // search inventry
				break;
			case 5:
				Inventorymanager.priceMenu(); // show all inventory with price
				break;
			case 6:
				return;
			default:
				break;
			}
		} while (key != 6);
	}

}
