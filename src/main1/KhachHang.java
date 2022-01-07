package main1;

import main2.HoaDon;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class KhachHang extends Nguoi{

    private Date ngayMuaHang;
    private HoaDon hoaDon;
    private double diemTichLuy;
    private String loaiKhachHang;
    private static int dem = 0;


    public KhachHang(String hoVaTen, String ngaySinh, String soDienThoai, String gioiTinh, String ngayMuaHang,
                     String loaiKhachHang) throws ParseException {
        super(hoVaTen, ngaySinh, soDienThoai, gioiTinh);
        this.ngayMuaHang = F.parse(ngayMuaHang);
        this.loaiKhachHang = loaiKhachHang;
    }

    public KhachHang(String hoVaTen, String ngaySinh, String soDienThoai, String gioiTinh, String ngayMuaHang,
                     String loaiKhachHang, double diemTichLuy) throws ParseException {
        super(hoVaTen, ngaySinh, soDienThoai, gioiTinh);
        this.ngayMuaHang = F.parse(ngayMuaHang);
        this.loaiKhachHang = loaiKhachHang;
        this.diemTichLuy = diemTichLuy;
    }


    public KhachHang(String hoVaTen){
        super(hoVaTen);
    }


    public KhachHang() {
        this.setMaSo(++dem);
    }


    public Date getNgayMuaHang() {
        return ngayMuaHang;
    }

    public void setNgayMuaHang(String ngayMuaHang) throws ParseException {
        this.ngayMuaHang = F.parse(ngayMuaHang);
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public double getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(double diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public String getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(String loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    @Override
    public String getHoVaTen() {
        return super.getHoVaTen();
    }

    @Override
    public void setHoVaTen(String hoVaTen) {
        super.setHoVaTen(hoVaTen);
    }

    @Override
    public Date getNgaySinh() {
        return super.getNgaySinh();
    }

    @Override
    public void setNgaySinh(String ngaySinh) throws ParseException {
        super.setNgaySinh(ngaySinh);
    }

    @Override
    public String getSoDienThoai() {
        return super.getSoDienThoai();
    }

    @Override
    public void setSoDienThoai(String soDienThoai) {
        super.setSoDienThoai(soDienThoai);
    }

    @Override
    public String getGioiTinh() {
        return super.getGioiTinh();
    }

    @Override
    public void setGioiTinh(String gioiTinh) {
        super.setGioiTinh(gioiTinh);
    }

    @Override
    public int getMaSo() {
        return super.getMaSo();
    }

    @Override
    public void setMaSo(int maSo) {
        super.setMaSo(maSo);
    }

    @Override
    public String toString() {
        return this.getMaSo() + ", " + this.getHoVaTen() + ", " + F.format(this.getNgaySinh()) + ", " +
                this.getSoDienThoai() + ", " + this.getGioiTinh() + ", " + F.format(this.ngayMuaHang)
                + ", " + this.getLoaiKhachHang() + ", " + this.getDiemTichLuy() ;

    }
    public void hienThi() {
        System.out.printf("|%-4d|%-20s|%-13s|%-15s|%15.2f|%-8s|", this.getMaSo(), this.getHoVaTen(),
                F.format(this.getNgaySinh()), this.getSoDienThoai(), this.getDiemTichLuy(), this.getLoaiKhachHang());
    }
    public int soSanh(KhachHang KH) {
        return this.diemTichLuy < KH.diemTichLuy ? 1 : (diemTichLuy > KH.diemTichLuy ? -1 : 0);
    }
    public void suaThongTin() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập họ và tên: "); String ht = sc.nextLine();
        System.out.print("Nhập số điện thoại: "); String sdt = sc.nextLine();
        System.out.print("Nhập ngày sinh (theo định dạng dd/MM/yyyy): "); String ns = sc.nextLine();
        System.out.print("Nhâp ngày đăng kí VIP: "); String ndki = sc.nextLine();
        this.setNgaySinh(ns);
        this.setHoVaTen(ht);
        this.setSoDienThoai(sdt);
        this.setNgayMuaHang(ndki);


    }

}
