<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String url = request.getRequestURL().toString();
	url = url.substring(0, url.indexOf('/', url.indexOf("//") + 2));
	String context = request.getContextPath();
	url += context;
	application.setAttribute("ctx", url);
	
%>
<!DOCTYPE HTML>
<html>

<body>
  <form action="<%=url%>/login/login">
      <input type="text" name="username"/>
       <input type="password" name="password"/>
        <input type="submit" value="tijiao"/>
  </form>
  <p></p>
</body>
</html>
