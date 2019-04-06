/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
            String apellidoP = request.getParameter("apellido1");
            String apellidoM = request.getParameter("apellido2");
            String correo = request.getParameter("correo");
            String contra = request.getParameter("contra");  
            String cumple = request.getParameter("cumple");

            if(nombre.equals("") || apellidoP.equals("") || correo.equals("") || apellidoM.equals("") || correo.equals("")){
               request.getRequestDispatcher("incompleto.jsp").forward(request, response);
            }else {

            Registro r=new Registro();
                
            r.setNombre1(nombre);
            r.setApellidoP(apellidoP);
            r.setApellidoM(apellidoM);
            r.setCorreoE(correo);
            r.setContrasena(contra);
            r.setCumpleA(cumple);

            HttpSession miSession = request.getSession();
            miSession.setAttribute("usuario", correo);
            miSession.setAttribute("usuarioC", contra);
            miSession.setAttribute("usuarioN", nombre);
            miSession.setAttribute("usuarioApP", apellidoP);
            miSession.setAttribute("usuarioApM", apellidoM);

            request.getSession().setAttribute("registro1", r);
            request.getRequestDispatcher("completo.jsp").forward(request, response);
            }

        }else{
            HttpSession miSession = request.getSession();
            String corre = request.getParameter("mail");
            String pass = request.getParameter("contraS");
            String rcorreo = (String)miSession.getAttribute("usuario");
            String rpass = (String)miSession.getAttribute("usuarioC");
            Comprobar co = new Comprobar();
            co.setCorreo(corre);
            co.setRcorreo(rcorreo);
            co.setPass(pass);
            co.setRpass(rpass);
            co.validar();
            if (co.getCheck()){
                Cookie micookie = new Cookie("Loggeo","Exitoso");
                micookie.setMaxAge(60*60*24);
                
                request.getRequestDispatcher("completo.jsp").forward(request, response);
                
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
                out.println("Correo o contraseña incorrectos" + " <br> <a href='Log.html'>Intentalo de nuevo</a>");
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

