package bo;

import bean.khachhangbean;
import dao.khachhangdao;

public class khachhangbo {
	khachhangdao khdao= new khachhangdao();
	public khachhangbean ktdn (String tendn, String pass)throws Exception{
		return khdao.ktdn(tendn, pass);
	}
	public int KhachHang(String hoten, String diachi, String sodt, String email, String tendn, String pass) throws Exception {
		return khdao.KhachHang(hoten, diachi, sodt, email, tendn, pass);
	}
}
