package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;

import model.Order;
import model.User;

public class OrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //1.�����������
		 request.setCharacterEncoding("utf-8");
		 String ff=request.getParameter("flag");
		 if("gomai".equals(ff)){
			 //�¶���
			 gomai(request,response);
		 }
		
	}

	private void gomai(HttpServletRequest request, HttpServletResponse response) {
		//1. �����������
		 String tel=request.getParameter("telphone");
		 String addr=request.getParameter("address");
		 User user=(User)request.getSession().getAttribute("user");
	     int uid=0;
		 if(user!=null){
			 uid=user.getUserid(); 
	     }
		String m=request.getParameter("money");
		float money=Float.parseFloat(m);
		String cids=request.getParameter("cartids");//32,37,38,39
		
	  // ��װOrder ����
		 Order order=new Order();
		 order.setUserid(uid);
		 order.setAddress(addr);
		 order.setTelphone(tel);
		 order.setTotalmoney(money);
		 
		 Timestamp time=new Timestamp(new Date().getTime());
		 order.setSubtime(time);
	 //2. ����dao
		 OrderDao dao=new OrderDao();
		 boolean result= dao.gomai(order,cids);
		
		 
	
	}

}
