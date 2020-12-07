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

</head>
<body>
	<canvas id="jsCanvas" class="canvas"></canvas>
	<div class="controls">
		<input type="range" id="jsRange" class="range" min="1" max="10" value="5" />
		<div class="buttons">
			<button id="jsFill">fill</button>
			<button id="jsSave">save</button>
			<button id="jsClear">clear</button>
			<input type="file" id="jsLoad" value="load" onclick="handleImageLoad(this.files);" />
		</div>
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
	</div>

	<script type="text/javascript" src="js/canvas.js"></script>

</body>
</html>