package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import util.DBUtil;
import model.Catalog;
import model.Goods;

public class CatalogDao {
   //��ѯ���з���
	public List<Catalog> getCatalogs(){
	 List<Catalog> list=new ArrayList<Catalog>();
	 Connection con=null;
	 PreparedStatement pst=null;
	 ResultSet rs=null;
	 Catalog cg=null;
	 try{
		con=DBUtil.getCon();
		String sql="select * from catalog";
		pst=con.prepareStatement(sql);
		rs=pst.executeQuery();
		while(rs.next()){
			cg=new Catalog();
			cg.setCatalogid(rs.getInt("catalogid"));
			cg.setCatalogname(rs.getString("catalogname"));
			
			list.add(cg);
		}
	 }catch(Exception e){
		e.printStackTrace(); 
	 }finally{
		 DBUtil.closeAll(con, rs, pst);
	 }
	 return list;	
	}
// ͨ��cid��ѯ��Ʒ�б�
	public List<Goods> getGoodsBycid(int cid) {
		List<Goods> list=new ArrayList<Goods>();
		 Goods goods=null;
		 Connection con=null;
		 PreparedStatement pst=null;
		 ResultSet rs=null;
		 try{
			con=DBUtil.getCon();
			String sql="select * from meizhuang where catalogid=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1, cid);
			rs=pst.executeQuery();
			while(rs.next()){
				goods=new Goods();
				goods.setCatalogid(cid);
				goods.setGoodsname(rs.getString("meizhuangname"));
				goods.setGoodsid(rs.getInt("meizhuangid"));
				goods.setPicture(rs.getString("picture"));
				goods.setPrice(rs.getFloat("price"));

				list.add(goods);
			}
		 }catch(Exception e){
			e.printStackTrace(); 
		 }finally{
			 DBUtil.closeAll(con, rs, pst);
		 }
		 return list;
	}
}
