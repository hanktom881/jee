<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<%   
String name = "XXX";
int age = 30;
Date now = new Date();
Calendar cal = Calendar.getInstance();
cal.setTime(now);
int hour = cal.get(Calendar.HOUR_OF_DAY);
//
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

Date expire = sdf.parse("2015-08-08 01:23:45");
%>
<%=hour %>
<%
if (hour<12)
	out.println("早安,請登入");
%>
<%=sdf.format(now) %>
<p>
<%
if (session.getAttribute("error")!=null){
	out.println(session.getAttribute("error"));
}
%>
</p>
<form action="login" method="post">
	帳號: <input type="text" name="userid" /> </br>
	密碼: <input type="text" name="pw" /></br>
	<input type="submit" value="登入" />
</form>
<%=now.getTime() %>
<% out.print(name); %>
<%=age %>
<%=expire %>
</body>
</html>