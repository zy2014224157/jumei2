<%@ page language="java" import="java.util.*,dao.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>聚美-【极速免税店】</title> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet"  href="css/goods.css">
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
              <li><a href="CartServlet?flag=showCart">购物车</a> <li>
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
   	 
   	 	 <div class="header_bottom">

  <% CatalogDao dao=new CatalogDao();
     request.setAttribute("catalogList" ,dao.getCatalogs());
  %>
  
  <ul class="hb">
   <li class="home"><a href="home.jsp">首页</a></li>
   <c:forEach var="catalog" items="${catalogList}" >
      <li><a href="GoodsServlet?cid=${catalog.catalogid}&flag=getGoodsBycId">${catalog.catalogname} </a></li>
   </c:forEach>
  </ul>  
   </div>
   	 
  <div class="back_top"></div>
     <c:if test="${empty goodsList}">
                  未搜索到符合要求的产品
     </c:if>
     <c:if test="${not empty goodsList}">
         <ul class="goods_list">
		       <c:forEach var="goods" items="${goodsList}">
		      <li>
		         <div class="mask">
		             <span class="fz">商品名：${goods.goodsname}</span>
		         </div>
		          <img src="images/${goods.picture }"><br>
		          <br>
		          <br>
		          <br>
		          <span>￥：${goods.price }</span>
		             <br>
		          <button><a href="CartServlet?gid=${goods.goodsid }&flag=addCart">加入购物车</a></button>
		      </li>                  
		       </c:forEach>
		  </ul>        
     </c:if>
  </body>
</html>
