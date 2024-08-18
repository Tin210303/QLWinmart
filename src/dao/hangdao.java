package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.hangbean;

public class hangdao {
	public ArrayList<hangbean> gethang() throws Exception {
		ArrayList<hangbean> ds= new ArrayList<hangbean>();
		//B1: Ket noi vao csdl		
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		//B2: Tao casu lenh sql
		String sql= "select * from hang";
		//B3: Tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//B4: Thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		//B5: Duyet rs de dua vao mang ds
		while(rs.next()) {
			String mahang= rs.getString("mahang");
			String tenhang= rs.getString("tenhang");
			long soluong= rs.getLong("soluong");
			double gia= rs.getDouble("gia");
			String maloai= rs.getString("maloai");
			String anh= rs.getString("anh");
			String DVT= rs.getString("DVT");
			String masp= rs.getString("masp");
			ds.add(new hangbean(mahang, tenhang, soluong, gia, maloai, anh, DVT, masp));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	public ArrayList<hangbean> timhangtheomasp(String msp) throws Exception {
		ArrayList<hangbean> ds= new ArrayList<hangbean>();	
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		//B2: Tao casu lenh sql
		String sql= "select * from hang where masp = ?";
		//B3: Tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, msp);
		//B4: Thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		//B5: Duyet rs de dua vao mang ds
		while(rs.next()) {
			String mahang= rs.getString("mahang");
			String tenhang= rs.getString("tenhang");
			long soluong= rs.getLong("soluong");
			double gia= rs.getDouble("gia");
			String maloai= rs.getString("maloai");
			String anh= rs.getString("anh");
			String DVT= rs.getString("DVT");
			String masp= rs.getString("masp");
			ds.add(new hangbean(mahang, tenhang, soluong, gia, maloai, anh, DVT, masp));
			
		}
		rs.close();
		kn.cn.close();
		return ds;
}
	public ArrayList<hangbean> timhangtheoten(String th) throws Exception {
		ArrayList<hangbean> ds= new ArrayList<hangbean>();	
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		//B2: Tao casu lenh sql
		String sql= "select * from hang where tenhang like ?";
		//B3: Tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, "%"+th+"%");
		//B4: Thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		//B5: Duyet rs de dua vao mang ds
		while(rs.next()) {
			String mahang= rs.getString("mahang");
			String tenhang= rs.getString("tenhang");
			long soluong= rs.getLong("soluong");
			double gia= rs.getDouble("gia");
			String maloai= rs.getString("maloai");
			String anh= rs.getString("anh");
			String DVT= rs.getString("DVT");
			String masp= rs.getString("masp");
			ds.add(new hangbean(mahang, tenhang, soluong, gia, maloai, anh, DVT, masp));
			
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
}
