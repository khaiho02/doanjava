package main1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Nguoi {
    public static SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    private String hoVaTen;
    private Date ngaySinh;
    private String soDienThoai;
    private String gioiTinh;
    private int maSo;

    public Nguoi() {
    }

    public Nguoi(String hoVaTen, String ngaySinh, String soDienThoai, String gioiTinh) throws ParseException {
        this.hoVaTen = hoVaTen;
        this.ngaySinh = F.parse(ngaySinh);
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
        //.maSo = maSo;
    }
    public Nguoi(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) throws ParseException {
        this.ngaySinh = F.parse(ngaySinh);
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getMaSo() {
        return maSo;
    }

    public void setMaSo(int maSo) {
        this.maSo = maSo;
    }
}

