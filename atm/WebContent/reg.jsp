<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<jsp:useBean id="member" class="com.tom.Member" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reg</title>
</head>
<body>
<p>
${member.error }
</p>
<form action="reg">
	帳號:<input type="text" name="userid" value="${member.userid }"/></br>
	匿稱:<input type="text" name="nickname" value="${member.nickname }"/></br>
	密碼:<input type="text" name="password" value="${member.password }"/></br>
	密碼(2):<input type="text" name="password2" value="${member.password2 }"/></br>
	E-mail:<input type="text" name="email" value="${member.email }"/></br>
	<input type="submit" value="註冊" />
</form>
</body>
</html>