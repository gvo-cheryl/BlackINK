$.ajax({
	type : "GET",
	url : "location.do?keyword="+keyword,
	dataType : "text",
	success : function(adr){
		
		var geocoder = new kakao.maps.services.Geocoder();
		
		geocoder.addressSearch(adr, function(result, status) {

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
		            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+keyword+'</div>'
		        });
		        infowindow.open(map, marker);
		
		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
    
			}
			
		});
			}, error : function(except){
					alert(except.responseText);
				}
});


$(function(){
			$("#search").click(	
				function(event){
				$.ajax({
					type : "GET",
					url : "location.do?keyword="+keyword,
					dataType : "text",
					success : function(adr){
						alert("success");
						
						getAdr = adr;

							}, error : function(except){
									alert("ajax 실패: " + except.responseText);
								}
				});
			});
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		