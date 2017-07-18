package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;

import model.Cart;
import model.User;

public class CartServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         String ff=request.getParameter("flag");
         if("addCart".equals(ff)){
        	 //���빺�ﳵ
        	 addCart(request,response);
         }
         if("showCart".equals(ff)){
        	 //��ʾ����
        	 showCart(request,response);
         }
         if("delItem".equals(ff)){
        	 //ɾ����������
        	 delCartItem(request,response);
         }
	}


	
	private void delCartItem(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println("ɾ��������Ϣ----");*/
		//1.�����������cartid������ת��
		  String catid= request.getParameter("cartid");
		  int cartid=Integer.parseInt(catid);
		//2.����dao
		   CartDao dao=new CartDao();
		  boolean result= dao.delCartItem(cartid);
	   //3. ���ݽ����ҳ����ת��showCart.jsp
		  if(result){
			  /*System.out.println("ɾ���ɹ�----");*/
			  
			 request.setAttribute("msg","ɾ���ɹ���"); 
			 showCart(request,response);
			 /*request.getRequestDispatcher("showCart.jsp").forward(request, response);*/ 
		  }
	}


	private void showCart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//1.�����û�userid(��session��ȡ) 
		 User user=(User)request.getSession().getAttribute("user");
		 if(user!=null){
			 int uid=user.getUserid();
			    //2.ͨ��uid��ѯcart��
				  CartDao dao=new CartDao();
				 List<Cart> list= dao.showCartByUserid(uid);
				//3.ҳ��ת��
				 request.setAttribute("carList", list);
				 request.getRequestDispatcher("showCart.jsp").forward(request, response); 	 
		 }else{
			 request.setAttribute("carList", null);
			 request.getRequestDispatcher("showCart.jsp").forward(request, response); 	  
		 } 
		 
	}


	private void addCart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//1.�ж��û��Ƿ��¼
		 User user=(User)request.getSession().getAttribute("user");
		  if(user==null){
			  request.getRequestDispatcher("login.html").forward(request, response);
		  }else{
			  String gid=request.getParameter("gid");
			   int gid_=Integer.parseInt(gid);
			 //2.����dao�㣬��ӹ��ﳵ 
			  CartDao dao=new CartDao();
			 boolean result= dao.addCart(gid_,user.getUserid());
			 //3.���ݽ����Ӧ��ͬ��Ϣ
			 if(result){
				request.setAttribute("msg", "��ӳɹ���");
				showCart(request,response);
				/*request.getRequestDispatcher("home.jsp").forward(request, response);*/
			 }
		  }
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
