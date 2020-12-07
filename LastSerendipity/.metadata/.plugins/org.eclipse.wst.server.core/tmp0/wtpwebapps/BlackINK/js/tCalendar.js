$(document).ready(function () {
	
    $.datepicker.setDefaults($.datepicker.regional['ko']); 
    $( "#startDate" ).datepicker({
         changeMonth: true, 
         changeYear: true,
         nextText: '다음 달',
         prevText: '이전 달', 
         dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
         dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
         monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         dateFormat: "yymmdd",
         onClose: function( selectedDate ) {    
             $("#endDate").datepicker( "option", "minDate", selectedDate );
         }    

    });
    $( "#endDate" ).datepicker({
         changeMonth: true, 
         changeYear: true,
         nextText: '다음 달',
         prevText: '이전 달', 
         dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
         dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
         monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         dateFormat: "yymmdd",
         onClose: function( selectedDate ) {    
             $("#startDate").datepicker( "option", "maxDate", selectedDate );
         }    

    });    
    $( "input[name=ti_date]" ).datepicker({
        changeMonth: true, 
        changeYear: true,
        nextText: '다음 달',
        prevText: '이전 달', 
        dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
        monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        dateFormat: "yymmdd",
        minDate: 0

   }); 
})
	
	function updateInfo(ti_no){
		
		$.ajax({
			type: "POST",
			url: "./tiUpdate.do",
			data:{
				"command" : "tattooInfoUpdate",
				"ti_no" : ti_no
			},
			datatype: "json",
			success: function(data){
				if(!data){
					alert("데이터 안들어있음");
				}else{
					var dto = JSON.parse(data);
					$("#updateInfoTable").append($("<input type='hidden' name='ti_no' value='"+dto.ti_no+"'/>"));
					console.log(decodeURIComponent(dto.me_name));
					
					$("#me_name").append(dto.me_name);
					$("input[name=ti_date]").val(dto.ti_date);
					$("input[name=ti_time_hour]").val((dto.ti_time+"").substring(0,2));
					$("input[name=ti_time_minute]").val((dto.ti_time+"").substring(2,4));
					$("input[name=ti_pay]").val(dto.ti_pay);
					$("#ti_regdate").append((dto.ti_regdate+"").substring(0,19));

					var radioBtn = $("input[name=ti_state]");
					for(var i in radioBtn){
						if(radioBtn[i].value == dto.ti_state){
							radioBtn[i].checked = true;
						}
					}
					
					$("#updateInfoTable").css("display","block");
					$("body").css("background","gray");
					var input = $("input");
					for(var i in input){
						input[i].disabled = "disabled";
					}
					$("#updateInfoTable").find("*").attr("disabled", false);
				}
			},
			error: function(){
				alert('error');
			}
		})
	}
	
	function clearWindow(){
		$("input[name=ti_no]").remove();
		$("#me_name").empty();
		$("input[name=ti_date]").val('');
		$("input[name=ti_time_hour]").val('');
		$("input[name=ti_time_minute]").val('');
		$("input[name=ti_pay]").val('');
		$("#ti_regdate").empty();
		var input = $("input");
		for(var i in input){
			input[i].disabled = "";
		}
		$("body").css("background","");
		$("#updateInfoTable").css("display","none");	
	}
	
	function updateRes(){
		$.ajax({
			type: "POST",
			url: "./tiUpdate.do",
			data:{
				"command":"updateRes",
				"ti_no":$("input[name=ti_no]").val(),
				"ti_pay":$("input[name=ti_pay]").val(),
				"ti_date":$("input[name=ti_date]").val(),
				"ti_time_hour":$("input[name=ti_time_hour]").val(),
				"ti_time_minute":$("input[name=ti_time_minute]").val(),
				"ti_state":$("input[name=ti_state]:checked").val()
			},
			datatype: "text",
			success: function(res){
				console.log(res);
				if(res>0){
					alert("success");
					clearWindow();
					location.reload();
				}
			},
			error: function(){
				alert("error");
			}
		});
		return false;
	}