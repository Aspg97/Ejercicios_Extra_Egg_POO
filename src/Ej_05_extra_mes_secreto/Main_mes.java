package Ej_05_extra_mes_secreto;

import java.util.Scanner;

public class Main_mes {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		String mesUser;
		Mes_service tool = new Mes_service();
		Mes m1 = tool.asignarMesSecreto();
		System.out.println("Adivina el mes definido por el sistema");
		mesUser = leer.next();
		if(tool.adivinarMes(m1, mesUser)==false) {
			while(tool.adivinarMes(m1, mesUser)==false) {
				System.out.println("INCORRECTO! Intentalo de nuevo");
				mesUser = leer.next();
				System.out.println("Una pequena ayuda -----> "+m1.getMesSecretro());
			}
			System.out.println("CORRECTO! El mes definido por el sistema fue: "+mesUser);
		}else {
			System.out.println("CORRECTO! El mes definido por el sistema es: "+mesUser);
		}
	}

}
