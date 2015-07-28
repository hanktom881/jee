<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reg</title>
</head>
<body>
<p>
<%
String userid = "";
String nickname = "";
String password = "";
String password2 = "";
String email = "";
if(session.getAttribute("error")!=null){
	out.print(session.getAttribute("error"));
}
if (session.getAttribute("userid")!=null){
	userid = (String)session.getAttribute("userid");
}
if (session.getAttribute("nickname")!=null){
	nickname = (String)session.getAttribute("nickname");
}
if (session.getAttribute("password")!=null){
	password = (String)session.getAttribute("password");
}
if (session.getAttribute("password2")!=null){
	password2 = (String)session.getAttribute("password2");
}
if (session.getAttribute("email")!=null){
	email = (String)session.getAttribute("email");
}

%>
</p>
<form action="reg">
	帳號:<input type="text" name="userid" value="<%=userid%>"/></br>
	匿稱:<input type="text" name="nickname" value="<%=nickname%>"/></br>
	密碼:<input type="text" name="password" value="<%=password%>"/></br>
	密碼(2):<input type="text" name="password2" value="<%=password2%>"/></br>
	E-mail:<input type="text" name="email" value="<%=email%>"/></br>
	<input type="submit" value="註冊" />
</form>
</body>
</html>