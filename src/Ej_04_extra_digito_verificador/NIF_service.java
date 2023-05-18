package Ej_04_extra_digito_verificador;

import java.util.Scanner;

/*
 Método crearNif(): le pide al usuario el DNI y con ese DNI calcula la letra que le
corresponderá. Una vez calculado, le asigna la letra que le corresponde según el
resultado del calculo.

 Método mostrar(): que nos permita mostrar el NIF (ocho dígitos, un guion y la letra
en mayúscula; por ejemplo: 00395469-F).

La letra correspondiente al dígito verificador se calculará a traves de un método que
funciona de la siguiente manera: Para calcular la letra se toma el resto de dividir el
número de DNI por 23 (el resultado debe ser un número entre 0 y 22). El método debe
buscar en un array (vector) de caracteres la posición que corresponda al resto de la
división para obtener la letra correspondiente. La tabla de caracteres es la siguiente:
*/

public class NIF_service {

	Scanner leer = new Scanner(System.in);

	public NIF crearNif() {
		long dni;
		NIF nif = new NIF();
		System.out.println("Ingrese su DNI");
		dni = leer.nextLong();
		nif.setDni(dni);
		return nif;
	}

	public void mostrar(NIF nif) {
		int posicion = (int) nif.getDni() % 23;
		char letra[] = new char[] { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
				'V', 'H', 'L', 'C', 'K', 'E' };
		nif.setLetra(letra[posicion]);
		String dni = String.valueOf(nif.getDni());
		int ceroFaltantes = 8;
		if (dni.length() < 8) {
			ceroFaltantes -= dni.length();
			for (int i = 0; i < ceroFaltantes; i++) {
				dni = "0".concat(dni);
			}
		}
		System.out.println("Su NIF correspondiente es: " + dni + "-" + nif.getLetra());
	}
}
