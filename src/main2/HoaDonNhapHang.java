package main2;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HoaDonNhapHang {
    public static SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    private Date ngayNhapHang;
    private String[] maSanPham;

    public HoaDonNhapHang(String ngayNhapHang, String[] sanPham) throws ParseException {
        this.ngayNhapHang = F.parse(ngayNhapHang);
        this.maSanPham = sanPham;
    }

    public void setNgayNhapHang(String ngayNhapHang) throws ParseException {
        this.ngayNhapHang = F.parse(ngayNhapHang);
    }

    public void setSanPham(String[] sanPham) {
        this.maSanPham = sanPham;
    }
    public void hienThi() {
        System.out.println("Ngày nhập hàng: " + F.format(this.ngayNhapHang));
        System.out.println("Danh sách sản phẩm( [masanpham]:[soluong]");
        for (int i = 0; i < maSanPham.length; i++) {
            System.out.println(maSanPham[i]);
        }
    }

    @Override
    public String toString() {
        String ssp = "";
        for (int i = 0; i <maSanPham.length - 2; i++) {
            ssp += maSanPham[i] + ", ";
        }
        ssp += maSanPham[maSanPham.length - 1];
        return F.format(this.ngayNhapHang) + "\n" + ssp;
    }
}
