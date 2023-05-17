package Ej_02_extra_puntos;

public class Main_puntos {

	public static void main(String[] args) {
		
		Puntos_Service tool = new Puntos_Service();
		Puntos puntos = tool.crearPuntos();
		Puntos p1 = tool.crearPuntos();
		tool.calcular(puntos);
		tool.calcular(p1);
	}
}
