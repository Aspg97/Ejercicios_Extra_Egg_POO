package Ej_03_extra_raices;

import java.util.Scanner;

/*
 Método getDiscriminante(): devuelve el valor del discriminante (double). El
discriminante tiene la siguiente formula: (b^2)-4*a*c
 Método tieneRaices(): devuelve un booleano indicando si tiene dos soluciones, para
que esto ocurra, el discriminante debe ser mayor o igual que 0.
 Método tieneRaiz(): devuelve un booleano indicando si tiene una única solución, para
que esto ocurra, el discriminante debe ser igual que 0.
 Método obtenerRaices(): llama a tieneRaíces() y si devolvió́ true, imprime las 2
posibles soluciones.
 Método obtenerRaiz(): llama a tieneRaiz() y si devolvió́ true imprime una única raíz.
Es en el caso en que se tenga una única solución posible.

 Método calcular(): esté método llamará tieneRaices() y a tieneRaíz(), y mostrará por
pantalla las posibles soluciones que tiene nuestra ecuación con los métodos
obtenerRaices() o obtenerRaiz(), según lo que devuelvan nuestros métodos y en caso
de no existir solución, se mostrará un mensaje.
*/

public class Raices_service {
	Scanner leer = new Scanner(System.in);

	public Raices crearRaiz() {
		int a, b, c;
		System.out.println(
				"A continuacion se ingresara una raiz cuadratica de la siguiente forma 'ax^2+bx+c'\nIngrese el valor de 'a'");
		a = leer.nextInt();
		System.out.println("Ingrese el valor de 'b'");
		b = leer.nextInt();
		System.out.println("ingrese el valor de 'c'");
		c = leer.nextInt();
		Raices raices = new Raices(a, b, c);
		return raices;
	}
	/*
	 *  Método getDiscriminante(): devuelve el valor del discriminante (double). El
	 * discriminante tiene la siguiente formula: (b^2)-4*a*c
	 */
	public double getDiscriminante(Raices raiz) {
		double discriminante;
		discriminante = (Math.pow(raiz.getB(), 2) - (4 * raiz.getA() * raiz.getC()));
		return discriminante;
	}
	/*
	 *  Método tieneRaiz(): devuelve un booleano indicando si tiene una única
	 * solución, para que esto ocurra, el discriminante debe ser igual que 0.
	 */
	public boolean tieneRaiz(double discriminante) {
		boolean unicaSolucion = false;
		if (discriminante == 0.0) {
			unicaSolucion = true;
		}
		return unicaSolucion;
	}
	/*
	 *  Método tieneRaices(): devuelve un booleano indicando si tiene dos
	 * soluciones, para que esto ocurra, el discriminante debe ser mayor o igual que 0
	 */
	public boolean tieneRaices(double discriminante) {
		boolean unicaSolucion = false;
		if (discriminante > 0.0) {
			unicaSolucion = true;
		}
		return unicaSolucion;
	}
	/*
	 *  Método obtenerRaices(): llama a tieneRaíces() y si devolvió́ true, imprime
	 * las 2 posibles soluciones.
	 */
	public void obtenerRaices(Raices raiz) {
		double discriminante = getDiscriminante(raiz);
		boolean tieneR = tieneRaiz(discriminante);
		boolean tieneCs = tieneRaices(discriminante);
		double x1 = 0, x2 = 0;
		if (tieneR == false && tieneCs == true) {
			x1 = (-raiz.getB() + Math.sqrt(discriminante)) / (2 * raiz.getA());
			x2 = (-raiz.getB() - Math.sqrt(discriminante)) / (2 * raiz.getA());
		}
		System.out.println("La raices son:\n x1 = " + x1 + "\n x2 = " + x2);
	}

	/*
	 *  Método obtenerRaiz(): llama a tieneRaiz() y si devolvió́ true imprime una
	 * única raíz. Es en el caso en que se tenga una única solución posible.
	 */
	public void obtenerRaiz(Raices raiz) {
		double discriminante = getDiscriminante(raiz);
		boolean tieneR = tieneRaiz(discriminante);
		boolean tieneCs = tieneRaices(discriminante);
		if (tieneR == true && tieneCs== false) {
			System.out.println("La raiz solucion es: x = "+(-raiz.getB() / (2 * raiz.getA())));
		}
	}
	/*
	 *  Método calcular(): esté método llamará tieneRaices() y a tieneRaíz(), y
	 * mostrará por pantalla las posibles soluciones que tiene nuestra ecuación con
	 * los métodos obtenerRaices() o obtenerRaiz(), según lo que devuelvan nuestros
	 * métodos y en caso de no existir solución, se mostrará un mensaje.
	 */
	public void calcular(Raices raiz) {
		double discriminante = getDiscriminante(raiz);
		//System.out.println("hola "+discriminante);
		boolean tieneR = tieneRaiz(discriminante);
		boolean tieneCs = tieneRaices(discriminante);
		//System.out.println(tieneR + "," +tieneCs);
		if(tieneR==true && tieneCs==false) {
			obtenerRaiz(raiz);
		}else if(tieneR == false && tieneCs == true) {
			obtenerRaices(raiz);
		}else {
			System.out.println("No paso nada");
		}
	}
}
