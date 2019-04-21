/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author JeanLugo
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        String vav = request.getParameter("controlar");
        
        if ("1".equals(vav)){
            
            String nombre = request.getParameter("nombre");
            String correo = request.getParameter("correo");
            String contra = request.getParameter("contra");  
            String cumple = request.getParameter("cumple");
            String numem = request.getParameter("numemp");
            int numemp = Integer.parseInt(numem);

            if(nombre.equals("") || correo.equals("") || correo.equals("")){
               request.getRequestDispatcher("Incompleto.html").forward(request, response);
            }else {

            Registro r=new Registro();
                
            r.setUsername(nombre);
            r.setCorreoE(correo);
            r.setContrasena(contra);
            r.setCumpleA(cumple);
           
            
            String insertar;
            insertar = "INSERT INTO ROOT.\"USUARIOS\" (USERNAME, CORREO, PASSWORD, FECHAN, TIPOUSER)";
            
           
            try {   
                Connection cnx;
                Statement sta;
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                cnx=DriverManager.getConnection("jdbc:derby://localhost:1527/Tarea9", "root", "root");
                sta=cnx.createStatement();

                sta.executeUpdate(insertar + "VALUES ('"+ nombre +"', '"+ correo +"', '"+ contra +"' , '"+ cumple +"', 'admin')");
               
                sta.close();
                cnx.close();
            }catch (ClassNotFoundException | SQLException e) {
                    request.getRequestDispatcher("Oops.html").forward(request, response);
            }
            String insertar2 = "INSERT INTO ROOT.\"ADMINISTRADORES\" (NOMBRE, NUMEROEMP)";
            try {
                Connection cnx;
                Statement sta;
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                cnx=DriverManager.getConnection("jdbc:derby://localhost:1527/Tarea9", "root", "root");
                sta=cnx.createStatement();

                sta.executeUpdate(insertar2 + "VALUES ('"+ nombre +"', "+ numemp +")");
               
                sta.close();
                cnx.close();
            }catch (ClassNotFoundException | SQLException e) {
                    request.getRequestDispatcher("Oops2.html").forward(request, response);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Registro completo... </title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"main.css\">");
            out.println("</head>"); 
            out.println("<body>");
            out.println("<fieldset id=\"texto\">");
            out.println("<legend>Sus datos son: </legend>");
            out.println("Nombre: " +nombre);
            out.println("<br>");
            out.println("<br>");
            out.println("Correo: " +correo);
            out.println("<br>");
            out.println("Fecha de nacimiento: " +cumple);
            out.println("<br>");
            out.println("<br>");
            out.println("<a href='LoginAdmin.html'>Inicie sesión</a>");
            out.println("</fieldset>");
            out.println("</body>"); 
            out.println("</html>"); 
            }
        }else if("6".equals(vav) ){
            
            String corre = request.getParameter("correo");
            String pass = request.getParameter("contra");
            
            Comprobar co = new Comprobar();
            Usuario usr = new Usuario();
            
            co.setCorreo(corre);
            co.setPass(pass);
            
            
            try{
                Connection cnx;
                Statement sta;
                ResultSet rs;
                
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                cnx=DriverManager.getConnection("jdbc:derby://localhost:1527/Tarea9", "root", "root");
                sta=cnx.createStatement();
                rs= sta.executeQuery("SELECT * FROM ROOT.USUARIOS");

                while(rs.next()){
                    String cocorreo = rs.getString("correo");
                    String cocontras = rs.getString("password");

                    if (cocorreo.equals(corre) & cocontras.equals(pass)) {
                        co.setRcorreo(cocorreo);
                        co.setRpass(cocontras);
                        usr.setID(rs.getInt("ID"));
                        usr.setNomb(rs.getString("USERNAME"));
                    }
                }    

            }catch (ClassNotFoundException | SQLException e){
                request.getRequestDispatcher("Oops.html").forward(request, response);
            }
            co.validar();
            if (co.getCheck()){
                Cookie micookie = new Cookie("Loggeo","Exitoso");
                micookie.setMaxAge(60*60*24);
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title> Bienvenido... </title>");
                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"main.css\">");
                out.println("</head>"); 
                out.println("<body>");
                out.println("<fieldset id=\"texto\">");
                out.println("<legend>Ha iniciado sesión exitosamente: </legend>");
                out.println("Bienvenido"); 
                out.println("<table border='0'>");
                out.println("<tr>");
                out.println("<td>Su nombre es: </td>");
                out.println("<td>" +usr.getNomb()+ "</td>");
                out.println("</tr>");
                out.println("<td>Su ID es: " +usr.getID()+ "</td>");
                out.println("</table>");
                out.println("<br>Cookie: " );
                out.println(micookie.getName() + " " + micookie.getValue());
                out.println("<br><a href='RegistroAdmin.html'>Inicio</a>");
                out.println("</fieldset>");
                out.println("</body>"); 
                out.println("</html>"); 
                
            } else { 
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title> Oh oh... </title>");
                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"main.css\">");
                out.println("</head>"); 
                out.println("<body>");
                out.println("<fieldset>");
                out.println("<legend>Ha ocurrido un error: </legend>");
                out.println("<br> <a href='RegistroAdmin.html'>Inicio</a>");
                out.println("</fieldset>");
                out.println("</body>"); 
                out.println("</html>"); 
            }
        }
    }


    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}

