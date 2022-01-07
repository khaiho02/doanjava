package main2;

import main1.KhachHang;
import main1.NhanVienBanHang;
import main3.QuanLiSanPham;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class HoaDon {
    public static SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    private Date ngayLapHoaDon;
    private String tenKhachHang;
    private String nhanVienLapHoaDon;
    private static int count = 0;
    private int maHoaDon;
    private double tongTien;
    private String[] maSanPham;
    private int sl;


    public HoaDon() {
    }

    public HoaDon(String ngayLapHoaDon, String tenKhachHang, String nhanVienLapHoaDon,
                  double tongTien, String[] sanPham) throws ParseException {
        this.ngayLapHoaDon = F.parse(ngayLapHoaDon);
        this.tenKhachHang = tenKhachHang;
        this.nhanVienLapHoaDon = nhanVienLapHoaDon;
        this.tongTien = tongTien;
        this.maSanPham = sanPham;
        this.maHoaDon = ++count;
    }

    public HoaDon(String ngayLapHoaDon, String tenKhachHang, String nhanVienLapHoaDon,
                  String[] sanPham, int sl) throws ParseException {
        this.ngayLapHoaDon = F.parse(ngayLapHoaDon);
        this.tenKhachHang = tenKhachHang;
        this.nhanVienLapHoaDon = nhanVienLapHoaDon;
        this.maSanPham = sanPham;
        this.sl = sl;
    }


    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(String ngayLapHoaDon) throws ParseException {
        this.ngayLapHoaDon = F.parse(ngayLapHoaDon);
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String khachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getNhanVienLapHoaDon() {
        return nhanVienLapHoaDon;
    }

    public void setNhanVienLapHoaDon(String nhanVienLapHoaDon) {
        this.nhanVienLapHoaDon = nhanVienLapHoaDon;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String[] getMaSanPham() {
        return maSanPham;
    }

    public void setSanPham(String[] sanPham) {
        this.maSanPham = sanPham;
    }

    public double xuatHoaDon(QuanLiSanPham listSP) {
        System.out.println("Tên khách hàng: " + this.tenKhachHang);
        System.out.println("Ngày lập hoá đơn: " + F.format(this.ngayLapHoaDon));
        System.out.println("Tên nhân viên lập hoá đơn: " + this.nhanVienLapHoaDon);
        System.out.println("Danh sách sản phẩm mua");

        for (int i = 0; i < sl; i++) {
            for (SanPham x : listSP.getDanhSachSanPham()) {
                if (this.maSanPham[i].equals(x.getMaSanPham())) {
                    System.out.printf("|%-40s|%15.2f|", x.getTenSanPham(), x.getGiaBan());
                    System.out.println();
                    tongTien += x.getGiaBan();
                    break;
                }

            }
        }

        System.out.println("Tổng cộng: " + tongTien);
        return tongTien;

    }

    @Override
    public String toString() {
        String spp = "";
        for (int i = 0; i < maSanPham.length - 2; i++) {
            spp += maSanPham[i] + ", ";
        }
        spp += maSanPham[maSanPham.length - 1];
        return this.maHoaDon + "\n" + F.format(this.ngayLapHoaDon) + "\n" + this.tenKhachHang + "\n" +
                this.nhanVienLapHoaDon + "\n" + this.tongTien + "\n" + spp;
    }
}