package org.apache.jsp.Jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import classes.methods;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Jsp/../Html/formulario-html.html");
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
      out.write("        <link rel=\"stylesheet\" href=\"../Css/Style2.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../Css/Style3.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../Css/Style4.css\">\n");
      out.write("        \n");
      out.write("        <title>Magazines online</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header >\n");
      out.write("            <div class=\"contenedoruno\">\n");
      out.write("             \n");
      out.write("                <nav>\n");
      out.write("                   <a class=\"crearcuenta\" href=\"./registrar.jsp\">Registrar</a>\n");
      out.write("                    \n");
      out.write("                </nav>\n");
      out.write("                </div> \n");
      out.write("        </header>   \n");
      out.write("      \n");
      out.write("\n");
      out.write("         <div class=\"contenedor\">\n");
      out.write("            <section id=\"cdos\">\n");
      out.write("                <article id=\"registro\">\n");
      out.write("                    \n");
      out.write("                    ");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"../Css/Style1.css\">\n");
      out.write("  <title>Document</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("  <form action=\"\">\n");
      out.write("  <h2>Iniciar sesion</h2>\n");
      out.write("  <input type =\"text\" id=\"usuario\" name=\"usuario\" placeholder=\"&#128272; usuario\" /> \n");
      out.write("\n");
      out.write("  <input type =\"password\" id=\"contraseÃ±a\" name=\"contraseÃ±a\" placeholder=\"&#128272; contraseÃ±a \"/>\n");
      out.write(" \n");
      out.write("  \n");
      out.write(" <input type=\"submit\" value=\"ingresar\">\n");
      out.write("\n");
      out.write(" \n");
      out.write("</form>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("                </article>\n");
      out.write("                \n");
      out.write("                <article id=\"quote\">\n");
      out.write("                    <h1 >\n");
      out.write("                        “Nadie lee anuncios. La gente lee lo que le <br>interesa, y a veces eso es un anuncio.”<br>\n");
      out.write("                        – Howard Gossage\n");
      out.write("                    </h1>\n");
      out.write("\n");
      out.write("                  \n");
      out.write("                    </article>\n");
      out.write("\n");
      out.write("                   \n");
      out.write("            </section>\n");
      out.write("           \n");
      out.write("\n");
      out.write("        </div>    \n");
      out.write("        <div class=\"revistas\"  >\n");
      out.write("            <table id=\"tabla\">\n");
      out.write("                <tr>\n");
      out.write("                    <th><img src=\"../Imagenes/Magazines.jpg\" alt=\"\" > </th>\n");
      out.write("                    <th><img src=\"../Imagenes/revista1.jpg\" alt=\"\"></th>\n");
      out.write("                    <th><img src=\"../Imagenes/revista2.jpg\" alt=\"\"></th>\n");
      out.write("                </tr>\n");
      out.write("                    \n");
      out.write("                    <tr> \n");
      out.write("                    <th><img src=\"../Imagenes/revista3.jpg\" alt=\"\"></th>\n");
      out.write("                    <th><img src=\"../Imagenes/revista4.jpg\" alt=\"\"></th>\n");
      out.write("                    <th><img src=\"../Imagenes/revista5.jpg\" alt=\"\"></th>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                    <tr> \n");
      out.write("                    <th><img src=\"../Imagenes/revista6.jpg\" alt=\"\"></th>\n");
      out.write("                    <th><img src=\"../Imagenes/revista7.jpg\" alt=\"\"></th>\n");
      out.write("                    <th><img src=\"../Imagenes/revista8.jpg\" alt=\"\"></th>\n");
      out.write("                    </tr>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("     \n");
      out.write(" \n");
      out.write("     \n");
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
