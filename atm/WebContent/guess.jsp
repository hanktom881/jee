<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=session.getId() %>
<%
int secret = -1;
int n = -1;
if (request.getParameter("number")!=null){
	n = Integer.parseInt(request.getParameter("number"));
	secret = (Integer)session.getAttribute("secret");
	if (n>secret){
		out.println("再小一點");
	}else if (n<secret){
		out.println("再大一點");
	}else{
		out.println("恭喜答對,祕密數字為"+secret);
	}
	
}else{
	Random r = new Random();
	secret = r.nextInt(10)+1;
	session.setAttribute("secret", secret);
}
%>
<%=n %> secret: <%=secret %> 

<form action="">
	<input type="text" name="number"/></br>
	<input type="submit" value="猜" />
</form>
</body>
</html>