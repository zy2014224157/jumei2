<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	 <link rel="stylesheet"  href="css/commit_order.css">

  <script  src="js/jquery-1.8.0.js"></script>
  <script>
     $(function(){
       //window.location返回值是object
        var addr=window.location+"";
        var arr=addr.split("?");
        var prs=arr[1].split("&");// cids=1-2-3 ,total=704
        $("#cartids").val(prs[0].split("=")[1]);
        $("#money").val(prs[1].split("=")[1]);
     });
  </script>
  </head>
  <body>
 
 <form action="success.jsp" method="post">
  <a href="CartServlet?flag=showCart">返回</a> 
  <div class="cmit_top"></div>
<ul class="cmit">
<li class="cfirm">确认订单</li>
      <li><label for="telphone"> 电话</label>
      <input type="text" name="telphone">   </li>
       <li><label for="address">发货地址</label>
       <input type="text" name="address"> </li>
         <li> <label for="uname">收件人</label>
         <input type="text" name="uname" value="${sessionScope.user.username}" readonly> </li>     
           <li> <label for="money">   金额 </label>
           <input id="money" type="text" name="money" readonly></li></ul>
           <div class="anniu">
        <input type="hidden" id="cartids" name="cartids">        
        <input class="a" type="submit" value="提交订单">
          <input class="a" type="reset" value="取消">
          </div>
 
 </form>
  </body>
</html>
