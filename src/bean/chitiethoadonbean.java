package bean;

public class chitiethoadonbean {
	private long macthd;
	private String mahang;
	private long slm;
	private long mahoadon;
	private boolean damua;
	public chitiethoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public chitiethoadonbean(long macthd, String mahang, long slm, long mahoadon, boolean damua) {
		super();
		this.macthd = macthd;
		this.mahang = mahang;
		this.slm = slm;
		this.mahoadon = mahoadon;
		this.damua = damua;
	}
	public long getMacthd() {
		return macthd;
	}
	public void setMacthd(long macthd) {
		this.macthd = macthd;
	}
	public String getMahang() {
		return mahang;
	}
	public void setMahang(String mahang) {
		this.mahang = mahang;
	}
	public long getSlm() {
		return slm;
	}
	public void setSlm(long slm) {
		this.slm = slm;
	}
	public long getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(long mahoadon) {
		this.mahoadon = mahoadon;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	
}
