package org.apache.jsp.Jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class magazine_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         <link rel=\"stylesheet\" href=\"../Css/Style8.css\">\n");
      out.write("         <script src=\"http://code.jquery.com/jquery-1.11.3.min.js\"></script>\n");
      out.write("\n");
      out.write("       \n");
      out.write("        <title>Revista</title>\n");
      out.write("        \n");
      out.write("    <script>\n");
      out.write("    function My_onLoad(){\n");
      out.write("       \n");
      out.write("        var alto= $(\".sidebar\").height();\n");
      out.write("             console.log(alto);\n");
      out.write("           \n");
      out.write("             if(alto>637){\n");
      out.write("                $(\".contenido\").height(alto);\n");
      out.write("             }else{\n");
      out.write("                $(\".contenido\").height(637);\n");
      out.write("                console.log(\"sa\");\n");
      out.write("                $(\".sidebar\").height(637);\n");
      out.write("                 \n");
      out.write("             }\n");
      out.write("\n");
      out.write("             \n");
      out.write("    }\n");
      out.write("    </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body onload=\"My_onLoad()\">\n");
      out.write("        <div class=\"sidebar\">\n");
      out.write("            <h2>MENU</h2>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"\">Inicio</a></li>\n");
      out.write("                <li><a href=\"\">Servicios</a></li>\n");
      out.write("                <li><a href=\"\">Productos</a></li>\n");
      out.write("                <li><a href=\"\">Contacto</a></li>\n");
      out.write("\n");
      out.write("              \n");
      out.write("                <li><a href=\"\">Inicio</a></li>\n");
      out.write("                <li><a href=\"\">Servicios</a></li>\n");
      out.write("                <li><a href=\"\">Productos</a></li>\n");
      out.write("                <li><a href=\"\">Contacto</a></li>\n");
      out.write("\n");
      out.write("\n");
      out.write("              \n");
      out.write("\n");
      out.write("                \n");
      out.write("\n");
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"contenido\">\n");
      out.write("            <img src=\"../Imagenes/img-perfil.jpg\" alt=\"\" class=\"menu-bar\"> \n");
      out.write("            <div id=\"slider\">\n");
      out.write("                <a href=\"#\" class=\"control_next\">></a>\n");
      out.write("                <a href=\"#\" class=\"control_prev\"> < </a>\n");
      out.write("                <ul>\n");
      out.write("                  <li>\n");
      out.write("                      <img src=\"../Imagenes/img-perfil.jpg\" style=\"height: 90%; width:90%;\"  alt=\"\">\n");
      out.write("                  </li>\n");
      out.write("\n");
      out.write("                  <li>\n");
      out.write("                    <img src=\"../Imagenes/revista2.jpg\" style=\"height: 90%; width:90%;\"  alt=\"\">\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                  <li style=\"background: #aaa;\" ></li>\n");
      out.write("                  <li style=\"background: #aaa;\">SLIDE 4</li>\n");
      out.write("                </ul>  \n");
      out.write("              </div>\n");
      out.write("              \n");
      out.write("              <div class=\"slider_option\">\n");
      out.write("                <input type=\"checkbox\" id=\"checkbox\">\n");
      out.write("                <label for=\"checkbox\">Autoplay Slider</label>\n");
      out.write("              </div> \n");
      out.write("              \n");
      out.write("        </div>\n");
      out.write("   \n");
      out.write("    \n");
      out.write("       \n");
      out.write("              <script src=\"../Js/abrir.js\"></script>\n");
      out.write("        </body>\n");
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
