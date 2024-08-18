package bo;

import dao.ketnoidao;

public class ketnoibo {
	ketnoidao kn= new ketnoidao();
	public void ketnoi(String server, String db, String un, String pass) throws Exception {
		kn.ketnoi(server, db, un, pass);
	}
}
