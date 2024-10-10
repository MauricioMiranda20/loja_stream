package util;

import java.util.Comparator;

import entities.Product;

public class PriceMedia implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return o2.getName().toUpperCase().compareTo(o1.getName().toUpperCase());
	}

}
