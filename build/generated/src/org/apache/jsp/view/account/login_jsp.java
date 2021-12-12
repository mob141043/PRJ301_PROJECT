package org.apache.jsp.view.account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, shrink-to-fit=no\">\r\n");
      out.write("    <title>Login - Student Attendance</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../resources/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../resources/fonts/fontawesome-all.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../resources/fonts/font-awesome.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../resources/fonts/fontawesome5-overrides.min.css\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"bg-gradient-light\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row justify-content-center\">\r\n");
      out.write("            <div class=\"col-md-9 col-lg-12 col-xl-10\">\r\n");
      out.write("                <div class=\"card shadow-lg o-hidden border-0 my-5\">\r\n");
      out.write("                    <div class=\"card-body p-0\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-lg-6 d-none d-lg-flex\">\r\n");
      out.write("                                <div class=\"flex-grow-1 bg-login-image\" style=\"background-image: url('https://takepsd.com/wp-content/uploads/2019/11/Takepsd-02-4.jpg'); width: 440px; height: 446px\">\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-lg-6\">\r\n");
      out.write("                                <div class=\"p-5\">\r\n");
      out.write("                                    <div class=\"text-center\">\r\n");
      out.write("                                        <h4 class=\"text-dark mb-4\">Login</h4>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<!-- FORM LOGIN -->\r\n");
      out.write("                                    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/account/login\"\r\n");
      out.write("\t\t\t\t\t\t\tmethod=\"POST\" class=\"user\">\r\n");
      out.write("                                        <p style=\"color: red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("                                        <div class=\"form-group\"><input class=\"form-control form-control-user\" type=\"text\" id=\"exampleInputEmail\" aria-describedby=\"emailHelp\" placeholder=\"Enter Username\" name=\"username\" required></div>\r\n");
      out.write("                                        <div class=\"form-group\"><input class=\"form-control form-control-user\" type=\"password\" id=\"exampleInputPassword\" placeholder=\"Password\" name=\"password\" required></div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("\r\n");
      out.write("                                        </div><button class=\"btn btn-primary btn-block text-white btn-user\" type=\"submit\">Login</button>\r\n");
      out.write("                                        <hr>\r\n");
      out.write("                                    </form>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
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
