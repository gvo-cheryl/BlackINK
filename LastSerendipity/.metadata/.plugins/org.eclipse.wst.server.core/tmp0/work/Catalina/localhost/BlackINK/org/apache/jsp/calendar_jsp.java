/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2020-10-04 20:06:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.semi.tattoo.login.dto.LoginDto;
import com.semi.tattoo.login.biz.LoginBiz;
import java.util.Map;
import com.semi.tattoo.tattooinfo.dto.tattooInfoDto;
import java.util.List;
import com.semi.tattoo.tattooinfo.dao.tattooInfoDao;
import java.util.Calendar;
import com.semi.tattoo.tattooinfo.controller.Util;
import com.semi.tattoo.tattooinfo.controller.Util;

public final class calendar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1601784424000L));
    _jspx_dependants.put("/./form/header.jsp", Long.valueOf(1601822699000L));
    _jspx_dependants.put("jar:file:/Users/cheryl/workspace/LastSerendipity/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BlackINK/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("/./form/leftNavi_tattooist.jsp", Long.valueOf(1601784424000L));
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
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.semi.tattoo.login.dto.LoginDto");
    _jspx_imports_classes.add("java.util.Calendar");
    _jspx_imports_classes.add("com.semi.tattoo.login.biz.LoginBiz");
    _jspx_imports_classes.add("com.semi.tattoo.tattooinfo.dao.tattooInfoDao");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("com.semi.tattoo.tattooinfo.dto.tattooInfoDto");
    _jspx_imports_classes.add("com.semi.tattoo.tattooinfo.controller.Util");
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write("\tbody{background: ghostwhite;}\n");
      out.write("\t.head_title {\n");
      out.write("\t   margin-top: 30px;\n");
      out.write("\t   margin-bottom: 30px;\n");
      out.write("\t}\n");
      out.write("\t.head_title > h1 {\n");
      out.write("\t   padding-right: 30px;\n");
      out.write("\t   text-align: right;\n");
      out.write("\t}\n");
      out.write("\t#tableOption{\n");
      out.write("\t\tpadding-left: 100px;\n");
      out.write("\t}\n");
      out.write("\t#calendar{\n");
      out.write("\t\tborder-collapse:collapse;\n");
      out.write("\t\tpadding-left:30px;\n");
      out.write("\t}\n");
      out.write("\t#calendar th{\n");
      out.write("\t\twidth:90px;\n");
      out.write("\t\tborder:2px solid gray;\n");
      out.write("\t}\n");
      out.write("\t#calendar td{\n");
      out.write("\t\twidth:90px;\n");
      out.write("\t\theight:90px;\n");
      out.write("\t\tborder:2px solid gray;\n");
      out.write("\t\ttext-align: left;\n");
      out.write("\t\tvertical-align: top;\n");
      out.write("\t\tposition: relative;\n");
      out.write("\t}\n");
      out.write("\t#calendar td:nth-child(7n){\n");
      out.write("\t\tborder-right:none;\n");
      out.write("\t}\n");
      out.write("\t#calendar td:nth-child(7n+1){\n");
      out.write("\t\tborder-left:none;\n");
      out.write("\t}\n");
      out.write("\t.date{\n");
      out.write("\t\tfont-weight: 800;\n");
      out.write("\t\tpadding: 2px;\n");
      out.write("\t}\n");
      out.write("\t.date:hover{\n");
      out.write("\t\tcursor: pointer;\n");
      out.write("\t}\n");
      out.write("\ta{\n");
      out.write("\t\ttext-decoration: none;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t#clist > p{\n");
      out.write("\t\tfont-size:5px;\n");
      out.write("\t\tmargin:1px;\n");
      out.write("\t}\n");
      out.write("\t.m,.y,.dot{\n");
      out.write("\t\tfont-size: 30px;\n");
      out.write("\t\tborder: 0;\n");
      out.write("\t\tfont-weight: 800;\n");
      out.write("\t\tcolor: skyblue;\n");
      out.write("\t}\n");
      out.write("\t.dot{\n");
      out.write("\t\tcolor:gray;\n");
      out.write("\t}\n");
      out.write("\tcaption{\n");
      out.write("\t\tpadding-bottom: 10px;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.cPreview{\n");
      out.write("\t\tposition : absolute;\n");
      out.write("\t\ttop:-30px;\n");
      out.write("\t\tleft:10px;\n");
      out.write("\t\tbackground: skyblue;\n");
      out.write("\t\twidth:40px;\n");
      out.write("\t\theight:40px;\n");
      out.write("\t\ttext-align: center;\n");
      out.write("\t\tline-height: 40px;\n");
      out.write("\t\tborder-radius: 40px 40px 40px 1px;\n");
      out.write("\t}\n");
      out.write("\t.head_title {\n");
      out.write("      margin-top: 30px;\n");
      out.write("      margin-bottom: 30px;\n");
      out.write("   }\n");
      out.write("   .head_title > h1 {\n");
      out.write("      padding-right: 30px;\n");
      out.write("      text-align: right;\n");
      out.write("   }\n");
      out.write("\t\n");
      out.write("\tarticle{width:900px; height: auto; position: relative; left: 25%;}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");

	Calendar cal = Calendar.getInstance();
	
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH)+1;
	int ti_tno = (int)session.getAttribute("me_no");
	String paramYear = request.getParameter("year");
	String paramMonth = request.getParameter("month");
	if(paramYear != null){
		year = Integer.parseInt(paramYear);
	}
	if(paramMonth != null){
		month = Integer.parseInt(paramMonth);
	}
	
	if(month > 12){
		month = 1;
		year++;
	}
	if(month < 1){
		month = 12;
		year--;
	}
	
	// 현재년도, 현재월, 해당월의 1일
	cal.set(year, month-1, 1);
	//1일의 요일
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	// 현재월의 마지막일
	int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	//달력에 일정 표현
	tattooInfoDao dao = new tattooInfoDao();
	//String yyyyMM = year + Util.isTwo(String.valueOf(month));
	//String yyyyMM = year + Util.isTwo(Integer.toString(month));
	String ti_date = year + Util.isTwo(month+"");
	tattooInfoDto dto = new tattooInfoDto(ti_tno,ti_date);
	List<Map<String,String>> clist = dao.calendarViewList(dto);

      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.5.1.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t$(function(){\n");
      out.write("\t\t$(\"#calendar tr\").children(\"th:first\").css(\"border-left\",\"none\");\n");
      out.write("\t\t$(\"#calendar tr\").children(\"th:last\").css(\"border-right\",\"none\");\n");
      out.write("\t});\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<body>\n");
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
      out.write("\n");
      out.write("<article>\n");
      out.write("<div id=join class=\"head_title\">\n");
      out.write("  <h1>내 일정</h1> \n");
      out.write("  <hr>\n");
      out.write("</div>\n");
      out.write("<br/>\n");
      out.write("<div id=\"tableOption\">\n");
      out.write("\t<table id = \"calendar\">\n");
      out.write("\t\t<caption>\n");
      out.write("\t\t\t<a style=\"color:black\" href=\"calendar.jsp?year=");
      out.print(year-1 );
      out.write("&month=");
      out.print(month );
      out.write("\">◁</a>\n");
      out.write("\t\t\t<a style=\"color:black\" href=\"calendar.jsp?year=");
      out.print(year );
      out.write("&month=");
      out.print(month-1 );
      out.write("\">◀</a>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<span class=\"y\">");
      out.print(year );
      out.write("</span>\n");
      out.write("\t\t\t<span class=\"dot\">/</span>\n");
      out.write("\t\t\t<span class=\"m\">");
      out.print(month );
      out.write("</span>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<a style=\"color:black\" href=\"calendar.jsp?year=");
      out.print(year );
      out.write("&month=");
      out.print(month+1 );
      out.write("\">▶</a>\n");
      out.write("\t\t\t<a style=\"color:black\" href=\"calendar.jsp?year=");
      out.print(year+1 );
      out.write("&month=");
      out.print(month );
      out.write("\">▷</a>\n");
      out.write("\t\t</caption>\n");
      out.write("\t\t\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<th style=\"color:red\">SUN</th><th>MON</th><th>TUE</th><th>WED</th>\n");
      out.write("\t\t\t<th>THU</th><th>FRI</th><th style=\"color:blue\">SAT</th>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");

	for(int i = 0;i<dayOfWeek-1; i++){
		out.print("<td>&nbsp;</td>");
	}

for(int i = 1;i<=lastDay;i++){

      out.write("\n");
      out.write("\t<td class=\"date\" onclick=\"location.href='tCalController.do?command=listcal&year=");
      out.print(year );
      out.write("&month=");
      out.print(month );
      out.write("&date=");
      out.print(i );
      out.write("'\">\n");
      out.write("\t\t<div>\n");
      out.write("\t\t\t<div style=\"color:");
      out.print(Util.fontColor(i, dayOfWeek) );
      out.write('"');
      out.write('>');
      out.print(i );
      out.write("</div>\n");
      out.write("\t\t\t<div id=\"clist\">\n");
      out.write("\t\t\t\t");
      out.print(Util.getCalView(i, clist) );
      out.write("\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</td>\n");

	if((dayOfWeek-1+i)%7 == 0){
		out.print("</tr><tr>");
	}
}

for(int i = 0;i<(7-(dayOfWeek-1+lastDay)%7)%7;i++){
	out.print("<td>&nbsp;</td>");
}

      out.write("\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t\n");
      out.write("\t</table>\n");
      out.write("\t</div>\n");
      out.write("</article>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<br/>\n");
      out.write("<br/>\n");
      out.write("<br/>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("aside {\n");
      out.write("      position: absolute;\n");
      out.write("      top: 200px;\n");
      out.write("      left: 50px;\n");
      out.write("      width: 250px;\n");
      out.write("      height: 300px;\n");
      out.write("   }\n");
      out.write("\n");
      out.write("#navi p {\n");
      out.write("   font-size: 25pt;\n");
      out.write("   font-weight: bold;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#navi ul li{\n");
      out.write("   font-size: 18pt;\n");
      out.write("   margin-top: 10px;\n");
      out.write("}\n");
      out.write("#navi ul li a:hover li{\n");
      out.write("   color:red;\n");
      out.write("}\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<aside> \n");
      out.write("      <div id=\"navi\">\n");
      out.write("         <p>My page</p>\n");
      out.write("         <br/>\n");
      out.write("         <ul> \n");
      out.write("\t\t\t<li><a href=\"mypage.do?command=mypage&me_no=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.me_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" id=\"info\">내정보 관리</a></li> \n");
      out.write("\t\t\t<li><a href=\"profileController.do?command=detail&me_no=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.me_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" id=\"profile\">내 프로필</a></li>\n");
      out.write("\t\t\t<li><a href=\"calendar.jsp\">내 일정</a></li>\n");
      out.write("         \t<li><a href=\"tCalController.do?command=listcal&today=");
      out.print(Util.getToday() );
      out.write("\">예약 내역</a></li>\n");
      out.write("         </ul> \n");
      out.write("      </div>\n");
      out.write("</aside>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write('\n');
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
      out.write("\n");
      out.write("</body>\n");
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
