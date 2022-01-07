package main2;

import java.util.Scanner;

public class SanPham {
    private String tenSanPham;
    private String maSanPham;
    private NhaSanXuat nhaSanXuat;
    private double giaBan;
    private int soLuong;
    private String loaiSanPham;
    private int thoiGianBaoHanh;

    public SanPham(String tenSanPham, String maSanPham, NhaSanXuat nhaSanXuat, double giaBan,
                   int soLuong, String loaiSanPham, int thoiGianBaoHanh) {
        this.tenSanPham = tenSanPham;
        this.maSanPham = maSanPham;
        this.nhaSanXuat = nhaSanXuat;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.loaiSanPham = loaiSanPham;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }
    public SanPham(String maSp, int soLuong) {
        this.maSanPham = maSp;
        this.soLuong = soLuong;
    }
    public SanPham(String maSp) {
        this.maSanPham = maSp;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public NhaSanXuat getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(NhaSanXuat nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public int soSanh(SanPham SP) {
        return this.giaBan > SP.giaBan ? 1 : (this.giaBan < SP.giaBan ? -1 : 0);
    }

    @Override
    public String toString() {
        return this.tenSanPham + ", " + this.getMaSanPham() + ", " + this.getNhaSanXuat().getTenNhaSanXuat()
                + ", " + this.getNhaSanXuat().getQuocGia() + ", " + this.getGiaBan() + ", " + this.soLuong
                + ", " + this.loaiSanPham + ", " +this.getThoiGianBaoHanh();
    }
    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm: "); String tensp = sc.nextLine();
        System.out.println("Nhập mã sản phẩm: "); String masp = sc.nextLine();
        System.out.println("Nhập loại sản phẩm: "); String loaisp = sc.nextLine();
        System.out.println("Nhập tên nhà sản xuất: "); String tennsx = sc.nextLine();
        System.out.println("Nhập quốc gia sản xuất: "); String qg = sc.nextLine();
        System.out.println("Nhập giá bán: "); double giaBan = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập số lượng: "); int sl = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập thời gian bảo hành: "); int bh = Integer.parseInt(sc.nextLine());

        this.maSanPham = masp;
        this.loaiSanPham = loaisp;
        this.giaBan = giaBan;
        this.soLuong = sl;
        this.tenSanPham = tensp;
        this.nhaSanXuat.setTenNhaSanXuat(tennsx);
        this.nhaSanXuat.setQuocGia(qg);
        this.thoiGianBaoHanh = bh;
    }
    public void hienThiChiTiet() {
        System.out.println("Tên: " + this.getTenSanPham());
        System.out.println("Loại: " + this.getLoaiSanPham());
        System.out.println("Mã: " + this.getMaSanPham());
        System.out.println("Nhà sản xuất: " + this.getNhaSanXuat().getTenNhaSanXuat());
        System.out.println("Giá bán: " + this.getGiaBan());
        System.out.println("Thời gian bảo hành: " + this.getThoiGianBaoHanh());
        System.out.println("Số lượng còn lại: " + this.getSoLuong());
    }
}

