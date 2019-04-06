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

            if(nombre.equals("") || apellidoP.equals("") || correo.equals("") || apellidoM.equals("") || correo.equals("")){
               request.getRequestDispatcher("incompleto.jsp").forward(request, response);
            }else {

            Registro r=new Registro();
                
            r.setNombre1(nombre);
            r.setApellidoP(apellidoP);
            r.setApellidoM(apellidoM);
            r.setCorreoE(correo);
            r.setContrasena(contra);

            HttpSession miSession = request.getSession();
            miSession.setAttribute("usuario", correo);
            miSession.setAttribute("usuarioC", contra);
            miSession.setAttribute("usuarioN", nombre);
            miSession.setAttribute("usuarioApP", apellidoP);
            miSession.setAttribute("usuarioApM", apellidoM);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"main.css\">");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<fieldset><legend>Su Informacion:</legend><h1>Su nombre es: " + r.getNombre1() + " " + r.getApellidoP() + " " + r.getApellidoM()+ "</h1>");
            out.println("<h1>Su correo: " + r.getCorreoE()+ "</h1>");
            out.println("<h1>Su password: " + r.getContrasena() + "</h1>");
            out.println("</fieldset><a href='Loggin.jsp'>Iniciar Sesión</a></body>");
            out.println("</html>");
            }

        }else{
                HttpSession miSession = request.getSession();
                String corre = request.getParameter("mail");
                String pass = request.getParameter("contraS");
                String rcorreo = (String)miSession.getAttribute("usuario");
                String rpass = (String)miSession.getAttribute("usuarioC");
                Validar t = new Validar();
                t.setCorreo(corre);
                t.setRcorreo(rcorreo);
                t.setPass(pass);
                t.setRpass(rpass);
                t.validar();
                    if (t.getCheck()){
                        Cookie micookie = new Cookie("Loggeo","Exitoso");
                        micookie.setMaxAge(60*60*24);
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"main.css\">");
                        out.println("Bienvenido " + miSession.getAttribute("usuarioN")+" "+miSession.getAttribute("usuarioApP")+" "+ miSession.getAttribute("usuarioApM"));
                        out.println("</head>"); 
                        out.println("<br>");
                        out.println("</fieldset><a href='Form.jsp'>Cerrar Sesión</a></body>");
                        out.println("</html>");
                        micookie.setMaxAge(0);
                    } else { 
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("Correo o Contraseña Incorrecto" + " <br> <a href='Loggin.jsp'>Intentalo de nuevo</a>");
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

