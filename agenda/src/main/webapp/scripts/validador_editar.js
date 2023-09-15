/**
 * Validação de formulário
 * @author Diego Tasso 
 */

function editar() {
	let idcon = document.getElementById("txtIdcon").value;
	let nome = document.getElementById("txtNome").value;
	let fone = document.getElementById("txtFone").value;
	let email = document.getElementById("txtEmail").value;
	let action = "editar";
	send = false;

	if (nome === null || nome === "") {
		alert('Nome em vazio!');



	} else if (fone === null || fone === "") {
		alert('Telefone em vazio!');


	} else {
		
		window.location.href = "agenda.jsp?tag=" + action + "&idcon2=" + idcon + "&nome2=" + nome + "&fone2=" + fone + "&email2=" + email;

		send = true;
	}

	if (send === true) {
		
		toAgenda();

	}
	


}

	function toAgenda() {

	window.location.href = "agenda.jsp";
}


