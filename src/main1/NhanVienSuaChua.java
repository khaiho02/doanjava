package main1;

import main2.HoaDon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class NhanVienSuaChua extends Nguoi{
    private static final double TIEN_LUONG_LAM_VIEC_1_NGAY_NHAN_VIEN_BAN_HANG = 145_000;
    private static int dem = 0;
    private String soCCD;
    private String diaChi;
    private int soNgayLamViec;

    public NhanVienSuaChua(String hoVaTen, String ngaySinh, String soDienThoai, String gioiTinh,
                           String soCCD, String diaChi) throws ParseException {
        super(hoVaTen, ngaySinh, soDienThoai, gioiTinh);
        this.soCCD = soCCD;
        this.diaChi = diaChi;
        this.setMaSo(++dem);
    }

    public NhanVienSuaChua(String soCCD, String diaChi, int soNgayLamViec) {
        this.soCCD = soCCD;
        this.diaChi = diaChi;
        this.soNgayLamViec = soNgayLamViec;
    }


    public NhanVienSuaChua(String hoVaTen, String ngaySinh, String soDienThoai, String gioiTinh, String soCCD, String diaChi, int soNgayLamViec) throws ParseException {
        super(hoVaTen, ngaySinh, soDienThoai, gioiTinh);
        this.soCCD = soCCD;
        this.diaChi = diaChi;
        this.soNgayLamViec = soNgayLamViec;
    }

    public NhanVienSuaChua(String hoVaTen, String soCCD, String diaChi, int soNgayLamViec) {
        super(hoVaTen);
        this.soCCD = soCCD;
        this.diaChi = diaChi;
        this.soNgayLamViec = soNgayLamViec;
    }

    public NhanVienSuaChua(String hoVaTen) {
        super(hoVaTen);
    }

    public String getSoCCD() {
        return soCCD;
    }

    public void setSoCCD(String soCCD) {
        this.soCCD = soCCD;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
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

    public void suaThongTin() throws ParseException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhâp họ và tên: ");   String hoVaTen = sc.nextLine();
        System.out.print("Nhâp ngày sinh: ");   String ngaySinh = sc.nextLine();
        System.out.print("Nhâp số điện thoại: ");   String soDienThoai = sc.nextLine();
        System.out.print("Nhâp giới tính: ");   String gioiTinh = sc.nextLine();
        System.out.print("Nhâp mã số: ");   int maSo = Integer.parseInt(sc.nextLine());
        System.out.print("Nhâp địa chỉ: ");     String diaChi = sc.nextLine();
        this.setHoVaTen(hoVaTen);
        this.setNgaySinh(ngaySinh);
        this.setSoDienThoai(soDienThoai);
        this.setGioiTinh(gioiTinh);
        this.setMaSo(maSo);
        this.setDiaChi(diaChi);
    }

    public double tinhTienLuong() {
        return this.soNgayLamViec * TIEN_LUONG_LAM_VIEC_1_NGAY_NHAN_VIEN_BAN_HANG;
    }

    @Override
    public String toString() {
        return this.getMaSo() + ", " + this.getHoVaTen() + ", " + F.format(this.getNgaySinh()) + ", " +
                this.getSoDienThoai() + ", " + this.getGioiTinh() + ", " + this.getSoCCD() + ", " + this.getDiaChi();
    }
    public void hienThi() {
        System.out.printf("|%-4d|%-20s|%-13s|%-15s|%-15s|", this.getMaSo(), this.getHoVaTen(),
                F.format(this.getNgaySinh()), this.getSoDienThoai(), this.getDiaChi());
    }

}
