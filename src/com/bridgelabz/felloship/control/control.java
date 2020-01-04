package com.bridgelabz.felloship.control;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.bridgelabz.felloship.inventory.Product;
import com.bridgelabz.felloship.productmenu.InventoryManager;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class control {
	static ObjectMapper mapper = new ObjectMapper();

	public static List<Product> read() throws IOException {
		String spath = InventoryManager.spath;
		List<Product> list = mapper.readValue(new File(spath), new TypeReference<List<Product>>() {
		});
		return list;
	}

	public static void write(List<Product> array) throws JsonGenerationException, JsonMappingException, IOException {
		String spath = InventoryManager.spath;
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File(spath), array);
	}

}
