package Ej_04_extra_digito_verificador;

public class Main_nif {

	public static void main(String[] args) {
		NIF_service tool = new NIF_service();
		NIF n1 = tool.crearNif();
		tool.mostrar(n1);
	}

}
