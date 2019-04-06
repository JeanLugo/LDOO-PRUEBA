<%-- 
    Document   : TAREA·-LDOO
    Created on : 2/03/2019, 10:41:22 AM
    Author     : JeanLugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LDOO TAREA 3</title>
        <link rel="stylesheet" type="text/css" href="main2.css">
    </head>
    <body>
        
    	<h3>- -Registro de Usurario Completo- -</h3>
    	Nombre: <%= request.getParameter("nombre") %>
        <br>
        Apellido: <%= request.getParameter("ape") %>
        <br>
        Edad: <%= request.getParameter("edad") %>
        <br>
        Correo: <%= request.getParameter("correo") %>
        <br>
        Codigo Postal: <%= request.getParameter("CoPo") %>
        <br>


    </body>
</html>
