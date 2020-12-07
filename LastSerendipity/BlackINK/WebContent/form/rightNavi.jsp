<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
   margin: 0;
   padding: 0;
}

#nav{
   position: fixed;
   right:50px;
   bottom:80px;
}

#appointmentBtn{
   width: 50px;
   height: 50px;
   border-radius: 5px;
   background-image: url(img/bookImg.jpeg);
   background-size: 100%, 100%;
   background-repeat: no-repeat;
   border: none;
}

#chatbot_button {
   width: 50px;
   height: 50px;
}

#chatbotStartButton {

   width: 50px;
   height: 50px;
   border-radius: 20px 20px 20px 20px;
   background-image: url(img/chatbotbutton.png);
   background-size: 100%, 100%;
   background-repeat: no-repeat;
   border: none;
      
}

#space {
   height: 10px;
}
</style>

<script type="text/javascript">

   function chatbotStart(){
      
      var url = "chatbot.jsp";
      var title = "Black INK FAQ chatbot";
      var prop = "top=50px,left=100px,width=365px,height=470px,resizable=no,fullscreen=no,location=no";
      
      window.open(url, title, prop);
      
   }

</script>

</head>
<body>
   
   <div id="nav">
      <div id="chatbot_button">
         <button id="chatbotStartButton" onclick="chatbotStart();" name="chatbotStartButton"></button>
      </div>
      <div id="space"></div>
      <div id="appointment">
      	<button id="appointmentBtn" onclick="location.href='appointment.do?command=insertAppointment'"></button>
      </div>
   </div>
   
</body>
</html>