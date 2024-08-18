package bo;

import bean.dangnhapbean;
import dao.dangnhapdao;

public class dangnhapbo {
	dangnhapdao dndao= new dangnhapdao();
	public dangnhapbean ktrDangNhap(String TenDangNhap, String MatKhau) throws Exception {
		return dndao.ktrDangNhap(TenDangNhap, MatKhau);
	}
	public long MaKhachhang(String usename,String pass) throws Exception{
		return dndao.MaKhachhang(usename, pass);
	}
}
