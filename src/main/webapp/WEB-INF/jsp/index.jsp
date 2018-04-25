<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
%>
<!DOCTYPE HTML>
<html>

<body>
  <form action="<%=basePath%>/login/login">
      <input type="text" name="username"/>
       <input type="password" name="password"/>
        <input type="submit" value="tijiao"/>
  </form>
  <p></p>
</body>
</html>
