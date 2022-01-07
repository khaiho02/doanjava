package main3;

import file.IFile;
import main1.KhachHang;
import main1.NhanVienBanHang;
import main2.HoaDon;
import main2.SanPham;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLiHoaDon implements IFile {
    private ArrayList<HoaDon> danhSachHoaDon = new ArrayList<>();

    public QuanLiHoaDon(ArrayList<HoaDon> danhSachHoaDon) {
        this.danhSachHoaDon = danhSachHoaDon;
    }

    public QuanLiHoaDon() {

    }

    public ArrayList<HoaDon> getDanhSachHoaDon() {
        return danhSachHoaDon;
    }

    public void setDanhSachHoaDon(ArrayList<HoaDon> danhSachHoaDon) {
        this.danhSachHoaDon = danhSachHoaDon;
    }

    public boolean themHoaDon(HoaDon HD) {
        danhSachHoaDon.add(HD);
        return true;
    }
    public boolean xoaHoaDon(String key, int maSo) {
        for (HoaDon x : danhSachHoaDon) {
            if (x.getTenKhachHang().equals(key) && x.getMaHoaDon() == maSo) {
                danhSachHoaDon.remove(x);
                return true;
            }
        }
        return false;
    }
    public void inHoaDon(int maSo, QuanLiSanPham list) {
        for (HoaDon x : danhSachHoaDon) {
            if (x.getMaHoaDon() == maSo)
                x.xuatHoaDon(list);
        }
    }
    public void inDanhSachTatCaHoaDon(QuanLiSanPham list) {
        for (HoaDon x : danhSachHoaDon) {
            x.xuatHoaDon(list);
            System.out.println();
        }
    }


    public void inDanhSachHoaDonTheoTenKhachHang(String tenKH,QuanLiSanPham list) {
        for (HoaDon x : danhSachHoaDon) {
            if (x.getTenKhachHang().contains(tenKH)) {
                x.xuatHoaDon(list);
            }
        }
    }

    @Override
    public void docFile(String link) throws FileNotFoundException {
        File F = new File(link);
        try( Scanner sc = new Scanner(F)) {
            while(sc.hasNext()) {
                int ms = Integer.parseInt(sc.nextLine());
                String ngayMua = sc.nextLine();
                String tenKH = sc.nextLine();
                String tenNV = sc.nextLine();
                double tongTien = Double.parseDouble(sc.nextLine());
                String sp = sc.nextLine();
                String[] dssp = sp.split(", ");
                String[] sp1 = new String[dssp.length];
                for (int i = 0; i < dssp.length; i++) {
                    sp1[i] = dssp[i];
                }
                HoaDon a = new HoaDon(ngayMua, tenKH, tenNV, tongTien, sp1);
                danhSachHoaDon.add(a);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ghiFile(String link) {
        try{
            FileWriter fw = new FileWriter(link);
            BufferedWriter bw = new BufferedWriter(fw);
            for (HoaDon x : danhSachHoaDon) {
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

