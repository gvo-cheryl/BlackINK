$(function(){
	$("#imageSearch").click(
		function(event){
			event.preventDefault();
			
			var form = new FormData($("#imageForm")[0]);
			$.ajax({
				type : "POST",
				enctype: 'multipart/form-data',
				url : "visionController.do",
				dataType : "json",
				data : form,
				processData : false,
				contentType : false,
				success : function(response){
					//alert("success");	
					var list = response.result;
					var labelTag = response.labelTag;
					var textTag = response.textTag;
					//alert("success : " + labelTag);
					
					$("#searchList").empty();	
					$("#resultCount").remove();	
					$(".label").remove();			
					var cnt = 1;
					var $tr;
					
					if(list == null || list == ""){
						$("#searchList").append($("<div>").attr('class','noresult').html("검색결과가 없습니다."));
					}
					
					
					for(var i = 0; i<list.length; i++){
						
						if(cnt%8 == 1){
							$tr = $("<tr>");
						}
						
						var $td = $("<td>");
						var $ul = $("<ul>");
						
						$ul.append($("<li>").append($("<a>").attr('id','imgClick').attr('href', 'profileController.do?command=imageDetail_Ts&im_no='+list[i].im_no+'&me_no='+list[i].me_no)
						.append($("<img>").attr('id','imageList').attr('src', '/BlackINK/img/'+list[i].im_servername))));
						$ul.append($("<li>").append($("<a>").attr('id','title').html(list[i].ts_title)));
						$ul.append($("<li>").append($("<a>").attr('id','writer').html(list[i].ts_writer)));
						$td.append($ul);
						$tr.append($td);
						$("#searchList").append($tr);
						

						
						if(cnt%8==0){ 
							$("#searchList").append($tr);
						}
						cnt++;						
					}
					$("#result").append($("<span>").attr('id','resultCount').html(list.length+"개의 검색결과가 있습니다."));
					//$("#searchList").prepend($("<div>").attr('class','noresult').html("텍스트검색: " + textTag));
					$("#searchList").before($("<div>").attr('class','label').html("연관키워드: " + labelTag +"<br>텍스트검색: " + textTag));
					
				}, error : function(except){
					alert(except.responseText);
				}
			});
	});
	
		$("#textSearch").click(function(event){
			event.preventDefault();
		
			//var textForm = $("form[name=textForm]").serialize;
			var text = $("input[name=text]").val();
			var chkArr = [];
			$("input[name=chk]:checked").each(function(i){
				chkArr.push($(this).val());
			});
			chkArr.push(text);			
/*			for(var i = 0; i<$("input[name=chk]:checked").length; i++){
				var checked = $("input[name=chk]:checked").eq(i);
				alert("text : " + text + " checked : " + checked);
			}*/
	
			$.ajax({
				type : "POST",
				url : "textsearchController.do",
				data : {"command":"textSearch", "data":JSON.stringify(chkArr)},
				dataTypa : "json",
				success : function(data){
					var obj = JSON.parse(data);
					var list = obj.result;
					//alert("success: " + list.length);
					
					$("#searchList").empty();	
					$("#resultCount").remove();				
				
					var cnt = 1;
					var $tr;
					
					if(list == null || list == ""){
						$("#searchList").append($("<div>").attr('class','noresult').html("검색결과가 없습니다."));
					}
					
					for(var i = 0; i<list.length; i++){
						
						if(cnt%8 == 1){
							$tr = $("<tr>");
						}
						
						var $td = $("<td>");
						var $ul = $("<ul>");
						
						$ul.append($("<li>").append($("<a>").attr('id','imgClick').attr('href', 'profileController.do?command=imageDetail_Ts&im_no='+list[i].im_no+'&me_no='+list[i].me_no)
						.append($("<img>").attr('id','imageList').attr('src', 'http://localhost:8787/BlackINK/img/'+list[i].im_servername))));
						$ul.append($("<li>").append($("<a>").attr('id','title').html(list[i].ts_title)));
						$ul.append($("<li>").append($("<a>").attr('id','writer').html(list[i].ts_writer)));
						$td.append($ul);
						$tr.append($td);
						$("#searchList").append($tr);
						
						if(cnt%8==0){ 
							$("#searchList").append($tr);
						}
						cnt++;						
					}
					$("#result").append($("<span>").attr('id','resultCount').html(list.length+"개의 검색결과가 있습니다."));


				},
				error : function(except)	{
					alert(except.responseText);
				}
		});
	});
	

});
















