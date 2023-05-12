package Ej_02_extra_puntos;

import java.util.Scanner;

/*
Generar un objeto puntos
usando un método crearPuntos() que le pide al usuario los dos números y los ingresa en
los atributos del objeto.
Después, a través de otro método calcular y devolver la distancia
que existe entre los dos puntos que existen en la clase Puntos. Para conocer como
calcular la distancia entre dos puntos consulte el siguiente link:
http://www.matematicatuya.com/GRAFICAecuaciones/S1a.html
*/

public class Puntos_Service {
	Scanner leer = new Scanner(System.in);

	public Puntos crearPuntos() {
		double x1, x2, y1, y2;
		System.out.println("Ingrese las coordenadas del punto 1: X1 , Y1");
		x1 = leer.nextDouble();
		y1 = leer.nextDouble();
		System.out.println("Ingrese las coordenadas del punto 2: X2 , Y2");
		x2 = leer.nextDouble();
		y2 = leer.nextDouble();
		Puntos puntos = new Puntos(x1, y1, x2, y2);
		return puntos;
	}
	
	public void calcular(Puntos puntos) {
		double res = Math.sqrt(Math.pow((puntos.getX2()-puntos.getX1()), 2)+Math.pow((puntos.getY2()-puntos.getY1()), 2));
		System.out.println("La distancia entre los puntos es: "+res);
	}
}
