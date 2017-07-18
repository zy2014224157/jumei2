package dao;

import java.sql.*;

import util.DBUtil;

import model.User;

public class UserDao {
  // ��¼���鿴���ݿ���û�и��û���
   public User login(String uname, String psw) {
	 User user=null;
	 Connection con=null;
	 PreparedStatement st=null; 
	 ResultSet rs=null;
	  try{
		  //1.�������ݿ�
		  con= DBUtil.getCon();
		  String sql="select * from user where username=? and password=?";
		 //2 ����prepareStatement����
		  st=con.prepareStatement(sql);
		  st.setString(1,uname);
		  st.setString(2, psw);
		// 3.ִ��sql
		  rs=st.executeQuery();
		//4.������
		  if(rs.next()){
			  user=new User();
			  user.setUserid(rs.getInt("userid"));
			  user.setUsername(uname);
			  user.setPassword(psw);
			  user.setRole(rs.getString("role"));
		  }  
	  }catch(Exception e){
		 e.printStackTrace(); //��ӡ�쳣��ջ��Ϣ
		  System.out.println(e.getMessage());
	  }finally{
		  //�ͷ���Դ
		  DBUtil.closeAll(con, rs, st);
	  }
	  return user;
  }
  // ע�ᣨuser��insert ��Ϣ��	
   public boolean register(User user){
	   Connection con=null;
	   PreparedStatement st=null;
	   boolean result=false;//ִ�н��
	   try{
	   //1.�������ݿ�
	    con=DBUtil.getCon();
	   //2.sql���
	    String sql="insert into user(username,password,role) values(?,?,?)";
	   //3. ����statement����
	      st= con.prepareStatement(sql);
	    st.setString(1, user.getUsername());
	    st.setString(2,user.getPassword());
	    st.setString(3, "customer");
	   //4.ִ��sql
	    st.execute();
	    result=true;
	  }catch(Exception e){
		  System.out.println(e.getMessage());
	  }finally{//�ͷ���Դ
		  DBUtil.closeAll(con, null, st);
	  }
	   return result;
   }
  
//��ѯ�û����Ƿ��ظ�   
public boolean checkUserName(String user) {
	boolean result=false;
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	try{
		  //1.�������ݿ�
		  con= DBUtil.getCon();
		  String sql="select * from user where username=?";
		 //2 ����prepareStatement����
		  pst=con.prepareStatement(sql);
		  pst.setString(1,user);
		// 3.ִ��sql
		  rs=pst.executeQuery();
		//4 ��������
		  if(rs.next()){
			  result=true;
		  }
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		DBUtil.closeAll(con, rs, pst);
	}
	return result;
}


//�޸�����	
  // ��������ַ	

}
