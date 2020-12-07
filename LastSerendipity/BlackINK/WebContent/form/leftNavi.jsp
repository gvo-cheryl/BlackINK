<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
aside {
      position: absolute;
      top: 200px;
      left: 50px;
      width: 250px;
      height: 300px;
   }

#navi p {
   font-size: 25pt;
   font-weight: bold;
}

#navi ul li{
   font-size: 18pt;
   margin-top: 10px;
}
#navi ul li a:hover li{
   color:red;
}

</style>
</head>
<body>

<aside> 
      <div id="navi">
         <p>My page</p>
         <br/>
         <ul> 
			<li><a href="mypage.do?command=mypage&me_no=${sessionScope.me_no}" id="info">내정보 관리</a></li> 
			<!-- <li><a href="designSelect?command=mydesign" id="searchimage">내 도안</a></li>-->
			<li><a href="uCalController.do?command=selectMyList">예약 내역</a></li>
			<li><a href="hispay?command=checkPay">결제 내역</a></li>
         </ul> 
      </div>
</aside>



</body>
</html>