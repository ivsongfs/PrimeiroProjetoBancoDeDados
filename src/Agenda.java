
public class Agenda {

	public static void main(String[] args) {
		
		BancoDeDados bancoDeDados = new BancoDeDados();
		bancoDeDados.conectar();
		if(bancoDeDados.estaConectado()) {
			
			bancoDeDados.apagarContato("'4'");
			bancoDeDados.listarContatos();
		}

	}

}
