package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.dangnhapbean;

public class dangnhapdao {
	public dangnhapbean ktrDangNhap(String TenDangNhap, String MatKhau) throws Exception {
		dangnhapbean dn = null;
		//Ket noi vao CSDL
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		
		String sql = "select * from DangNhap where TenDangNhap = ? and MatKhau = ?";
		
		PreparedStatement cmd = ketnoidao.cn.prepareStatement(sql);
		
		cmd.setString(1, TenDangNhap);
		cmd.setString(2, MatKhau);
		ResultSet rs= cmd.executeQuery();
		
		if(rs.next()) {
			Boolean Quyen= rs.getBoolean("Quyen");
			dn= new dangnhapbean(TenDangNhap, MatKhau, Quyen);
		}
		cmd.close();
		rs.close();
		return dn;
	}
	public long MaKhachhang(String usename,String pass) throws Exception{
		long makh=0;
		String query = "select makh from KhachHang where tendn=? and pass=?";
		try {
			ketnoidao kn= new ketnoidao();
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(query);
			ps.setString(1, usename);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				makh= rs.getLong(1);
			}
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return makh;
	}
}
