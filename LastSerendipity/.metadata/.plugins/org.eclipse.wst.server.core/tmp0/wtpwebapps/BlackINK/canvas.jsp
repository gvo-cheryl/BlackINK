<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Canvas Painter</title>

<style type="text/css">
@import url("css/canvas.css");
</style>

<script src="http://code.jquery.com/jquery-1.11.3.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />

</head>
<body>

<%@ include file="./form/header.jsp" %>

<article id="canvas_article">
	<div id="join" class="head_title">
	  <h1>내 도안</h1> 
	  <hr>
	</div>
	<br/>
	  <div id="sub_title">도안을 직접 그려 나만의 특별한 타투를 만들어보세요.</div><br/>
	<div id="canvas_body">
		<div id="jsContainer">
			<canvas id="jsCanvas" class="canvas"></canvas>
			<div class="jsCanvas_spase2"></div>
			<div class="controls">
				<input type="range" id="jsRange" class="range" min="1" max="10" value="5" />
				<div class="jsCanvas_spase2"></div>
				<div class="buttons">
					<button id="jsFill">fill</button>
					<button id="jsSave">save</button>
					<button id="jsClear">clear</button>
					<input type="file" id="jsLoad" value="load" onclick="handleImageLoad(this.files);" />
				</div>
				<div class="jsCanvas_spase2"></div>
				<div class="color__btns" id="jsColors">
					<div class="color__btn jsColor" style="background-color: black;"></div>
					<div class="color__btn jsColor" style="background-color: white;"></div>
					<div class="color__btn jsColor" style="background-color: orangered;"></div>
					<div class="color__btn jsColor" style="background-color: orange;"></div>
					<div class="color__btn jsColor" style="background-color: yellow;"></div>
					<div class="color__btn jsColor" style="background-color: green;"></div>
					<div class="color__btn jsColor" style="background-color: blue;"></div>
					<div class="color__btn jsColor" style="background-color: blueviolet;"></div>
					<div class="color__btn jsColor" id="transparent"></div>
				</div>
				<div class="jsCanvas_spase2"></div>
			</div>
		</div>
	</div>
</article>
<script type="text/javascript" src="js/canvas.js"></script>
<%@ include file="./form/rightNavi.jsp" %>
<%@ include file="./form/leftNavi_sample.jsp" %>
<%@ include file="./form/footer.jsp" %>

</body>
</html>