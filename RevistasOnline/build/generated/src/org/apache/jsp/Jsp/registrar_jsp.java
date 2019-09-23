package org.apache.jsp.Jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import classes.usuario;

public final class registrar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Jsp/../Html/formregistro.html");
  }

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div >\n");
      out.write("                  \n");
      out.write("                    ");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    \n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"../Css/Style5.css\">\n");
      out.write("    <title>Document</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("        <form class=\"formbox\" action=\"/RevistasOnline/CrearUser \" method=\"POST\">\n");
      out.write("                <h1 id=\"titulo\">REGISTRAR</h1>\n");
      out.write("                <input type =\"text\" id=\"nombre\" name=\"nombre\" placeholder=\" nombre completo\" required /> \n");
      out.write("                <input type =\"text\" id=\"user\" name=\"user\" placeholder=\" nombre usuario\" required/> \n");
      out.write("                \n");
      out.write("                <input type =\"number\" id=\"edad\" name=\"edad\" placeholder=\" edad\" required/> \n");
      out.write("                <input type =\"text\" id=\"direccion\" name=\"direccion\" placeholder=\" direccion\" required/> \n");
      out.write("                \n");
      out.write("                <input type =\"date\" id=\"fecha\" name=\"fecha\" required/> \n");
      out.write("                \n");
      out.write("                <input type =\"password\" id=\"contraseÃ±a\" name=\"password\" placeholder=\" contraseÃ±a \"required/>\n");
      out.write("               \n");
      out.write("                \n");
      out.write("                <button type=\"submit\" name=\"btn\" >Registrar</button>\n");
      out.write("              \n");
      out.write("               \n");
      out.write("              </form>   \n");
      out.write("              \n");
      out.write("              /RevistasOnline/CrearUser \n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("                    \n");
      out.write("                   \n");
      out.write("                    \n");
      out.write("        </div>\n");
      out.write("                    ");
 int a;
                    a=2;
                    
                     if(usuario.getMessage()==null){
                     String alert="alert('"+"ss"+"');";
                     out.print("<script>"+alert+"</script>");
                     }   
                    
                    
      out.write("\n");
      out.write("   \n");
      out.write("    \n");
      out.write("             \n");
      out.write("\n");
      out.write("     \n");
      out.write("       \n");
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
