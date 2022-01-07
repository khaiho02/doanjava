package main1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class NhanVienBanHang extends NhanVienSuaChua{
    private static final double TIEN_LUONG_1_NGAY_LAM_VIEC_NHAN_VIEN_SUA_CHUA = 180_000;
    private static int dem = 0;

    public NhanVienBanHang(String hoVaTen, String ngaySinh, String soDienThoai, String gioiTinh,
                           String soCCD, String diaChi) throws ParseException {
        super(hoVaTen, ngaySinh, soDienThoai, gioiTinh, soCCD, diaChi);
                this.setMaSo(++dem);

    }

    public NhanVienBanHang(String soCCD, String diaChi, int soNgayLamViec) {
        super(soCCD, diaChi, soNgayLamViec);
    }

    public NhanVienBanHang(String hoVaTen, String ngaySinh, String soDienThoai, String gioiTinh, String soCCD, String diaChi, int soNgayLamViec) throws ParseException {
        super(hoVaTen, ngaySinh, soDienThoai, gioiTinh, soCCD, diaChi, soNgayLamViec);
    }

    public NhanVienBanHang(String hoVaTen, String soCCD, String diaChi, int soNgayLamViec) {
        super(hoVaTen, soCCD, diaChi, soNgayLamViec);
    }

    public NhanVienBanHang(String hoVaTen) {
        super(hoVaTen);
    }

    @Override
    public int getSoNgayLamViec() {
        return super.getSoNgayLamViec();
    }

    @Override
    public void setSoNgayLamViec(int soNgayLamViec) {
        super.setSoNgayLamViec(soNgayLamViec);
    }

    @Override
    public String getSoCCD() {
        return super.getSoCCD();
    }

    @Override
    public void setSoCCD(String soCCD) {
        super.setSoCCD(soCCD);
    }

    @Override
    public String getDiaChi() {
        return super.getDiaChi();
    }

    @Override
    public void setDiaChi(String diaChi) {
        super.setDiaChi(diaChi);
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
        System.out.print("Nhâp số căn cước công dân: ");    String soCCCD = sc.nextLine();
        System.out.print("Nhâp địa chỉ: ");     String diaChi = sc.nextLine();
        this.setHoVaTen(hoVaTen);
        this.setNgaySinh(ngaySinh);
        this.setSoDienThoai(soDienThoai);
        this.setGioiTinh(gioiTinh);
        this.setMaSo(maSo);
        this.setSoCCD(soCCCD);
        this.setDiaChi(diaChi);
    }

    public double tinhTienLuong() {
        return this.getSoNgayLamViec() * TIEN_LUONG_1_NGAY_LAM_VIEC_NHAN_VIEN_SUA_CHUA;
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

