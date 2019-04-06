function validar(){
	var nombre= document.getElementById("nombre").value;
	var ape= document.getElementById("ape").value;
	var edad= document.getElementById("edad").value;
	var contra= document.getElementById("contra").value;
	var CoPo= document.getElementById("CoPo").value;
	

	if (nombre.length>15) {
		alert("Tu nombre es demasiado largo.");
		return false;
	}else if (ape.length>15) {
		alert("Tu apellido es demasiado largo.");
		return false;
	}else if (isNaN(CoPo) || CoPo.length>5 ||	CoPo.length<5) {
		alert("El codigo postal que introdujo no es valido.");
		return false;
	}else if (contra.length<8) {
		alert("Su contraseña es demasiado corta.");
		return false;
	}else if (isNaN(edad)) {
		alert("Solo numeros.");
		return false
	}else alert("Bienvenido.");

		
}