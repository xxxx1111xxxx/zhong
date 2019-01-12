<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>使用struts2标签</title>
  </head>
  
  <body>
    <h1><s:property value="message"/></h1><!-- 显示strutsTwo.action返回的message信息 -->
    <form action="strutsTestAction.action" method="post">
    	<input name="name" type="text"/><input type="submit" value="提交"/>
    </form>
  </body>
</html>
