/**
 * Validação de formulário
 * @author Diego Tasso 
 */

 function validador(){
	let nome = frmContato.nome.value;
	let fone = frmContato.fone.value;
	
	if(nome === ""){
		alert('Nome em vazio!');
		frmContato.nome.focus();
		return false;
		
	}else if(fone === ""){
		alert('Telefone em vazio!');
			frmContato.fone.focus();
		return false;
	}else {
		document.forms["frmContato"].submit();
		
	}	
	
	
 }
 
  function pegarDados(){
	 nome = document.getElementByName("nome2").value;
	 alert(nome);
 }
 
