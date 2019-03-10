import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDeDados {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	
	
	
	
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/agenda?useSSL=false&useTimezone=true&serverTimezone=UTC";
		String usuario = "root";
		String senha = "ivson";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try 
		{
			 
			
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor,usuario,senha);
			this.statement = this.connection.createStatement();
			
		}catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
		
	}
	
	public boolean estaConectado() {
		if(this.connection != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void listarContatos() {
		try {
			String query = "SELECT * FROM contato ORDER BY nome";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			
			while(this.resultset.next()) {
				System.out.println("ID: " + this.resultset.getString("id") + " - Nome: " + this.resultset.getString("nome") + " - Telefone: " + this.resultset.getString("telefone"));
			}
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void inserirContatos(String nome, String telefone) {
		try {
			String query = "INSERT INTO contato (nome, telefone) VALUES (" + nome + "," + telefone + ");";
			this.statement.executeUpdate(query);
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	
	public void editarContato(String id, String nome, String telefone) {
		try {
			String query = "UPDATE contato SET nome = '" + nome + "', telefone = '" + telefone + "'WHERE id = " + id + ";";
			this.statement.executeUpdate(query);
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void apagarContato(String id) {
		try {
			String query = "DELETE FROM contato WHERE id = " + id + ";";
			this.statement.executeUpdate(query);
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void desconectar() {
		try {
			this.connection.close();
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
