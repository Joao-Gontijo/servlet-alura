<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:url value="/entrada" var="linkEntradaServlet"/>
	<form action="${linkEntradaServlet }" method="post">
	
		Login: <input type="text" name="login"/>
		senha: <input type="password" name="senha"/>
		
		<input type="hidden" name="acao" value="Login">
		<input type="submit">
	</form>
</body>
</html>