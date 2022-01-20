package defaultproyecto;

public interface DefaultInterface {
	
	
	default void imprimir(String string) {
		System.out.println("Hello" + string);

	}
}