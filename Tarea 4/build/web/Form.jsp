<%-- 
    Document   : Form
    Created on : 16/03/2019, 10:25:30 AM
    Author     : JeanLugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="main.css">
        <title>LDOO-Tarea-4</title>
    </head>
    <body>
        <div id="form1">
            <form id="form1" action="Controlador" method="post" > 
            <fieldset>
                <legend>Proceso de registro</legend>
                <br>
                <label>Nombre:</label>
                <br>
                <input type="text" name="nombre" size="65">
                <br>
                <label>Apellido paterno:</label>
                <br>
                <input type="text" name="apellido1" size="65">
                <br>
                <label>Apellido materno:</label>
                <br>
                <input type="text" name="apellido2" size="65">
                <br>
                <label>Fecha de Nacimiento:</label>
                <br>
                <input type="date" name="cumple" size="65">
                <br>
                <label>Correo:</label>
                <br>
                <input type="email" name="correo" size="65">
                <br>
                <label>Contraseña:</label>
                <br>
                <input type="password" name="contra" size="65" >
                <br>
                <br>
                <input type="submit" value="Registrar" > 
            </fieldset>
        </form>
      </div>
    </body>
</html>
