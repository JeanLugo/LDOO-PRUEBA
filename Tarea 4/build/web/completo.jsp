<%-- 
    Document   : completo
    Created on : 16/03/2019, 07:01:31 PM
    Author     : JeanLugo
--%>

<%@page import="Controlador.Registro"%>
<%
   Registro r = (Registro) request.getSession().getAttribute("registro1");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> OK </title>
        <link rel="stylesheet" type="text/css" href="main.css">
    </head>
    <body>
        <h1>- - -Datos de Usuario- - -</h1>
        Nombre:<%=r.getNombre1() +" "+ r.getApellidoP()+" "+ r.getApellidoM()%>
        <br>
        Correo:<%=r.getCorreoE()%>
        <br>

    </body>
</html>
