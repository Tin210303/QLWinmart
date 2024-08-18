package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.hangbean;
import bean.loaibean;
import bean.sanphambean;

public class sanphamdao {
	public ArrayList<sanphambean> getsanpham() throws Exception {
		ArrayList<sanphambean> ds= new ArrayList<sanphambean>();
		//B1: Ket noi vao csdl		
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		//B2: Tao casu lenh sql
		String sql= "select * from sanpham";
		//B3: Tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//B4: Thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		//B5: Duyet rs de dua vao mang ds
		while(rs.next()) {
			String masp= rs.getString("masp");
			String tensp= rs.getString("tensp");
			String maloai= rs.getString("maloai");
			ds.add(new sanphambean(masp, tensp, maloai));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	
	public ArrayList<sanphambean> timSPtheoMaLoai(String ml) throws Exception {
		ArrayList<sanphambean> ds= new ArrayList<sanphambean>();
		//String masach, String tensach, String tacgia, Long soluong, Long gia, String anh, String maloai
		//B1: Ket noi vao csdl		
				ketnoidao kn= new ketnoidao();
				kn.ketnoi();
				//B2: Tao casu lenh sql
				String sql= "select * from sanpham where maloai = ?";
				//B3: Tao cau lenh
				PreparedStatement cmd= kn.cn.prepareStatement(sql);
				cmd.setString(1, ml);
				//B4: Thuc hien cau lenh
				ResultSet rs= cmd.executeQuery();
				//B5: Duyet rs de dua vao mang ds
				while(rs.next()) {
					String masp= rs.getString("masp");
					String tensp= rs.getString("tensp");
					String maloai= rs.getString("maloai");
					ds.add(new sanphambean(masp, tensp, maloai));
				}
				rs.close();
				kn.cn.close();
		return ds;
	}
	
	
}
