
	
//키워드로 검색을 요청하는 함수 
function searchPlaces(){
	var keyword = document.getElementById("keyword").value;
	
	if(!keyword.replace(/^s+|\s+$/g, '')){
		alert("키워드를 입력해주세요!");
		return false;
	}

	//장소검색 객체를 통해 키워드로 장소검색을 요청 
	ps.keywordSearch(keyword, placesSearchCB);
}

function placesSearchCB(data, status){
	if(status === kakao.maps.services.Status.OK){
		
		//정상적으로 검색이 완료됐으면 검색목록과 마커를 표출 
		displayPlaces(data);
	} else if(status === kakao.maps.services.Status.ZERO_RESULT){
		alert("검색결과가 존재하지 않습니다.");
		return
	} else if(status === kakao.maps.services.Status.ERROR){
		alert("검색 결과 중 오류가 발생했습니다.");
		return
	}
	
}

function displayPlaces(places){
	
	bounds = new kakao.maps.latLngBounds(),
	listStr = '';
	
	removeMarker();
	
	for(vari=0; i<places.length; i++){
		var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
			marker = addMarker(placePosition, i),
			itemEl = getListItem(i, places[i]); //검색 결과 항목 element를 생성 
			
		//검색된 장소 위치를 기준으로 지도 범위를 재설정하기 위해
		//LatLngBounds 객체에 좌표를 추가 	
		bounds.extend(placePosition);
		
		//마커와 검색결과 항목에 mouseover했을때 해당장소에 인포윈도우에 장소명을 표시 
		//mouseout 했을때 인포윈도우 닫기
		(function(marker, title){
			kakao.maps.event.addListener(marker, 'mouseover', function(){
				displayInfowindow(marker, title);
			});
			
			kakao.maps.event.addListener(marker, 'mouseout', function(){
				infowindow.close();
			});
			
			itemEl.onmouseover = function(){
				displayInfowindow(marker, title);
			};
			
			itemEl.onmouseout = function(){
				infowindow.close();
			};
			
		})(marker, places[i].place_name);

	}
	
		map.setBounds(bounds);
}

//마커를 생성하고 지도 위에 마커를 표시하는 함수 
function addMarker(position, idx, title){
	//마커 이미지 url, 스프라이트 이미지를 쓴다고 함 
	var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png",
		imageSize = new kakao.maps.Size(36, 37), //마커 이미지 크기
		imgOptions = {
			spriteSize : new kakao.maps.Size(36, 691), //스프라이트 이미지 크기
			spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), //스프라이트 이미지 중 사용할 영역의 좌상단 좌표
			offset : new kakao.maps.Point(13,37) //마커 좌표에 일치시킬 이미지 내에서의 좌
		},
		markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
			marker = new kakao.maps.Marker({
			position : position, //마커의 위치
			image : markerImage	
			});
			
	marker.setMap(map); //지도 위에 마커를 표출 
	markers.push(marker); //배열에 생성된 마커를 추가 
		
	return marker;	
}

//지도 위에 표시되고 있는 마커를 모두 제거 
function removeMarker(){
	for(var i=0; i<markers.length; i++){
		markers[i].setMap(null);
	}
	markers = [];
}

//검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수
//인포윈도우에 장소명을 표시
function displayInfowindow(marker, title){
	var content = "<div>" + title + "</div>";
	
	infowindow.setContent(content);
	infowindow.open(map, marker);
}































