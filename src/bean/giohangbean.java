package bean;

public class giohangbean {
	private String mahang;
	private String tenhang;
	private String DVT;
	private Long soluongmua;
	private Double gia;
	private Double thanhtien;
	private String anh;
	public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public giohangbean(String mahang, String tenhang, String dVT, Long soluongmua, Double gia, String anh) {
		super();
		this.mahang = mahang;
		this.tenhang = tenhang;
		DVT = dVT;
		this.soluongmua = soluongmua;
		this.gia = gia;
		this.anh = anh;
		this.thanhtien = gia*soluongmua;
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
	public String getDVT() {
		return DVT;
	}
	public void setDVT(String dVT) {
		DVT = dVT;
	}
	public Long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(Long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public Double getGia() {
		return gia;
	}
	public void setGia(Double gia) {
		this.gia = gia;
	}
	public Double getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(Double thanhtien) {
		this.thanhtien = gia*soluongmua;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	
	
	
	
}
