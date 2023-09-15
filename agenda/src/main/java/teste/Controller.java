package teste;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;


// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller {
	
	/** The jb. */
	JavaBeans jb = new JavaBeans();
	
	/** The dao. */
	DAO dao = new DAO();
	
	
	/**
	 * Adicionar.
	 *
	 * @param nome the nome
	 * @param fone the fone
	 * @param email the email
	 */
	// adicionar
	public void adicionar(String nome, String fone, String email) {
		
		jb.setNome(nome);
		jb.setFone(fone);
		jb.setEmail(email); 	
				
		dao.adicionar(jb);
	
	
		
	}
	
		/**
		 * Listar.
		 *
		 * @param idcon the idcon
		 * @param nome the nome
		 * @param fone the fone
		 * @param email the email
		 * @return the array list
		 */
		// listar
	public ArrayList<JavaBeans> listar(String idcon, String nome, String fone, String email){
		
		ArrayList<JavaBeans> lista = new ArrayList<>();
		lista.add(new JavaBeans(idcon,nome,fone,email));
		
		return lista;
		
			
			
		/*	Com Servlet-------------------------------------------------
		 		
		request.setAttribute("contatos", lista);						   // cria um atributo do objeto para a View
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp"); // endereça o objeto
		rd.forward(request, response); // envia
		 									   
		 */				
		
		}
	
	/**
	 * Listar contato.
	 *
	 * @param id the id
	 */
	// editar
	public void listarContato(String id) {
			String idcon = id;
			jb.setIdcon(idcon); // grava no JavaBeans temporariamente
			
			dao.selecionarContato(jb);
			
			String nome = jb.getNome();
			
	}
		
	/**
	 * Editar.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param fone the fone
	 * @param email the email
	 */
	public void editar(String id, String nome, String fone, String email) {
		jb.setIdcon(id);
		jb.setNome(nome);
		jb.setFone(fone);
		jb.setEmail(email);
		
		dao.editar(jb);
		
		
	}	
	
	/**
	 * Excluir.
	 *
	 * @param id the id
	 */
	// excluir
	public void excluir(String id) {
		//Controller >> JavaBeans
		jb.setIdcon(id);
		
		// Controller >> DAO
		dao.excluir(jb);
	}
	
	
}
	
	
	

