package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.hoadonbean;


public class hoadondao {
	public int themhoadon(long makh) throws Exception {
        ketnoidao kn = new ketnoidao();
        kn.ketnoi();
        String sql ="insert into hoadon(makh,NgayMua,damua) values(?,?,0)";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setLong(1, makh);
        Date n1 = new Date(); // lay ngay trong may ra 
        SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
        String tam = dd.format(n1); // doi ngay ra chuoi
        Date n2 = dd.parse(tam);// doi chuoi ra ngay ulti
        cmd.setDate(2, new java.sql.Date(n2.getTime()));// doi ngay ulti ra ngay sql
        int kq = cmd.executeUpdate();
        cmd.close();
        kn.cn.close();
        return kq;
    }
    public long  maxhd() throws Exception {
    	ketnoidao kn = new ketnoidao();
        kn.ketnoi();
        String sql = "select max(MaHoaDon) as maxhd from hoadon";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        ResultSet rs = cmd.executeQuery();
        long max = 0;
        if(rs.next()) {
            max = rs.getLong("maxhd");
        }
        rs.close();
        kn.cn.close();
        return max;
    }
    public ArrayList<hoadonbean> gethoadon(long makh) throws Exception {
    	ArrayList<hoadonbean> ds = new ArrayList<hoadonbean>();
    	ketnoidao kn = new ketnoidao();
        kn.ketnoi();
        String sql = "select * from hoadon where makh = ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setLong(1, makh);
        ResultSet rs = cmd.executeQuery();
        while(rs.next()) {
           long mahd = rs.getLong("MaHoaDon");
           Date ngaymua = rs.getDate("Ngaymua");
           boolean damua = rs.getBoolean("damua") ;
           ds.add(new hoadonbean(mahd, makh, ngaymua, damua));
        }
        rs.close();
        kn.cn.close();
        return ds;
    }
}
