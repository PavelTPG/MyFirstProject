package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SessionLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <title>???????? ????????? ????? ? ???????</title>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("    <br>\n");
      out.write("\n");
      out.write("    <h1>???? ?????????? ? ??????? ?????? ???????</h1>\n");
      out.write("\n");
      out.write("   ");
      CommandPost.entity.User user = null;
      synchronized (application) {
        user = (CommandPost.entity.User) _jspx_page_context.getAttribute("user", PageContext.APPLICATION_SCOPE);
        if (user == null){
          try {
            user = (CommandPost.entity.User) java.beans.Beans.instantiate(this.getClass().getClassLoader(), "CommandPost.entity.User");
          } catch (ClassNotFoundException exc) {
            throw new InstantiationException(exc.getMessage());
          } catch (Exception exc) {
            throw new ServletException("Cannot create bean of class " + "CommandPost.entity.User", exc);
          }
          _jspx_page_context.setAttribute("user", user, PageContext.APPLICATION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("   ????????????: ");
      out.print( user.getUser());
      out.write("<br>\n");
      out.write("\n");
      out.write("   Email: ");
      out.print( user.getEmail());
      out.write("<br>\n");
      out.write("\n");
      out.write("   ?????: ");
      out.print( user.getAddress());
      out.write("<br>\n");
      out.write("\n");
      out.write("   ???????: ");
      out.print( user.getPhone());
      out.write("<br>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html> ");
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
