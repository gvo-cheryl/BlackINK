/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2020-10-04 19:50:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.semi.tattoo.notice.dto.NoticeDto;

public final class noticeSelectOne_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1601784424000L));
    _jspx_dependants.put("/./form/header.jsp", Long.valueOf(1601822699000L));
    _jspx_dependants.put("jar:file:/Users/cheryl/workspace/LastSerendipity/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BlackINK/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("/./form/rightNavi.jsp", Long.valueOf(1601835101000L));
    _jspx_dependants.put("/./form/leftNaviStory.jsp", Long.valueOf(1601799354000L));
    _jspx_dependants.put("/./form/footer.jsp", Long.valueOf(1601784424000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.semi.tattoo.notice.dto.NoticeDto");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
 request.setCharacterEncoding("UTF-8"); 
      out.write('\r');
      out.write('\n');
 response.setContentType("text/html; charset=UTF-8"); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body {\r\n");
      out.write("\tbackground: ghostwhite;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#main {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tmargin-left: 300px;\r\n");
      out.write("\tmargin-top: 30px;\r\n");
      out.write("\twidth: 1200px;\r\n");
      out.write("\theight: 400px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#main hr {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tmargin-top: 50px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#article {\r\n");
      out.write("\theight: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".head_title {\r\n");
      out.write("\tmargin-top: 30px;\r\n");
      out.write("\tmargin-bottom: 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".head_title>h1 {\r\n");
      out.write("\tpadding-right: 30px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"./css/select.css\">\r\n");

	String name = (String)(session.getAttribute("me_name"));
	NoticeDto dto = new NoticeDto();
	dto = (NoticeDto)(request.getAttribute("dto"));
	String regdate = dto.getRegdate().substring(5,16);
	String role = (String)(session.getAttribute("me_role"));
	String A = "A";

      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"./css/header.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<header>\n");
      out.write("<div id=\"header\">\n");
      out.write("   <h1><a href=\"main.jsp\">Black INK</a></h1>\n");
      out.write("   \n");
      out.write("   <div id=\"naviList\">\n");
      out.write("      <ul id=\"mainMenu\">\n");
      out.write("         <li><a href=\"tattooshareController.do?command=list\">Sample</a>\n");
      out.write("         \t\t<ul class=\"subMenu\">\n");
      out.write("\t        \t\t<li><a href=\"tattooshareController.do?command=list\" >Search</a></li>\n");
      out.write("\t        \t\t<li><a href=\"canvas.jsp\">Canvas</a></li>\n");
      out.write("\t        \t</ul> \n");
      out.write("         </li>\n");
      out.write("         \n");
      out.write("         \n");
      out.write("         <li><a href=\"location.jsp\">Location</a></li>\n");
      out.write("         \n");
      out.write("         \n");
      out.write("         <li><a href=\"NoticeController.do?command=notice&curPage=1\">Story</a>\n");
      out.write("\t         \t<ul class=\"subMenu\">\n");
      out.write("\t         \t\t<li><a href=\"NoticeController.do?command=notice&curPage=1\">notice</a></li>\n");
      out.write("\t         \t\t<li><a href=\"ReviewController.do?command=review&curPage=1\">review</a></li>\n");
      out.write("\t         \t</ul>\n");
      out.write("\t     </li>\n");
      out.write("         \n");
      out.write("         <li><a href=\"QnaController.do?command=qna&curPage=1\">Q&A</a></li>\n");
      out.write("         \n");
      out.write("         \n");
      out.write("                 <li>\n");
      out.write("            ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            ");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            ");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t \n");
      out.write("         </li>\n");
      out.write("         \n");
      out.write("         \n");
      out.write("         <li>\n");
      out.write("            ");
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            ");
      if (_jspx_meth_c_005fif_005f4(_jspx_page_context))
        return;
      out.write("\n");
      out.write("         </li>\n");
      out.write("         \n");
      out.write("         \n");
      out.write("      </ul>\n");
      out.write("      \n");
      out.write("   </div>\n");
      out.write("</div>\n");
      out.write("   <hr size=\"10\" width=\"100%\" color=\"black\">\n");
      out.write("</header>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t<article id=\"article\" style=\"height: 800px;\">\r\n");
      out.write("\t\t<section id=\"main\">\r\n");
      out.write("\t\t\t<div id=join class=\"head_title\">\r\n");
      out.write("\t\t\t\t<h1>공지사항</h1>\r\n");
      out.write("\t\t\t\t<hr size=\"2\" color=\"grey\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id=\"mainWrap\">\r\n");
      out.write("\t\t\t\t<div id=\"topWrap\">\r\n");
      out.write("\t\t\t\t\t<p>");
      out.print(dto.getTitle() );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t<p>");
      out.print(dto.getWriter() );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t<p>");
      out.print(regdate );
      out.write("&nbsp;&nbsp;조회&nbsp;");
      out.print(dto.getView() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
 
					if(role.equals(A)){

      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"수정\" \tonclick=\"location.href='NoticeController.do?command=update&no=");
      out.print(dto.getNo() );
      out.write("'\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"삭제\" \tonclick=\"location.href='NoticeController.do?command=delete&no=");
      out.print(dto.getNo() );
      out.write("&writer=");
      out.print(dto.getWriter() );
      out.write("&name=");
      out.print(name );
      out.write("'\">\r\n");

					}

      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<hr>\r\n");
      out.write("\t\t\t\t<div id=\"bottomWrap\">\r\n");
      out.write("\t\t\t\t\t<p>");
      out.print(dto.getContent());
      out.write("</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t</article>\r\n");
      out.write("\t");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("* {\n");
      out.write("   margin: 0;\n");
      out.write("   padding: 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#nav{\n");
      out.write("   position: fixed;\n");
      out.write("   right:50px;\n");
      out.write("   bottom:80px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#appointmentBtn{\n");
      out.write("   width: 50px;\n");
      out.write("   height: 50px;\n");
      out.write("   border-radius: 5px;\n");
      out.write("   background-image: url(img/bookImg.jpeg);\n");
      out.write("   background-size: 100%, 100%;\n");
      out.write("   background-repeat: no-repeat;\n");
      out.write("   border: none;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#chatbot_button {\n");
      out.write("   width: 50px;\n");
      out.write("   height: 50px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#chatbotStartButton {\n");
      out.write("\n");
      out.write("   width: 50px;\n");
      out.write("   height: 50px;\n");
      out.write("   border-radius: 20px 20px 20px 20px;\n");
      out.write("   background-image: url(img/chatbotbutton.png);\n");
      out.write("   background-size: 100%, 100%;\n");
      out.write("   background-repeat: no-repeat;\n");
      out.write("   border: none;\n");
      out.write("      \n");
      out.write("}\n");
      out.write("\n");
      out.write("#space {\n");
      out.write("   height: 10px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("   function chatbotStart(){\n");
      out.write("      \n");
      out.write("      var url = \"chatbot.jsp\";\n");
      out.write("      var title = \"Black INK FAQ chatbot\";\n");
      out.write("      var prop = \"top=50px,left=100px,width=365px,height=470px,resizable=no,fullscreen=no,location=no\";\n");
      out.write("      \n");
      out.write("      window.open(url, title, prop);\n");
      out.write("      \n");
      out.write("   }\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("   \n");
      out.write("   <div id=\"nav\">\n");
      out.write("      <div id=\"chatbot_button\">\n");
      out.write("         <button id=\"chatbotStartButton\" onclick=\"chatbotStart();\" name=\"chatbotStartButton\"></button>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"space\"></div>\n");
      out.write("      <div id=\"appointment\">\n");
      out.write("      \t<button id=\"appointmentBtn\" onclick=\"location.href='appointment.do?command=insertAppointment'\"></button>\n");
      out.write("      </div>\n");
      out.write("   </div>\n");
      out.write("   \n");
      out.write("</body>\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("aside {\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\ttop: 200px;\r\n");
      out.write("\t\tleft: 50px;\r\n");
      out.write("\t\twidth: 250px;\r\n");
      out.write("\t\theight: 300px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("#navi p {\r\n");
      out.write("\tfont-size: 25pt;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#navi ul li{\r\n");
      out.write("\tfont-size: 18pt;\r\n");
      out.write("\tmargin-top: 10px;\r\n");
      out.write("}\r\n");
      out.write("#navi ul li a:hover li{\r\n");
      out.write("\tcolor:red;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<aside> \r\n");
      out.write("\t\t<div id=\"navi\">\r\n");
      out.write("\t\t\t<p>Story</p>\r\n");
      out.write("\t\t\t<br/>\r\n");
      out.write("\t\t\t<ul> \r\n");
      out.write("\t\t\t\t<li><a href=\"NoticeController.do?command=notice&curPage=1\" id=\"info\">공지 사항</a></li> \r\n");
      out.write("\t\t\t\t<li><a href=\"ReviewController.do?command=review&curPage=1\" id=\"searchimage\">타투 후기</a></li>\r\n");
      out.write("\t\t\t</ul> \r\n");
      out.write("\t\t</div>\r\n");
      out.write("</aside>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<footer>\n");
      out.write("\t<address>Serendipity&nbsp;&copy; All Right Reserved</address>\n");
      out.write("</footer>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /./form/header.jsp(40,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty sessionScope.me_no}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("               <a href=\"login.do\">MyPage</a>\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /./form/header.jsp(43,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sessionScope.me_name}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("               <a href=\"mypage.do?command=mypage&me_no=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.me_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.me_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</a>\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f2_reused = false;
    try {
      _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f2.setParent(null);
      // /./form/header.jsp(46,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sessionScope.me_nic}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
      if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t<a href=\"mypage.do?command=mypage&me_no=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.me_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.me_nic}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</a>\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      _jspx_th_c_005fif_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f3_reused = false;
    try {
      _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f3.setParent(null);
      // /./form/header.jsp(54,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty sessionScope.me_no}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
      if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("               <a href=\"login.do\">LOGIN</a>\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      _jspx_th_c_005fif_005f3_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f3, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f3_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f4_reused = false;
    try {
      _jspx_th_c_005fif_005f4.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f4.setParent(null);
      // /./form/header.jsp(57,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sessionScope.me_no}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f4 = _jspx_th_c_005fif_005f4.doStartTag();
      if (_jspx_eval_c_005fif_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("               <a href=\"logout.do\">LOGOUT</a>\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
      _jspx_th_c_005fif_005f4_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f4, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f4_reused);
    }
    return false;
  }
}
