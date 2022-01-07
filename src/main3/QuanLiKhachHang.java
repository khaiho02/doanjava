package main3;

import file.IFile;
import main1.KhachHang;
import main1.NhanVienBanHang;
import main2.HoaDon;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class QuanLiKhachHang extends QuanLi implements IFile {
    private ArrayList<KhachHang> danhSachKhachHang = new ArrayList<>();

    public QuanLiKhachHang(ArrayList<KhachHang> danhSachKhachHang) {
        this.danhSachKhachHang = danhSachKhachHang;
    }

    public QuanLiKhachHang() {

    }

    public ArrayList<KhachHang> getDanhSachKhachHang() {
        return danhSachKhachHang;
    }
    public boolean them (KhachHang KH) {
        danhSachKhachHang.add(KH);
        return true;
    }

    public void setDanhSachKhachHang(ArrayList<KhachHang> danhSachKhachHang) {
        this.danhSachKhachHang = danhSachKhachHang;
    }

    @Override
    public boolean xoa(int maSo) {
        for (KhachHang x : danhSachKhachHang) {
            if (x.getMaSo() == maSo) {
                danhSachKhachHang.remove(x);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean sua(String soCCD) throws ParseException {
        return false;
    }


    public boolean suaThongTin(int maSo) throws ParseException {
        for (KhachHang x : danhSachKhachHang) {
            if (x.getMaSo() == maSo ) {
                x.suaThongTin();
                return true;
            }
        }
        return false;
    }

    @Override
    public void inDanhSach() {
        for (KhachHang x : danhSachKhachHang) {
            x.hienThi();
            System.out.println();
        }
    }

    public void capNhatDiemTichLuy(QuanLiHoaDon dshd) {
        Scanner sc = new Scanner(System.in);
        for (KhachHang x : danhSachKhachHang) {
            if (x.getLoaiKhachHang().contains("VIP")) {
                for (HoaDon o : dshd.getDanhSachHoaDon()) {
                    if (x.getHoVaTen().equals(o.getTenKhachHang())) {
                        double tien = o.getTongTien() / 1000;
                        x.setDiemTichLuy(tien);
                    }
                }

            }
        }
    }

    public ArrayList<KhachHang> timKiem(String key) {
        ArrayList<KhachHang> list = new ArrayList<>();
        for (KhachHang x : danhSachKhachHang) {
            if(x.getHoVaTen().contains(key))
                list.add(x);
        }
        return list;
    }

    public void sapXepTangDanTheoDiemTichLuy() {
        danhSachKhachHang.sort((KH1, KH2) -> KH1.soSanh(KH2));
        for (KhachHang x : danhSachKhachHang) {
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
                double diemTL = Double.parseDouble(s[7]);
                KhachHang KH = new KhachHang(s[1], s[2], s[3], s[4], s[5], s[6], diemTL);
                danhSachKhachHang.add(KH);
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
            for (KhachHang x : danhSachKhachHang) {
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
