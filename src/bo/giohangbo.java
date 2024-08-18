package bo;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	public ArrayList<giohangbean> Them(String mahang, String tenhang, String DVT, Long soluongmua, Double gia, String anh) throws Exception {
		int n= ds.size();
		for(int i=0; i<n; i++) {
			if(ds.get(i).getMahang().toLowerCase().trim().equals(mahang.toLowerCase().trim())) {
				long slm= ds.get(i).getSoluongmua() + soluongmua;
				ds.get(i).setSoluongmua(slm);
				Double g= ds.get(i).getGia();
				Double tt= slm*g;
				ds.get(i).setThanhtien(tt);
				return ds;
			}
		}
		ds.add(new giohangbean(mahang, tenhang, DVT, soluongmua, gia, anh));
		return ds;
	}
	public void Sua(String mahang, Long soluongmua) {
		int n= ds.size();
		for(int i=0; i<n; i++) {
			if(ds.get(i).getMahang().toLowerCase().trim().equals(mahang.toLowerCase().trim())) {
				long sls= soluongmua;
				ds.get(i).setSoluongmua(sls);
				Double g= ds.get(i).getGia();
				Double tt= sls*g;
				ds.get(i).setThanhtien(tt);
				return ;
			}
		}
	}
	public ArrayList<giohangbean> Xoa(String masach) throws Exception{
	     //Kiem tra trung ma
	     for(giohangbean gh:ds)
	         if(gh.getMahang().toLowerCase().trim().equals(masach.toLowerCase().trim())) {
	             ds.remove(gh);//Xoa trong bo nho: xoa trong mang
	             return ds;
	         }
	     return ds;
	 }
	public ArrayList<giohangbean> XoaCheckBox(String[] check) throws Exception{
	     //Kiem tra trung ma
	     for(giohangbean gh:ds) {
	    	 if(check != null) {
	    		 ds.remove(gh);//Xoa trong bo nho: xoa trong mang
	    		 return ds;
	    	 }
	     }
	     return ds;
	 }
	public int resize() throws Exception{
	     //Kiem tra trung ma
		int n =ds.size();
	    return n;
	 }
	
	public ArrayList<giohangbean> XoaAll() throws Exception{
	     //Kiem tra trung ma
	    	ds.clear();
	         
	     return ds;
	 }
	
	public Double Tongtien() {
		Double s = 0.0;
		for(giohangbean gh:ds)
			s = s + gh.getThanhtien();
	    return s;
	}
}
