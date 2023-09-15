/**
 * 
 */

function confirmar(id) {
	let resposta = confirm("Confirma a exclusão do contato?");
	send = false;

	if (resposta === true) {
		send = true;
		window.location.href = "excluir.jsp?delete_idcon=" + id;
		
	}
	
	if (send === true){
		toAgenda();
	}

}

function toAgenda() {

	window.location.href = "agenda.jsp";
}
