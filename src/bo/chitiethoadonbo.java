package bo;

import dao.chitiethoadondao;

public class chitiethoadonbo {
	chitiethoadondao ctdao= new chitiethoadondao();
	public int themChiTietHD(String mh ,long slm, long mahd) throws Exception {
		int kq= 0;
		kq= ctdao.themChiTietHD(mh, slm, mahd);
		return kq;
	}
}
