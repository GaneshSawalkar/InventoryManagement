package com.bridgelabz.fellowship.control;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.bridgelabz.fellowship.inventory.Product;
import com.bridgelabz.fellowship.productmenu.Inventorymanager;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Control {
	static ObjectMapper mapper = new ObjectMapper();

	public static List<Product> readInventory() {
		String spath = Inventorymanager.spath;
		List<Product> inventorylist = null;
		try {
			// read inventory
			inventorylist = mapper.readValue(new File(spath), new TypeReference<List<Product>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inventorylist;
	}

	/**
	 * @param updatedinventory received user updated inventory list
	 */
	public static void writeInventory(List<Product> updatedinventory) {
		String spath = Inventorymanager.spath;
		try {
			// update inventory
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(spath), updatedinventory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
