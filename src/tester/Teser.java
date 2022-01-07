package tester;

import main1.KhachHang;
import main1.NhanVienBanHang;
import main1.NhanVienSuaChua;
import main2.HoaDon;
import main2.HoaDonNhapHang;
import main2.NhaSanXuat;
import main2.SanPham;
import main3.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Teser {
    public static void main(String[] args) throws ParseException, FileNotFoundException, UnsupportedEncodingException {
        QuanLiSanPham quanLiSanPham = new QuanLiSanPham();
        QuanLiKhachHang quanLiKhachHang = new QuanLiKhachHang();
        QuanLiNhanVienBanHang quanLiNhanVienBanHang = new QuanLiNhanVienBanHang();
        QuanLiNhanVienSuaChua quanLiNhanVienSuaChua = new QuanLiNhanVienSuaChua();
        QuanLiHoaDon quanLiHoaDon = new QuanLiHoaDon();
        QuanLiHoaDonNhapHang quanLiHoaDonNhapHang = new QuanLiHoaDonNhapHang();
        Scanner sc = new Scanner(System.in);
        quanLiSanPham.docFile("src/file/sanpham.txt");
        quanLiKhachHang.docFile("src/file/khachhang.txt");
        quanLiNhanVienBanHang.docFile("src/file/nhanvienbanhang.txt");
        quanLiNhanVienSuaChua.docFile("src/file/nhanviensuachua.txt");
        quanLiHoaDon.docFile("src/file/hoadon.txt");
        quanLiHoaDonNhapHang.docFile("src/file/hoadonmuahang.txt");


        int luachon;
        while(true) {
            System.out.println("\t\t\t===== MENU CỬA HÀNG BÁN MÁY TÍNH =====");
            System.out.println("\t\t\t1. NHÂN VIÊN");
            System.out.println("\t\t\t2. HOÁ ĐƠN");
            System.out.println("\t\t\t3. KHÁCH HÀNG VIP");
            System.out.println("\t\t\t4. SẢN PHẨM");
            System.out.println("\t\t\t5. KIỂM TRA LỊCH SỬ NHẬP HÀNG CỦA CỬA HÀNG");
            System.out.println("\t\t\t0. THOÁT CHƯƠNG TRÌNH");
            System.out.print("\tNhập lựa chọn: "); luachon = Integer.parseInt(sc.nextLine());
            if (luachon < 0 || luachon > 5) {
                System.out.println("Lựa chọn không hợp lệ. Hãy nhập lại");
            } else if (luachon == 0) {
                break;
            } else if (luachon == 1) {
                System.out.println("\t\t===== QUẢN LÍ NHÂN VIÊN CỦA CỬA HÀNG =====");
                int luachon1;
                while (true) {
                    System.out.println("1. Nhân viên sửa chữa");
                    System.out.println("2. Nhân viên bán hàng");
                    System.out.println("3. In danh sách tiền lương của nhân viên");
                    System.out.println("0. Quay lại");
                    System.out.print("Nhập lựa chọn: "); luachon1 = Integer.parseInt(sc.nextLine());
                    if (luachon1 < 0 || luachon1 > 3) {
                        System.out.println("Lựa chọn không hợp lệ. Hãy nhập lại");
                    } else if (luachon1 == 0) {
                        break;
                    } else if (luachon1 == 1) {
                        while(true) {
                            int luachon2;
                            System.out.println("===== Quản lí nhân viên sửa chữa =====");
                            System.out.println("1. Thêm nhân viên");
                            System.out.println("2. Xoá nhân viên");
                            System.out.println("3. Sửa thông tin nhân viên");
                            System.out.println("4. Tìm kiếm nhân viên theo mã nhân viên");
                            System.out.println("5. Tìm kiếm nhân viên theo tên nhân viên");
                            System.out.println("6. In danh sách các nhân viên bán hàng");
                            System.out.println("0. Quay lại");
                            System.out.print("Nhập lựa chọn: "); luachon2 = Integer.parseInt(sc.nextLine());
                            if (luachon2 < 0 || luachon2 > 6) {
                                System.out.println("Lựa chọn không hợp lệ. Hãy nhập lại");
                            } else if (luachon2 == 0) {
                                quanLiNhanVienSuaChua.ghiFile("src/file/nhanviensuachua.txt");
                                break;
                            } else if (luachon2 == 1) {
                                System.out.print("Nhập họ và tên: "); String ht = sc.nextLine();
                                System.out.print("Nhập ngày sinh (theo định dạng dd/MM/yyyy): "); String ns = sc.nextLine();
                                System.out.print("Nhập số điện thoại: "); String sdt = sc.nextLine();
                                System.out.print("Nhập giới tính: "); String gt = sc.nextLine();
                                System.out.print("Nhập số căn cước công dân: "); String cccd = sc.nextLine();
                                System.out.print("Nhập địa chỉ: "); String dc = sc.nextLine();
                                NhanVienSuaChua nv = new NhanVienSuaChua(ht, ns, sdt, gt, cccd, dc);
                                quanLiNhanVienSuaChua.them(nv);
                            } else if (luachon2 == 2) {
                                System.out.print("Nhập mã số nhân viên cần xoá: "); int ms = Integer.parseInt(sc.nextLine());
                                if (quanLiNhanVienSuaChua.xoa(ms)) {
                                    System.out.println("Xoá thành công");
                                } else {
                                    System.out.println("Không tìm thấy mã số cần xoá. Hãy kiểm tra lại");
                                }
                            } else if (luachon2 == 3) {
                                System.out.print("Nhập số căn cước công dân của nhân viên cần sửa thông tin: "); String cccd = sc.nextLine();
                                if (quanLiNhanVienSuaChua.sua(cccd)) {
                                    System.out.println("Sửa thành công");
                                } else {
                                    System.out.println("Không tìm số căn cước công dân của nhân viên cần sửa thông tin. Hãy kiểm tra lại");
                                }
                            } else if (luachon2 == 4) {
                                System.out.print("Nhập mã nhân viên cần tìm kiếm: "); int ms = Integer.parseInt(sc.nextLine());
                                NhanVienSuaChua a = quanLiNhanVienSuaChua.timKiem(ms);
                                a.hienThi();
                                System.out.println();
                            } else if (luachon2 == 5) {
                                System.out.print("Nhập tên nhân viên cần tìm kiếm: "); String tennv = sc.nextLine();
                                ArrayList<NhanVienSuaChua> list = quanLiNhanVienSuaChua.timKiem(tennv);
                                for (NhanVienSuaChua x : list) {
                                    x.hienThi();
                                    System.out.println();
                                }

                            } else if (luachon2 == 6) {
                                System.out.println("Danh sách các nhân viên sửa chữa của cửa hàng");
                                quanLiNhanVienSuaChua.inDanhSach();
                            }
                        }
                    } else if(luachon1 == 2) {
                        while (true) {
                            int luachon3;
                            System.out.println("===== Quản lí nhân viên bán hàng =====");
                            System.out.println("1. Thêm nhân viên");
                            System.out.println("2. Xoá nhân viên");
                            System.out.println("3. Sửa thông tin nhân viên");
                            System.out.println("4. Tìm kiếm nhân viên theo mã nhân viên");
                            System.out.println("5. Tìm kiếm nhân viên theo tên nhân viên");
                            System.out.println("6. In danh sách các nhân viên bán hàng");
                            System.out.println("0. Quay lại");
                            System.out.print("Nhập lựa chọn: "); luachon3 = Integer.parseInt(sc.nextLine());
                            if (luachon3 < 0 || luachon3 > 6) {
                                System.out.println("Lựa chọn không hợp lệ. Hãy nhập lại");
                            } else if (luachon3 == 0) {
                                quanLiNhanVienBanHang.ghiFile("src/file/nhanvienbanhang.txt");
                                break;
                            } else if (luachon3 == 1) {
                                System.out.print("Nhập họ và tên: "); String ht = sc.nextLine();
                                System.out.print("Nhập ngày sinh (theo định dạng dd/MM/yyyy): "); String ns = sc.nextLine();
                                System.out.print("Nhập số điện thoại: "); String sdt = sc.nextLine();
                                System.out.print("Nhập giới tính: "); String gt = sc.nextLine();
                                System.out.print("Nhập số căn cước công dân: "); String cccd = sc.nextLine();
                                System.out.print("Nhập địa chỉ: "); String dc = sc.nextLine();
                                NhanVienBanHang nv = new NhanVienBanHang(ht, ns, sdt, gt, cccd, dc);
                                quanLiNhanVienBanHang.them(nv);
                            } else if (luachon3 == 2) {
                                System.out.print("Nhập mã số nhân viên cần xoá: "); int ms = Integer.parseInt(sc.nextLine());
                                if (quanLiNhanVienBanHang.xoa(ms)) {
                                    System.out.println("Xoá thành công");
                                } else {
                                    System.out.println("Không tìm thấy mã số cần xoá. Hãy kiểm tra lại");
                                }
                            } else if (luachon3 == 3) {
                                System.out.print("Nhập số căn cước công dân của nhân viên cần sửa thông tin: "); String cccd = sc.nextLine();
                                if (quanLiNhanVienBanHang.sua(cccd)) {
                                    System.out.println("Sửa thành công");
                                } else {
                                    System.out.println("Không tìm số căn cước công dân của nhân viên cần sửa thông tin. Hãy kiểm tra lại");
                                }
                            } else if (luachon3 == 4) {
                                quanLiNhanVienBanHang.docFile("src/file/nhanvienbanhang.txt");
                                System.out.println("Nhập mã nhân viên cần tìm kiếm: "); int ms = Integer.parseInt(sc.nextLine());
                                NhanVienBanHang a = quanLiNhanVienBanHang.timKiem(ms);
                                a.hienThi();
                                System.out.println();
                            } else if (luachon3 == 5) {
                                System.out.print("Nhập tên nhân viên cần tìm kiếm: "); String tennv = sc.nextLine();
                                ArrayList<NhanVienBanHang> list = quanLiNhanVienBanHang.timKiem(tennv);
                                for (NhanVienBanHang x : list) {
                                    x.hienThi();
                                    System.out.println();
                                }
                            } else if (luachon3 == 6) {
                                System.out.println("Danh sách các nhân viên bán hàng của cửa hàng");
                                quanLiNhanVienBanHang.inDanhSach();
                            }
                        }
                    } else if (luachon1 == 3) {
                        System.out.println("\t\t\tNhân viên bán hàng");
                        quanLiNhanVienBanHang.nhapSoNgayLamViec();
                        System.out.println("\t\t\tNhân viên sửa chữa");
                        quanLiNhanVienSuaChua.nhapSoNgayLamViec();
                        System.out.println("Danh sách tiền lương");
                        quanLiNhanVienBanHang.inDanhSachTienLuongNhanVien();
                        quanLiNhanVienSuaChua.inDanhSachTienLuongNhanVien();
                    }
                }
            } else if (luachon == 2) {
                while(true) {
                    int luachon4;
                    System.out.println("===== QUẢN LÍ HOÁ ĐƠN BÁN HÀNG CỦA CỬA HÀNG ===== ");
                    System.out.println("1. Tạo hoá đơn");
                    System.out.println("2. Xoá hoá đơn");
                    System.out.println("3. In hoá đơn");
                    System.out.println("4. In danh sách tất cả các hoá đơn");
                    System.out.println("5. In danh sách hoá đơn theo tên khách hàng");
                    System.out.println("0. Quay lại");
                    System.out.print("Nhập lựa chọn: "); luachon4 = Integer.parseInt(sc.nextLine());
                    if (luachon4 < 0 || luachon4 > 5) {
                        System.out.println("Lựa chọn không hợp lệ. Hãy nhập lại");
                    } else if (luachon4 == 1) {
                        System.out.print("Nhập tên khách hàng: "); String tenKH = sc.nextLine();
                        System.out.print("Nhập ngày mua hàng (theo định dạng dd/MM/yyyy): "); String ngayMua = sc.nextLine();
                        System.out.print("Nhập tên nhân viên lập hoá đơn: "); String tenNv = sc.nextLine();
                        System.out.print("Nhập số lượng sản phẩm mua: "); int sl = Integer.parseInt(sc.nextLine());
                        String[] msp = new String[sl];
                        for (int i = 0; i < sl; i++) {
                            System.out.print("Nhập mã sản phẩm thứ " + (i + 1) +": "); String masp = sc.nextLine();
                            for (SanPham x : quanLiSanPham.getDanhSachSanPham()) {
                                if (masp.equals(x.getMaSanPham())){
                                    msp[i] = x.getMaSanPham();
                                    break;
                                }
                            }
                        }
                        HoaDon hd = new HoaDon(ngayMua, tenKH, tenNv, msp, sl);
                        double tong = hd.xuatHoaDon(quanLiSanPham);
                        HoaDon hd2 = new HoaDon(ngayMua, tenKH, tenNv,tong,msp);
                        quanLiHoaDon.themHoaDon(hd2);
                    } else if (luachon4 == 2) {
                        System.out.println("Nhập tên khách hàng: "); String ht = sc.nextLine();
                        System.out.println("Nhập mã số hoá đơn: "); int ms = Integer.parseInt(sc.nextLine());
                        quanLiHoaDon.xoaHoaDon(ht, ms);
                    } else if (luachon4 == 3) {
                        System.out.println("Nhập mã số hoá đơn: "); int ms = Integer.parseInt(sc.nextLine());
                        quanLiHoaDon.inHoaDon(ms, quanLiSanPham);
                    } else if (luachon4 == 4) {
                        System.out.println("Danh sách tất cả các hoá đơn bán hàng của cửa hàng");
                        quanLiHoaDon.inDanhSachTatCaHoaDon(quanLiSanPham);
                        System.out.println("Số lượng: " + quanLiHoaDon.getDanhSachHoaDon().size());
                    } else if (luachon4 == 5) {
                        System.out.print("Nhập tên khách hàng: "); String tkh = sc.nextLine();
                        quanLiHoaDon.inDanhSachHoaDonTheoTenKhachHang(tkh, quanLiSanPham);
                    } else if (luachon4 == 0) {
                        quanLiHoaDon.ghiFile("src/file/hoadon.txt");
                        break;
                    }
                }
            } else if (luachon == 3) {
                while(true) {
                    int luachon5;
                    System.out.println("===== QUẢN LÍ KHÁCH HÀNG VIP CỦA CỬA HÀNG ===== ");
                    System.out.println("1. Đăng kí khách hàng VIP");
                    System.out.println("2. Huỷ đăng kí khách hàng VIP");
                    System.out.println("3. Sửa thông tin khách hàng VIP");
                    System.out.println("4. In danh sách tất cả các khách hàng VIP");
                    System.out.println("5. Cập nhật điểm tích luỹ của khách hàng VIP");
                    System.out.println("6. Tìm kiếm danh sách khách hàng theo tên");
                    System.out.println("7. Sắp xếp danh sách khách hàng theo điểm tích luỹ");
                    System.out.println("0. Quay lại");
                    System.out.print("Nhập lựa chọn: "); luachon5 = Integer.parseInt(sc.nextLine());

                    if (luachon5 < 0 || luachon5 > 7) {
                        System.out.println("Lựa chọn không hợp lệ. Hãy kiểm tra lại");
                    } else if (luachon5 == 0) {
                        quanLiKhachHang.ghiFile("src/file/khachhang.txt");
                        break;
                    } else if (luachon5 == 1) {
                        System.out.print("Nhập họ và tên khách hàng: "); String ht = sc.nextLine();
                        System.out.print("Nhập ngày sinh (theo định dạng dd/MM/yyyy): "); String ns = sc.nextLine();
                        System.out.print("Nhập số điện thoại: "); String sdt = sc.nextLine();
                        System.out.print("Nhập giới tính: "); String gt = sc.nextLine();
                        System.out.print("Nhập ngày đăng kí VIP hoặc ngày mua hàng (theo định dang dd/MM/yyyy)"); String ngayMH = sc.nextLine();
                        String loaiKH = "VIP";
                        KhachHang kh = new KhachHang(ht, ns, sdt, gt, ngayMH, loaiKH);
                        quanLiKhachHang.them(kh);
                    } else if (luachon5 == 2) {
                        System.out.println("Nhập mã số khách hàng: "); int ms = Integer.parseInt(sc.nextLine());
                        if(quanLiKhachHang.xoa(ms)) {
                            System.out.println("Huỷ đăng kí thành công");
                        } else {
                            System.out.println("Không tìm thấy mã số của khách hàng");
                        }
                    } else if (luachon5 == 3) {
                        System.out.println("Nhập mã số khách hàng: "); int ms = Integer.parseInt(sc.nextLine());
                        if(quanLiKhachHang.suaThongTin(ms)) {
                            System.out.println("Sửa thông tin khách hàng thành công");
                        } else {
                            System.out.println("Không tìm thấy mã số của khách hàng");
                        }
                    } else if (luachon5 == 4) {
                        System.out.println("Danh sách các khách hàng VIP của cửa hàng");
                        quanLiKhachHang.inDanhSach();
                    } else if (luachon5 == 5) {
                        System.out.println("Cập nhật điểm tích luỹ của khách hàng VIP");
                        quanLiKhachHang.capNhatDiemTichLuy(quanLiHoaDon);
                    } else if (luachon5 == 6) {
                        System.out.print("Nhập tên khách hàng: "); String ht = sc.nextLine();
                        ArrayList<KhachHang> list = quanLiKhachHang.timKiem(ht);
                        for (KhachHang x : list) {
                            x.hienThi();
                            System.out.println();
                        }
                    } else if (luachon5 == 7) {
                        System.out.println("Danh sách khách hàng giảm dần theo điểm tích luỹ");
                        quanLiKhachHang.sapXepTangDanTheoDiemTichLuy();
                    }
                }
            } else if (luachon == 4) {
                while(true) {
                    int luachon6;
                    System.out.println("===== QUẢN LÍ SẢN PHẨM CỦA CỬA HÀNG =====");
                    System.out.println("1. Thêm sản phẩm");
                    System.out.println("2. Xoá sản phẩm");
                    System.out.println("3. Cập nhật giá bán");
                    System.out.println("4. Sắp xếp sản phẩm theo giá bán");
                    System.out.println("5. Hiển thị danh sách sản phẩm của cửa hàng");
                    System.out.println("6. Hiển thị danh sách sản phẩm theo loại sản phẩm");
                    System.out.println("7. Hiển thị chi tiết thông tin 1 sản phẩm");
                    System.out.println("8. Tìm kiếm sản phẩm theo mức giá");
                    System.out.println("9. Tìm kiếm sản phẩm theo tên");
                    System.out.println("0. Quay lại ");
                    System.out.print("Nhập lựa chọn: "); luachon6 = Integer.parseInt(sc.nextLine());

                    if (luachon6 < 0 || luachon6 > 9) {
                        System.out.println("Lựa chọn không hợp lệ. Hãy kiểm tra lại");
                    } else if (luachon6 == 0) {
                        quanLiSanPham.ghiFile("src/file/sanpham.txt");
                        break;
                    } else if (luachon6 == 1) {
                        System.out.print("Nhập tên sản phẩm: "); String tensp = sc.nextLine();
                        System.out.print("Nhập mã sản phẩm: "); String masp = sc.nextLine();
                        System.out.print("Nhập loại sản phẩm: "); String loaisp = sc.nextLine();
                        System.out.print("Nhập tên nhà sản xuất: "); String tennsx = sc.nextLine();
                        System.out.print("Nhập quốc gia sản xuất: "); String qg = sc.nextLine();
                        System.out.print("Nhập giá bán: "); double giaBan = Double.parseDouble(sc.nextLine());
                        System.out.print("Nhập số lượng: "); int  soL = Integer.parseInt(sc.nextLine());
                        System.out.print("Nhập thời gian bảo hành: "); int bh = Integer.parseInt(sc.nextLine());
                        NhaSanXuat nhaSanXuat = new NhaSanXuat(tennsx, qg);
                        SanPham sp = new SanPham(tensp, masp, nhaSanXuat, giaBan, soL,loaisp,bh);
                        quanLiSanPham.themSanPham(sp);
                    } else if (luachon6 == 2) {
                        System.out.print("Nhập mã sản phẩm cần xoá: "); String msp = sc.nextLine();
                        if (quanLiSanPham.xoaSanPham(msp)) {
                            System.out.println("Xoá thành công");
                        } else {
                            System.out.println("Không tìm thấy mã sản phẩm cần xoá");
                        }
                    } else if (luachon6 == 3) {
                        System.out.print("Nhập mã sản phẩm cần cập nhật giá bán: "); String msp = sc.nextLine();
                        if(quanLiSanPham.capNhatGiaBan(msp)) {
                            System.out.println("Cập nhật thành công");
                        } else {
                            System.out.println("Không tìm thấy mã sản phẩm cần cập nhật giá bán");
                        }
                    } else if (luachon6 == 4) {
                        quanLiSanPham.sapXepSanPhamTheoGiaBan();
                    } else if (luachon6 == 5) {
                        System.out.println("===== Danh sách các sản phẩm của cửa hàng ===== ");
                        quanLiSanPham.hienThiDanhSachSanPham();
                    } else if (luachon6 == 6) {
                        System.out.print("Nhập loại sản phẩm cần hiển thị: "); String loaisp = sc.nextLine();
                        quanLiSanPham.inDanhSachSanPhamTheoLoaiSanPham(loaisp);
                    } else if (luachon6 == 7) {
                        System.out.print("Nhập mã sản phẩm: "); String masp = sc.nextLine();
                        quanLiSanPham.hienThiChiTietThongTin1SanPham(masp);
                    } else if (luachon6 == 8) {
                        System.out.print("Nhập mực giá từ: "); double dau = Double.parseDouble(sc.nextLine());
                        System.out.print("Đến: "); double cuoi = Double.parseDouble(sc.nextLine());
                        quanLiSanPham.hienThiSanPhamTheoMucGia(dau, cuoi);
                    } else if (luachon6 == 9) {
                        System.out.print("Nhập tên sản phẩm cần tìm: "); String ten = sc.nextLine();
                        ArrayList<SanPham> list = quanLiSanPham.timKiemSanPham(ten);
                        for (SanPham x : list) {
                            x.hienThiChiTiet();
                            System.out.println();
                        }
                    }
                }

            } else if (luachon == 5) {
                while(true) {
                    int luachon7;
                    System.out.println("===== QUẢN LÍ HOÁ ĐƠN NHẬP HÀNG CỦA CỬA HÀNG =====");
                    System.out.println("1. Thêm hoá đơn mua hàng vào danh sách");
                    System.out.println("2. In lịch sử mua hàng");
                    System.out.println("0. Quay lại");
                    System.out.println("Nhập lựa chọn: "); luachon7 = Integer.parseInt(sc.nextLine());

                    if (luachon7 < 0 || luachon7 > 2) {
                        System.out.println("Lựa chọn không hợp lệ. Hãy kiểm tra lại");
                    } else if (luachon7 == 0) {
                        quanLiHoaDonNhapHang.ghiFile("src/file/hoadonmuahang.txt");
                        break;
                    } else if (luachon7 == 1) {
                        System.out.print("Nhập ngày nhập hàng: "); String nnh = sc.nextLine();
                        System.out.print("Nhập số lượng mặt hàng nhập về: "); int sl = Integer.parseInt(sc.nextLine());
                        String[] sp = new String[sl];
                        for (int i = 0; i < sl; i++) {
                            System.out.print("Nhập lần lượt mã sản phẩm và số lượng sản phẩm (theo định dạng: [masanpham]:[soluong]): ");
                            sp[i] = sc.nextLine();
                        }
                        HoaDonNhapHang hdnh = new HoaDonNhapHang(nnh, sp);
                        quanLiHoaDonNhapHang.them(hdnh);
                    } else if (luachon7 == 2) {
                        System.out.println("Danh sách các hoá đơn nhập hàng");
                        quanLiHoaDonNhapHang.inDanhSachHoaDonNhapHang();
                    }
                }
            }
        }
    }
}