package bo;

import dao.hoadondao;

public class hoadonbo {
	hoadondao hddao= new hoadondao();
	public int themhoadon(long makh) throws Exception {
		int kq= 0;
		kq= hddao.themhoadon(makh);
		return kq;
	}
	public long maxhd() throws Exception {
		long max= 0;
		max= hddao.maxhd();
		return max;
	}
}
