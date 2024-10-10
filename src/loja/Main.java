package loja;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.Product;
import util.PriceMedia;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		List<Product> list = new ArrayList<>();

		String path = "C:\\Users\\User\\Documents\\preco.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();

			while (line != null) {
				String[] s = line.split(",");

				list.add(new Product(s[0], Double.parseDouble(s[1])));

				line = br.readLine();
			}
			double sum = list.stream()
									 .map(Product::getPrice)
									 .reduce(0.0, (x, y) -> x + y) / list.size();

			System.out.println("Average price: " + String.format("%.2f", sum));

			List<Product> newList = list.stream()
												.filter(x -> x.getPrice() <= sum)
												.sorted(new PriceMedia())
												.collect(Collectors.toList());

			newList.forEach(System.out::print);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
