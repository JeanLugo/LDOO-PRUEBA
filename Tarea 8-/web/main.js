function validar(){
	var nombre= document.getElementById("nombre").value;
	var ape= document.getElementById("ape").value;
	var ape= document.getElementById("ape2").value;
	var contra= document.getElementById("contra").value;
	

	if (nombre.length>20) {
		alert("Tu nombre es demasiado largo.");
		return false;
	}else if (ape.length>20) {
		alert("Tu apellido es demasiado largo.");
		return false;
	}else if (contra.length<8) {
		alert("Su contraseña es demasiado corta.");
		return false;
	}else alert("Bienvenido.");	
}