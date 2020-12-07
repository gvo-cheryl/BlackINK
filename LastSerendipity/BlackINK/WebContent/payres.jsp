<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript" src="js/jquery.ajax-cross-origin.min.js"></script>

<script type="text/javascript">
	
	$(function() {
		
		console.log("js 시작");

		var IMP = window.IMP;
		IMP.init('imp89798577');

		var ti_no, me_no, ti_pay, hi_method, ti_title, hi_email;
						
		ti_no = document.getElementById("ti_no").value;	// 글 번호 => 주문 번호
		me_no = document.getElementById("me_no").value;	// 회원 번호
		ti_pay = document.getElementById("hi_pay").value;	// 결제 금액
		pay = (ti_pay * 0.1);
		hi_method = document.getElementById("hi_method").value;	// 결제 방법 
		ti_title = document.getElementById("ti_title").value;	// 주문 명
		hi_email = document.getElementById("hi_email").value;	// 주문자 이메일

		IMP.request_pay({
			
			pg : "html5_inicis",
			pay_method : hi_method,
			merchant_uid : ti_no,
			name : ti_title,
			amount : pay,
			buyer_email : hi_email,
			buyer_name : me_no
			
		}, function(rsp) {
			
			if (rsp.success) {
				
				console.log("ajax 1번 시작");
				
				var sendData = {
						"pay_method" : hi_method,	// 결제 방법
						"merchant_uid" : ti_no,	// 주문 번호
						"real_amount" : pay,	// 결제 금액
						"member_no" : me_no,	// 회원 번호
						"imp_uid" : rsp.imp_uid	// 결제 번호
					}
				
				console.log(JSON.stringify(sendData));
				
				$.ajax({			// 가맹점 db에 정보 저장

					url : "hispay",
					method : "post",
					data : {
						"command": "save",
						"sendData" : JSON.stringify(sendData)
					},
					success: function(result){
						
						var msg = '결제가 완료되었습니다.';
				        msg += '고유ID : ' + rsp.imp_uid;
				        msg += '상점 거래ID : ' + rsp.merchant_uid;
				        msg += '결제 금액 : ' + rsp.paid_amount;
				        msg += '카드 승인번호 : ' + rsp.apply_num;
				        alert(msg);
				        
				        location.href="uCalController.do?command=selectMyList";
						
					}
				
				});

			
		} else {
				
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
				alert(msg);
				
				location.href="uCalController.do?command=selectMyList";
				
			}
			
		});
	});
	
</script>

</head>
<body>

	<!-- 

	tattooinfo 테이블에서 받을 것
		: 시술 번호, 회원 번호, 시술 명, 시술 금액, 결제 방식

 -->

	<input type="hidden" value="${dto.ti_no}" id="ti_no" />
	<input type="hidden" value="${dto.me_no}" id="me_no" />
	<input type="hidden" value="${dto.ti_pay}" id="hi_pay" />
	<input type="hidden" value="${dto.hi_method}" id="hi_method" />
	<input type="hidden" value="${dto.ti_title}" id="ti_title" />
	<input type="hidden" value="${dto.hi_email}" id="hi_email" />

</body>
</html>