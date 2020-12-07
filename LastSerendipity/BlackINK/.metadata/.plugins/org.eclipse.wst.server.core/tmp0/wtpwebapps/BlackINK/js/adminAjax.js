$(function(){
	$("#submit").click(
		function(event){
			
			var me_enabled = $("#me_enabled").val();
			var me_role = $("#me_role").val();
			
			var me_enabled_list = [];
			var me_role_list = [];
			
			$("input[name='chk1']:checked").each(function(i){
				me_enabled_list.push($(this).val());
				//alert($(this).val());
			});
			
			$("input[name='chk2']:checked").each(function(i){
				me_role_list.push($(this).val());
				//alert($(this).val());
			});
			
			for(var i=0; i<me_role_list.length; i++){
				//alert(me_role_list[i]);
			}
			
			$.ajax({
				
				type: "post",
				url: "mypage.do",
				data: {"command": "detailSearch", "me_enabled": JSON.stringify(me_enabled_list), 
						"me_role": JSON.stringify(me_role_list)},
				dataType: "json",
				contentType: 'application/x-www-form-urlencoded; charset=euc-kr',
				success: function(data){
					//alert("success");
					
					
					
					var $tbody = $("tbody");
					var list = data.result;
					
					if(list[0]== null) {
						$(".list").remove();
						var $tr = $("<tr>").attr("class", "list");
						$tr.append($("<th>").attr('colspan', '9').html("------ 조회 결과가 없습니다. ------"));
						$tbody.append($tr);
					} else {
						$(".list").remove();
						for (var i = 0 ; i < list.length ; i++) {
						var $tr = $("<tr>").attr("class", "list");
						
						$tr.append($("<td>").append(list.length-i));
						$tr.append($("<td>").append(list[i].me_no));
						$tr.append($("<td>").append(list[i].me_email));
						$tr.append($("<td>").append(list[i].me_name));
						$tr.append($("<td>").append(list[i].me_nic));
						$tr.append($("<td>").append(list[i].me_phone));
						$tr.append($("<td>").append(list[i].me_enabled=="Y"? "활동회원": "탈퇴회원"));
						$tr.append($("<td>").append(list[i].me_sns_type));
						if(list[i].me_role=="U"){
							$tr.append($("<td>").append('일반회원'));
						} else if(list[i].me_role=="T"){
							$tr.append($("<td>").append('타투이스트'));
						} else if(list[i].me_role=="A"){
							$tr.append($("<td>").append('관리자'));
						}
						$tr.append($("<td>").append('<input type="button" value="변경" onclick="updateRole('+list[i].me_no+');" id="update">'));
						$tbody.append($tr);
						}
					}
					
						
						
						
						
				}, 
				error: function(except){
					alert(except.responseText);
				}
				
				
				
			});
		
	});
});