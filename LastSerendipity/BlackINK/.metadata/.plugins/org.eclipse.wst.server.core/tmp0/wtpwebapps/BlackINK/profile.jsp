<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
// opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
//document.domain = "abc.go.kr";

function goPopup(){
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
    var pop = window.open("./etcJsp/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
    
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}
/** API 서비스 제공항목 확대 (2017.02) **/
function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
						, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	document.form.roadAddrPart1.value = roadAddrPart1;
	document.form.roadAddrPart2.value = roadAddrPart2;
	document.form.addrDetail.value = addrDetail;
	document.form.zipNo.value = zipNo;
}
</script>
<style type="text/css">
body{background: ghostwhite;}
.field{width: 800px; position: relative; left: 30%; top:30px;}
#bottom{height:200px;}
.first {display: inline-table; margin: 10px; padding: 10px; margin-bottom: 0px; padding-bottom: 0;}
.second {display: inline-table; margin-left: 15px; padding: 10px; margin-top: 0; padding-top: 0; margin-bottom: 0px; padding-bottom: 0;}
.third1 {display: inline-table; margin: 14px;  padding: 10px; margin-top: 0; padding-top: 0; margin-bottom: 0px; padding-bottom: 0;}
.third2 {display: inline-table; margin: 5px;  padding: 10px; margin-top: 0; padding-top: 0;}
.last{position: relative; left: 30%; margin: 10px; padding: 10px;}
.button{width:60px; height:30px;}
#center{margin: 10px; padding: 10px;}
#height{position: relative; top:3px;}
.text > p {height:23.5px;}
p{margin: 10px;}
#imageList{width:200px; height:200px;}
#searchList{position: relative; margin: 50px;}
#imageClick{text-align: center;}
</style>
</head>
<body>

<%@ include file="./form/header.jsp" %>

<!-- 회원마이페이지에서 회원수정 들어가면 기본정보 수정이가능하고 
하단에 프로필 수정을 누르면 새로 창이뜨거나 아래로 화면이 펼쳐지면서 수정할수 있도록 -->
<form action="profileController.do" method="POST" enctype="multipart/form-data" 
accept-charset="UTF-8" id="form" name="form">
	<div class="field">
		<h1>PROFILE</h1>
		<div class="first">
			<div class="text">
				<p>상호명</p>
				<p>운영시간</p>
				<p>우편번호</p>
				<p>주소</p>
				<p>상세주소</p>
				<p>소개글</p>
			</div>
		</div>
		
		<div class="first">
			<p><input type="text" name="shopname" value="${dto.pr_shopname }" style="width:47%; height:20px;"/></p>
			<p><input type="time" name="open" value="${dto.pr_open }"> ~
				<input type="time" name="close" value="${dto.pr_close }"/>
				<input type="hidden" name="command" value="insert"/>
				<input type="hidden" name="me_no" value="${dto.me_no }"/>
			</p>
			<p><input type="hidden" id="confmKey" name="confmKey" value=""  >
				<input type="text" id="zipNo" name="zipNo" value="${dto.pr_post }" readonly style="width:108px; height:20px;">
				<input type="button"  value="주소검색" onclick="goPopup();" style="margin-left: 10px;">
			<p>
				<input type="text" id="roadAddrPart1" name="roadAddrPart1" value="${dto.pr_adr_main }" style="width:80%; height:20px;">
			</p>
			<p>
				<input type="text" id="addrDetail" name="addrDetail" value="${dto.pr_adr_d1 }" style="width:38%; height:20px;" value="">
				<input type="text" id="roadAddrPart2" name="roadAddrPart2" value="${dto.pr_adr_d2 }" style="width:40%; height:20px;" value="">
			</p>
			<p><textarea rows="30" cols="60" name="intro">${dto.pr_content }</textarea></p>
		</div>
	</div>
	<div class="field">
		<div class="second">
			<div class="text">
					<p>도안첨부</p>
				</div>
		</div>
		<div class="second">
			<p><input multiple="multiple" type="file" name="files"/></p>
		</div>
	</div>
	
	<div class="field">
		<div class="last">
			<input type="button" value="취소" onclick="location.href='profileController.do?command=detail&me_no=${dto.me_no}'" class="button"/>
			<input type="submit" value="수정" class="button" />
		</div>
	</div>
</form>

<div id="bottom"></div>



<%@ include file="./form/footer.jsp" %>


</body>
</html>
