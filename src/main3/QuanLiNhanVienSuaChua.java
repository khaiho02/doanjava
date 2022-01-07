package main3;

import file.IFile;
import main1.NhanVienBanHang;
import main1.NhanVienSuaChua;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLiNhanVienSuaChua extends QuanLi implements IFile {
    private ArrayList<NhanVienSuaChua> danhSachNhanVienSuaChua = new ArrayList<>();

    public QuanLiNhanVienSuaChua() {

    }

    public QuanLiNhanVienSuaChua(ArrayList<NhanVienSuaChua> danhSachNhanVienSuaChua) {
        this.danhSachNhanVienSuaChua = danhSachNhanVienSuaChua;
    }

    public ArrayList<NhanVienSuaChua> getDanhSachNhanVienSuaChua() {
        return danhSachNhanVienSuaChua;
    }

    public void setDanhSachNhanVienSuaChua(ArrayList<NhanVienSuaChua> danhSachNhanVienSuaChua) {
        this.danhSachNhanVienSuaChua = danhSachNhanVienSuaChua;
    }

    public boolean them(NhanVienSuaChua nv) {
        danhSachNhanVienSuaChua.add(nv);
        return true;
    }
    @Override
    public boolean xoa(int maSo) {
        for (NhanVienSuaChua x : danhSachNhanVienSuaChua) {
            if (x.getMaSo() == maSo) {
                danhSachNhanVienSuaChua.remove(x);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean sua(String soCCCD) throws ParseException {
        for (NhanVienSuaChua x : danhSachNhanVienSuaChua) {
            if (x.getSoCCD().equals(soCCCD)) {
                x.suaThongTin();
                return true;
            }
        }
        return false;
    }
    public NhanVienSuaChua timKiem(int maSo) {
        for (NhanVienSuaChua x : danhSachNhanVienSuaChua) {
            if (x.getMaSo() == maSo)
                return x;
        }
        return null;
    }

    public ArrayList<NhanVienSuaChua> timKiem(String key) {
        ArrayList<NhanVienSuaChua> list = new ArrayList<>();
        for (NhanVienSuaChua x : danhSachNhanVienSuaChua) {
            if(x.getHoVaTen().contains(key))
                list.add(x);
        }
        return list;
    }

    public void nhapSoNgayLamViec () {
        Scanner sc = new Scanner(System.in);
        for (NhanVienSuaChua x : danhSachNhanVienSuaChua) {
            System.out.print("Nhập số ngày làm việc của nhân viên " + x.getHoVaTen() + ": ");
            int sn = Integer.parseInt(sc.nextLine());
            x.setSoNgayLamViec(sn);
        }
    }

    public void inDanhSachTienLuongNhanVien() {
        double tongCong = 0;
        for (NhanVienSuaChua x : danhSachNhanVienSuaChua) {
            System.out.printf("|%-20s|%.2f|", x.getHoVaTen(), x.tinhTienLuong());
            System.out.println();
            tongCong += x.tinhTienLuong();
        }
        System.out.println("Tổng cộng: " + tongCong);
    }

    @Override
    public void inDanhSach() {
        for (NhanVienSuaChua x : danhSachNhanVienSuaChua) {
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
                NhanVienSuaChua nv = new NhanVienSuaChua(s[1], s[2], s[3], s[4], s[5], s[6]);
                danhSachNhanVienSuaChua.add(nv);
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
            for (NhanVienSuaChua x : danhSachNhanVienSuaChua) {
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
