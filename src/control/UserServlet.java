package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

import model.User;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         String ff= request.getParameter("flag");
         if("checkUserName".equals(ff)){
        	 checkUserName(request,response);
         }
          
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       System.out.println("userservlet--post");
		//���������������
		request.setCharacterEncoding("utf-8");
		//��ȡflagֵȷ���û�����
		String f=request.getParameter("flag");
		if("register".equals(f)){
			System.out.println("ע�������");
			//ע��
			register(request,response);
		}
		if("login".equals(f)){
			System.out.println("��¼������");
			//��¼
			login(request,response);
		}
		
	}

	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.��ȡ�������
		String user=request.getParameter("uname");
		String psw=request.getParameter("pass");
		
		//2. ʵ����һ���û�����
		 User u=new User();
		 u.setUsername(user);
		 u.setPassword(psw);
		 
		//3.����dao��
		  UserDao dao=new UserDao();
		  boolean result=dao.register(u);
		//4. ��Ӧ��Ϣ
		  
		  if(result){
			 //����ת����
			 request.getRequestDispatcher("login.html").forward(request, response);
		  }else{
			  request.getRequestDispatcher("register.html").forward(request, response);  
		  }
		
	}	
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //1.��ȡ�������
		 String uname=request.getParameter("uname");
		 String psw=request.getParameter("pass");
	   // 2.����dao��
		 UserDao dao=new UserDao();
		 User user=dao.login(uname,psw);
	   //3.���ݽ����Ӧ��ͬ��Ϣ
		 if(user!=null){
			 //��¼�ɹ��������session��
			 request.getSession().setAttribute("user", user);
			 request.getRequestDispatcher("home.jsp").forward(request, response); 
		 }else{
			 request.getRequestDispatcher("login.html").forward(request, response); 
		 }
		
	}
	// ��֤�û����Ƿ��ظ�
	public void checkUserName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���get��������
		String user=request.getParameter("uname");
		user=new String(user.getBytes("iso-8859-1"),"utf-8");
		// ����dao��
		UserDao dao=new UserDao();
		boolean result=dao.checkUserName(user);
		PrintWriter  out=response.getWriter();
		
		if(!result){//û�鵽������
			out.print(1);
		}else{
			out.print(0);
		}
	}
	
}
