import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

enum Tax {
	SUPERREDUCED(4), REDUCED(10), NORMAL(21);
	public int percent;
	private Tax(int percent) {
		this.percent = percent;
}

 public int getPercent() {
	 return percent;
	}
}

class Product {
	public String name;
	public BigDecimal price;
	public Tax tax;
	
	Product(String name, BigDecimal price, Tax tax) {
		this.name = name;
		this.price = price;
		this.tax = tax;
	}
}
public class ProductMain {
	public static void main(String[] args) {
		
		


		List<Product> shoppingCart = List.of(
		new Product("Clothes", new BigDecimal("15.90"), Tax.NORMAL),
		new Product("Bread", new BigDecimal("1.5"), Tax.SUPERREDUCED),
		new Product("Meat", new BigDecimal("13.99"), Tax.REDUCED),
		new Product("Cheese", new BigDecimal("3.59"), Tax.SUPERREDUCED),
		new Product("Coke", new BigDecimal("1.89"), Tax.REDUCED),
		new Product("Whiskey", new BigDecimal("19.90"), Tax.NORMAL));

		// Implementación
		
		BigDecimal result = shoppingCart.stream()
				.map(product -> product.price.add(product.price.multiply(new BigDecimal(product.tax.percent)
				.divide(new BigDecimal(100))))).reduce(BigDecimal.ZERO, (x, y) -> x.add(y));
		
		System.out.println("Valor " + result.toString());
		
		String result2 = shoppingCart.stream()
				.filter(product -> product.name.startsWith("C"))
				.map(product -> product.name)
				.collect(Collectors.joining(", " , "Resultado ","."));
		
		}

}
