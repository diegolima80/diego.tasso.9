package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import teste.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {

	/** The driver. */
	//parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver"; 
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The senha. */
	private String senha = "Senha@123";

	

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	//métodos de conexão
	public Connection conectar() {  // importa a classe 'Connection'
		 Connection con = null; //inicia uma sessão
		
		try {
			Class.forName(driver);
			
		} catch(Exception e){
			System.out.println("#1 - Erro no Driver de conexão");
		}
		
		try {
			con = DriverManager.getConnection( url, user, senha);
			return con;
		} catch (Exception e) {
			System.out.println("#2 - Erro na conexão com banco de dados");
			return null;
		}
	}
		
	
	/**
	 * Adicionar.
	 *
	 * @param jb the jb
	 */
	// adicionar
	public void adicionar(JavaBeans jb){
		String create = "insert into contatos (nome,fone,email) values(?,?,?)";
		try {
		Connection con = conectar(); //abrir a conexao
		PreparedStatement pst = con.prepareStatement(create); // preparar o sql para executar
		pst.setString(1, jb.getNome()); // 1 = primeira (?)
		pst.setString(2, jb.getFone());
		pst.setString(3, jb.getEmail());
		
		pst.executeUpdate(); // execute no sql workbench
		con.close();
		
		}catch (Exception e) {
			
		}
	}
	
	/**
	 * Listar.
	 *
	 * @return the array list
	 */
	// listar
	public ArrayList<JavaBeans> listar(){
		ArrayList<JavaBeans> lista = new ArrayList<>();  // atenção ao "<>"
		Controller c = new Controller();
		String read = "select * from contatos order by nome";
		
		try {
			Connection con = conectar(); // abre a conexão
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			// o mais importante!!!
			while(rs.next()) {  // enquanto houver objeto dentro do resultado - read
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				
				// popular o Arraylist com objetos JavaBeans
				lista.add(new JavaBeans(idcon,nome,fone,email));
				
				// joga pro Controller
				c.listar(idcon, nome, fone, email);
				}
			
			
			con.close();
			return lista;
			
			
			
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	/**
	 * Selecionar contato.
	 *
	 * @param jb the jb
	 */
	//update
	public void selecionarContato(JavaBeans jb) {
		String read2 = "select * from contatos where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, jb.getIdcon());
			ResultSet rs = pst.executeQuery(); //vai no banco
			
			while(rs.next()) {
				jb.setIdcon(rs.getString(1));// seta nos models
				jb.setNome(rs.getString(2));
				jb.setFone(rs.getString(3));
				jb.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Editar.
	 *
	 * @param jb the jb
	 */
	public void editar(JavaBeans jb) {
		String create2 = "update contatos set nome = ?, fone = ?, email = ? where idcon=?";
		
		try {
			System.out.println(jb.getNome());
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create2);
			
			// preencher as ???
			pst.setString(1, jb.getNome());
			pst.setString(2, jb.getFone());
			pst.setString(3, jb.getEmail());
			pst.setString(4, jb.getIdcon());
			pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}	
	}

	/**
	 * Excluir.
	 *
	 * @param jb the jb
	 */
	// excluir
	public void excluir(JavaBeans jb){
		String delete = "delete from contatos where idcon=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			
			// setar o 1 do pst com o id que setei no controller
			pst.setString(1, jb.getIdcon());
			pst.executeUpdate();
			
			listar();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}


