package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Goods;

import dao.CatalogDao;
import dao.GoodsDao;

public class GoodsServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		//get  
	
		String ff=request.getParameter("flag");
		if("getGoodsBycId".equals(ff)){
			//ͨ������id��ѯ��Ʒ
			getGoodsBycId(request,response);
		}
		if("search".equals(ff)){
			//ͨ���ؼ��ֲ�ѯ��Ʒ
			searchBystr(request,response);
		}
	}

	private void searchBystr(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//1.�����������--��ѯ�ؼ���
		  String str=request.getParameter("seach_key");
		   str=new String(str.getBytes("iso-8859-1"),"utf-8");
		   //2.����dao��
		  GoodsDao dao=new GoodsDao();
		  List<Goods> list=dao.getGoodsBystr(str) ; 
		  System.out.println(list.size()+"��Ʒ����---");
		  // 3.����ѯ�Ĳ�Ʒ�б�����request��
		  request.setAttribute("goodsList", list);
		  request.getRequestDispatcher("goods.jsp").forward(request, response);
		
	}

	private void getGoodsBycId(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	  //1. ��ȡ�������������
		String id=request.getParameter("cid");
		// ���ַ���ת��������
		int cid= Integer.parseInt(id);
	 //2. ����dao
		 CatalogDao dao=new CatalogDao();
	    List<Goods>	list= dao.getGoodsBycid(cid);
	 // 3.list���request��ת����jspҳ����ʾ	
	    if(list!=null){
	    	request.setAttribute("goodsList", list);
	    	request.getRequestDispatcher("goods.jsp").forward(request, response);
	    }
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
