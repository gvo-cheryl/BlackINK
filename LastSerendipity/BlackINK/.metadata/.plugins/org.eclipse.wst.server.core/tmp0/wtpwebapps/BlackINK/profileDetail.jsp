<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
article{width:800px; height: 1000px; position: relative; left: 25%;}
body{background: ghostwhite;}
#imageList{width:100px; height:100px;}
#searchList{position: relative; margin: 50px;}
#imageClick{text-align: center;}
#chk{text-align: center;}
</style>
</head>
<body>
<%@ include file="./form/header.jsp"%>
<article>
	<h1>${dto.me_nic } </h1>
	<input type="hidden" value="${dto.pr_shopname }" id="pr_shopname"/>
	<input type="hidden" value="${dto.pr_adr_main }" id="pr_adr_main"/>
	
	<div>
		<p>소개글</p>
		<p>${dto.pr_content }</p>	
	</div>
	
	<div>
		<p>위치안내 </p>
		<div id="map" style="width:80%;height:350px;"></div>	
	</div>
	<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c5dc0112e4e6fe63d4816715e4635e6e&libraries=services" ></script>
	<script>
	var pr_shopname = $("#pr_shopname").val();
	var pr_adr_main = $("#pr_adr_main");
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = {
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };  
	
	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(pr_shopname, function(result, status) {
	
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
	            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+pr_adr_main+'</div>'
	        });
	        infowindow.open(map, marker);
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } 
	});    
	</script>
	
	
	<div>
		<p>도안수정</p>
		
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
		    							<input type="checkbox" name="chk" value="${img.im_no }" id="chk"/>
		    						</li>
		    						<li>
		    							<a href="profileController.do?command=imageDetail&im_no=${img.im_no }&me_no=${list[0].me_no}" id="imageClick">
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
	    	
	    	
	    	
	    	
	    	<tr>
	    		<td>
	    			<ul>
	    				<li></li>
	    			</ul>
	    		</td>
	    		<td></td>
	    		<td></td>
	    		<td></td>
	    	</tr>
	    </table>
	    	<input type="hidden" name="command" value="muldel"/>
	    	<input type="hidden" name="me_no" value="${list[0].me_no }"/>
	    	<input type="button" value="전체선택" id="allchk" />
	    	<input type="submit" value="선택삭제" id="delete" />
	    	<input type="button" value="프로필수정" onclick="location.href='profileController.do?command=updateForm&me_no=${dto.me_no}'"/>
	   </form>
	</div>
</article>

<%@ include file="./form/leftNavi_tattooist.jsp"%>
<%@ include file="./form/footer.jsp"%>
</body>
</html>