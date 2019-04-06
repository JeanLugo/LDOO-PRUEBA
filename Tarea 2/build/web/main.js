
function validar(){
	var nombre, apellido, correo, CoPo, contra, edad;
	nombre.getElementById("nombre").value;
	apellido.getElementById("apellido").value;
	correo.getElementById("correo").value;
	CoPo.getElementById("CoPo").value;
	contra.getElementById("contra").value;
	edad.getElementById("edad").value;

	if (edad=="") {
		alert("Introduce tu edad");
		return false;
	}
	if (nombre=="") {
		alert("Introduce tu nombre");
	}
}