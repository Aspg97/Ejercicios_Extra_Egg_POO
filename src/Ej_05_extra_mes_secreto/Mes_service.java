package Ej_05_extra_mes_secreto;

/*
Crea una clase en Java donde declares una variable de tipo array de Strings que
contenga los doce meses del año, en minúsculas. A continuación, declara una variable
mesSecreto de tipo String, y hazla igual a un elemento del array (por ejemplo,
mesSecreto = mes[9]. El programa debe pedir al usuario que adivine el mes secreto. Si el
usuario acierta mostrar un mensaje, y si no lo hace, pedir que vuelva a intentar adivinar
el mes secreto. Un ejemplo de ejecución del programa podría ser este:
Adivine el mes secreto. Introduzca el nombre del mes en minúsculas: febrero
No ha acertado. Intente adivinarlo introduciendo otro mes: agosto
¡Ha acertado!
*/

public class Mes_service {
	public Mes asignarMesSecreto() {
		Mes mesSecreto = new Mes();
		String mes[] = new String[] { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto",
				"septiembre", "octubre", "noviembre", "diciembre" };
		mesSecreto.setMesSecretro(mes[(int)(Math.random()*(12+0)+0)]);
		return mesSecreto;
	}
	
	public boolean adivinarMes(Mes mes, String mesUser) {
		boolean adivino = false;
		if(mesUser.equalsIgnoreCase(mes.getMesSecretro())) {
			adivino = true;
		}
		return adivino;
	}
}
