package main3;

import file.IFile;
import main2.HoaDon;
import main2.HoaDonNhapHang;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLiHoaDonNhapHang implements IFile {
    private ArrayList<HoaDonNhapHang> danhSachHoaDonNhapHang = new ArrayList<>();


    public boolean them(HoaDonNhapHang HD) {
        danhSachHoaDonNhapHang.add(HD);
        return true;
    }
    public void inDanhSachHoaDonNhapHang() {
        for (HoaDonNhapHang x : danhSachHoaDonNhapHang) {
            x.hienThi();
        }
    }

    @Override
    public void docFile(String link) throws FileNotFoundException {
        File F = new File(link);
        try (Scanner sc = new Scanner(F)) {
            while(sc.hasNext()) {
                String ngayNhap = sc.nextLine();
                String sp = sc.nextLine();
                String[] dssp = sp.split(", ");
                String sp1[] = new String[dssp.length];
                for (int i = 0; i < dssp.length; i++) {
                    sp1[i] = dssp[i];
                }
                HoaDonNhapHang a = new HoaDonNhapHang(ngayNhap,sp1);
                danhSachHoaDonNhapHang.add(a);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ghiFile(String link) throws FileNotFoundException, UnsupportedEncodingException {
        try{
            FileWriter fw = new FileWriter(link);
            BufferedWriter bw = new BufferedWriter(fw);
            for (HoaDonNhapHang x : danhSachHoaDonNhapHang) {
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
