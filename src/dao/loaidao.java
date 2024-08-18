package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getloai() throws Exception {
		ArrayList<loaibean> ds= new ArrayList<loaibean>();
		//B1: Ket noi vao csdl		
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		//B2: Tao casu lenh sql
		String sql= "select * from loai";
		//B3: Tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//B4: Thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		//B5: Duyet rs de dua vao mang ds
		while(rs.next()) {
			String maloai= rs.getString("maloai");
			String tenloai= rs.getString("tenloai");
			String anh= rs.getString("anh");
			ds.add(new loaibean(maloai, tenloai, anh));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
}
