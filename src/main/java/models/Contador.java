package models;

public class Contador {
	
	private static int contador;

	public static int getContador() {
		return ++contador;
	}

}
