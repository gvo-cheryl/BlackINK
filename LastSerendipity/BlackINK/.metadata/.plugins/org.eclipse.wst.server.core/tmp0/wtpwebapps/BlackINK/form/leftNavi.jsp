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
			<li><a href="mypage.do?me_no=${sessionScope.me_no}" id="info">내정보 관리</a></li> 
			<li><a href="myhistory.do?me_no=${sessionScope.me_no}" id="searchimage">내 히스토리</a></li>
			<li>관심있는 타투</li>
			<li>결제 내역</li>
         </ul> 
      </div>
</aside>



</body>
</html>