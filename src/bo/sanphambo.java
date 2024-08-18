package bo;

import java.util.ArrayList;

import bean.sanphambean;
import dao.sanphamdao;

public class sanphambo {
	sanphamdao spdao= new sanphamdao();
	public ArrayList<sanphambean> getsanpham() throws Exception {
		return spdao.getsanpham();
	}
	public ArrayList<sanphambean> timSPtheoMaLoai(String ml) throws Exception {
		return spdao.timSPtheoMaLoai(ml);
	}
}
