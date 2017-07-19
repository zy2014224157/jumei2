<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="css/goods.css">
	-->
<link rel="stylesheet" type="text/css" href="css/goods.css">
  </head>
  
  <body>
  
   <c:if test="${not empty msg}">
       <script>
         alert("${msg}");
       </script>
   </c:if>
   	 <div class="header">
   	 <div class="header_top">
   	    <font>欢迎来到聚美！</font>
   	   <ul class="header_top" id="header_top">
            <li><a href="home.jsp" >订单查询</a></li>
              <li><a href="CartServlet?flag=showCart">购物车</a> <li>r
               <li><a href="register.html" >快速注册</a></li>
              <li>  <c:if test="${not empty sessionScope.user}">
     <span>  欢迎${sessionScope.user.username}</span>
     <span><a href="UserServlet?flag=logout">退出登录</a></span>
   </c:if>
  
  <c:if test="${empty sessionScope.user}">
    <span> <a href="login.html">请登录</a></span>
      
  </c:if></li> 
       </ul>
   	 </div>
   	 	 <div class="header_center">
   	    <div class="logo"><a href="home.jsp"><img src="images/logo.png"></a></div>
   	 

   	 </div>
   	 <br>
   <span style="font-size:100px,color:#E93274" >提交成功！</span>
    <span><a href="home.jsp">返回</a></span>
  </body>
</html>
