<%-- 
    Document   : completo
    Created on : 13/04/2019, 03:25:54 PM
    Author     : JeanLugo
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de usuarios</title>
    </head>
    <body>
        <table border="1" width="600">
        	<tr bgcolor="skyblue">
        		<th>ID</th>
        		<th>Correo</th>
        		<th>Contraseña</th>
        		<th>Nombre</th>
        		<th>Apellido Paterno</th>
        		<th>Apellido Materno</th>
        	</tr>
        </table>
        <%
        Connection cnx= null;
        Statement sta=null;
        ResultSet rs=null;

        try{
        Class.forName("com.mysql.jdbc.Driver");
        cnx= DriverManager.getConnection("JDBC:mysql//localhost:3306/TareaJDBC", "root", "JeanLugoRoot");
        sta=cnx.createStatement();
        rs=sta.executeQuery("select * from Usuarios");
        while(rs.next()){
		%>
		<tr>
			<th><%=rs.getString(1)%></th>
                        <th><%=rs.getString(2)%></th>
                        <th><%=rs.getString(3)%></th>
		</tr>
		<%
    	}
    	sta.close();
    	rs.close();
    	cnx.close();
    	}catch(Exception e){

    	}
        %>
    
    </body>
</html>
