<%-- 
    Document   : Loggin
    Created on : 23/03/2019, 11:15:29 AM
    Author     : JeanLugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INICIO DE SESIÓN</title>
        <link rel="stylesheet" type="text/css" href="main.css">
    </head>
    <body>
        <div>
            
            <form action="Controlador" id="formu" method="post" > 
            <fieldset>
                <legend>Inicie sesión con su cuenta previamente creada</legend>
                Correo:<br>
                <input type="text" name="mail" size="65">
                <br>
                Contraseña:<br>
                <input type="password" name="contraS" size="65">
                <br>
                <input type="submit" value="Entrar" > 
            </fieldset>
        </form>

        </div>
        
    </body>
</html>
