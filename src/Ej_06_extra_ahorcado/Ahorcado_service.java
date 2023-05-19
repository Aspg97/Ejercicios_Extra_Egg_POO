package Ej_06_extra_ahorcado;

import java.util.Scanner;

/*
 Metodo crearJuego(): le pide la palabra al usuario y cantidad de jugadas máxima.
Con la palabra del usuario, pone la longitud de la palabra, como la longitud del
vector. Después ingresa la palabra en el vector, letra por letra, quedando cada letra
de la palabra en un índice del vector. Y también, guarda en cantidad de jugadas
máximas, el valor que ingresó el usuario y encontradas en 0.
 Método longitud(): muestra la longitud de la palabra que se debe encontrar. Nota:
buscar como se usa el vector.length.
 Método buscar(letra): este método recibe una letra dada por el usuario y busca sila
letra ingresada es parte de la palabra o no. También informará si la letra estaba o no.
 Método encontradas(letra): que reciba una letra ingresada por el usuario y muestre
cuantas letras han sido encontradas y cuantas le faltan. Este método además deberá
devolver true si la letra estaba y false si la letra no estaba, ya que, cada vez que se
busque una letra que no esté, se le restará uno a sus oportunidades.
 Método intentos(): para mostrar cuantas oportunidades le queda al jugador.
 Método juego(): el método juego se encargará de llamar todos los métodos
previamente mencionados e informará cuando el usuario descubra toda la palabra o
se quede sin intentos. Este método se llamará en el main.
*/

public class Ahorcado_service {
	Scanner leer = new Scanner(System.in);

	public Ahorcado crearJuego() {
		int maxInt;
		String palabra;
		System.out.println("Ingrese el numero de intentos que tendra el jugador");
		maxInt = leer.nextInt();
		System.out.println("Ingrese la palabra que se va a utilizar para el juego");
		palabra = leer.next();
		char palabraFor[] = new char[palabra.length()];
		for (int i = 0; i < palabra.length(); i++) {
			palabraFor[i] = palabra.charAt(i);
		}
		Ahorcado ahorcado = new Ahorcado(palabraFor, maxInt);
		return ahorcado;
	}

	/*
	 *  Método longitud(): muestra la longitud de la palabra que se debe encontrar.
	 * Nota: buscar como se usa el vector.length.
	 */
	public void longitud(Ahorcado ahorcado) {
		System.out.println("La longitud de la palabra es " + ahorcado.getPalabra().length);
	}

	/*
	 *  Método buscar(letra): este método recibe una letra dada por el usuario y
	 * busca sila letra ingresada es parte de la palabra o no. También informará si
	 * la letra estaba o no.
	 */
	public void buscar(Ahorcado ahorcado, char letra) {
		boolean esta = false;
		for (int i = 0; i < ahorcado.getPalabra().length; i++) {
			if (letra == ahorcado.getPalabra()[i]) {
				esta = true;
			}
		}
		if (esta == true)
			System.out.println("La letra forma parte de la palabra");
		else
			System.out.println("La letra no forma parte de la palabra");
	}

	/*
	 *  Método encontradas(letra): que reciba una letra ingresada por el usuario y
	 * muestre cuantas letras han sido encontradas y cuantas le faltan. Este método
	 * además deberá devolver true si la letra estaba y false si la letra no estaba,
	 * ya que, cada vez que se busque una letra que no esté, se le restará uno a sus
	 * oportunidades.
	 */
	public boolean encontradas(Ahorcado ahorcado, char letra) {
		boolean esta = false;
		for (int i = 0; i < ahorcado.getPalabra().length; i++) {
			if (letra == ahorcado.getPalabra()[i]) {
				esta = true;
				ahorcado.setLetrasEncontradas(ahorcado.getLetrasEncontradas() + 1);
			}
		}
		System.out.println("Estado: Letras encontradas " + ahorcado.getLetrasEncontradas() + " -----> Letras faltantes "
				+ (ahorcado.getPalabra().length - ahorcado.getLetrasEncontradas()));
		return esta;
	}

	/*
	 *  Método intentos(): para mostrar cuantas oportunidades le queda al jugador.
	 */
	public void intentos(Ahorcado ahorcado, char letra) {
		if (encontradas(ahorcado, letra) == false) {
			ahorcado.setJugadasMaxima(ahorcado.getJugadasMaxima() - 1);
		}
		System.out.println("Le queda: " + ahorcado.getJugadasMaxima() + " intentos");
	}

	/*
	 *  Método juego(): el método juego se encargará de llamar todos los métodos
	 * previamente mencionados e informará cuando el usuario descubra toda la
	 * palabra o se quede sin intentos. Este método se llamará en el main.
	 */
	public void juego() {
		char letra;
		boolean ejecutarIntento = true;
		System.out.println("<<< Crea las reglas del juego >>>");
		Ahorcado ahorcado = crearJuego();
		char mostrarProgreso[] = new char[ahorcado.getPalabra().length];
		for (int i = 0; i < mostrarProgreso.length; i++) {
			mostrarProgreso[i] = '_';
		}
		System.out.print("<<< Iniciando Juego >>>\nPista: ");
		longitud(ahorcado);
		do {
			System.out.println("Ingrese una letra");
			letra = leer.next().charAt(0);
			buscar(ahorcado, letra);
			for (int i = 0; i < mostrarProgreso.length; i++) {
				if (letra == mostrarProgreso[i]) {
					ejecutarIntento = false;
					break;
				}
			}
			if (ejecutarIntento == true) {
				intentos(ahorcado, letra);
			} else {
				System.out.println("\n**La letra ya fue encontrada**\n");
				ejecutarIntento = true;
			}
			System.out.println("Su progreso:");
			for (int i = 0; i < mostrarProgreso.length; i++) {
				if (letra == ahorcado.getPalabra()[i] && mostrarProgreso[i] == '_') {
					mostrarProgreso[i] = letra;
				}
			}
			for (int i = 0; i < mostrarProgreso.length; i++) {
				System.out.print(mostrarProgreso[i] + " ");
			}
			System.out.println("\n<-------------------->\n");
		} while (ahorcado.getLetrasEncontradas() != ahorcado.getPalabra().length && ahorcado.getJugadasMaxima() != 0);
		if (ahorcado.getJugadasMaxima() == 0)
			System.out.println("Oportunidades Agotadas PERDISTE!");
		else if (ahorcado.getLetrasEncontradas() == ahorcado.getPalabra().length)
			System.out.println("GANASTE!");
		else
			System.out.println("?");
	}
}
