const canvas = document.getElementById("jsCanvas");
const ctx = canvas.getContext("2d");
const range = document.getElementById("jsRange");
const fillBtn = document.getElementById("jsFill");
const colorBtn = document.getElementsByClassName("jsColor");
const saveBtn = document.getElementById("jsSave");
const clearBtn = document.getElementById("jsClear");
const loadBtn = document.getElementById("jsLoad");

const CANVAS_SIZE = 400;

canvas.height = CANVAS_SIZE;
canvas.width = CANVAS_SIZE;

ctx.strokeStyle = "black";
ctx.fillStyle = "white";
ctx.fillRect(0, 0, CANVAS_SIZE, CANVAS_SIZE);
ctx.lineWidth = 2.5;

let painting = false;
let filling = false;

function startPainting() {
  painting = true;
}

function stopPainting() {
  painting = false;
}

function onMouseMove(event) {
  const x = event.offsetX;
  const y = event.offsetY;

  if (!painting) {
    ctx.beginPath();
    ctx.moveTo(x, y);
  } else {
    ctx.lineTo(x, y);
    ctx.stroke();
  }
}

function handleRangeChange(event) {
  ctx.lineWidth = event.target.value;
}

function handleFillClick() {
  if (!filling) {
    fillBtn.innerText = "paint";
    filling = true;
  } else {
    fillBtn.innerText = "fill";
    filling = false;
  }
}

// 투명기능 추가
function handleColorChange(event) {
  if (event.target.id === "transparent") {
    ctx.globalCompositeOperation = "destination-out";
  }
  if (event.target.style.backgroundColor) {
    ctx.globalCompositeOperation = "source-over";
    const color = event.target.style.backgroundColor;
    ctx.strokeStyle = color;
    ctx.fillStyle = color;
  }
}

function onCanvasClick() {
  if (filling) {
    ctx.fillRect(0, 0, CANVAS_SIZE, CANVAS_SIZE);
  }
}

function handleContextmenu(event) {
  event.preventDefault();
}

function handleSaveClick() {
  const image = canvas.toDataURL("image/png");
  const link = document.createElement("a");
  link.href = image;
  link.download = "Your Awesome Art 🎨";
  link.click();
}

// 전체 지우기
function handleClear() {
	ctx.clearRect(0, 0 ,CANVAS_SIZE, CANVAS_SIZE);
}

// 이미지 업로드
function handleImageLoad(files) {
	var file = files[0];
	
	if (!file.type.match(/image.*/)){
		alert("not image file!");
	}
	var reader = new FileReader();
	
	reader.onload = function(e){
		
		var loadImage = new Image();
		
		loadImage.onload = function(){
			ctx.drawImage(loadImage,0,0,780,780);

		}
		loadImage.src = e.target.result;
	}
	reader.readAsDataURL(file);
}

if (canvas) {
  canvas.addEventListener("mouseup", stopPainting);
  canvas.addEventListener("mousedown", startPainting);
  canvas.addEventListener("mouseleave", stopPainting);
  canvas.addEventListener("mousemove", onMouseMove);
  canvas.addEventListener("click", onCanvasClick);
  canvas.addEventListener("contextmenu", handleContextmenu);
}

if (jsRange) {
  range.addEventListener("input", handleRangeChange);
}

if (fillBtn) {
  fillBtn.addEventListener("click", handleFillClick);
}

if (colorBtn) {
  Array.from(colorBtn).forEach((color) =>
    color.addEventListener("click", handleColorChange)
  );
}

if (saveBtn) {
  saveBtn.addEventListener("click", handleSaveClick);
}

if (clearBtn) {
	clearBtn.addEventListener("click", handleClear);
}
