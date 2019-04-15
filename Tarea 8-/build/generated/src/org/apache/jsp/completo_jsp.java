package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;

public final class completo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Lista de usuarios</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table border=\"1\" width=\"600\">\n");
      out.write("        \t<tr bgcolor=\"skyblue\">\n");
      out.write("        \t\t<th>ID</th>\n");
      out.write("        \t\t<th>Correo</th>\n");
      out.write("        \t\t<th>Contraseña</th>\n");
      out.write("        \t\t<th>Nombre</th>\n");
      out.write("        \t\t<th>Apellido Paterno</th>\n");
      out.write("        \t\t<th>Apellido Materno</th>\n");
      out.write("        \t</tr>\n");
      out.write("        </table>\n");
      out.write("        ");

        Connection cnx= null;
        Statement sta=null;
        ResultSet rs=null;

        try{
        Class.forName("com.mysql.jdbc.Driver");
        cnx= DriverManager.getConnection("JDBC:mysql//localhost:3306/TareaJDBC", "root", "JeanLugoRoot");
        sta=cnx.createStatement();
        rs=sta.executeQuery("select * from Usuarios");
        while(rs.next()){
		
      out.write("\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<th>");
      out.print(rs.getString(1));
      out.write("</th>\n");
      out.write("                        <th>");
      out.print(rs.getString(2));
      out.write("</th>\n");
      out.write("                        <th>");
      out.print(rs.getString(3));
      out.write("</th>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t");

    	}
    	sta.close();
    	rs.close();
    	cnx.close();
    	}catch(Exception e){

    	}
        
      out.write("\n");
      out.write("    \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
