<%@ page language="java" import="java.util.*,model.*,dao.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'home.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link rel="stylesheet" href="css/style_home.css">
	<script type="text/javascript" src="js/jquery-1.8.0.js"></script>

  </head>
   <script>
  $(function(){
   $(".circle li").eq(0).css({background:"orange"});
    
     var i=0;// 当前图片下标     
     //自定义函数 ：轮播图片
     function lunbo(){
      if(i>=5){
        i=0;
      }
       $(".pic").animate({left:-1583*i},1000);
       $(".circle li").eq(i).css({background:"orange"});
        $(".circle li").eq(i).siblings().css({background:"rgba(0,0,0,0.6)"});
       i++;
     }
    
      var tt=setInterval(lunbo,1000);
      
      $(".site_body").mouseenter(function(){//光标进入
        clearInterval(tt);
      }).mouseleave(function(){// 光标移开
        tt=setInterval(lunbo,2000);
      }); 
      
     // 点击小圆点改变大图
     $(".circle li").click(function(){
         var currentIndex= $(this).index();
         $(this).css({background:"orange"});
         $(this).siblings().css({background:"rgba(0,0,0,0.6)"});  
         
         i=currentIndex;
         $(".pic").animate({left:-1583*i},500);
         
     });
     
  });
  

</script>  
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
   </c:if>
  
  <c:if test="${empty sessionScope.user}">
    <span> <a href="login.html">请登录</a></span>
  </c:if></li> 
       </ul>
   	 </div>
   	 
   	 <div class="header_center">
   	    <div class="logo"><a href="home.jsp"><img src="images/logo.png"></a></div>
   	    <div class="search"> 
      <form action="GoodsServlet">
      <input type="hidden" name="flag" value="search">
      <input type="text" name="seach_key" placeholder="要查询的产品">
      <input type="submit" value="搜索">
  </form>
 </div> 

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
   </div>
    <div class="site_body">
    	<ul class="pic">
    		<li><a href="home.jsp" target="_parent"><img src="images/body.png"></a></li>
    		<li><a href="home.jsp" target="_parent"><img src="images/body1.png"></a></li>
    		<li><a href="home.jsp" target="_parent"><img src="images/body2.png"></a></li>
    		<li><a href="home.jsp" target="_parent"><img src="images/body4.png"></a></li>
    		<li><a href="home.jsp" target="_parent"><img src="images/body5.png"></a></li>
    	</ul>
    	<ul class="circle">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
         </ul>
    </div>
      <div class="site_part">
      <div class="a">
       <div class="parta_left"> <a href="#" target="_blank"><img src="images/face.png"></a></div>
       <div class="parta_right"><a href="#" target="_blank"><img src="images/face1.png"></a> </div>
      </div>
      
       <div class="b">
       <div class="partb_left"> <a href="#" target="_blank"><img src="images/face2.png"></a></div>
       <div class="partb_right"> <a href="#" target="_blank"><img src="images/face3.png"></a></div>
       </div>
      
      </div>
  </body>
</html>
