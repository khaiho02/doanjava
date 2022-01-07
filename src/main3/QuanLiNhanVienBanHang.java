package main3;

import file.IFile;
import main1.NhanVienBanHang;
import main1.NhanVienSuaChua;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLiNhanVienBanHang extends QuanLi implements IFile {
    private ArrayList<NhanVienBanHang> danhSachNhanVienBanHang = new ArrayList<>();

    public QuanLiNhanVienBanHang() {

    }

    public QuanLiNhanVienBanHang(ArrayList<NhanVienBanHang> danhSachNhanVienBanHang) {
        this.danhSachNhanVienBanHang = danhSachNhanVienBanHang;
    }

    public ArrayList<NhanVienBanHang> getDanhSachNhanVienBanHang() {
        return danhSachNhanVienBanHang;
    }

    public void setDanhSachNhanVienBanHang(ArrayList<NhanVienBanHang> danhSachNhanVienBanHang) {
        this.danhSachNhanVienBanHang = danhSachNhanVienBanHang;
    }

    public boolean them(NhanVienBanHang nv) {
        danhSachNhanVienBanHang.add(nv);
        return true;
    }

    @Override
    public boolean xoa(int maSo) {
        for (NhanVienBanHang x : danhSachNhanVienBanHang) {
            if (x.getMaSo() == maSo) {
                danhSachNhanVienBanHang.remove(x);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean sua(String soCCCD) throws ParseException {
        for (NhanVienBanHang x : danhSachNhanVienBanHang) {
            if (x.getSoCCD().equals(soCCCD)) {
                x.suaThongTin();
                return true;
            }
        }
        return false;
    }
    public NhanVienBanHang timKiem(int maSo) {
        for (NhanVienBanHang x : danhSachNhanVienBanHang) {
            if (x.getMaSo() == maSo)
                return x;
        }
        return null;
    }

    public ArrayList<NhanVienBanHang> timKiem(String key) {
        ArrayList<NhanVienBanHang> list = new ArrayList<>();
        for (NhanVienBanHang x : danhSachNhanVienBanHang) {
            if(x.getHoVaTen().contains(key))
                list.add(x);
        }
        return list;
    }
    public void nhapSoNgayLamViec() {
        Scanner sc = new Scanner(System.in);
        for (NhanVienBanHang x : danhSachNhanVienBanHang) {
            System.out.print("Nhập số ngày làm việc của nhân viên " + x.getHoVaTen() + ": ");
            int sn = Integer.parseInt(sc.nextLine());
            x.setSoNgayLamViec(sn);
        }
    }
    public void inDanhSachTienLuongNhanVien() {
        double tongCong = 0;
        for (NhanVienBanHang x : danhSachNhanVienBanHang) {
            System.out.printf("|%-20s|%.2f|", x.getHoVaTen(), x.tinhTienLuong());
            System.out.println();
            tongCong += x.tinhTienLuong();
        }
        System.out.println("Tổng cộng: " + tongCong);
    }


    @Override
    public void inDanhSach() {
        for (NhanVienBanHang x : danhSachNhanVienBanHang) {
            x.hienThi();
            System.out.println();
        }
    }

    @Override
    public void docFile(String link) {
        File F = new File(link);
        try( Scanner sc = new Scanner(F)) {
            while(sc.hasNext()) {
                String a = sc.nextLine();
                String[] s = a.split(", ");
                NhanVienBanHang nv = new NhanVienBanHang(s[1], s[2], s[3], s[4], s[5], s[6]);
                danhSachNhanVienBanHang.add(nv);
            }
        } catch (ParseException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ghiFile(String link) {
        try{
            FileWriter fw = new FileWriter(link);
            BufferedWriter bw = new BufferedWriter(fw);
            for (NhanVienBanHang x : danhSachNhanVienBanHang) {
                bw.write(x.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
