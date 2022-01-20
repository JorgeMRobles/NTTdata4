package defaultproyecto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DefaultClass implements DefaultInterface{

	public void imprimir(String string) {
	}
	
	public static void main(String[] args) {
		DefaultClass defaultClass = new DefaultClass();
		defaultClass.imprimir("Jorge");
		
		//lamba con hilo (nada que ver con el default)
		Thread myThread = new Thread(
			    () -> System.out.println("hello world")
			);
		myThread.start();
		
		//lambda con hilo y default
		Thread myThread2 = new Thread(
			    () -> defaultClass.imprimir("Luis")
			);
		myThread2.start();
		
		//list pasada a map (nada que ver con el default)
		List<String> myList = new ArrayList<>();
		
		Map<String, String> myMap = new HashMap<>();
		for (String i : myList) {
			myMap.put("Key" + i, "Value" + i);
		}
		
	}
		

}
