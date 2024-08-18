package bean;

public class hangbean {
	private String mahang;
	private String tenhang;
	private long soluong;
	private double gia;
	private String maloai;
	private String anh;
	private String DVT;
	private String masp;
	public hangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hangbean(String mahang, String tenhang, long soluong, double gia, String maloai, String anh, String dVT,
			String masp) {
		super();
		this.mahang = mahang;
		this.tenhang = tenhang;
		this.soluong = soluong;
		this.gia = gia;
		this.maloai = maloai;
		this.anh = anh;
		DVT = dVT;
		this.masp = masp;
	}
	public String getMahang() {
		return mahang;
	}
	public void setMahang(String mahang) {
		this.mahang = mahang;
	}
	public String getTenhang() {
		return tenhang;
	}
	public void setTenhang(String tenhang) {
		this.tenhang = tenhang;
	}
	public long getSoluong() {
		return soluong;
	}
	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getDVT() {
		return DVT;
	}
	public void setDVT(String dVT) {
		DVT = dVT;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	
}
