import java.util.List;

public class Comparacion {
	public static void main(String[] args) {
		int count = 0;
		List<Integer> numbers = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);

		//imperative
		
		for (int i : numbers) {
			if(i > 10) count++;
		}
		
		//functional		
		Long count2 = numbers.stream().filter(num -> num > 10).count();
		
		//functional usando peek. No opera, para eso se usa filter
		Long count3 = numbers.stream()
				.peek((Integer i) -> System.out.println("Elemento: " + i))
				.filter(num -> num > 10)
				.peek((Integer i) -> System.out.println("Elemento que cumple: " + i))
				.count();

		//functional pero es tan complicado que no merece la pena. Peor que hacer en imperative
//		final AtomicInteger count3 = new AtomicInteger();
//		numbers.stream().forEach((Integer i) -> {
//		if(i > 10) {
//		count3.getAndIncrement();
//		}
//		});
		
		//resultado
		System.out.println(count);
		System.out.println(count2);
		System.out.println(count3);
	}
}
