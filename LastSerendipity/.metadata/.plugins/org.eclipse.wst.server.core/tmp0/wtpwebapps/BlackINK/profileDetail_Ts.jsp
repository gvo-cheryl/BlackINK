<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>profileDetail</title>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		
		$("#allchk").click(function(){
			$("input[name=chk]").each(function(){
				$(this).prop("checked", true);
			});
		});
		
		$("#muldel").submit(function(){
			if($("#muldel input:checked").length == 0){
				alert("하나 이상 체크해주세요.")
				return false; 
			}
		});
		
	});	
</script>
<style type="text/css">
#total{width:65%; height: 2400px; position: relative; left: 18%; }
body{background: ghostwhite;}
#me_nic, #intro, #map_wrap, #sample, #calender{width: 100%; } 
#me_nic{height: 100px; }
#me_nic h1{position: relative; top: 40%; right: 15%;}
#intro{height: 13%; position: relative;}
#intro #intro_title{position: relative; left:3%; top:3%;}
#intro hr{position: relative; top: 5%; }
#intro p{position: relative; top: 10%; left: 5%;}
#map_wrap{height: 24%; position: relative;}
#map_wrap #map_wrap_title{position: relative; left:3%; top:3%;}
#map_wrap hr{position: relative; top: 5%; }
#map{position: relative; top:15%; left: 3%;}
#map_wrap p{position: relative; top: 10%; left: 5%;}
#sample{height: auto; position: relative; }
#sample #tattoo_sample{position: relative; padding-top: 2%; padding-left: 3%;}
#sample hr{position: relative; }
#sample #sample_text{position: relative; margin-top:5%; left: 5%; color:gray; font-size: small;}
#Schedule{height: 20%; position: relative; margin-top: 5%;}
#Schedule #Schedule_title{position: relative; left:3%; top:3%;}
#Schedule hr{position: relative; top: 5%;}
#Schedule div{position: relative; top:10%;}
#editSchedule{position: relative; top:25%; margin-top: 5%;}

#imageList{width:120px; height:120px;}
#searchList{position: relative; margin: 50px; text-align: center;}
#imageClick{text-align: center;}
#chk{text-align: center;}
#button{position: relative; right: 5%; padding-bottom: 3%;}
#edit{position: relative; top:20%; right: 5%;}
</style>
</head>
<body>
<%@ include file="./form/header.jsp"%>
<div id="total">
	<div id="me_nic">
		<h1>${dto.me_nic }</h1>
		<input type="hidden" value="${dto.pr_shopname }" id="pr_shopname"/>
		<input type="hidden" value="${dto.pr_adr_main }" id="pr_adr_main"/>
	</div>
	<div id="intro">
		<p id="intro_title"><b>Introduce</b></p>
		<hr>
		<p style="white-space: pre;">${dto.pr_content }</p>
	</div>
	<div id="map_wrap">
		<p id="map_wrap_title"><b>Location</b></p>
		<hr>
		<p>상호명: ${dto.pr_shopname }</p>
		<p>주소: ${dto.pr_adr_main }</p>
		<div id="map" style="width:95%;height:350px;"></div>
	</div>
<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c5dc0112e4e6fe63d4816715e4635e6e&libraries=services" ></script>
<script>
var pr_shopname = $("#pr_shopname").val();
var pr_adr_main = $("#pr_adr_main").val();
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch(pr_adr_main, function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+pr_shopname+'</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>
	<div id="sample">
		<p id="tattoo_sample"><b>Sample</b></p>
		<hr>
		<form action="profileController.do" method="post" id="muldel">
	    <c:set var="i" value="0"/>
	    <c:set var="j" value="8"/>
		<table id="searchList" >
	    	<c:choose>
	    		<c:when test="${empty list }">
	    			<tr>
	    				<th colspan="4" rowspan="3" align="center">--- 검색결과가 없습니다 ---</th>
	 				</tr>
	    		</c:when>
	    		<c:otherwise>
	    			<c:forEach items="${list }" var="img">
	    				<c:if test="${i%j == 0}">
	    					<tr>
	    				</c:if>
	    					<td>
		    					<ul id="ajaxReset">
		    						<li>
		    							<a href="profileController.do?command=imageDetail_Ts&im_no=${img.im_no }&me_no=${list[0].me_no}" id="imageClick">
		    								<img src="/BlackINK/img/${img.im_servername}" id="imageList" alt="">
		    							</a>
		    						</li>
		    						<li>
		    							<a id="title">${img.ts_title }</a>
		    						</li>
		    					</ul>
		    				</td>
		    			<c:if test="${i%j == j-1 }">
	    					</tr>
	    				</c:if>
	    				<c:set var="i" value="${i+1 }"/>	
	    			</c:forEach>
	    		</c:otherwise>
	    	</c:choose>
	    	</table>
	   </form>
	</div>
	<div id="Schedule">
		<p id="Schedule_title">
			<b>Schedule</b>
		</p>
		<hr>
		<div align="center" id="editSchedule"><%@ include file="./profileCalendar.jsp"%></div>
	</div>


</div>
<%@ include file="./form/rightNavi.jsp" %>
<%@ include file="./form/footer.jsp"%>
</body>
</html>



























