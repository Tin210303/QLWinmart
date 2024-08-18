package bo;

import java.util.ArrayList;

import bean.hangbean;
import dao.hangdao;

public class hangbo {
	hangdao hdao= new hangdao();
	public ArrayList<hangbean> gethang() throws Exception {
		return hdao.gethang();
	}
	public ArrayList<hangbean> timhangtheomasp(String msp) throws Exception {
		return hdao.timhangtheomasp(msp);
	}
	public ArrayList<hangbean> timhangtheoten(String th) throws Exception {
		return hdao.timhangtheoten(th);
	}
}
