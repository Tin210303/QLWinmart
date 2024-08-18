package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.khachhangbean;

public class khachhangdao {
	public khachhangbean ktdn (String tendn, String pass)throws Exception{
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		String sql="select * from KhachHang where tendn=? and pass=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tendn);
		cmd.setString(2, pass);
		ResultSet rs = cmd.executeQuery();
		khachhangbean kh = null;
		if(rs.next()) {
			long makh = rs.getLong("makh");
			String hoten = rs.getString("hoten");
			String diachi = rs.getString("diachi");
			String sodt = rs.getString("sdt");
			String email = rs.getString("email");
			kh = new khachhangbean(makh, hoten, diachi, sodt, email, tendn, pass);
		}
		return kh;
	}
	public int KhachHang(String hoten, String diachi, String sodt, String email, String tendn, String pass) throws Exception {
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		
		String sql= "insert into KhachHang(hoten,diachi,sdt,email,tendn,pass) values(?,?,?,?,?,?)";
		
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, hoten);
		cmd.setString(2, diachi);
		cmd.setString(3, sodt);
		cmd.setString(4, email);
		cmd.setString(5, tendn);
		cmd.setString(6, pass);
		
		int kq= cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
