package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import model.Goods;

public class GoodsDao {

	public List<Goods> getGoodsBystr(String str) {
		List<Goods> list=new ArrayList<Goods>();
		 Goods goods=null;
		 Connection con=null;
		 PreparedStatement pst=null;
		 ResultSet rs=null;
		 try{
			con=DBUtil.getCon();
			// Ä£ºý²éÑ¯ like  
			String sql="select * from meizhuang where meizhuangname like ? ";
			pst=con.prepareStatement(sql);
			pst.setString(1, "%"+str+"%");
			rs=pst.executeQuery();
			while(rs.next()){
				goods=new Goods();
				goods.setCatalogid(rs.getInt("catalogid"));
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
