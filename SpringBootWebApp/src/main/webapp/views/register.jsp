

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href ="CSS/style.css"/>
</head>
<body class ="body_bg">


<h4>  Register Here </h4>


<c:if test = "${not empty successMSG}">
<h4 style="color: green">${successMSG}</h4>
</c:if>


<c:if test = "${not empty errorMSG}">
<h4 style="color: green">${errorMSG}</h4>
</c:if>

<form action ="regForm" method = "post"> >
Name : <input type="text" name ="name"/> <br/> <br/> 
Email : <input type="text" name ="email"/> <br/> <br/>
Password : <input type="password" name ="password"/> <br/> <br/>
Phone No : <input type="text" name ="phoneno"/> <br/> <br/>
<input type="submit" value ="Register"/> 
</form>

<br/> <br/>



if already registered......<a href="loginPage"><b>Click Here</b> </a>

</body>
</html>