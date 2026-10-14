

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href ="CSS/style.css"/>
</head>
<body class ="body_bg">


<h4>  Login Here </h4>


<c:if test = "${not empty errorMSG}">
<h4 style="color: green">${errorMSG}</h4>
</c:if>

<form action ="loginForm" method = "post">
Email : <input type="text" name ="email"/> <br/> <br/>
Password : <input type="password" name ="password"/> <br/> <br/>
<input type="submit" value ="Login"/> 
</form>

<br/> <br/>



if not registered......<a href="regPage"><b>Click Here</b> </a>

</body>
</html>