package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.chitiethoadonbean;

public class chitiethoadondao {
	public int themChiTietHD(String mh ,long slm, long mahd) throws Exception {
		ketnoidao kn = new ketnoidao();
        kn.ketnoi();
        String sql ="insert into ChiTietHoaDon(MaHang,SoLuongMua,MaHoaDon,damua) values(?,?,?,0)";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setString(1,mh);
        cmd.setLong(2, slm);
        cmd.setLong(3, mahd);
        int kq = cmd.executeUpdate();
        cmd.close();
        kn.cn.close();
        return kq;
    }
	public ArrayList<chitiethoadonbean>	 getchitiet(long mahd) throws Exception {
		ArrayList<chitiethoadonbean> ds = new ArrayList<chitiethoadonbean>();
		ketnoidao kn = new ketnoidao();
        kn.ketnoi();
        String sql ="select * from ChiTietHoaDon where MaHoaDon = ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setLong(1, mahd);
        ResultSet rs = cmd.executeQuery();
        while(rs.next()) {
        	long mact = rs.getLong("MaChiTietHD");
        	String mahang =  rs.getString("MaHang");
        	long solm = rs.getLong("SoLuongMua");
        	long mahd2 =  rs.getLong("MaHoaDon");
        	boolean damua = rs.getBoolean("damua");
        	ds.add(new chitiethoadonbean(mact, mahang, solm, mahd2, damua) );
        }
        cmd.close();
        kn.cn.close();
        return ds; 
	}
}
