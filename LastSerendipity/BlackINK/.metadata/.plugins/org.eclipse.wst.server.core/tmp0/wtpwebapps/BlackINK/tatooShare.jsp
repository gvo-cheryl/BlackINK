<%@page import="com.semi.tattoo.tattooshare.dto.tattooshareDto"%>
<%@page import="java.util.List"%>
<%@page import="com.semi.tattoo.tattooshare.biz.tattooshareBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>  
<!DOCTYPE html>
<html>
 <head>
  <title> New Document </title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
  <script src="./js/tattooshareAjax.js"></script>
    <script>

        $(document).ready(function(){
        	//$("#blah").hide();
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
                    reader.onload = function (e) { 
                    //파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
                        $('#blah').attr('src', e.target.result);
                    	$('#blah').css({'width':'200px', 'height':'200px'});
                    	//$('#blah').attr('style', 'width: 500px; height:500px;');
                        //이미지 Tag의 SRC속성에 읽어들인 File내용을 지정
                        //(아래 코드에서 읽어들인 dataURL형식)
                    }                    
                    reader.readAsDataURL(input.files[0]);
                    //File내용을 읽어 dataURL형식의 문자열로 저장
                }
            }//readURL()--
    
            //file 양식으로 이미지를 선택(값이 변경) 되었을때 처리하는 코드
            $('#imgInp').change(function(){
               // alert(this.value); //선택한 이미지 경로 표시
                readURL(this);
                $('#content').hide();
                $('#blah').show();
            });
         });
       
  </script>
  <style type="text/css">
body{background: ghostwhite;}
article{width:70%; height: 500px; position: relative; left: 20%;}
#first{position: relative; left: 20%; top:30px;}
#second{position: relative; left: 250px; top:5px; width:200px;}
#third{margin: 20px;}
fieldset{width:660px; padding:5px; margin-top: 5px;}  
#content {
	outline: 2px dashed white;
	outline-offset: -10px;
	text-align: center;
	transition: all .15s ease-in-out;
	width: 200px;
	height: 200px;
	background-color: lightgray;
}
#content > a{text-align: center; position: relative; top:50%; font-size: large; color:white;}
h2{margin-left: 40px; margin-bottom: 20px;}
#imageList{width:130px; height:130px;}
#searchList{position: relative; margin: 50px;}
#imageClick{text-align: center;}
  </style>

 </head>
 <body>
 <%@ include file="./form/header.jsp" %>
 
 <article>	
	<div id="first">
		<form id="textForm" method="post" enctype="multipart/form-data">
			<div>
				<p>도안검색: 
					<input type="hidden" name="command" value="textSearch"/>
					<input type="text" name="text" style="width:550px;"/>
					<input type="submit" value="검색" id="textSearch"/>
		 		</p>
				<fieldset>
					<p>
					<label for="reply">부위별</label>
					<input type="checkbox" name="chk" value="Arm"/>팔
					<input type="checkbox" name="chk" value="Leg"/>다리
					<input type="checkbox" name="chk" value="Hand"/>손
					<input type="checkbox" name="chk" value="Wrist"/>손목
					<input type="checkbox" name="chk" value="Foot"/>발
					<input type="checkbox" name="chk" value="Ankle"/>발목
					<input type="checkbox" name="chk" value="Back"/>등
					<input type="checkbox" name="chk" value="Waist"/>허리
					<input type="checkbox" name="chk" value="Belly"/>배
					<input type="checkbox" name="chk" value="Clavicle"/>쇄골
					<input type="checkbox" name="chk" value="Head"/>머리
					<input type="checkbox" name="chk" value="Chest"/>어깨	
					<input type="checkbox" name="chk" value="Neck"/>목
					<br>
					<label for="reply">주제별</label> 
					<input type="checkbox" name="chk" value="Calligraphy"/>캘리그라피
					<input type="checkbox" name="chk" value="Flower"/>꽃
					<input type="checkbox" name="chk" value="Drawing"/>드로잉
					<input type="checkbox" name="chk" value="Design"/>디자인
					<input type="checkbox" name="chk" value="Illustration"/>일러스트			
				</p>
				</fieldset>
				</div>
		</form>
 	
	 	<div id="second">
			<form id="imageForm" method="post" enctype="multipart/form-data">
		        <div id="content"><a>이미지검색</a></div>
		        <img id="blah" src=""/><br>
		        <input type='file' name="filename1" id="imgInp" />
		        <input type="submit" value="이미지검색" id="imageSearch" style="width: 200px; float: center;"/>  
		    </form>
	    </div>
    </div>
    
    <h2>search results...</h2>
    <br>
    <hr>
        
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
    			<c:forEach items="${list }" var="dto">
    				<c:if test="${i%j == 0}">
    					<tr>
    				</c:if>
    					<td>
	    					<ul id="ajaxReset">
	    						<li>
	    							<a href="profileController.do?command=imageDetail_Ts&im_no=${dto.im_no }&me_no=${dto.me_no}" id="imageClick">
	    								<img src="http://localhost:8787/BlackINK/img/${dto.im_servername}" id="imageList" alt="">
	    							</a>
	    						</li>
	    						<li>
	    							<a id="title">${dto.ts_title }</a>
	    						</li>
	    						<li>
	    							<a id="writer">${dto.ts_writer }</a>
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
 </article>    
    
    
    <%@ include file="./form/leftNavi_sample.jsp" %>
    <%@ include file="./form/footer.jsp" %>
    
      
 </body>
</html>



















































