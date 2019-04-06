function validar(){
	var nombre= document.getElementById("nombre").value;
	var ape1= document.getElementById("ape1").value;
	var contra= document.getElementById("contra").value;
	

	if (nombre.length>15) {
		alert("Tu nombre es demasiado largo.");
		return false;
	}else if (ape.length>15) {
		alert("Tu apellido es demasiado largo.");
		return false;
	}else if (contra.length<8) {
		alert("Su contraseña es demasiado corta.");
		return false;
	}else alert("Bienvenido.");

		
}